package playgrounds;

public class Matrices {

    char[][] characterMatrix3D = {{'a', 'b', 'c'}, {'d', 'e', 'f'}, {'g', 'h', 'i'}};
    char[][] characterMatrix4D = {{'a', 'b', 'c', 'd'}, {'e', 'f', 'g', 'h'}, {'i', 'j', 'k', 'l'}};

    public void matrixPrinter(char[][] matrix, int dim) {

        for (int i = 0; i < dim; i++) {
            StringBuilder line = new StringBuilder();
            for (int j = 0; j < dim; j++) {
                line.append(j);
                line.append(" ");
            }
            line.append("\n");
            System.out.println(line);
        }
    }





    public static void main(String... args) {

    }

}
