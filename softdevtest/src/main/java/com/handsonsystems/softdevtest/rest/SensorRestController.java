package com.handsonsystems.softdevtest.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.handsonsystems.softdevtest.dao.SensorDAO;
import com.handsonsystems.softdevtest.entity.Sensor;

@RestController
@RequestMapping("/api")
public class SensorRestController {

	private SensorDAO sensorDAO;
	
	// inject sensor DAO (use constructor injection)
	
	@Autowired
	public SensorRestController(SensorDAO thesensorDAO) {
		sensorDAO = thesensorDAO;
	}
	
	// expose "/sensors" and return list of all sensors
	@GetMapping("/sensors")
	@ResponseBody
	public List<Sensor> findAll(){
		return sensorDAO.findAll();
	}
	
	// add mapping for GET /sensors/{sensorId}
	
	@GetMapping("/sensors/{sensorId}")
	public Sensor getSensor(@PathVariable int sensorId) {
		
		Sensor theSensor = sensorDAO.findByid(sensorId);
		
		if (theSensor == null) {
			throw new RuntimeException("Sensor id not found - " + sensorId);
		}
		
		return theSensor;
	}
	
	// add mapping for POST /sensors - add new sensor
	
	@PostMapping("/sensors")
	public Sensor addSensor(@RequestBody Sensor theSensor) {
		
		// in case they pass id in JSON, set id to 0
		
		theSensor.setId(0);
		
		sensorDAO.save(theSensor);
		
		return theSensor;
	}
	
	// add mapping for PUT /sensors - update existing sensor
	
	@PutMapping("/sensors")
	public Sensor updateSensor(@RequestBody Sensor theSensor) {
		
		sensorDAO.save(theSensor);
		
		return theSensor;
	}
	
	// add mapping for DELETE /sensors/{sensorId} - delete sensor
	
	@DeleteMapping("/sensors/{sensorId}")
	public String deleteSensor(@PathVariable int sensorId) {
		
		Sensor theSensor = sensorDAO.findByid(sensorId);
		
		// throw Exception if null
		
		if(theSensor == null) {
			throw new RuntimeException("Sensor Id not found - " + sensorId);
		}
		
		sensorDAO.deleteById(sensorId);
		
		return "Deleted sensor id - " + sensorId;
	}
}
