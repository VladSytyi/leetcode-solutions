import java.util.HashMap;
import java.util.Map;

public class Easy_ContainsDuplicateTwo {

    /*
        219. Contains Duplicate II

        Given an integer array nums and an integer k, return true
        if there are two distinct indices i and j in the array such that nums[i] == nums[j]
        and abs(i - j) <= k.

        Input: nums = [1,2,3,1], k = 3
        Output: true

        Topics: Array, HashMap, Sliding Window

     */

    public static void main(String[] args) {
        int[] a = new int[]{1, 0, 1, 1};
        int[] b = new int[]{1, 2, 3, 1};
        int[] c = new int[]{1, 2, 3, 1, 2, 3};

        System.out.println(containsNearbyDuplicate(a, 1)); // true
        System.out.println(containsNearbyDuplicate(b, 3)); // true
        System.out.println(containsNearbyDuplicate(c, 2)); // false

    }

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> mapa = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (mapa.containsKey(nums[i])) {
                int prevPosition = mapa.get(nums[i]);
                if (Math.abs(i - prevPosition) <= k) return true;
            }
            // Always update the index in the map
            mapa.put(nums[i], i);
        }

        return false;
    }

}


