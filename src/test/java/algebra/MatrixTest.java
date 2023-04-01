package algebra;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MatrixTest {

    @Test
    void setUpMatrixToTestPrinting() {
        //Given
        Matrix A = new Matrix();
        A.matrix = new int[][]{{1, 0, 0}, {0, 1, 0}, {0, 0, 1}};
        //When
        String actual = A.printMatrixString();
        //Then
        Assertions.assertEquals("100;010;001;", actual);
    }

    @Test
    void setUpMatrixThroughConstructor() {
        //Given
        int[] a = new int[]{1,0,0};
        int[] b = new int[]{0,1,0};
        int[] c = new int[]{0,0,1};
        int[][] vectors = new int[][]{a, b, c};
        Matrix A = new Matrix(vectors, "r");
        //When
        String actual = A.printMatrixString();
        //Then
        Assertions.assertEquals("100;010;001;", actual);
    }

}