package com.example.managementLaw.Entity;


import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.*;


@Entity
@Table(name = "tasks")

public class Task {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "titre", nullable = false)
	private String titre;
	@Column(name = "description", nullable = false)
	private String  description;
	@Column(name = "status", nullable = false)
	private String status;

	@Column(name = "datec", nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	    private LocalDateTime dateC;

	 
	@Column(name = "datet", nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	    private LocalDateTime dateT;

	
	public Task() {}

	

	public Task(Long id, String titre, String description, String status,  LocalDateTime dateC,  LocalDateTime dateT) {
		super();
		this.id = id;
		this.titre = titre;
		this.description = description;
		this.status = status;
		this.dateC = dateC;
		this.dateT = dateT;
	}



	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getTitre() {
		return titre;
	}


	public void setTitre(String titre) {
		this.titre = titre;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public LocalDateTime getDateC() {
		return dateC;
	}


	public void setDateC(LocalDateTime dateC) {
		this.dateC = dateC;
	}


	public LocalDateTime getDateT() {
		return dateT;
	}


	public void setDateT(LocalDateTime dateT) {
		this.dateT = dateT;
	}

	
	
	
	

}
