import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Easy_TwoSum {

    /*
    Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
    You may assume that each input would have exactly one solution, and you may not use the same element twice.
    You can return the answer in any order.

    Input: nums = [2,7,11,15], target = 9
    Output: [0,1]
     */

    public static void main(String[] args) {

        int[] nums = new int[]{2, 7, 11, 15};
        int target = 9;

        System.out.println(Arrays.toString(twoSumBruteForce(nums, target)));
        System.out.println(Arrays.toString(twoSumMapApproach(nums, target)));
        System.out.println(Arrays.toString(twoSumTwoPointersApproach(nums, target)));
    }

    /*
    There are 3 ways to solve this issue
    1. brute force with O(n^2) complexity
    2. using hash map approach
    3. Two pointers approach
     */

    private static int[] twoSumBruteForce(int[] nums, int target) {
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == complement) {
                    result[0] = i;
                    result[1] = j;
                }
            }

        }
        return result;

    }

    private static int[] twoSumMapApproach(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                result[0] = map.get(complement);
                result[1] = i;
                return result;
            }
            map.put(nums[i], i);
        }
        return result;
    }

    private static int[] twoSumTwoPointersApproach(int[] nums, int target) {
        int[] result = new int[2];
        Arrays.sort(nums);

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {

            int sum = nums[right] + nums[left];

            if (sum == target) {
                result[0] = left;
                result[1] = right;
                return result;
            }

            if (sum > target) right--;
            if (sum < target) left++;

        }

        return result;
    }


}
