package arrays;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class TwoSumImplTest {

    private static final TwoSum hashMap = new TwoSumHashMap();
    private static final TwoSum square = new TwoSumSquareComplexity();
    private static final TwoSum arrays = new TwoSumArrays();

    public static Stream<Arguments> implementations() {
        return Stream.of(
                Arguments.of(arrays),
                Arguments.of(hashMap),
                Arguments.of(square)
        );
    }

    @ParameterizedTest
    @MethodSource("implementations")
    void test0(TwoSum a) {

        var res = a.twoSum(new int[]{1, 2, 7, 11, 15, 16, 21}, 32);

        assertThat(res).containsExactlyInAnyOrder(3, 6);
    }

    @ParameterizedTest
    @MethodSource("implementations")
    void test1(TwoSum a) {

        var res = a.twoSum(new int[]{2, 7, 11, 15}, 9);

        assertThat(res).containsExactlyInAnyOrder(0, 1);
    }

    @ParameterizedTest
    @MethodSource("implementations")
    void test2(TwoSum a) {

        var res = a.twoSum(new int[]{3, 2, 4}, 6);

        assertThat(res).containsExactlyInAnyOrder(1, 2);
    }

    @ParameterizedTest
    @MethodSource("implementations")
    void test3(TwoSum a) {

        var res = a.twoSum(new int[]{3, 3}, 6);

        assertThat(res).containsExactlyInAnyOrder(0, 1);
    }

}
