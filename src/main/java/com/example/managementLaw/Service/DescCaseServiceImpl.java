package com.example.managementLaw.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.managementLaw.Entity.DescCase;
import com.example.managementLaw.Repository.DescCaseRepository;
@Service
public class DescCaseServiceImpl implements DescCaseService {

	@Autowired
	private DescCaseRepository DescCaseRepository;
	
	
	public DescCaseServiceImpl(DescCaseRepository descCaseRepository) {
		super();
		DescCaseRepository = descCaseRepository;
	}

	@Override
	public List<DescCase> getAllDescCases() {
		// TODO Auto-generated method stub
		return  DescCaseRepository.findAll();
	}

	@Override
	public DescCase saveDescCase(DescCase DescCase) {
		// TODO Auto-generated method stub
		return DescCaseRepository.save(DescCase);
	}

	@Override
	public DescCase getDescCaseById(Long id) {
		return DescCaseRepository.findById(id).get();
	}

	@Override
	public DescCase updateDescCase(DescCase DescCase) {
		return DescCaseRepository.save(DescCase);
	}

	@Override
	public void deleteDescCaseById(Long id) {
		DescCaseRepository.deleteById(id);	
	}

	/*@Override
	public List<DescCase> findByCaseJur(Long id) {
		// TODO Auto-generated method stub
		return DescCaseRepository.findByCaseJur(id);
	}*/

}
