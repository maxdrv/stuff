package leetcode.arrays;

import java.util.HashMap;

/**
 * is it O(n) ???
 * one iteration and calls to map with constant
 *
 */
public class TwoSumHashMap implements TwoSum {

    @Override
    public int[] twoSum(int[] nums, int target) {

        var cache = new HashMap<Integer, Integer>(nums.length);
        cache.put(nums[0], 0);

        for (int i = 1; i <= nums.length; i++) {
            int num = nums[i];

            int reverse = target - num;
            if (cache.containsKey(reverse)) {
                return new int[]{cache.get(reverse), i};
            }
            cache.put(num, i);
        }

        return new int[0];
    }

}
