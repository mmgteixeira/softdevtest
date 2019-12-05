package com.handsonsystems.softdevtest.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.handsonsystems.softdevtest.entity.Sensor;

public interface SensorRepository extends JpaRepository<Sensor, Integer> {
	
}
