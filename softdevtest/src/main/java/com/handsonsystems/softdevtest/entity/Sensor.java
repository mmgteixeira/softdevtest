package com.handsonsystems.softdevtest.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="sensor")
public class Sensor {

	// define fields
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="name")
	private String name;
	
	@OneToMany(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinColumn(name="sensor_id")
	public List<Temperature> temp;
	
	// define constructors
	
	public Sensor() {
		
	}
	
	public Sensor(int id, String name, List<Temperature> temp) {
		this.id = id;
		this.name = name;
		this.temp = temp;
	}



	public Sensor(String name) {
		this.name = name;
	}

	// define getters/setters
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public List<Temperature> getTemp() {
		return temp;
	}

	public void setTemp(List<Temperature> temp) {
		this.temp = temp;
	}

	// add a convenience method
	
	public void addTemperature(Temperature theTemperature) {
		
		if(temp == null) {
			temp = new ArrayList<>();
		}
		
		temp.add(theTemperature);
		
	}
	
	// define toString()
	
	@Override
	public String toString() {
		return "Sensor [id=" + id + ", name=" + name + "]";
	}
	

	
	
	

}
