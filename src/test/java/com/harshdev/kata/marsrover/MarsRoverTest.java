package com.harshdev.kata.marsrover;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class MarsRoverTest {

    private final Planet planet = new SpheresPlanet(new Axis(1, 6), new Axis(1, 10));

    @Nested
    public class RotateDirectionTest {
        private final MarsRover marsRover = new MarsRover(planet, new Coordinate(5, 5), DirectionEnum.NORTH);

        @ParameterizedTest
        @CsvSource(value = {
                "R,5:5:E",
                "RR,5:5:S",
                "RRR, 5:5:W",
                "RRRR, 5:5:N"
        })
        public void turnTowardsRight(String command, String expectedOutput) {
            String state = marsRover.execute(command);
            assertThat(state).isEqualTo(expectedOutput);
        }


        @ParameterizedTest
        @CsvSource(value = {
                "L,5:5:W",
                "LL, 5:5:S",
                "LLL, 5:5:E",
                "LLLL, 5:5:N"
        })
        public void turnTowardsLeft(String command, String expectedOutput) {
            String state = marsRover.execute(command);
            assertThat(state).isEqualTo(expectedOutput);
        }
    }

    @Nested
    public class ForwardAndBackWardDirectionTest {

        @Nested
        public class FacingNorthDirection {

            @ParameterizedTest
            @CsvSource(value = {
                    "F, 5:6:N",
                    "FFF, 5:8:N",
                    "FFFF, 5:9:N",
                    "FFFFF, 1:9:N"
            })
            public void forwardOneStepOnEachForwardCommand(String command, String expectedState) {
                MarsRover marsRover = new MarsRover(planet, new Coordinate(5, 5), DirectionEnum.NORTH);
                String state = marsRover.execute(command);
                assertThat(state).isEqualTo(expectedState);
            }

            @ParameterizedTest
            @CsvSource(value = {
                    "B, 1:4:N",
                    "BBB, 1:2:N",
                    "BBBB, 1:1:N",
                    "BBBBB, 5:1:N",
            })
            public void backwardOneStepOnEachBackwardCommand(String command, String expectedState) {
                MarsRover marsRover = new MarsRover(planet, new Coordinate(1, 5), DirectionEnum.NORTH);
                String state = marsRover.execute(command);
                assertThat(state).isEqualTo(expectedState);
            }
        }

        @Nested
        public class FacingSouthDirection {

            @ParameterizedTest
            @CsvSource(value = {
                    "F, 1:4:S",
                    "FFF, 1:2:S",
                    "FFFF, 1:1:S",
                    "FFFFF, 5:1:S",
            })
            public void forwardOneStepOnEachForwardCommand(String command, String expectedState) {
                MarsRover marsRover = new MarsRover(planet, new Coordinate(1, 5), DirectionEnum.SOUTH);
                String state = marsRover.execute(command);
                assertThat(state).isEqualTo(expectedState);
            }

            @ParameterizedTest
            @CsvSource(value = {
                    "B, 5:6:S",
                    "BBB, 5:8:S",
                    "BBBB, 5:9:S",
                    "BBBBB, 1:9:S"
            })
            public void backwardOneStepOnEachBackwardCommand(String command, String expectedState) {
                MarsRover marsRover = new MarsRover(planet, new Coordinate(5, 5), DirectionEnum.SOUTH);
                String state = marsRover.execute(command);
                assertThat(state).isEqualTo(expectedState);
            }
        }

        @Nested
        public class FacingEastDirection {


            @ParameterizedTest
            @CsvSource(value = {
                    "F, 2:5:E",
                    "FFF, 4:5:E",
                    "FFFF, 5:5:E",
                    "FFFFF, 1:5:E"
            })
            public void forwardOneStepOnEachForwardCommand(String command, String expectedState) {
                MarsRover marsRover = new MarsRover(planet, new Coordinate(1, 5), DirectionEnum.EAST);
                String state = marsRover.execute(command);
                assertThat(state).isEqualTo(expectedState);
            }

            @ParameterizedTest
            @CsvSource(value = {
                    "B, 4:5:E",
                    "BBB, 2:5:E",
                    "BBBB, 1:5:E",
                    "BBBBB, 5:5:E"
            })
            public void backwardOneStepOnEachBackwardCommand(String command, String expectedState) {
                MarsRover marsRover = new MarsRover(planet, new Coordinate(5, 5), DirectionEnum.EAST);
                String state = marsRover.execute(command);
                assertThat(state).isEqualTo(expectedState);
            }
        }

        @Nested
        public class FacingWestDirection {

            @ParameterizedTest
            @CsvSource(value = {
                    "F, 4:5:W",
                    "FFF, 2:5:W",
                    "FFFF, 1:5:W",
                    "FFFFF, 5:5:W"

            })
            public void forwardOneStepOnEachForwardCommand(String command, String expectedState) {
                MarsRover marsRover = new MarsRover(planet, new Coordinate(5, 5), DirectionEnum.WEST);
                String state = marsRover.execute(command);
                assertThat(state).isEqualTo(expectedState);
            }

            @ParameterizedTest
            @CsvSource(value = {
                    "B, 2:5:W",
                    "BBB, 4:5:W",
                    "BBBB, 5:5:W",
                    "BBBBB, 1:5:W"
            })
            public void backwardOneStepOnEachBackwardCommand(String command, String expectedState) {
                MarsRover marsRover = new MarsRover(planet, new Coordinate(1, 5), DirectionEnum.WEST);
                String state = marsRover.execute(command);
                assertThat(state).isEqualTo(expectedState);
            }
        }


    }

}
