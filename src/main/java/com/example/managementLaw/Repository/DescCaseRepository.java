package com.example.managementLaw.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.managementLaw.Entity.DescCase;

public interface DescCaseRepository extends JpaRepository<DescCase, Long> {
	
}
