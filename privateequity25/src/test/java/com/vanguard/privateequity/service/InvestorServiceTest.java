package com.vanguard.privateequity.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.vanguard.privateequity.dao.InvestorDao;
import com.vanguard.privateequity.exceptions.InvesterException;
import com.vanguard.privateequity.models.Investor;


@SpringBootTest
@RunWith(SpringRunner.class)
public class InvestorServiceTest {

	@Autowired
	InvestorService investorService;
	
	@MockBean
	InvestorDao investorDao;
	
	@Test
	 public void  saveInvestorTest() throws InvesterException
	 {
		
		 Investor investor=new Investor();
		 investor.setEmail("abhijeet");
		 when(investorDao.save(investor)).thenReturn(investor);
		 assertEquals(investor, investorService.saveInvestor(investor));
	 }
	
	@Test
	 public void  UpdateInvestorTest() throws InvesterException
	 {
		
		 Investor investor=new Investor();
		 investor.setEmail("abhijeet");
		 investor.setInvestorid(12);
		 when(investorDao.save(investor)).thenReturn(investor);
		 assertEquals(investor, investorService.updateInvestor(investor,investor.getInvestorid() ));
	 }
	
	
	@Test
	public void deleteInvestor() 
	{
		 
		Investor investor=new Investor();
		 investor.setInvestorid(12);
		 doNothing().when(investorDao).deleteById(investor.getInvestorid());
		
	}
	@Test
	 public void  getInvestorTest() throws InvesterException
	 {
		
		Investor investor=new Investor();
		 investor.setEmail("abhijeet");
		 investor.setInvestorid(12);

		 when(investorDao.findById(investor.getInvestorid())).thenReturn(Optional.of(investor));
		 assertEquals(Optional.of(investor), investorService.getInvestor(investor.getInvestorid()));
	 }

		
	@Test
	 public void getAllInvestorTest() 
	 {
		
		List<Investor> list = new ArrayList<Investor>();
		Investor investor1=new Investor();
		 investor1.setEmail("abhijeet");
		 investor1.setInvestorid(12);
		 Investor investor2=new Investor();
		 investor2.setEmail("abhijeet");
		 investor2.setInvestorid(12);

		list.add(investor1);
		 when(investorDao.findAll()).thenReturn(list);
		 assertEquals(list.size(), investorService.getAllInvestor().size());
	 }

	 

}
