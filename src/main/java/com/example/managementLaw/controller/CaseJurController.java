package com.example.managementLaw.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.managementLaw.Entity.*;
import com.example.managementLaw.Service.*;
@Controller
public class CaseJurController {
	@Autowired
	private CaseJurService CaseJurService;

	@Autowired
	private ClientService ClientService;
	
	
	
	public CaseJurController(CaseJurService caseJurService,
		ClientService clientService) {
		super();
		CaseJurService = caseJurService;
		ClientService = clientService;
	}

	@GetMapping("/CaseJurs")
	public String listCaseJurs(Model model) {
		model.addAttribute("CaseJurs", CaseJurService.getAllCaseJurs());
		return "CaseJurs";
	}
	
	@GetMapping("/CaseJurs/new")
	public String createCaseJurForm(Model model) {
		
		// create student object to hold student form data
		CaseJur CaseJur = new CaseJur();
		 model.addAttribute("clients", ClientService.getAllClients());
		model.addAttribute("CaseJur", CaseJur);
		return "create_caseJurs";
		
		
	}
	
	@PostMapping("/CaseJurs")
	public String saveCaseJur( @ModelAttribute("CaseJur") CaseJur CaseJur) {
	         
		CaseJurService.saveCaseJur(CaseJur);
		return "redirect:/CaseJurs";
	}
	
	@GetMapping("/CaseJurs/edit/{id}")
	public String editCaseJurForm(@PathVariable Long id, Model model) {
		model.addAttribute("CaseJur", CaseJurService.getCaseJurById(id));
		List<Client> clients = ClientService.getAllClients();
	    
	    // Add the list of clients to the model
	    model.addAttribute("clients", clients);
		return "edit_caseJurs";
	}

	@PostMapping("/CaseJurs/{id}")
	public String  updateCaseJurs( @PathVariable Long id,
	        @ModelAttribute("CaseJur") CaseJur CaseJur,
	        BindingResult result,
	        Model model) {
		
		// get student from database by id
		
		 
		CaseJur c = CaseJurService.getCaseJurById(id);
	       
c.setId(id);
		c.setNumero(CaseJur.getNumero());
		
		c.setDateCreation(CaseJur.getDateCreation());
		  Long clientId = CaseJur.getClient().getId();
	        Client associatedClient = ClientService.getClientById(clientId);
	        c.setClient(associatedClient);
		
		
		
		// save updated student object
		CaseJurService.updateCaseJur(c);
		return "redirect:/CaseJurs";		
	}
	
	// handler method to handle delete student request
	
	@GetMapping("/CaseJurs/{id}")
	public String delete(@PathVariable Long id) {
		CaseJurService.deleteCaseJurById(id);
		return "redirect:/CaseJurs";
	}
	
	
}
