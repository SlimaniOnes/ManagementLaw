package com.example.managementLaw.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.managementLaw.Entity.*;
import com.example.managementLaw.Service.*;

@Controller
public class DescCaseController {

	@Autowired
	private CaseJurService CaseJurService;
	@Autowired
	private DescCaseService DescCaseService;
	
	
	public DescCaseController(CaseJurService caseJurService, DescCaseService descCaseService) {
		super();
		CaseJurService = caseJurService;
		DescCaseService = descCaseService;
	}
	
	@GetMapping("/DescCases")
	public String listDescCasess(Model model) {
		model.addAttribute("descCases", DescCaseService.getAllDescCases());
		return "DescCases";
	}
	
	@GetMapping("/DescCases/new")
	public String createDescCaseForm(Model model) {
	
		    DescCase descCase = new DescCase();
		    model.addAttribute("caseJurs", CaseJurService.getAllCaseJurs());
		    
		    model.addAttribute("descCase", descCase);

		    return "create_Desc";
		
	}
	
	@PostMapping("/DescCases")
	public String saveDescCase(@ModelAttribute("DescCase") DescCase DescCase) {

		   DescCaseService.saveDescCase(DescCase);
    
	    return "redirect:/DescCases";
	}
	
	
	@GetMapping("/DescCases/edit/{id}")
	public String editDescCaseForm(@PathVariable Long id, Model model) {
		model.addAttribute("DescCase", DescCaseService.getDescCaseById(id));
		List<DescCase> descCases = DescCaseService.getAllDescCases();
	    
	    // Add the list of clients to the mode
	    model.addAttribute("DescCase", descCases);
		return "edit_DescCases";
	}

	@PostMapping("/DescCases/{id}")
	public String  updateDescCases( @PathVariable Long id,
	        @ModelAttribute("DescCase") DescCase DescCase,
	        BindingResult result,
	        Model model) {

		DescCase c = DescCaseService.getDescCaseById(id);
	       
		c.setId(id);
		c.setFile(DescCase.getFile());
		c.setDescription(DescCase.getDescription());
		c.setDateCreation(DescCase.getDateCreation());
		  Long case_jur_id = DescCase.getCaseJur().getId();
		  CaseJur associatedCaseJur = CaseJurService.getCaseJurById(case_jur_id);
	        c.setCaseJur(associatedCaseJur);
		
		
		
		// save updated student object
	        DescCaseService.updateDescCase(c);
		return "redirect:/DescCases";		
	}

	@GetMapping("/DescCases/{id}")
	public String delete(@PathVariable Long id) {
		DescCaseService.deleteDescCaseById(id);
		return "redirect:/DescCases";
	}
	
	/*@GetMapping("/DescCases/DescCasesByCase/{caseJurId}")
	public String getDescCasesByCase(@PathVariable("caseJurId") Long caseJurId, Model model) {
	    List<DescCase> desccases = DescCaseService.findByCaseJur(caseJurId);
	    model.addAttribute("desccases", desccases);
	    model.addAttribute("selected", caseJurId);
	    return "/descCassBy"; 
	}*/


	
}
