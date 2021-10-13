package com.harshdev.kata.marsrover;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class MarsRoverTest {

    public static final char NORTH = 'N';
    private static final char SOUTH = 'S';
    private static final char EAST = 'E';
    private static final char WEST = 'W';

    @Nested
    public class RotateDirectionTest {
        private final MarsRover marsRover = new MarsRover(5, 5, NORTH);

        @ParameterizedTest
        @CsvSource(value = {
                "R,5:5:E",
                "RR,5:5:S",
                "RRR, 5:5:W",
                "RRRR, 5:5:N"
        })
        public void turnTowardsRight(String command, String expectedOutput) {
            MarsRover marsRover = new MarsRover(5, 5, NORTH);
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
    public class ForwardBackWardDirectionTest {

        @Nested
        public class FacingNorthDirection {

            private MarsRover marsRover = new MarsRover(5, 5, NORTH);


            @ParameterizedTest
            @CsvSource(value = {
                    "F, 5:6:N",
                    "FFF, 5:8:N",
                    "FFFF, 5:9:N"
            })
            public void forwardOneStepOnEachForwardCommand(String command, String expectedState) {
                String state = marsRover.execute(command);
                assertThat(state).isEqualTo(expectedState);
            }

            @ParameterizedTest
            @CsvSource(value = {
                    "B, 5:4:N",
                    "BBB, 5:2:N",
                    "BBBB, 5:1:N"
            })
            public void backwardOneStepOnEachBackwardCommand(String command, String expectedState) {
                String state = marsRover.execute(command);
                assertThat(state).isEqualTo(expectedState);
            }
        }

        @Nested
        public class FacingSouthDirection {

            private MarsRover marsRover = new MarsRover(5, 5, SOUTH);


            @ParameterizedTest
            @CsvSource(value = {
                    "F, 5:4:S",
                    "FFF, 5:2:S",
                    "FFFF, 5:1:S"
            })
            public void forwardOneStepOnEachForwardCommand(String command, String expectedState) {
                String state = marsRover.execute(command);
                assertThat(state).isEqualTo(expectedState);
            }

            @ParameterizedTest
            @CsvSource(value = {
                    "B, 5:6:S",
                    "BBB, 5:8:S",
                    "BBBB, 5:9:S"
            })
            public void backwardOneStepOnEachBackwardCommand(String command, String expectedState) {
                String state = marsRover.execute(command);
                assertThat(state).isEqualTo(expectedState);
            }
        }

        @Nested
        public class FacingEastDirection {

            private MarsRover marsRover = new MarsRover(5, 5, EAST);


            @ParameterizedTest
            @CsvSource(value = {
                    "F, 6:5:E",
                    "FFF, 8:5:E",
                    "FFFF, 9:5:E"
            })
            public void forwardOneStepOnEachForwardCommand(String command, String expectedState) {
                String state = marsRover.execute(command);
                assertThat(state).isEqualTo(expectedState);
            }

            @ParameterizedTest
            @CsvSource(value = {
                    "B, 4:5:E",
                    "BBB, 2:5:E",
                    "BBBB, 1:5:E"
            })
            public void backwardOneStepOnEachBackwardCommand(String command, String expectedState) {
                String state = marsRover.execute(command);
                assertThat(state).isEqualTo(expectedState);
            }
        }

        @Nested
        public class FacingWestDirection {

            private MarsRover marsRover = new MarsRover(5, 5, WEST);


            @ParameterizedTest
            @CsvSource(value = {
                    "F, 4:5:W",
                    "FFF, 2:5:W",
                    "FFFF, 1:5:W"
            })
            public void forwardOneStepOnEachForwardCommand(String command, String expectedState) {
                String state = marsRover.execute(command);
                assertThat(state).isEqualTo(expectedState);
            }

            @ParameterizedTest
            @CsvSource(value = {
                    "B, 6:5:W",
                    "BBB, 8:5:W",
                    "BBBB, 9:5:W"
            })
            public void backwardOneStepOnEachBackwardCommand(String command, String expectedState) {
                String state = marsRover.execute(command);
                assertThat(state).isEqualTo(expectedState);
            }
        }



    }

}
