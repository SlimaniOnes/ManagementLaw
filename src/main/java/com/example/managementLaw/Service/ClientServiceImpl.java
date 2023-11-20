package com.example.managementLaw.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.managementLaw.Entity.Client;
import com.example.managementLaw.Repository.*;

@Service
public class ClientServiceImpl implements ClientService{
	   @Autowired
	private ClientRepository ClientRepository;
	
	public ClientServiceImpl(ClientRepository studentRepository) {
		super();
		this.ClientRepository = ClientRepository;
	}

	@Override
	public List<Client> getAllClients() {
		return ClientRepository.findAll();
	}

	@Override
	public Client saveClient(Client Client) {
		return ClientRepository.save(Client);
	}

	@Override
	public Client getClientById(Long id) {
		return ClientRepository.findById(id).get();
	}

	@Override
	public Client updateClient(Client Client) {
		return ClientRepository.save(Client);
	}

	@Override
	public void deleteClientById(Long id) {
		ClientRepository.deleteById(id);	
	}

}
