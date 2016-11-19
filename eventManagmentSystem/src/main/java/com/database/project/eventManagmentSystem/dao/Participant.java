package com.database.project.eventManagmentSystem.dao;

import com.database.project.eventManagmentSystem.event.Event;

import java.util.ArrayList;
import java.util.List;

public class Participant {
	
	private int id;
	private String name;
	private String email;
	private String phone;
	private int zipcode;
	
	private List<Event> interestedIn = new ArrayList<Event>();
	
	public Participant() {
	
	}
	
	public Participant(String name, String email, String phone, int zipcode){
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.zipcode = zipcode;
	}
	
	public Participant(int id, String name, String email, String phone, int zipcode){
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.zipcode = zipcode;
	}
	
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	/**
	 * @return the zipcode
	 */
	public int getZipcode() {
		return zipcode;
	}
	/**
	 * @param zipcode the zipcode to set
	 */
	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}

	/**
	 * List of events participant is interested in
	 * @return
	 */
	public List<Event> getInterestedIn() {
		return interestedIn;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("\n Name -> ").append(name)
		.append("\n Email -> ").append(email).append("\n Phone -> ")
		.append(phone).append("\n Zipcode -> ").append(zipcode);
		return sb.toString();
	}

	/*public Event searchEvent(String eventName) {
		return null;
	}

	public Event searchEvent(String streetAddress, String city, String state, int zip) {
		return null;
	}
	
	public void interestedToAttend(List<Event> Event) {
		// JDBC code to insert into Interest table (not shown in UML)
	}*/
}