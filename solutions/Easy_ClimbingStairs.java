public class Easy_ClimbingStairs {

    public static void main(String[] args) {
        System.out.println(climbStairs(2));
        System.out.println(climbStairs(3));
    }

    public static int climbStairs(int n) {
        // O(n) = 2^n
        if (n <= 1) return 1;

        return climbStairs(n - 1) + climbStairs(n - 2);
    }

    public static int climbStairsIterative(int n) {
        if (n <= 1) return 1;

        int[] arr = new int[n+1];
        arr[0] = 1;
        arr[1] = 1;

        for (int i = 2; i<=n; i ++) {
            arr[i] = arr[i-1] + arr[i - 2];
        }

        return arr[n];
    }
}
