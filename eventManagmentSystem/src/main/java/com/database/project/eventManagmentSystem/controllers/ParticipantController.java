package com.database.project.eventManagmentSystem.controllers;

import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.database.project.eventManagmentSystem.dao.Participant;
import com.database.project.eventManagmentSystem.service.ParticipantService;

@Controller
public class ParticipantController {
	
	private ParticipantService participantService;
	
	/**
	 * @param participantService the participantService to set
	 */
	@Autowired
	public void setParticipantService(ParticipantService participantService) {
		this.participantService = participantService;
	}

	/**
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("/participants")
	public String showParticipants(Model model) {
		
		List<Participant> participants =  participantService.getCurrent();
		
		model.addAttribute("participants", participants);
		
		return "participants";
	}
	
	@RequestMapping("/createParticipant")
	public String createOffer() {
		
		return "createParticipant";
	}
}