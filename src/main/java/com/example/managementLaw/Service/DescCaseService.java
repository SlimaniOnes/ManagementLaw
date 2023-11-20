package com.example.managementLaw.Service;

import java.util.List;

import com.example.managementLaw.Entity.DescCase;


public interface DescCaseService {
	List<DescCase> getAllDescCases();
	
	DescCase saveDescCase(DescCase DescCase);
		
	DescCase getDescCaseById(Long id);
		
	DescCase updateDescCase(DescCase DescCase);
		
		void deleteDescCaseById(Long id);
		
		/*public List<DescCase> findByCaseJur(Long caseJur_id);
	*/
}
