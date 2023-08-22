package com.realestateapp;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ApartmentRaterTest {
    private static final BigDecimal CHEAP_THRESHOLD = new BigDecimal(6000.0);
    private static final BigDecimal MODERATE_THRESHOLD = new BigDecimal(8000.0);

    @ParameterizedTest
    @CsvSource(value = {"30,120000,0", "30,190000,1", "30,280000,2"})
    void should_ReturnCorrectRating_When_CorrectApartment(double area, BigDecimal price, int rating) {
        //given
        Apartment apartment = new Apartment(area, price);
        int expected = rating;
        //when
        int actual = ApartmentRater.rateApartment(apartment);
        //then
        assertEquals(expected, actual);
    }

    @Test
    void should_ReturnErrorValue_When_IncorrectApartment() {
        //given
        Apartment apartment = new Apartment(0, new BigDecimal(230000));
        int expectedRating = -1;
        //when
        int actualRating = ApartmentRater.rateApartment(apartment);
        //then
        assertEquals(expectedRating, actualRating);
    }

    @Test
    void should_CalculateAverageRating_When_CorrectApartmentList() {
        //given
        List<Apartment> apartments = new ArrayList<>();
        apartments.add(new Apartment(30, new BigDecimal(120000)));
        apartments.add(new Apartment(50, new BigDecimal(310000)));
        apartments.add(new Apartment(40, new BigDecimal(340000)));
        double expected = 1.0;
        //when

        double actual = ApartmentRater.calculateAverageRating(apartments);
        //then
        assertEquals(expected, actual);
    }

    @Test
    void should_ThrowExceptionInCalculateAverageRating_When_EmptyApartmentList() {
        //given
        List<Apartment> apartments = new ArrayList<>();
        //when
        Executable executable = () -> ApartmentRater.calculateAverageRating(apartments);
        //then
        assertThrows(RuntimeException.class, executable);

    }


}