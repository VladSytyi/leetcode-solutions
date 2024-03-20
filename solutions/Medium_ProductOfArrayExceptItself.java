import java.util.Arrays;

class Medium_ProductOfArrayExceptItself {

    public static void main(String[] args) {

        int[] a = new int[]{1, 2, 3, 4};

        System.out.println(Arrays.toString(productExceptSelf(a)));

    }

    /*
    1. Declare two arrays with the same size: first -- contains all products to the left of index, right - to the right
    2. First element of left[] arr is equal = 1, because there is nothing before first element
    3. The last element of right[] also equal 1, by the same reason as above
    4. Multiple all left and then all right
    5. Multiple left[i] * right[i] and save it into final array
      */

    public static int[] productExceptSelf(int[] nums) {

        int[] left = new int[nums.length];
        int[] right = new int[nums.length];

        left[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            left[i] = left[i - 1] * nums[i - 1];  // left to index adjacent values
        }

        right[nums.length - 1] = 1;

        for (int i = right.length - 2; i >= 0; i--) {
            right[i] = right[i + 1] * nums[i + 1];  // right to index adjacent values
        }

        for (int i = 0; i < nums.length; i++) {
            nums[i] = left[i] * right[i];
        }

        return nums;

    }
}