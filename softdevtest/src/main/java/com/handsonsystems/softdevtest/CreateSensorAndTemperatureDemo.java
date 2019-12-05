package com.handsonsystems.softdevtest;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.temporal.ChronoUnit;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.handsonsystems.softdevtest.entity.Sensor;
import com.handsonsystems.softdevtest.entity.Temperature;

public class CreateSensorAndTemperatureDemo {

		public static void main(String[] args) {
			
			// create session factory
			SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Sensor.class)
									.addAnnotatedClass(Temperature.class)
									.buildSessionFactory();
			// create session
			Session session = factory.getCurrentSession();
			
			try {
					
				// start a transaction
				session.beginTransaction();
				
				// create the course
				Sensor tempSensor = new Sensor("Sensor Kitchen");
				
				// add some review
				tempSensor.addTemperature(new Temperature(25.0,
						OffsetDateTime.now(ZoneOffset.ofHours(1)).truncatedTo(ChronoUnit.MILLIS).toString()));
				tempSensor.addTemperature(new Temperature(24.0,
						OffsetDateTime.now(ZoneOffset.ofHours(1)).truncatedTo(ChronoUnit.MILLIS).toString()));
				tempSensor.addTemperature(new Temperature(21.0,
						OffsetDateTime.now(ZoneOffset.ofHours(1)).truncatedTo(ChronoUnit.MILLIS).toString()));

				// save the course ... and leverage the cascade all ;)
				System.out.println("Saving the temperature");
				System.out.println(tempSensor);
				System.out.println(tempSensor.getTemp());
				
				session.save(tempSensor);
				
				// commit transaction
				session.getTransaction().commit();
				
				System.out.println("Done...");
				
			} finally {
				// add clean up code
				session.close();
				factory.close();
			}
		}

	}
