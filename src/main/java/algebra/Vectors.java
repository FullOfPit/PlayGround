package algebra;

public class Vectors {

    public static double dotProduct(Vector a, Vector b) {
        double result = 0.0;
        int dimension = 0;
        //check for uniform dimensions of points?

        if (a.getDimension() != b.getDimension()) {
            throw new RuntimeException("Dimensions of given points do not match");
        }

        dimension = a.getDimension();

        for (int i = 0; i < dimension; i++) {
            result += (a.getCoordinates()[i] * b.getCoordinates()[i]);
        }

        return result;
    }

    public static double length(Point point) {
        double coordinatesSum = 0;
        for (Integer coordinate : point.getCoordinates()) {
            coordinatesSum += Math.pow(coordinate, 2.0d);
        }
        return Math.sqrt(coordinatesSum);
    }

    public static double rounded(double numberToRound, int dp) {
        int temp = (int) (numberToRound * Math.pow(10, dp));
        return (temp / Math.pow(10, dp));
    }

    public static double angle(Vector a, Vector b) {
        double dotProductOverLengthProduct = dotProduct(a, b) / (a.length() * b.length());
        double angleInRadians = Math.acos(dotProductOverLengthProduct);
        return Math.toDegrees(angleInRadians);
    }

    public static boolean areVectorsParallel(Vector a, Vector b) {
        double angle = angle(a, b);
        return (0.1 >= angle && angle >= -0.1) || (180.1 >= angle && angle >= 179.9);
    }
}
