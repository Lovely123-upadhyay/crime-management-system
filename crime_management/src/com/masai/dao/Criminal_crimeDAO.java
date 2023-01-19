package com.masai.dao;

import java.util.List;

import com.masai.bean.Criminal_Info;
import com.masai.exception.Criminal_InfoExcetion;



public interface Criminal_crimeDAO {

	public List<Criminal_Info>  CrimeFile(String cname)  throws Criminal_InfoExcetion;
	
	public String AddCriminalCrime(int id, int id1);
}
