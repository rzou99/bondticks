package com.ice.bondedge.bondticks;

public final class Utils {
    public static final int CUSIP_LENGTH = 8;

    public static boolean isValidPrice(String value) {
        try {
            float price = Float.parseFloat(value);
            return price >= 0;
        } catch (NumberFormatException nfe) {
            return false;
        }

    }

    public static boolean isCUSIP(String value) {
        return value.length() == CUSIP_LENGTH && isAlphaNumeric(value);
    }

    public static boolean isAlphaNumeric(String value) {
        for (int i = 0; i < value.length(); i++) {
            if (!Character.isLetterOrDigit(value.charAt(i)))
                return false;
        }
        return true;
    }
}
