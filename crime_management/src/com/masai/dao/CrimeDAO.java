package com.masai.dao;

import java.util.List;

import com.masai.bean.Crime_Info;
import com.masai.exception.Crime_InfoException;



public interface CrimeDAO {

	public String AddCrime(Crime_Info crimeInfo);
	
	public List<Crime_Info> ViewCrime() throws Crime_InfoException;
	
	public int statuscount(String s1)throws Crime_InfoException;
	
	public int Monthcount(String s1, String s2)throws Crime_InfoException; 
	
	public List<Crime_Info> CrimeArea(String s) throws Crime_InfoException;
	
	public String UpdateCrime(Crime_Info crimeInfo);
	
	public String DeleteCrime(int crimeId);
	
	public List<Crime_Info> getListBaseonCrimeAndStstus(String crime, String satus) throws Crime_InfoException;
	
	public List<Crime_Info> CrimeName(String crimeName) throws Crime_InfoException;
	
}


