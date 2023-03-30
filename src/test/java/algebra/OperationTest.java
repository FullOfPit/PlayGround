package algebra;

import datamodels.Point;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class VectorOpsTest {

    @Test
    void checkDotProduct() {
        //Given
        Point testPointOne = new Point(List.of(3, 4, 7));
        Point testPointTwo = new Point(List.of(2, -1, 4));
        //When
        double actual = VectorOps.dotProduct(List.of(testPointOne, testPointTwo));
        //Then
        Assertions.assertEquals(30.0d, actual);
    }

    @Test
    void checkVectorDistances() {
        //Given
        Point testPointOne = new Point(List.of(3, 4, 7));
        Point testPointTwo = new Point(List.of(2, -1, 4));
        //When
        double lengthOne = VectorOps.rounded(VectorOps.length(testPointOne), 2);
        double lengthTwo = VectorOps.rounded(VectorOps.length(testPointTwo), 2);
        //Then
        Assertions.assertEquals(8.60, lengthOne);
        Assertions.assertEquals(4.58, lengthTwo);
    }
}