package algebra;

import java.util.List;

public class Matrix {
    //[row 1: [a, b, c], row 2: [d, e, f]]
    int[][] matrix;
    int[] dimensions;

    public Matrix() {

    }

    public Matrix(int rows, int columns) {
        this.dimensions = new int[]{rows, columns};
        this.matrix = new int[rows][columns];
    }

    public Matrix(Vector ...vectors) {

        this.dimensions = new int[]{
                vectors[0].getDimension(),
                vectors.length
        };

        this.matrix = new int[dimensions[0]][dimensions[1]];

        for (int i = 0; i < vectors.length; i++) {
            for (int j = 0; j < vectors[i].getDimension(); j++) {
                this.matrix[i][j] = vectors[i].getCoordinates().get(j);
            }
        }
    }

    public Matrix(int[][] matrix, String direction) {

        if (direction.equals("c")) {

            this.dimensions = new int[]{
                    matrix[0].length,
                    matrix.length
            };
        } else if (direction.equals("r")) {

            this.dimensions = new int[]{
                    matrix.length,
                    matrix[0].length
            };

            //change this to get rows/columns via method
            this.matrix = new int[dimensions[0]][dimensions[1]];

            for (int i = 0; i < matrix.length; i++) {
                this.matrix[i] = matrix[i];
            }
        }
    }

    public String printMatrixString() {
        StringBuilder printedMatrix = new StringBuilder();
        for (int[] outer : this.matrix) {
            for (int inner : outer) {
                printedMatrix.append(inner);
            }
            printedMatrix.append(";");
        }
        return printedMatrix.toString();
    }
}
