package com.example.managementLaw.Entity;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;

@Entity
@Table(name = "caseJurs")
public class CaseJur {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
		public Long id;
	    
	    @Column(name = "numero", nullable = false)
	    private String numero;
	    
	  
	    
	    @Column(name = "date_creation", nullable = false)
	    private Date dateCreation;
	    
	    @ManyToOne
	  
	    private Client client;

	    @JsonBackReference
		@OneToMany(mappedBy = "caseJur", cascade = CascadeType.ALL, orphanRemoval = true )
	    private List<DescCase> descCase = new ArrayList<>();
	    
	    public CaseJur() {}
	    
		
		

		public CaseJur(Long id, String numero,  Date dateCreation, Client client,
				List<DescCase> descCase) {
			super();
			this.id = id;
			this.numero = numero;
		
			this.dateCreation = dateCreation;
			this.client = client;
			this.descCase = descCase;
		}


		public  Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getNumero() {
			return numero;
		}

		public void setNumero(String numero) {
			this.numero = numero;
		}

		
		public Date getDateCreation() {
			return dateCreation;
		}

		public void setDateCreation(Date dateCreation) {
			this.dateCreation = dateCreation;
		}

		public Client getClient() {
			return client;
		}

		public void setClient(Client client) {
			this.client = client;
		}
	    
		public List<DescCase> getDescCase() {
			return descCase;
		}


		public void setDescCase(List<DescCase> descCase) {
			this.descCase = descCase;
		}

	







}
