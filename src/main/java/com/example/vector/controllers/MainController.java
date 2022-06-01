package com.example.vector.controllers;

import com.example.vector.cache.Cache;
import com.example.vector.counter.Counter;
import com.example.vector.exceptions.MainException;
import com.example.vector.loggers.MainLogger;
import com.example.vector.processes.ParamInput;
import com.example.vector.processes.ParamOutput;
import com.example.vector.responses.MainResponse;
import com.example.vector.service.RateCalculation;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
public class MainController {



  //  public static List<MainResponse> list = new ArrayList<>();

    RateCalculation calc = new RateCalculation();

    Cache cache;
    Counter counterService;

    @Autowired
    public void setCounter(Counter counter) {
        this.counterService = counter;
    }

    @Autowired
    public void setCache(Cache cache) {
        this.cache = cache;
    }


    @GetMapping("/vector")
    public ResponseEntity<MainResponse> getPos(@RequestParam(value = "x1", defaultValue = "3") int firstXPOS,
        @RequestParam(value = "x2", defaultValue = "8") int secondXPOS,
        @RequestParam(value = "y1", defaultValue = "6") int firstYPOS,
        @RequestParam(value = "y2", defaultValue = "12") int secondYPOS){
        //int coordinates[] = new int [4];
        var parIn = new ParamInput(firstXPOS, secondXPOS, firstYPOS, secondYPOS);
        ParamOutput params;
        counterService.inc();
        MainLogger.warn("Counter "+counterService.getRequestsCount());
        String coordinates = firstXPOS + " " + secondXPOS + " " + firstYPOS + " " + secondYPOS + "";

        if (cache.containsKey(coordinates)) {
            params = cache.get(coordinates);
            MainLogger.info("Result already in cache");
            return new ResponseEntity<>(new MainResponse(params),HttpStatus.OK);
        } else {
         //   var tempVector = new RateCalculation();
            Integer projectionOnX = calc.ProjectionOnX(firstXPOS,secondXPOS);
            Integer projectionOnY = calc.ProjectionOnY(firstYPOS,secondYPOS);
            Double vectorRate = calc.vectorRate(projectionOnX, projectionOnY);
            params = new ParamOutput(projectionOnX, projectionOnY, vectorRate);
            if(params.getProjectionOnX() == 0 && params.getProjectionOnY() == 0) {
                throw new MainException("As the projections are nill your vector stands as a simple point without rate...");
            }
            cache.put(params, coordinates);
            MainLogger.info("Result calculated");
            return new ResponseEntity<>(calc.resulting(parIn), HttpStatus.OK);
        }



    }

    @PostMapping("/static")
    public ResponseEntity<?> bulkOp(@RequestBody  List<ParamInput> parIn) {
        List<Integer> projX = new ArrayList<>();
        List<Integer> projY = new ArrayList<>();
        List<Double> result = new ArrayList<>();

        for (ParamInput smth:parIn)
        {
            projX.add(calc.ProjectionOnX(smth.getFirstXPos(), smth.getSecondXPos()));
        }

        for (ParamInput smth:parIn)
        {
            projY.add(calc.ProjectionOnY(smth.getFirstYPos(), smth.getSecondYPos()));
        }

        for (ParamInput smth:parIn)
        {
            result.add(calc.vectorRate(calc.ProjectionOnX(smth.getFirstXPos(), smth.getSecondXPos()), calc.ProjectionOnY(smth.getFirstYPos(), smth.getSecondYPos())));
        }

        counterService.inc();

        Map<String, Object> mapNew = new HashMap<>();

        mapNew.put("Num of requests", counterService.getRequestsCount());

        mapNew.put("Average ProjX", projX
                .stream()
                .mapToInt(i -> i)
                .average()
                .orElseThrow(NoSuchElementException::new));

        mapNew.put("Max ProjX", projX
                .stream()
                .mapToInt(i -> i)
                .max()
                .orElseThrow(NoSuchElementException::new));

        mapNew.put("Min ProjX", projX
                .stream()
                .mapToInt(i -> i)
                .min()
                .orElseThrow(NoSuchElementException::new));

        mapNew.put("Average ProjY", projY
                .stream()
                .mapToInt(i -> i)
                .average()
                .orElseThrow(NoSuchElementException::new));

        mapNew.put("Max ProjY", projY
                .stream()
                .mapToInt(i -> i)
                .max()
                .orElseThrow(NoSuchElementException::new));

        mapNew.put("Min ProjY", projY
                .stream()
                .mapToInt(i -> i)
                .min()
                .orElseThrow(NoSuchElementException::new));

        mapNew.put("Average Rate", result
                .stream()
                .mapToDouble(d -> d)
                .average()
                .orElseThrow(NoSuchElementException::new));
        mapNew.put("Max Rate", result
                .stream()
                .mapToDouble(d -> d)
                .max()
                .orElseThrow(NoSuchElementException::new));
        mapNew.put("Min Rate", result
                .stream()
                .mapToDouble(d -> d)
                .min()
                .orElseThrow(NoSuchElementException::new));


        return new ResponseEntity<>(mapNew, HttpStatus.OK);
    }


}