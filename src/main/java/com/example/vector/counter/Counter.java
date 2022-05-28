package com.example.vector.counter;

import org.springframework.stereotype.Service;

@Service
public class Counter {
    private int requests = 0;

    public void inc() {
        requests++;
    }

    public int getRequestsCount() {
        return requests;
    }
}