package com.ramsey.plantorchestrator.datalayer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

import com.ramsey.plantorchestrator.datalayer.dataObject.Weather;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class WeatherStoreTest {

    private WeatherStore store;

    @BeforeEach
    public void init() {
        store = new WeatherStore();
    }

    @Test
    public void testCanAddOneReadOneWeather() throws Exception {
        Weather w = new Weather(1, 1, 1);
        store.put(w);
        Weather actual = store.getAll().iterator().next();
        Assertions.assertEquals(w, actual);
    }

    @Test
    public void testCanAddMany() throws Exception{
        Weather w1 = new Weather(1,1,1);
        Weather w2 = new Weather(2,2,2);
        Collection<Weather> weathers = new ArrayList<>(Arrays.asList(w1,w2));
        store.put(weathers);
        Iterator<Weather> weathersActual = weathers.iterator();
        Iterator<Weather> weathersExected = store.getAll().iterator();
        while(weathersActual.hasNext() && weathersExected.hasNext()){
            Assertions.assertEquals(weathersExected.next(), weathersActual.next());
        }

    }

    
}