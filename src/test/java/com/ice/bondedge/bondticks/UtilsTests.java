package com.ice.bondedge.bondticks;

import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

public class UtilsTests {

    @Test
    public void priceTest() {
        assertFalse(Utils.isValidPrice("abc"));
        assertFalse(Utils.isValidPrice("307c.521"));
        assertFalse(Utils.isValidPrice("-307.521"));

        assertTrue(Utils.isValidPrice("307.521"));
    }

    @Test
    public void cusipTest() {
        assertFalse(Utils.isCUSIP("123abc"));
        assertFalse(Utils.isCUSIP("(32abc2d)"));
        assertFalse(Utils.isCUSIP("123456789"));
        assertFalse(Utils.isCUSIP("1234abcdefg"));
        assertFalse(Utils.isCUSIP("$#1234a"));

        assertTrue(Utils.isCUSIP("12345678"));
        assertTrue(Utils.isCUSIP("abcdefgh"));
        assertTrue(Utils.isCUSIP("1234abcd"));
    }

    @Test
    public void alphanumericTest() {
        assertFalse(Utils.isAlphaNumeric("*()"));
        assertFalse(Utils.isAlphaNumeric("@12ab"));

        assertTrue(Utils.isAlphaNumeric("123"));
        assertTrue(Utils.isAlphaNumeric("abc"));
        assertTrue(Utils.isAlphaNumeric("123abc"));
    }

}
