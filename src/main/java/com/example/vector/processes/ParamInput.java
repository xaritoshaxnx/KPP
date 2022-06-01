package com.example.vector.processes;

public class ParamInput {

    private final Integer firstXPos;

    private final Integer  secondXPos;

    private final Integer firstYPos;

    private final Integer secondYPos;

    public ParamInput(
            Integer firstXPos,
            Integer secondXPos,
            Integer firstYPos,
            Integer secondYPos
    )
    {
        this.firstXPos = firstXPos;
        this.secondXPos = secondXPos;
        this.firstYPos = firstYPos;
        this.secondYPos = secondYPos;
    }
    public ParamInput()
    {
        this.secondYPos = 1;
        this.firstYPos = 2;
        this.secondXPos = 3;
        this.firstXPos = 4;
    }

    public Integer getFirstXPos()
    {
        return firstXPos;
    }

    public Integer getSecondXPos()
    {
        return secondXPos;
    }

    public Integer getFirstYPos()
    {
        return firstYPos;
    }

    public Integer getSecondYPos()
    {
        return secondYPos;
    }
}
