public class Easy_BinarySearch {

    public static void main(String[] args) {
        int[] a = new int[] { -1, 0, 3, 5, 9, 12 };
        System.out.println(search(a, 9));
    }
    public static int search(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {

            int middle = left + (right - left) / 2;

            if (nums[middle] == target) return middle;

            if (nums[middle] > target) {
                right = middle - 1;
                continue;
            }

            if (nums[middle] < target) {
                left = middle + 1;
            }

        }

        return -1;
    }
}
