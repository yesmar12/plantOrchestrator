package com.ramsey.plantorchestrator;

import java.util.Collection;

import com.ramsey.plantorchestrator.datalayer.MongoDataStore;
import com.ramsey.plantorchestrator.datalayer.dataObject.Weather;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeatherController {

    @Autowired
    private MongoDataStore store;

    @GetMapping("/hello")
    public String hello() {
        return "Hello Application!";
    }

    @GetMapping("/weather")
    public Collection<Weather> weather() {
        Collection<Weather> db = store.findAll();
        return db;
    }

    @PostMapping("/createWeather")
    public Weather createWeather(@RequestBody Weather weather){
        store.save(weather);
        return weather;
    }

    @PostMapping("/createWeathers")
    public Collection<Weather> createWeather(@RequestBody Collection<Weather> weathers){
        store.saveAll(weathers);
        return weathers;
    }


}