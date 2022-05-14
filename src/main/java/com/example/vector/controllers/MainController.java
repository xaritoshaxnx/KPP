package com.example.vector.controllers;

import java.util.concurrent.atomic.AtomicLong;

import com.example.vector.exceptions.MainException;
import com.example.vector.responses.MainResponse;
import com.example.vector.service.RateCalculation;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.vector.Config;
import com.example.vector.cache.Cache;
import com.example.vector.loggers.MainLogger;
import com.example.vector.processes.ParamOutput;

@RestController
public class MainController {

    public static AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/vector")
    public MainResponse getPos(@RequestParam(value = "x1", defaultValue = "3") int firstXPOS,
                               @RequestParam(value = "x2", defaultValue = "8") int secondXPOS,
                               @RequestParam(value = "y1", defaultValue = "6") int firstYPOS,
                               @RequestParam(value = "y2", defaultValue = "12") int secondYPOS) throws MainException {
        Cache cache = context.getBean("cache", Cache.class);
        ParamOutput params;
        //int coordinates[] = new int [4];
        String coordinates = firstXPOS + "" + secondXPOS + "" + firstYPOS + "" + secondYPOS + "";
        if (cache.containsKey(coordinates)) {
            params = cache.get(coordinates);
            MainLogger.info("Result already in cache");
        } else {
            var tempVector = new RateCalculation();
            int projectionOnX = tempVector.ProjectionOnX(firstXPOS,secondXPOS);
            int projectionOnY = tempVector.ProjectionOnY(firstYPOS,secondYPOS);
            double vectorRate = tempVector.vectorRate(projectionOnX, projectionOnY);
            params = new ParamOutput(projectionOnX, projectionOnY, vectorRate);
            cache.put(params, coordinates);
            MainLogger.info("Result calculated");
        }
        if(params.getProjectionOnX() == 0 && params.getProjectionOnY() == 0) {
            throw new MainException("As the projections are nill your vector stands as a simple point without rate...");
        }
        return new MainResponse(counter.incrementAndGet(),  firstXPOS,
                secondXPOS, firstYPOS, secondYPOS, params );
    }
}