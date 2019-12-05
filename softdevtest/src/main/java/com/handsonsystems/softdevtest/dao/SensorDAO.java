package com.handsonsystems.softdevtest.dao;

import java.util.List;

import com.handsonsystems.softdevtest.entity.Sensor;

public interface SensorDAO {

	public List<Sensor> findAll();
	
	public Sensor findByid(int theId);
	
	public void save(Sensor theSensor);
	
	public void deleteById(int theId);
}
