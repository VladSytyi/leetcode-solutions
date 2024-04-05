public class Easy_FindMissingNumber {
    /*
    Given an array of non-duplicating numbers from 1 to n where one number is missing,
     write an efficient java program to find that missing number.
     */
    public static void main(String[] args) {
        int[] a = new int[] { 2, 3, 4, 5, 6, 7 };
        System.out.println(findMissing(a));
    }

    public static int findMissing(int[] nums ) {

        // because we have only one missing number
        int n = nums.length + 1;

        // Calculate the sum of numbers from 1 to n using the formula (n * (n + 1)) / 2
        int totalSum = (n * (n + 1)) / 2;

        // Calculate the sum of numbers in the array
        int arraySum = 0;
        for (int num : nums) {
            arraySum += num;
        }

        // The difference between the total sum and array sum will be the missing number
        return totalSum - arraySum;
    }
}
