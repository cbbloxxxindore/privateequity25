package com.vanguard.privateequity.service;

import java.util.List;
import java.util.Optional;

import com.vanguard.privateequity.exceptions.InvesterException;
import com.vanguard.privateequity.models.Investor;

public interface InvestorService {
	  Investor saveInvestor(Investor investor ) throws InvesterException;
	  Investor updateInvestor(Investor investor ,int investorid ) throws InvesterException;
	  void deleteInvestor(int investorid );
	  Optional<Investor> getInvestor(int investorid ) throws InvesterException;
	 List< Investor> getAllInvestor();

}
