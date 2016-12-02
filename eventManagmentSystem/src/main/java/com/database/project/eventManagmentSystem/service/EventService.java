package com.database.project.eventManagmentSystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.database.project.eventManagmentSystem.event.Event;
import com.database.project.eventManagmentSystem.dao.EventDAO;

//service class used to coordinate various dao objects and give it to the controller , equivalent of calling from the main method

@Service("eventService")
public class EventService {
	
	private EventDAO eventDAO;

	/**
	 * @param eventDAO the eventDAO to set
	 */
	@Autowired
	public void setEventDAO(EventDAO eventDAO) {
		this.eventDAO = eventDAO;
	}

	
	public List<Event> getCurrent(){	
		return eventDAO.getEvents();
	}


	public void createService(Event event) {
		eventDAO.create(event);
	}
	
	public void attendService(Integer event_id, Integer numGuests, Integer userId) {
		eventDAO.attend(event_id, numGuests, userId);
	}
	
	public void interestedService(Integer event_id, Integer userId) {
		eventDAO.interested(event_id, userId);
	}
	
	public List<Integer> getAttendees(Integer event_id) {
		return eventDAO.getAttendees(event_id);
	}
	
	public List<Integer> getProspectiveAttendees(Integer event_id) {
		return eventDAO.getProspectiveAttendees(event_id);
	}
	
	public List<Event> getAttendingEvents(Integer userId) {
		return eventDAO.getAttendingEvents(userId);
	}
	
	public List<Event> getOrganizingEvents(Integer userId) {
		return eventDAO.getOrganizingEvents(userId);
	}
	
	public void deleteEvent(Integer event_id) {
		eventDAO.deleteEvent(event_id);
	}
	
}
