package com.example.vector.responses;

import com.example.vector.processes.ParamOutput;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
public class MainResponse {

    private final ParamOutput parameters;

    public MainResponse(ParamOutput parameters) {


        this.parameters = parameters;

    }



    public ParamOutput getParameters() { return parameters; }

    public double getRate() {
        return parameters.getVectorRate();
    }


}