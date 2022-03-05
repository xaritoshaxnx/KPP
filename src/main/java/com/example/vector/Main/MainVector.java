package com.example.vector.Main;


public class MainVector {

    private final long id;
    private final int firstXPOS;
    private final int secondXPOS;
    private final int firstYPOS;
    private final int secondYPOS;
    private final double vectorRate;
    private final int projectionOnX;
    private final int projectionOnY;

    public MainVector(long id, int projectionOnX, int projectionOnY, double vectorRate, int firstXPOS, int secondXPOS,
                      int firstYPOS, int secondYPOS) {

        this.id = id;
        this.firstXPOS = firstXPOS;
        this.secondXPOS = secondXPOS;
        this.firstYPOS = firstYPOS;
        this.secondYPOS = secondYPOS;
        this.vectorRate = vectorRate;
        this.projectionOnX = projectionOnX;
        this.projectionOnY = projectionOnY;

    }

    public long getId() {
        return id;
    }

    public int getFirstXPOS() {
        return firstXPOS;
    }

    public int getSecondXPOS() {
        return secondXPOS;
    }

    public int getFirstYPOS() {
        return firstYPOS;
    }

    public int getSecondYPOS() {
        return secondYPOS;
    }

    public double getVectorRate() {
        return vectorRate;
    }

    public int getProjectionOnX() {
        return projectionOnX;
    }

    public int getProjectionOnY() {
        return projectionOnY;
    }
}