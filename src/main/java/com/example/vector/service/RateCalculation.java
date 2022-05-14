package com.example.vector.service;

import com.example.vector.loggers.MainLogger;

public class RateCalculation
{

    public int ProjectionOnX(int firstXPOS, int secondXPOS) {
        if((secondXPOS - firstXPOS) == 0) {
            MainLogger.info("Your vector parallel to Y-axis ...");
            return 0;
        }
        else return Math.abs(secondXPOS - firstXPOS);
    }

    public int ProjectionOnY(int firstYPOS, int secondYPOS) {
        if((secondYPOS - firstYPOS) == 0) {
            MainLogger.info("Your vector parallel to X-axis ...");
            return 0;
        }
        else return Math.abs(secondYPOS - firstYPOS);
    }

    public double vectorRate(int ProjectionOnX, int ProjectionOnY) {
        if(!(ProjectionOnX == 0 && ProjectionOnY == 0)) {
            MainLogger.info("Rate of your vector can be calculated ...");
            return Math.pow((Math.pow(ProjectionOnX, 2) + Math.pow(ProjectionOnY, 2)), 0.5);
        }
        else return 0;
    }
}
