package algebra;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;
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

    @ParameterizedTest
    @MethodSource("vectorSupplier")
    void setUpMatrixWithVectors(String result, Vector ...vectors) {
        //Given
        Matrix A = new Matrix(vectors);
        //When
        String actual = A.printMatrixString();
        //Then
        Assertions.assertEquals(result, actual);
    }

    public static Stream<Arguments> vectorSupplier() {

        return Stream.of(
                Arguments.arguments(
                        "100;010;001;",
                        new Vector[]{
                                new Vector(1, 0, 0),
                                new Vector(0, 1, 0),
                                new Vector(0, 0, 1)
                        }
                ),
                Arguments.arguments(
                        "111;000;000;",
                        new Vector[]{
                                new Vector(1, 1, 1),
                                new Vector(0, 0, 0),
                                new Vector(0, 0, 0)
                        }
                ),
                Arguments.arguments(
                        "10;01;",
                        new Vector[]{
                                new Vector(1, 0),
                                new Vector(0, 1)
                        }
                ),
                Arguments.arguments(
                        "1000;0100;0010;0001;",
                        new Vector[]{
                                new Vector(1, 0, 0, 0),
                                new Vector(0, 1, 0, 0),
                                new Vector(0, 0, 1, 0),
                                new Vector(0, 0, 0, 1)
                        }
                ),
                Arguments.arguments(
                        "1;",
                        new Vector[]{
                                new Vector(1),
                        }
                )

                /*
                //TODO to be handled at a later stage
                Arguments.arguments(
                        "",
                        new Vector[]{

                        }
                )

                 */
        );
    }

    @Test
    void setUpMatrixByDimensions() {
        //Given
        Matrix A = new Matrix(3, 3);
        Matrix B = new Matrix(1, 1);
        Matrix C = new Matrix(1, 3);
        Matrix D = new Matrix(0 , 0);
        //When
        String actualA = A.printMatrixString();
        String actualB = B.printMatrixString();
        String actualC = C.printMatrixString();
        String actualD = D.printMatrixString();
        //Then
        Assertions.assertEquals("000;000;000;", actualA);
        Assertions.assertEquals("0;", actualB);
        Assertions.assertEquals("000;", actualC);
        Assertions.assertEquals("", actualD);
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