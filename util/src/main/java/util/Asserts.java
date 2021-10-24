package util;

import static util.Utils.notEquals;

public class Asserts {

    public static void equals(Object expected, Object actual) {
        if (notEquals(expected, actual)) {
            throw new AssertionError();
        }
    }

}
