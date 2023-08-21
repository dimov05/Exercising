package com.healthycoderapp;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.OS;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

class BMICalculatorTest {


    @Nested
    class IsDietRecommendedTests {
        @Test
        void shouldReturnFalseWhenDiesIsNotRecommended() {
            // given / arrange
            double weight = 69;
            double height = 1.83;
            // when / act
            boolean recommended = BMICalculator.isDietRecommended(weight, height);
            // then / assert
            assertFalse(recommended);
        }

        @ParameterizedTest
        @CsvSource(value = {"89.0,1.72", "95.0,1.75", "110.0,1.78"})
        void shouldReturnTrueWhenDiesIsRecommended(Double coderWeight, Double coderHeight) {
            // given / arrange
            double weight = coderWeight;
            double height = coderHeight;
            // when / act
            boolean recommended = BMICalculator.isDietRecommended(weight, height);
            // then / assert
            assertTrue(recommended);
        }

        @Test
        void shouldThrowArithmeticExceptionWhenDiesHeightIsZero() {
            // given / arrange
            double weight = 69;
            double height = 0;
            // when / act
            Executable executable = () -> BMICalculator.isDietRecommended(weight, height);
            // then / assert
            assertThrows(ArithmeticException.class, executable);
        }
    }

    @Nested
    class FindCoderWithWorstBMI {
        @Test
        @DisplayName("Sample method display name")
        @Disabled
        @DisabledOnOs(OS.MAC)
        void shouldReturnCoderWithWorstBMIWhenCoderListNotEmpty() {
            //given
            List<Coder> coders = new ArrayList<>();
            coders.add(new Coder(1.80, 60));
            coders.add(new Coder(1.82, 99));
            coders.add(new Coder(1.82, 64.7));
            //when
            Coder coderWorstBMI = BMICalculator.findCoderWithWorstBMI(coders);
            //then
            assertAll(
                    () -> assertEquals(1.82, coderWorstBMI.getHeight()),
                    () -> assertEquals(99, coderWorstBMI.getWeight())
            );
        }

        @Test
        void shouldReturnCoderWithWorstBMIIn1msWhenCoderListHas10000ELements() {
            //given
            List<Coder> coders = new ArrayList<>();
            for (int i = 0; i < 10000; i++) {
                coders.add(new Coder(1.0 + i, 10.0 + i));
            }
            //when
            Executable executable = () -> BMICalculator.findCoderWithWorstBMI(coders);
            //then
            assertTimeout(Duration.ofMillis(500), executable);
        }

        @Test
        void shouldReturnNullWorstBMIWhenCoderListNotEmpty() {
            //given
            List<Coder> coders = new ArrayList<>();
            //when
            Coder coderWorstBMI = BMICalculator.findCoderWithWorstBMI(coders);
            //then
            assertNull(coderWorstBMI);
        }
    }

    @Nested
    class GetBMICorrectResults {

        @Test
        void shouldReturnCorrectBMIScoreWhenCoderListNotEmpty() {
            //given
            List<Coder> coders = new ArrayList<>();
            coders.add(new Coder(1.80, 60));
            coders.add(new Coder(1.82, 98));
            coders.add(new Coder(1.82, 64.7));
            double[] expected = {18.52, 29.59, 19.53};
            //when
            double[] bmiScores = BMICalculator.getBMIScores(coders);
//then
            assertArrayEquals(expected, bmiScores);
        }
    }


}