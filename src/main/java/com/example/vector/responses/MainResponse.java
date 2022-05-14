package com.example.vector.responses;

import com.example.vector.processes.ParamOutput;

public class MainResponse {

    private final long id;
    private final int firstXPOS;
    private final int secondXPOS;
    private final int firstYPOS;
    private final int secondYPOS;

    private final ParamOutput parameters;

    public MainResponse(long id, int firstXPOS, int secondXPOS, int firstYPOS, int secondYPOS, ParamOutput parameters) {

        this.id = id;
        this.firstXPOS = firstXPOS;
        this.secondXPOS = secondXPOS;
        this.firstYPOS = firstYPOS;
        this.secondYPOS = secondYPOS;
        this.parameters = parameters;

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

    public ParamOutput getParameters() { return parameters; }
}