package util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;

public class Utils {

    public static <T> ArrayList<T> newArrayList(T... objects) {
        return new ArrayList<T>(Arrays.asList(objects));
    }

    public static <T> HashSet<T> newHashSet(T... objects) {
        return new HashSet<T>(Arrays.asList(objects));
    }

    public static boolean notEquals(Object first, Object second) {
        return !Objects.equals(first, second);
    }
    
}
