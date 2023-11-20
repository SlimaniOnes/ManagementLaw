package com.example.managementLaw.Service;

import java.util.List;

import com.example.managementLaw.Entity.Client;


public interface ClientService {
	List<Client> getAllClients();
	
	Client saveClient(Client Client);
	
	Client getClientById(Long id);
	
	Client updateClient(Client Client);
	
	void deleteClientById(Long id);
}