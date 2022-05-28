package com.example.vector.cache;

import com.example.vector.loggers.MainLogger;
import com.example.vector.processes.ParamOutput;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service

public class Cache {
    public static HashMap<String, ParamOutput> map = new HashMap<>();
    public void put(ParamOutput parameters, String coordinates)
    {
        if (!map.containsKey(coordinates)) {
            map.put(coordinates, parameters);
            MainLogger.info("Key (coordinates): " + coordinates + " Values: " + parameters.getVectorRate() + parameters.getProjectionOnY() + parameters.getProjectionOnX() + " is put in cache");
        }
        else {
            MainLogger.info("Responce is already in cache!");
        }
    }

    public ParamOutput get(String coordinates)
    {

        ParamOutput parameters = map.get(coordinates);
        MainLogger.info("Value: " + parameters.getVectorRate() + " " + parameters.getProjectionOnY() + " " + parameters.getProjectionOnX() + " is got from cache with Key: " + coordinates);
        return parameters;
    }

    public boolean containsKey(String coordinates){
        return map.containsKey(coordinates);
    }

    public void printMap(){
        System.out.println("Cache:"+map);
    }
}