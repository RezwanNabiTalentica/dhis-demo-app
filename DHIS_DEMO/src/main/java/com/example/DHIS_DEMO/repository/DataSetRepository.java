package com.example.DHIS_DEMO.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.DHIS_DEMO.model.DataSet;

public interface DataSetRepository extends MongoRepository<DataSet, ObjectId>{

}
