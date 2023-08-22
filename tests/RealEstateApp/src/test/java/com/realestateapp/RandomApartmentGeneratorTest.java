package com.realestateapp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class RandomApartmentGeneratorTest {
    private static final double MAX_MULTIPLIER = 4.0;

    @Nested
    class RandomDefaultGenerator {
        private RandomApartmentGenerator generator;

        @BeforeEach
        void setup() {
            this.generator = new RandomApartmentGenerator();
        }

        @RepeatedTest(50)
        void should_GenerateCorrectApartment_When_DefaultMinAreaMinPrice() {
            //given
            double minArea = 30;
            double maxArea = minArea * MAX_MULTIPLIER;
            BigDecimal minPricePerSqM = new BigDecimal(3000);
            BigDecimal maxPricePerSqM = minPricePerSqM.multiply(new BigDecimal(MAX_MULTIPLIER));

            //when
            Apartment apartment = generator.generate();
            //then
            BigDecimal minApartmentPrice = new BigDecimal(apartment.getArea()).multiply(minPricePerSqM);
            BigDecimal maxApartmentPrice = new BigDecimal(apartment.getArea()).multiply(maxPricePerSqM);
            assertAll(
                    () -> assertTrue(apartment.getArea() >= minArea),
                    () -> assertTrue(apartment.getArea() <= maxArea),
                    () -> assertTrue(apartment.getPrice().compareTo(minApartmentPrice) >= 0),
                    () -> assertTrue(apartment.getPrice().compareTo(maxApartmentPrice) <= 0)
            );
        }
    }

    @Nested
    class CustomGenerator {
        private RandomApartmentGenerator generator;
        private double minArea = 16;

        private BigDecimal minPricePerSqM = new BigDecimal(4000.0);

        @BeforeEach
        void setup() {
            this.generator = new RandomApartmentGenerator(minArea, minPricePerSqM);
        }

        @RepeatedTest(50)
        void should_GenerateCorrectApartment_When_CustomMinAreaMinPrice() {
            //given
            double minArea = this.minArea;
            double maxArea = minArea * MAX_MULTIPLIER;
            BigDecimal minPricePerSqM = this.minPricePerSqM;
            BigDecimal maxPricePerSqM = minPricePerSqM.multiply(new BigDecimal(MAX_MULTIPLIER));
            //when
            Apartment apartment = generator.generate();
            //then
            BigDecimal minApartmentPrice = new BigDecimal(apartment.getArea()).multiply(minPricePerSqM);
            BigDecimal maxApartmentPrice = new BigDecimal(apartment.getArea()).multiply(maxPricePerSqM);
            assertAll(
                    () -> assertTrue(apartment.getArea() >= minArea),
                    () -> assertTrue(apartment.getArea() <= maxArea),
                    () -> assertTrue(apartment.getPrice().compareTo(minApartmentPrice) >= 0),
                    () -> assertTrue(apartment.getPrice().compareTo(maxApartmentPrice) <= 0)
            );
        }
    }
}