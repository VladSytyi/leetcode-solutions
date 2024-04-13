import java.util.Arrays;

public class Medium_SortColors {

    // leetcode: 75. Sort Colors

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sortColors(new int[]{2, 0, 1,}))); // 0,1,2
        System.out.println(Arrays.toString(sortColors(new int[]{2,0,2,1,1,0}))); // 0,0,1,1,2,2
    }

    public static int[] sortColors(int[] nums) {

        // Three pointers --> start ( for red) end( for the blue ) and current for the white

        int start = 0;
        int current = 0;
        int end = nums.length - 1;

        while (current <= end) {

            int color = nums[current];

            if (color == 0) {
                int temp = nums[start];
                nums[start] = color;
                nums[current] = temp;

                start++;
                current++;
                continue;
            }

            if (color == 2) {
                // blue
                int temp = nums[end];
                nums[end] = color;
                nums[current] = temp;

                end--;
                continue;
            }

            if (color == 1) {
                // white color
                current++;
            }

        }

        return nums;

    }
}
