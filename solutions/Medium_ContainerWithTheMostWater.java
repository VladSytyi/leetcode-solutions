public class Medium_ContainerWithTheMostWater {

    // leetcode: 11 - Container with most Water

    public static void main(String[] args) {
        int[] container = { 1,8,6,2,5,4,8,3,7 };

        System.out.println(maxArea(container));
    }

    // init two pointers
    // pick the min height of two pointers,
    // multiply by the distance e.g right - left
    // compare with the initial maxAmount
    // if it's greater, rewrite the initial
    // otherwise change the pointers,
    // move pointer to the shorter vertical line

    public static int maxArea(int[] height) {

        int left = 0;
        int right = height.length - 1;
        int maxAmount = 0;

        while (left < right) {

            int minHeight = Math.min(height[left], height[right]);

            int distance = right - left;

            int tempVolume = minHeight * distance;

            if (tempVolume >= maxAmount ) {
                maxAmount = tempVolume;
            }

            if (minHeight == height[left]) {
                left++;
                continue;
            }

            if (minHeight == height[right]) {
                right--;
            }



        }
        return maxAmount;


    }
}
