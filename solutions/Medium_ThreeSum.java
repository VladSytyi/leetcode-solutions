import java.util.Arrays;

class Medium_ThreeSum {

    public static void main(String[] args) {
        int[] a = new int[]{3,7,1,2,8,4,5};
        int target = 10;
        System.out.println(findSumOfThree(a, target));
    }

    // Sort array first
    // Declare two pointers left = i + 1; right = lastElem
    // switch until find the requested value

    public static boolean findSumOfThree(int[] nums, int target) {
        Arrays.sort(nums);

        int low, high, tripleSum;

        for(int i = 0; i < nums.length - 2; i++) {
            low = i + 1;
            high = nums.length - 1;

            while (low < high) {

                tripleSum = nums[i] + nums[low] + nums[high];

                if (tripleSum > target) high--;
                if (tripleSum < target) low++;
                if (tripleSum == target) return true;

            }
        }

        return false;
    }
}