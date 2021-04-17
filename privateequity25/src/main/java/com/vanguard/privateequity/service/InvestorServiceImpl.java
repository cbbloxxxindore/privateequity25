package com.vanguard.privateequity.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vanguard.privateequity.dao.InvestorDao;
import com.vanguard.privateequity.exceptions.InvesterException;
import com.vanguard.privateequity.models.Investor;
@Service
public class InvestorServiceImpl implements InvestorService
{
	@Autowired
 private InvestorDao investorDao;
	public Investor saveInvestor(Investor investor) throws InvesterException
	{
		
		Investor investor2=null;
 try {
	
	 
	investor2 =investorDao.save(investor);
} catch (Exception e) {

throw (new InvesterException("bad input"));
}
		
		return investor2;
	}

	public Investor updateInvestor(Investor investor, int investorid) throws InvesterException  
	{
		
		Investor investor2=null;
 try {
	
	 investor.setInvestorid(investorid);
	investor2 =investorDao.save(investor);
} catch (Exception e) {

throw (new InvesterException("bad input"));
}
		
		return investor2;
	
	}

	public void deleteInvestor(int investorid)
	{

		try {
			investorDao.deleteById(investorid);
		} catch (Exception e) {

		System.out.println(e);
		}
	}

	public Optional<Investor> getInvestor(int investorid) throws InvesterException {
		
		Optional<Investor> optional=null;
		try {
			 optional=investorDao.findById(investorid);
		} catch (Exception e) {
throw(new InvesterException("invaild input"));
		
		}
		return optional;
	}

	
	public List<Investor> getAllInvestor() {

		List<Investor> list=null;
		
		try {
			list=investorDao.findAll();
		} catch (Exception e) {
			System.out.println(e);
		}
		return list;
	}

}
