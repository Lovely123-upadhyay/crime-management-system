package com.masai.dao;

import java.util.List;

import com.masai.bean.Criminal_Info;
import com.masai.exception.Criminal_InfoExcetion;

public interface CriminalDAO {

	public String AddCriminal(Criminal_Info criminalInfo);
    
	public List<Criminal_Info> ViewCriminal() throws Criminal_InfoExcetion;
	
	public Criminal_Info getcriminalByCId(int Cid) throws   Criminal_InfoExcetion;
	
	public String UpdateCriminal(Criminal_Info criminalInfo);
	
	public String DeleteCriminal(Criminal_Info criminalInfo);
	
	
	
}
