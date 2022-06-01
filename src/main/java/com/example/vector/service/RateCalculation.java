package com.example.vector.service;

import com.example.vector.loggers.MainLogger;
import com.example.vector.processes.ParamInput;
import com.example.vector.processes.ParamOutput;
import com.example.vector.responses.MainResponse;

public class RateCalculation
{
    double ProjectionOnX;
    double ProjectionOnY;
    double vectorRate;
    public Integer ProjectionOnX(int firstXPOS, int secondXPOS) {
        if((secondXPOS - firstXPOS) == 0) {
            MainLogger.info("Your vector parallel to Y-axis ...");
            return 0;
        }
        else return Math.abs(secondXPOS - firstXPOS);
    }

    public Integer ProjectionOnY(int firstYPOS, int secondYPOS) {
        if((secondYPOS - firstYPOS) == 0) {
            MainLogger.info("Your vector parallel to X-axis ...");
            return 0;
        }
        else return Math.abs(secondYPOS - firstYPOS);
    }

    public Double vectorRate(double ProjectionOnX, double ProjectionOnY) {
        if(!(ProjectionOnX == 0 && ProjectionOnY == 0)) {
            MainLogger.info("Rate of your vector can be calculated ...");
            return Math.pow((Math.pow(ProjectionOnX, 2) + Math.pow(ProjectionOnY, 2)), 0.5);
        }
        else return 0.0;
    }

    public MainResponse resulting(ParamInput params)
    {
        ProjectionOnX = Math.abs(params.getSecondXPos() - params.getFirstXPos());
        ProjectionOnY = Math.abs(params.getSecondYPos() - params.getFirstYPos());
        vectorRate = Math.pow((Math.pow(ProjectionOnX, 2) + Math.pow(ProjectionOnY, 2)), 0.5);
        return new MainResponse(new ParamOutput(ProjectionOnX, ProjectionOnY, vectorRate));
    }


    public MainResponse getResponse() {
        return new MainResponse(new ParamOutput(ProjectionOnX, ProjectionOnY, vectorRate));
    }
}
