package com.example.vector.Service;

public class VectorRateAndProjection {

    public int ProjectionOnX(int firstXPOS, int secondXPOS) {
        return Math.abs(secondXPOS - firstXPOS);
    }

    public int ProjectionOnY(int firstYPOS, int secondYPOS) {
        return Math.abs(secondYPOS - firstYPOS);
    }

    public double vectorRate(int ProjectionOnX, int ProjectionOnY) {
        return Math.pow((Math.pow(ProjectionOnX, 2) + Math.pow(ProjectionOnY, 2)), 0.5);
    }
}
