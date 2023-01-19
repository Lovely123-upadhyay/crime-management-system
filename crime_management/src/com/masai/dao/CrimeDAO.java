package com.masai.dao;

import java.util.List;

import com.masai.bean.Crime_Info;
import com.masai.exception.Crime_InfoExcetion;



public interface CrimeDAO {

	public String AddCrime(Crime_Info crimeInfo);
	
	public List<Crime_Info> ViewCrime() throws Crime_InfoExcetion;
	
	public int statuscount(String s1)throws Crime_InfoExcetion;
	
	public int Monthcount(String s1, String s2)throws Crime_InfoExcetion; 
	
	public List<Crime_Info> CrimeArea(String s) throws Crime_InfoExcetion;
	
	public String UpdateCrime(Crime_Info crimeInfo);
	public String DeleteCrime(Crime_Info crimeInfo);
	
	
}


