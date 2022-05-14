package com.example.vector.processes;

public class ParamOutput {

    private final int ProjectionOnX;

    private final int ProjectionOnY;
    private final double vectorRate;


    public ParamOutput(
            int ProjectionOnX,
            int ProjectionOnY,
            double vectorRate
    ) {
        this.ProjectionOnX = ProjectionOnX;
        this.ProjectionOnY = ProjectionOnY;
        this.vectorRate = vectorRate;
    }
    public int getProjectionOnX() {return ProjectionOnX; }
    public int getProjectionOnY() {return ProjectionOnY; }

    public double getVectorRate() {return vectorRate; }
}