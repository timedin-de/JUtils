package de.timedin.jUtils.methods;

import java.net.MalformedURLException;
import java.net.URL;

@SuppressWarnings("all")
public class Validator {
    public static boolean is_url(Object haystack) {
        try {
            new URL((String) haystack);
            return true;
        } catch (MalformedURLException e) {
            return false;
        }
    }

    public static boolean is_int(Object haystack) {
        try {
            Integer.parseInt((String) haystack);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean is_Integer(Object haystack) {
        try {
            Integer.valueOf((String) haystack);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean is_float(Object haystack) {
        try {
            Float.parseFloat((String) haystack);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean is_double(Object haystack) {
        try {
            Double.parseDouble((String) haystack);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean is_short(Object haystack) {
        try {
            Short.parseShort((String) haystack);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean is_long(Object haystack) {
        try {
            Long.parseLong((String) haystack);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
