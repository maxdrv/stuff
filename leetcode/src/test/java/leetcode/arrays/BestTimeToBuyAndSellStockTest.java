package leetcode.arrays;

import leetcode.Examples;
import leetcode.ExamplesRun;

import static org.assertj.core.api.Assertions.assertThat;

class BestTimeToBuyAndSellStockTest extends ExamplesRun {

    public BestTimeToBuyAndSellStockTest() {
        super(new BestTimeToBuyAndSellStockImpl());
    }

    @Examples
    void test01(BestTimeToBuyAndSellStock alg) {

        int res = alg.maxProfit(new int[]{7, 1, 5, 3, 6, 4});

        assertThat(res).isEqualTo(5);
    }

    @Examples
    void test02(BestTimeToBuyAndSellStock alg) {

        int res = alg.maxProfit(new int[]{7, 6, 4, 3, 1});

        assertThat(res).isEqualTo(0);
    }

}