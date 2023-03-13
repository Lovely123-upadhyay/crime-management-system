package com.masai.dao;

import java.util.List;

import com.masai.bean.Criminal_Info;
import com.masai.exception.Criminal_InfoException;

public interface CriminalDAO {

	public String AddCriminal(Criminal_Info criminalInfo);
    
	public List<Criminal_Info> ViewCriminal() throws Criminal_InfoException;
	
	public Criminal_Info getcriminalByCId(int Cid) throws   Criminal_InfoException;
	
	public String UpdateCriminal(Criminal_Info criminalInfo);
	
	public String DeleteCriminal(int criminalId);
	
	public List<Criminal_Info> ViewCriminalListBasedOnGender(String gender) throws Criminal_InfoException;
	
	public List<Criminal_Info> ViewCriminalListBasedOnAge(int age) throws Criminal_InfoException;
	
}
