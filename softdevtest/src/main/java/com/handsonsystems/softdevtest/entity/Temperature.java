package com.handsonsystems.softdevtest.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="temperature")
public class Temperature {

	// define fields
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="temp")
	private Double temp;
	
	@Column(name="date_entered")
	private String date_entered;
	
	// define constructors
	
	public Temperature() {
		
	}

	public Temperature(Double temp,String date_entered) {
		this.temp = temp;
		this.date_entered = date_entered;
	}

	// define getters/setters
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Double getTemp() {
		return temp;
	}

	public void setTemp(Double temp) {
		this.temp = temp;
	}

	public String getDate_entered() {
		return date_entered;
	}

	public void setDate_entered(String date_entered) {
		this.date_entered = date_entered;
	}

	// define toString
	
	@Override
	public String toString() {
		return "Temperature [id=" + id + " : " + temp + "]";
	}
	
	
}