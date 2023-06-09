package algebra;

import lombok.Data;

import java.util.ArrayList;

@Data
public class Vector {
    private int dimension;
    private ArrayList<Integer> coordinates;

    public Vector (int... coordinates) {

        this.dimension = 0;
        this.coordinates = new ArrayList<>();

        for (int coordinate  : coordinates) {
            this.dimension ++;
            this.coordinates.add(coordinate);
        }
    }


    public Vector(Point a, Point b) {

        if (a.getCoordinates().size() != b.getCoordinates().size()) {
            throw new RuntimeException("Dimensions of given points do not match");
        }

        this.dimension = a.getCoordinates().size();
        this.coordinates = new ArrayList<>();

        for (int i = 0; i < dimension; i++) {
            coordinates.add(a.getCoordinates().get(i) - b.getCoordinates().get(i));
        }
    }

    public Vector(int[] a, int[] b) {

        if (a.length != b.length) {
            throw new RuntimeException("Dimensions of given points do not match");
        }

        this.dimension = a.length;
        this.coordinates = new ArrayList<>();

        for (int i = 0; i < dimension; i++) {
            coordinates.add(a[i] - b[i]);
        }
    }

    public double length() {
        double coordinatesSum = 0;
        for (Integer coordinate : this.coordinates) {
            coordinatesSum += Math.pow(coordinate, 2.0d);
        }
        return Math.sqrt(coordinatesSum);
    }

    public static double rounded(double numberToRound, int dp) {
        int temp = (int) (numberToRound * Math.pow(10, dp));
        return (temp / Math.pow(10, dp));
    }
}
