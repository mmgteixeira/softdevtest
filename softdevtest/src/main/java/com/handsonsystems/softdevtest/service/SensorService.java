package com.handsonsystems.softdevtest.service;

import java.util.List;

import com.handsonsystems.softdevtest.entity.Sensor;

public interface SensorService {

	public List<Sensor> findAll();
	
	public Sensor findById(int theId);
	
	public void save(Sensor theSensor);
	
	public void deleteById(int theId);
	
}
