package com.example.managementLaw.Entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;

@Entity
@Table(name = "clients")
public class Client implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "cin", nullable = false)
	private Integer cin;
	
	@Column(name = "first_name", nullable = false)
	private String firstName;
	
	@Column(name = "last_name", nullable = false)
	private String lastName;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "tel", nullable = false)
	private Integer tel;
	
	
	@Column(name = "dateN", nullable = false)
	private LocalDateTime dNaissance;
	
	@JsonBackReference
	@OneToMany(mappedBy = "client", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CaseJur> casesJur = new ArrayList<>();

	public Client() {
		super();
	}

	
	public Client(Long id, Integer cin, String firstName, String lastName, String email, Integer tel, LocalDateTime dNaissance,
			List<CaseJur> casesJur) {
		super();
		this.id = id;
		this.cin = cin;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.tel = tel;
		this.dNaissance = dNaissance;
		this.casesJur= casesJur;
	}
	
	


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getCin() {
		return cin;
	}

	public void setCin(Integer cin) {
		this.cin = cin;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getTel() {
		return tel;
	}

	public void setTel(Integer tel) {
		this.tel = tel;
	}

	public LocalDateTime getdNaissance() {
		return dNaissance;
	}

	public void setdNaissance(LocalDateTime dNaissance) {
		this.dNaissance = dNaissance;
	}

	public List<CaseJur> getCasesJur() {
		return casesJur;
	}

	public void setCasesJur(List<CaseJur> casesJur) {
		this.casesJur = casesJur;
	}

	
	
	}