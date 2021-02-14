package com.ramsey.plantorchestrator.datalayer;

import java.util.ArrayList;
import java.util.Collection;

import com.ramsey.plantorchestrator.datalayer.dataObject.Weather;

import org.springframework.stereotype.Component;

/*
 for now lets save the data in memory we can use a db later
*/
@Component
public class WeatherStore implements DataStore<Weather>{

    Collection<Weather> database = new ArrayList<>();

    public void put(Weather w){
        database.add(w);
    }

    public void put(Collection<Weather> weathers){
        database.addAll(weathers);
    }

    public Collection<Weather> getAll(){
        return database;
    }
}