package com.database.project.eventManagmentSystem.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.database.project.eventManagmentSystem.event.Event;

@Component("eventDAO")
public class EventDAO {

	private NamedParameterJdbcTemplate jdbc;
	
	/**
	 * @param jdbc the jdbc to set
	 */
	@Autowired
	public void setDataSource(DataSource jdbc) {
		this.jdbc = new NamedParameterJdbcTemplate(jdbc);
	}

	/**
	 * 
	 * @return
	 */
	public List<Event> getEvents() {
		return jdbc.query("select * from Event", new RowMapper<Event>() { 

			public Event mapRow(ResultSet rs, int rowNum) throws SQLException {
				Event event = new Event();
				
				event.setId(rs.getInt(1));
				event.setName(rs.getString(2));
				event.setDescription(rs.getString(3));
				event.setAddress(rs.getString(4));
				event.setSeats(rs.getInt(5));
				
				return event;
			}
		});
	}
	
//	/**
//	 * 
//	 * @return
//	 */
//	public Participant getParticipant(int id) {
//		
//		MapSqlParameterSource params = new MapSqlParameterSource();
//		params.addValue("id", id);
//		return jdbc.queryForObject("select * from Participant where id=:id", params, new RowMapper<Participant>() { //wrap this in Prepared Statement later
//
//			public Participant mapRow(ResultSet rs, int rowNum) throws SQLException {
//				Participant participant = new Participant();
//				
//				participant.setId(rs.getInt(1));
//				participant.setName(rs.getString(2));
//				participant.setEmail(rs.getString(3));
//				participant.setPhone(rs.getString(4));
//				participant.setZipcode(rs.getInt(5));
//				
//				return participant;
//			}
//		});
//	}
//	
	/**
	 * 
	 * @param event
	 * @return
	 */
	public boolean create(Event event){
		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(event);
		return jdbc.update("insert into Event (name,description,address,total_seats, organized_by) values(:name, :description, :address, :seats, :organizedBy)", params) == 1;
	}
	
	/**
	 * 
	 * @param event
	 * @param userId
	 */
	public void attend(Integer event_id, Integer userId) {
		System.out.println("Event ID: "+event_id);
		System.out.println("User ID: "+userId);
		String SQL = "INSERT INTO Event_Attendee (event_id, user_id) VALUES (:eventId, :userId)";
	      Map namedParameters = new HashMap();   
	      namedParameters.put("eventId", event_id);   
	      namedParameters.put("userId", userId);
	      jdbc.update(SQL, namedParameters);
	}
//	
//	/**
//	 * Batch create method
//	 * @param participants
//	 * @return
//	 */
//	@Transactional
//	public int[] create(List<Participant> participants){
//		SqlParameterSource[] params = SqlParameterSourceUtils.createBatch(participants.toArray());
//		return jdbc.batchUpdate("insert into Participant (name,email,phone,zipcode) values(:name, :email, :phone, :zipcode)", params);
//	}
//	
//	/**
//	 * 
//	 * @param participant
//	 * @return
//	 */
//	public boolean update(Participant participant){
//		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(participant);
//		return jdbc.update("update Participant set name=:name, email=:email, phone=:phone, zipcode=:zipcode where id=:id" , params) == 1;
//	}
//	
//	/**
//	 * 
//	 * @param id
//	 * @return
//	 */
//	public boolean delete(int id) {
//		MapSqlParameterSource params = new MapSqlParameterSource("id", id);
//		return jdbc.update("delete from Participant where id=:id", params) == 1;
//	}
}