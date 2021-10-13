package com.harshdev.kata.marsrover;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class SpheresPlanetTest {


    @Nested
    public class incrementingY {

        private SpheresPlanet spheresPlanet = new SpheresPlanet(new Axis(1, 6), new Axis(1,6));

        @ParameterizedTest
        @CsvSource(value = {
            "1,2",
            "4,5"
        })
        public void incrementWhenMaxIsNotReached(int before, int after) {
            Coordinate coordinate = spheresPlanet.incrementY(new Coordinate(1, before));
            assertThat(coordinate).isEqualTo(new Coordinate(1, after));
        }

        @ParameterizedTest
        @MethodSource(value = "com.harshdev.kata.marsrover.SpheresPlanetTest#datForFlipXWhenMaxReached")
        public void incrementXWhenMaxReached(Coordinate before, Coordinate after) {
            Coordinate coordinate = spheresPlanet.incrementY(before);
            assertThat(coordinate).isEqualTo(after);
        }

    }

    @Nested
    public class decrementingY {

        private SpheresPlanet spheresPlanet = new SpheresPlanet(new Axis(1, 6), new Axis(1,6));

        @ParameterizedTest
        @CsvSource(value = {
                "2,1",
                "5,4"
        })
        public void decrementWhenMinIsNotReached(int before, int after) {
            Coordinate coordinate = spheresPlanet.decrementY(new Coordinate(1, before));
            assertThat(coordinate).isEqualTo(new Coordinate(1, after));
        }

        @ParameterizedTest
        @MethodSource(value = "com.harshdev.kata.marsrover.SpheresPlanetTest#dataForDecrementXWhenMinReached")
        public void decrementXWhenMinReached(Coordinate before, Coordinate after) {
            Coordinate coordinate = spheresPlanet.decrementY(before);
            assertThat(coordinate).isEqualTo(after);
        }

    }

    @Nested
    public class decrementingX {
        private SpheresPlanet spheresPlanet = new SpheresPlanet(new Axis(1, 6), new Axis(1,6));

        @ParameterizedTest
        @CsvSource(value = {
                "2,1",
                "5,4"
        })
        public void decrementWhenMinIsNotReached(int before, int after) {
            Coordinate coordinate = spheresPlanet.decrementX(new Coordinate(before, 3));

            assertThat(coordinate).isEqualTo(new Coordinate(after, 3));
        }

        @Test
        public void flipValueWhenMinReached() {
            Coordinate coordinate = spheresPlanet.decrementX(new Coordinate(1, 3));

            assertThat(coordinate).isEqualTo(new Coordinate(5, 3));
        }

    }

    @Nested
    public class incrementingX {
        private SpheresPlanet spheresPlanet = new SpheresPlanet(new Axis(1, 6), new Axis(1,6));

        @ParameterizedTest
        @CsvSource(value = {
                "1,2",
                "4,5"
        })
        public void incrementWhenMinIsNotReached(int before, int after) {
            Coordinate coordinate = spheresPlanet.incrementX(new Coordinate(before, 3));

            assertThat(coordinate).isEqualTo(new Coordinate(after, 3));
        }

        @Test
        public void flipValueWhenMinReached() {
            Coordinate coordinate = spheresPlanet.incrementX(new Coordinate(5, 3));

            assertThat(coordinate).isEqualTo(new Coordinate(1, 3));
        }

    }

    private static Stream<Arguments> datForFlipXWhenMaxReached() {
        return Stream.of(
                Arguments.of(new Coordinate(5, 5), new Coordinate(1, 5)),
                Arguments.of(new Coordinate(1, 5), new Coordinate(2, 5)),
                Arguments.of(new Coordinate(4, 5), new Coordinate(5, 5))
        );
    }

    private static Stream<Arguments> dataForDecrementXWhenMinReached() {
        return Stream.of(
                Arguments.of(new Coordinate(2, 1), new Coordinate(1, 1)),
                Arguments.of(new Coordinate(5, 1), new Coordinate(4, 1))
        );
    }

}