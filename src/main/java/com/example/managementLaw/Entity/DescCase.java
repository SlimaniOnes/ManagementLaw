package com.example.managementLaw.Entity;

import java.sql.Date;
import java.time.LocalDateTime;

import org.springframework.web.multipart.MultipartFile;

import jakarta.persistence.*;

@Entity
@Table(name = "descCase")
public class DescCase {

	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    
	    @Column(name = "description", nullable = false)
	    private String description;
	    
	    @Column(name = "date_creation", nullable = false)
	    private LocalDateTime dateCreation;
	    
	    @Transient
	    @Column(name = "file", nullable = true)
	    private MultipartFile file;
	    
	    @ManyToOne
	 
	    private CaseJur caseJur;

	    
		public DescCase() {
			super();
		}


		public DescCase(Long id, String description, LocalDateTime dateCreation, MultipartFile file, CaseJur caseJur) {
			super();
			this.id = id;
			this.description = description;
			this.dateCreation = dateCreation;
			this.file = file;
			this.caseJur = caseJur;
		}


		public Long getId() {
			return id;
		}


		public void setId(Long id) {
			this.id = id;
		}


		public String getDescription() {
			return description;
		}


		public void setDescription(String description) {
			this.description = description;
		}


		public LocalDateTime getDateCreation() {
			return dateCreation;
		}


		public void setDateCreation(LocalDateTime dateCreation) {
			this.dateCreation = dateCreation;
		}


		public MultipartFile getFile() {
			return file;
		}


		public void setFile(MultipartFile file) {
			this.file = file;
		}


		public CaseJur getCaseJur() {
			return caseJur;
		}


		public void setCaseJur(CaseJur caseJur) {
			this.caseJur = caseJur;
		}
	    
		
	    
}
