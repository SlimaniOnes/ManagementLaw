package com.example.managementLaw.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.managementLaw.Entity.CaseJur;
import com.example.managementLaw.Repository.CaseJurRepository;

@Service
public class CaseJurServiceImpl implements CaseJurService{

	 @Autowired
		private CaseJurRepository CaseJurRepository;
	 
	 
		
	public CaseJurServiceImpl(com.example.managementLaw.Repository.CaseJurRepository caseJurRepository) {
		super();
		CaseJurRepository = caseJurRepository;
	}

	@Override
	public List<CaseJur> getAllCaseJurs() {
		// TODO Auto-generated method stub
		return CaseJurRepository.findAll() ;
	}

	@Override
	public CaseJur saveCaseJur(CaseJur CaseJur) {
		// TODO Auto-generated method stub
		return CaseJurRepository.save(CaseJur);
	}

	@Override
	public CaseJur getCaseJurById(Long id) {
		// TODO Auto-generated method stub
		return CaseJurRepository.findById(id).get();
	}

	@Override
	public CaseJur updateCaseJur(CaseJur CaseJur) {
		// TODO Auto-generated method stub
		return CaseJurRepository.save(CaseJur);
	}

	@Override
	public void deleteCaseJurById(Long id) {
		// TODO Auto-generated method stub
		CaseJurRepository.deleteById(id);	
		
	}

}
