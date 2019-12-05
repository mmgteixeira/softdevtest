package com.handsonsystems.softdevtest.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.handsonsystems.softdevtest.entity.Sensor;

@Repository
public class SensorDAOHibernateImpl implements SensorDAO {

	// define field for entitymanager
	
	private EntityManager entityManager;
	
	// set up constructor injection
	
	@Autowired
	public SensorDAOHibernateImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;	
	}
	
	
	@Override
	public List<Sensor> findAll() {
		
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		// create a query
		Query<Sensor> theQuery = 
				currentSession.createQuery("from Sensor", Sensor.class);
		
		// execute query and get result list
		List<Sensor> sensors = theQuery.getResultList();
		
		// return the results
		return sensors;
	}


	@Override
	public Sensor findByid(int theId) {
		
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		// get the sensor
		Sensor theSensor= 
				currentSession.get(Sensor.class, theId);
		
		// return the sensor
		return theSensor;
	}


	@Override
	public void save(Sensor theSensor) {
		
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		// save sensor
		currentSession.saveOrUpdate(theSensor);
	}


	@Override
	public void deleteById(int theId) {
		
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		// delete object with primary key
		Query theQuery = 
				currentSession.createQuery(
						"delete from Sensor where id=:sensorId");
		theQuery.setParameter("sensorId", theId);
		
		theQuery.executeUpdate();
	}

}
