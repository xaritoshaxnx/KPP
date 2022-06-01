package com.example.vector.processes;

public class ParamOutput {

    private final double ProjectionOnX;
    private final double ProjectionOnY;
    private final double vectorRate;


    public ParamOutput(
            double ProjectionOnX,
            double ProjectionOnY,
            double vectorRate
    ) {
        this.ProjectionOnX = ProjectionOnX;
        this.ProjectionOnY = ProjectionOnY;
        this.vectorRate = vectorRate;
    }
    public double getProjectionOnX() {return ProjectionOnX; }
    public double getProjectionOnY() {return ProjectionOnY; }

    public double getVectorRate() {return vectorRate; }
}