package com.example.managementLaw.controller;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.managementLaw.Entity.Client;
import com.example.managementLaw.Service.*;



@Controller
public class ClientController {
	
	private ClientService ClientService;

	public ClientController(ClientService ClientService) {
		super();
		this.ClientService = ClientService;
	}
	
	// handler method to handle list students and return mode and view
	@GetMapping("/clients")
	public String listStudents(Model model) {
		model.addAttribute("clients", ClientService.getAllClients());
		return "clients";
	}
	
	@GetMapping("/clients/new")
	public String createStudentForm(Model model) {
		
		// create student object to hold student form data
		Client Client = new Client();
		model.addAttribute("client", Client);
		return "create_client";
		
	}
	
	@PostMapping("/clients")
	public String saveClient(@ModelAttribute("Client") Client Client) {
		ClientService.saveClient(Client);
		return "redirect:/clients";
	}
	
	@GetMapping("/clients/edit/{id}")
	public String editClientForm(@PathVariable Long id, Model model) {
		model.addAttribute("client", ClientService.getClientById(id));
		return "edit_clientt";
	}

	@PostMapping("/clients/{id}")
	public String updateClient(@PathVariable Long id,
			@ModelAttribute("client") Client client,
			Model model) {
		
		// get student from database by id
		Client existingClient = ClientService.getClientById(id);
		existingClient.setId(id);
		existingClient.setCin(client.getCin());
		existingClient.setFirstName(client.getFirstName());
		existingClient.setLastName(client.getLastName());
		existingClient.setEmail(client.getEmail());
		existingClient.setTel(client.getTel());
		existingClient.setdNaissance(client.getdNaissance());
		
		// save updated student object
		ClientService.updateClient(existingClient);
		return "redirect:/clients";		
	}
	
	// handler method to handle delete student request
	
	@GetMapping("/clients/{id}")
	public String deleteClient(@PathVariable Long id) {
		ClientService.deleteClientById(id);
		return "redirect:/clients";
	}
	
}
