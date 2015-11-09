package com.yusuf.assignments.utils;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class UtilitiesTest {

    private Utilities utilities;

    @Before
    public void before(){
        utilities = new Utilities();
    }

    @Test
    public void shouldReturnInvalidUrl() {
        assertTrue(utilities.isInvalidUrl("invalid url"));
        assertTrue(utilities.isInvalidUrl("google"));
        assertTrue(utilities.isInvalidUrl("ftp://www.google.com"));
    }

    @Test
    public void shouldReturnValidUrl() {
        assertFalse(utilities.isInvalidUrl("www.n11.com"));
        assertFalse(utilities.isInvalidUrl("http://www.n11.com"));
        assertFalse(utilities.isInvalidUrl("https://www.n11.com"));
    }

    @Test
    public void shouldReturnInvalidEvenIfOneOfUrlsIsInvalid(){
        assertTrue(utilities.isAnyInvalidUrl("www.google.com", "http://www.n11.com", "ertyuıol"));
    }

    @Test
    public void shouldReturnValidIfAllUrlsAreValid(){
        assertFalse(utilities.isAnyInvalidUrl("www.google.com", "http://www.n11.com"));
    }

    @Test
    public void shouldReturnInBetween(){
        assertTrue(utilities.isBetween(1, 10, 5));
        assertTrue(utilities.isBetween(1, 10, 1));
        assertTrue(utilities.isBetween(1, 10, 10));
    }

    @Test
    public void shouldReturnIsNotInBetween(){
        assertFalse(utilities.isBetween(1, 10, 11));
        assertFalse(utilities.isBetween(1, 10, 0));
    }

    @Test
    public void shouldReturnValidIfAllNumbersAreInBetween(){
        assertTrue(utilities.isAllBetween(1, 10, 2, 4, 6, 8, 9));
    }

    @Test
    public void shouldReturnInValidIfOneOfNumbersIsNotInBetween(){
        assertFalse(utilities.isAllBetween(1, 10, 2, 4, 0, 8, 9));
    }

}