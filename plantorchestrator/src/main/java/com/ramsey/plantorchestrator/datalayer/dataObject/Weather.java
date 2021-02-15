package com.ramsey.plantorchestrator.datalayer.dataObject;

import org.springframework.data.annotation.Id;

import lombok.Value;

@Value
public class Weather {

    @Id
    String id;
    long time;
    int humidity;
    int temp;
    

}