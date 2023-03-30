package algebra;

import datamodels.Point;

import java.text.DecimalFormat;
import java.util.List;

public class VectorOps {

    public static double dotProduct(List<Point> listOfPoints) {
        double result = 0.0;
        //check for uniform dimensions of points?
        int dimension = listOfPoints.get(0).getCoordinates().size();

        for (int i = 0; i < dimension; i++) {
            int product = 1;
            for (Point point : listOfPoints) {
                product *= point.getCoordinates().get(i);
            }
            result += product;
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
}
