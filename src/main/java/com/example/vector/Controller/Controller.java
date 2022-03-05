package com.example.vector.Controller;

import java.util.concurrent.atomic.AtomicLong;


import com.example.vector.Main.MainVector;
import com.example.vector.Service.VectorRateAndProjection;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/vector")
    public MainVector getPos(@RequestParam(value = "x1", defaultValue = "3") int firstXPOS,
                             @RequestParam(value = "x2", defaultValue = "8") int secondXPOS,
                             @RequestParam(value = "y1", defaultValue = "6") int firstYPOS,
                             @RequestParam(value = "y2", defaultValue = "12") int secondYPOS) {
        var tempVector = new VectorRateAndProjection();
        int projectionOnX = tempVector.ProjectionOnX(firstXPOS,secondXPOS);
        int projectionOnY = tempVector.ProjectionOnY(firstYPOS,secondYPOS);
        double vectorRate = tempVector.vectorRate(projectionOnX, projectionOnY);
        return new MainVector(counter.incrementAndGet(), projectionOnX, projectionOnY, vectorRate, firstXPOS,
                secondXPOS, firstYPOS, secondYPOS);
    }
}