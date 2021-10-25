package arrays;

/**
 * how to improve {@link TwoSumSquareComplexity} ?
 *
 * 1-2-7-11-15-16-21
 *
 * окей, пары можно проверить меньше чем за n^2
 *
 * (1-2) (2-7) (7-11) (11-15) (15-16) (16-21) соседние пары (dist=1) (n-1)
 * (1-7) (2-11) (7-15) (11-16) (15-16) пары на расстоянии в одну (dist=2) (n-2)
 * и т.д., на каждой итерации число проходов уменьшается на 1
 *
 *
 * (n-1) + (n-2) + (n-3) + ... + 2 + 1
 * что аналогично ряду только минус n
 * 1 + 2 + 3 + ... + (n-2) + (n-1) + n - n = n(n-1)/2 - n
 *
 * получается чуть более чем в 2 раза быстрее n^2
 *
 */
public class TwoSumArrays implements TwoSum {

    @Override
    public int[] twoSum(int[] nums, int target) {
        int dist = 1;
        for (int i = dist; i < nums.length; i++) {
            for (int j = dist; j < nums.length; j++) {

                int a = nums[j];
                int b = nums[j-i];

                if (a + b == target) {
                    return new int[]{j, j-i};
                }
            }
            dist++;
        }

        return new int[2];
    }
}
