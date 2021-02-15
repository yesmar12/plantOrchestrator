package com.ramsey.plantorchestrator;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;

import com.ramsey.plantorchestrator.datalayer.MongoDataStore;
import com.ramsey.plantorchestrator.datalayer.dataObject.Weather;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = PlantorchestratorApplication.class)
@WebAppConfiguration
public class WeatherControllerTest {
    Weather expectedWeather = new Weather("aoeu", 1, 1, 1);
    List<Weather> expectedWeathers = new ArrayList<>(Arrays.asList(expectedWeather));

    @Mock
    private MongoDataStore mongo;

    @InjectMocks
    @Resource
    private WeatherController controller;
    
    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);
        Mockito.when(mongo.findAll()).thenReturn(expectedWeathers);
    }

    @Test
    public void testHello() throws Exception {
        Assert.assertEquals("Hello Application!", controller.hello());
    }

    @Test
    public void testWeather() throws Exception {
        Assert.assertEquals(expectedWeathers, controller.weather());
    }

    @Test
    public void testCreateWeather() throws Exception {
        Assert.assertEquals(expectedWeather, controller.createWeather(expectedWeather));
        Mockito.verify(mongo, Mockito.times(1)).save(expectedWeather);
    }

    @Test
    public void testCreateWeathers() throws Exception {
        Assert.assertEquals(expectedWeathers, controller.createWeather(expectedWeathers));
        Mockito.verify(mongo, Mockito.times(1)).saveAll(expectedWeathers);
    }
}