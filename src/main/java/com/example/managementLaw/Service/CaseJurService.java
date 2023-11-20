package com.example.managementLaw.Service;

import java.util.List;

import com.example.managementLaw.Entity.CaseJur;

public interface CaseJurService {
List<CaseJur> getAllCaseJurs();
	
CaseJur saveCaseJur(CaseJur CaseJur);
	
CaseJur getCaseJurById(Long id);
	
CaseJur updateCaseJur(CaseJur CaseJur);
	
	void deleteCaseJurById(Long id);
}
