package com.ramsey.plantorchestrator.datalayer;

import com.ramsey.plantorchestrator.datalayer.dataObject.Weather;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface MongoDataStore extends MongoRepository<Weather, String> {

}