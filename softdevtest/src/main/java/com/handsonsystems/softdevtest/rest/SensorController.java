package com.handsonsystems.softdevtest.rest;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.handsonsystems.softdevtest.entity.Sensor;
import com.handsonsystems.softdevtest.service.SensorService;

@Controller
@RequestMapping("/api")
public class SensorController {

	private SensorService sensorService;
	
	public SensorController(SensorService theSensorService) {
		sensorService = theSensorService;
	}
	
	// add mapping for "/list"

	@GetMapping("/sensorlist")
	public String listSensors(Model theModel) {
		
		// get employees from db
		List<Sensor> theSensor = sensorService.findAll();
		
		// add to the spring model
		theModel.addAttribute("sensors", theSensor);
		
		return "list-sensors";
	}
}









