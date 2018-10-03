package com.example.DHIS_DEMO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.DHIS_DEMO.model.DataSet;
import com.example.DHIS_DEMO.repository.DataSetRepository;

@RestController
public class BasicController {

	@Autowired
	DataSetRepository repository;
	@RequestMapping("/dataset")
	public List<DataSet> getDataSet() {
		return repository.findAll();
	}
}
