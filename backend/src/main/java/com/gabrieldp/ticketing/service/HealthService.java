package com.gabrieldp.ticketing.service;

import org.springframework.stereotype.Service;

@Service
public class HealthService {

    public String check(){
        return "OK";
    }
}
