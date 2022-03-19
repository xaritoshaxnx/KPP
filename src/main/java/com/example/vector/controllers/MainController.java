package com.example.vector.controllers;

import java.util.concurrent.atomic.AtomicLong;

import com.example.vector.exceptions.MainException;
import com.example.vector.responses.MainResponse;
import com.example.vector.service.RateCalculation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/vector")
    public MainResponse getPos(@RequestParam(value = "x1", defaultValue = "3") int firstXPOS,
                               @RequestParam(value = "x2", defaultValue = "8") int secondXPOS,
                               @RequestParam(value = "y1", defaultValue = "6") int firstYPOS,
                               @RequestParam(value = "y2", defaultValue = "12") int secondYPOS) throws MainException {
        var tempVector = new RateCalculation();
        int projectionOnX = tempVector.ProjectionOnX(firstXPOS,secondXPOS);
        int projectionOnY = tempVector.ProjectionOnY(firstYPOS,secondYPOS);
        if(projectionOnX == 0 && projectionOnY == 0) {
            throw new MainException("As the projections are nill your vector stands as a simple point without rate...");
        }
        double vectorRate = tempVector.vectorRate(projectionOnX, projectionOnY);
        return new MainResponse(counter.incrementAndGet(), projectionOnX, projectionOnY, vectorRate, firstXPOS,
                secondXPOS, firstYPOS, secondYPOS);
    }
}