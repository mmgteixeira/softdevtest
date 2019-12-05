package com.handsonsystems.softdevtest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.handsonsystems.softdevtest.dao.SensorRepository;
import com.handsonsystems.softdevtest.entity.Sensor;

@Service
public class SensorServiceImpl implements SensorService {

	private SensorRepository sensorRepository;
	
	@Autowired
	public SensorServiceImpl(SensorRepository theSensorRepository) {
		sensorRepository = theSensorRepository;
	}
	
	@Override
	public List<Sensor> findAll() {
		return sensorRepository.findAll();
	}

	@Override
	public Sensor findById(int theId) {
		Optional<Sensor> result = sensorRepository.findById(theId);
		
		Sensor theSensor = null;
		
		if (result.isPresent()) {
			theSensor = result.get();
		}
		else {
			// we didn't find the employee
			throw new RuntimeException("Did not find sensor id - " + theId);
		}
		
		return theSensor;
	}

	@Override
	public void save(Sensor theSensor) {
		sensorRepository.save(theSensor);
	}

	@Override
	public void deleteById(int theId) {
		sensorRepository.deleteById(theId);
	}

}






