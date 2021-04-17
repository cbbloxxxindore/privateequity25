package com.vanguard.privateequity.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vanguard.privateequity.exceptions.InvesterException;
import com.vanguard.privateequity.models.Investor;
import com.vanguard.privateequity.service.InvestorService;

@RestController
public class InvestorController
{
	@Autowired
	 private InvestorService investorService;
@PostMapping("/saveInvestor")
	public  ResponseEntity<Investor>  saveInvestor(@RequestBody Investor investor)
	{
	Investor investor2=null;
	try {
		investor2=investorService.saveInvestor(investor);
		
	} catch (InvesterException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();	
	}
	
	
	return ResponseEntity.ok(investor2);
	
	
	}

@PutMapping("/UpdateInvestor/{investorid}")
public  ResponseEntity<Investor>  UpdateInvestor(@RequestBody Investor investor,@PathVariable("investorid") int investorid )
{
	



	Investor investor2=null;
	try {
		investor2=investorService.updateInvestor(investor,  investorid);
		
	} catch (InvesterException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();	
	}
	
	
	return ResponseEntity.ok(investor2);
	
	

}
@DeleteMapping("/deleteInvestor/{investorid}")
public  ResponseEntity<Void>  deleteInvestor( @PathVariable("investorid")int  investorid)
{
	
	
	try {
		investorService.deleteInvestor(investorid);
	} catch (Exception e) {
return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		
	}
	
return ResponseEntity.status(HttpStatus.NO_CONTENT).build();


}

@GetMapping("/getInvestor/{investorid}")
public  ResponseEntity<Optional<Investor>>  getInvestor(@PathVariable("investorid") int investorid)
{Optional<Investor> optional=null;
	try {
		optional=investorService.getInvestor(investorid);
	} catch (InvesterException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	
	
	
return ResponseEntity.of(Optional.of(optional));


}
@GetMapping("/getAllInvestor")
public  ResponseEntity< List<Investor>>  getAllInvestor()
{
	List<Investor> list=null;
	
	try {
		list=investorService.getAllInvestor();
	} catch (Exception e) {

return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	}
	
return ResponseEntity.ok(list);


}

}
