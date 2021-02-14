package com.ramsey.plantorchestrator.datalayer.dataObject;

import lombok.Value;

@Value
public class Weather {

    long time;
    int humidity;
    int temp;
    

}