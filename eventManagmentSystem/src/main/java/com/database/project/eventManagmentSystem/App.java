package com.database.project.eventManagmentSystem;


import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.jca.cci.CannotGetCciConnectionException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;

import com.database.project.eventManagmentSystem.dao.Participant;
import com.database.project.eventManagmentSystem.dao.ParticipantDAO;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ){
    	
    	ApplicationContext applicationContext = new FileSystemXmlApplicationContext("beans.xml");
    	
        Participant participant = (Participant) applicationContext.getBean("participant");
        
//        DbConnection dbConnection = (DbConnection) applicationContext.getBean("dbConnection");
//        
//        dbConnection.login();
        
        ParticipantDAO participantDAO = (ParticipantDAO) applicationContext.getBean("participantDAO");
        
        try {
        	
        	//create participant -- uncomment this while adding a participant (email and phone should be unique for each participant)
        	/*Participant participant1 = new Participant("Bob", "bob2@yahoo.com", "451-312-9090", 02121);
        	Participant participant2 = new Participant("Mary", "mary2@hotmail.com", "341-242-8031", 02446);
        	
        	if (participantDAO.create(participant1)){
        		System.out.println("\n\n Participant created "+participant1);
        	}
        	if (participantDAO.create(participant2)){
        		System.out.println("\n\n Participant created "+participant2);
        	}*/
        	
        	
        	//batch create for participants -- uncomment this while adding a participant (email and phone should be unique for each participant)
        	/*List<Participant> participantList = new ArrayList<Participant>();
        	participantList.add(new Participant("Sanjiv", "sanjiv@yahoo.com", "212-312-3290", 02321));
        	participantList.add(new Participant("Parth", "parth@gmail.com", "617-221-3210", 02132));
        	int results[] = participantDAO.create(participantList);
        	for (int r : results){
        		System.out.println("Updated " + r + " row");
        	}*/
        	
        	//update participant
        	Participant updateParticipant = new Participant(10,"Jim", "jim@yahoo.com", "451-312-9090", 02121);
        	if (participantDAO.update(updateParticipant)){
        		System.out.println("\n\n Participant updated "+updateParticipant);
        	}
        	
        	//remove a participant
        	System.out.println("Participant removed from database ? " + participantDAO.delete(4));
        	
        	//fetch a list of participants
        	List<Participant> participants = participantDAO.getParticipants();
        	for(Participant p : participants) {
            	System.out.println(p);
            }
        	//fetch a single participant
        	Participant singleParticipant = participantDAO.getParticipant(2);
        	System.out.println("\n\n Single Participant is: " +singleParticipant);
        			
		} catch(CannotGetJdbcConnectionException e){
			System.out.println("Cannot get database connection");
		}
        catch (DataAccessException e) {
			System.out.println(e.getMessage());
			System.out.println(e.getClass());
		}
        
        
        
        
        
        
        
        /*Admin admin = (Admin) applicationContext.getBean("admin");
        
        System.out.println(participant);
        System.out.println(admin);*/
        
        ((FileSystemXmlApplicationContext) applicationContext).close();

    }
}
