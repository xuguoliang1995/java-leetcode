package leetcode;


import java.util.HashMap;

public class TwoSum_1 {
    /**
     * Two Sum
     * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
     * You may assume that each input would have exactly one solution, and you may not use the same element twice.
     * Example:
     * Given nums = [2, 7, 11, 15], target = 9,
     * Because nums[0] + nums[1] = 2 + 7 = 9,
     * return [0, 1].
     *
     * @param nums
     * @param target
     * @return time: O(n)
     * space: O(n)
     */
    // 方法1
    public static int[] twoSum1(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return new int[]{-1, -1};
        }
        int[] res = new int[]{-1, -1};
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            int n = target - nums[i];
            if (map.containsKey(n)) {
                res[0] = map.get(n);
                res[1] = i;
                break;

            }
            map.put(nums[i], i);
        }
        return res;
    }


    static int[] res = new int[]{2, 7, 11, 15};
    static int target = 9;

    public static void main(String[] args) {
        int[] result = twoSum1(res, target);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + "  ");
        }
    }
}
