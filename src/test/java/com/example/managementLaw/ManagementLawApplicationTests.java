package com.example.managementLaw;

import org.junit.jupiter.api.Test;
import com.example.managementLaw.Entity.*;
import com.example.managementLaw.Repository.*;

import java.time.LocalDateTime;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest

class ManagementLawApplicationTests {
	 @Autowired
	    private ClientRepository clientRepository;
@Test
	 void testCreateClient() {
	        // Create a new Client object with the required data
	        Client client = new Client();
	        client.setCin(123456);
	        client.setFirstName("John");
	        client.setLastName("Doe");
	        client.setEmail("john@example.com");
	        client.setTel(1234567890);
	        client.setdNaissance(LocalDateTime.of(1999,02,02,18,10,02));
	        // Set other properties as needed

	        // Save the client to the repository
	        clientRepository.save(client);

	        // You can add assertions here to verify the save operation
	        // For example, you can check if the client has been assigned an ID after saving.
	    }
}
