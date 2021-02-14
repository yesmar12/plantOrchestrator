package com.ramsey.plantorchestrator;

import java.util.Collection;

import com.ramsey.plantorchestrator.datalayer.DataLayerException;
import com.ramsey.plantorchestrator.datalayer.DataStore;
import com.ramsey.plantorchestrator.datalayer.WeatherStore;
import com.ramsey.plantorchestrator.datalayer.dataObject.Weather;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeatherController {

    @Autowired
    private DataStore<Weather> store;

    @GetMapping("/hello")
    public String hello() {
        return "Hello Application!";
    }

    @GetMapping("/weather")
    public Collection<Weather> weather() throws DataLayerException {
        Collection<Weather> db = store.getAll();
        return db;
    }

    @PostMapping("/createWeather")
    public Weather createWeather(@RequestBody Weather weather) throws DataLayerException {
        store.put(weather);
        return weather;
    }

    @PostMapping("/createWeathers")
    public Collection<Weather> weather(@RequestBody Collection<Weather> weathers) throws DataLayerException {
        store.put(weathers);
        return weathers;
    }


}