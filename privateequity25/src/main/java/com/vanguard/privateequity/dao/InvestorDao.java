package com.vanguard.privateequity.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vanguard.privateequity.models.Investor;

public interface InvestorDao extends JpaRepository<Investor, Integer> {

}
