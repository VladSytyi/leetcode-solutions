import java.util.Arrays;
import java.util.Stack;

public class Easy_FloodFill {

    public static void main(String[] args) {
         int[][] a = new int[][] {
                 { 1 ,1, 1 },
                 { 1, 1, 0 },
                 { 1, 0, 1 }
        };

        System.out.println(Arrays.deepToString(a));
        System.out.println(a[0][1]);
        System.out.println(a[1][2]);

        int[][] ints = floodFill(a, 1, 1, 2);

        System.out.println(Arrays.deepToString(ints));
    }

    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {

        if (image[sr][sc] == color) return image;

        int oldColor = image[sr][sc];

        fill(image, sr, sc, color, oldColor);

        return image;

    }

    public static void fill(int[][] image, int sr, int sc, int color, int oldColor) {
        if (sr < 0) return; // top boundary of the matrix
        if (sr >= image.length) return; // bottom boundary of the matrix
        if (sc < 0) return; // left boundary of the matrix
        if (sc >= image[0].length) return; // right boundary of the matrix

        if (image[sr][sc] != oldColor) return;

        image[sr][sc] = color;
        fill(image, sr + 1, sc, color, oldColor);
        fill(image, sr - 1, sc, color, oldColor);
        fill(image, sr, sc + 1, color, oldColor);
        fill(image, sr, sc - 1, color, oldColor);
    }

}
