package algebra;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class VectorOpsTest {

    @Test
    void checkDotProduct() {
        //Given
        Vector a = new Vector(new int[]{3, 4, 7});
        Vector b = new Vector(new int[]{2, -1, 4});
        //When
        double actual = Vectors.dotProduct(a, b);
        //Then
        Assertions.assertEquals(30.0d, actual);
    }

    @Test
    void checkVectorDistances() {
        //Given
        Point testPointOne = new Point(List.of(3, 4, 7));
        Point testPointTwo = new Point(List.of(2, -1, 4));
        //When
        double lengthOne = Vectors.rounded(Vectors.length(testPointOne), 2);
        double lengthTwo = Vectors.rounded(Vectors.length(testPointTwo), 2);
        //Then
        Assertions.assertEquals(8.60, lengthOne);
        Assertions.assertEquals(4.58, lengthTwo);
    }

    @Test
    void checkVectorLength() {
        //Given
        Vector a = new Vector(new int[]{3, 4, 7});
        //When
        double actual = a.length();
        //Then
        Assertions.assertEquals(8.6, Vectors.rounded(actual, 1));
    }

    @Test
    void checkAngleBetweenVectors() {
        //Given
        Vector a = new Vector(new int[]{1, 0, 0});
        Vector b = new Vector(new int[]{-1, 0, 0});
        //When
        double actual = Vectors.angle(a, b);
        //Then
        Assertions.assertEquals(180.0, actual);
        Assertions.assertTrue(Vectors.areVectorsParallel(a, b));
    }


}