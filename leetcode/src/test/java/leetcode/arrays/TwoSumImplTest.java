package leetcode.arrays;

import leetcode.Examples;
import leetcode.ExamplesRun;

import static org.assertj.core.api.Assertions.assertThat;

public class TwoSumImplTest extends ExamplesRun {

    public TwoSumImplTest() {
        super(
            new TwoSumHashMap(),
            new TwoSumSquareComplexity(),
            new TwoSumArrays()
        );
    }

    @Examples
    void test0(TwoSum a) {

        var res = a.twoSum(new int[]{1, 2, 7, 11, 15, 16, 21}, 32);

        assertThat(res).containsExactlyInAnyOrder(3, 6);
    }

    @Examples
    void test1(TwoSum a) {

        var res = a.twoSum(new int[]{2, 7, 11, 15}, 9);

        assertThat(res).containsExactlyInAnyOrder(0, 1);
    }

    @Examples
    void test2(TwoSum a) {

        var res = a.twoSum(new int[]{3, 2, 4}, 6);

        assertThat(res).containsExactlyInAnyOrder(1, 2);
    }

    @Examples
    void test3(TwoSum a) {

        var res = a.twoSum(new int[]{3, 3}, 6);

        assertThat(res).containsExactlyInAnyOrder(0, 1);
    }

}
