package com.realestateapp;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ApartmentRaterTest {
    private static final BigDecimal CHEAP_THRESHOLD = new BigDecimal(6000.0);
    private static final BigDecimal MODERATE_THRESHOLD = new BigDecimal(8000.0);

    @Test
    void should_ReturnCorrectRating_When_CorrectApartment() {
        //given
        Apartment apartment0 = new Apartment(30, new BigDecimal(120000));
        Apartment apartment1 = new Apartment(30, new BigDecimal(190000));
        Apartment apartment2 = new Apartment(30, new BigDecimal(280000));
        int expected0 = 0;
        int expected1 = 1;
        int expected2 = 2;
        //when
        int actual0 = ApartmentRater.rateApartment(apartment0);
        int actual1 = ApartmentRater.rateApartment(apartment1);
        int actual2 = ApartmentRater.rateApartment(apartment2);
        //then
        assertAll(
                () -> assertEquals(expected0, actual0),
                () -> assertEquals(expected1, actual1),
                () -> assertEquals(expected2, actual2)
        );
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