import java.util.ArrayList;
import java.util.List;

public class Medium_SpiralMatrix {

    public static void main(String[] args) {
        int[][] a = {{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(spiralOrder(a));
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        // Declare direction, 1 -- left->right, top -> bottom
        //                   -1 --> right->left, bottom->top

        // Declare variable col  -- pointer of current column should be -1
        // Declare variable row -- pointer to the current row

        // Declare rows --- total number of rows in matrix
        // Declare cols --- total number of cols in matrix

        // to change direction: multiply direction by -1

        int direction = 1;
        int col = -1;
        int row = 0;

        int rows = matrix.length;
        int cols = matrix[0].length;
        List<Integer> result = new ArrayList<>();


        // loop to process the whole matrix
        while (rows > 0 && cols > 0) {

            for (int i = 0; i < cols; i++) {
                col = col + direction;
                result.add(matrix[row][col]);
            }
            rows--; // decrease by one because it was processed

            for (int i = 0; i < rows; i++) {
                row += direction;
                result.add(matrix[row][col]);
            }
            cols--;

            direction = direction * -1;
        }

        return result;

    }
}
