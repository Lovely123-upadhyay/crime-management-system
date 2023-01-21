package com.masai.usecase;

import java.util.List;

import com.masai.bean.Crime_Info;
import com.masai.dao.CrimeDAO;
import com.masai.dao.CrimeDAOImp;
import com.masai.exception.Crime_InfoException;



public class GetCrimeUsecase {

public static void ViewCrimeRecord() {
		
		CrimeDAO dao = new CrimeDAOImp();
		
		try {
		List<Crime_Info> criminals= dao.ViewCrime();
		
		criminals.forEach(s ->{
			
			System.out.println("Crime Id :"+s.getCrimeId());
			System.out.println("Crime Date : "+s.getCdate());
			System.out.println("Crime Place: "+s.getCplace());
			System.out.println("Crime Name: "+s.getCrime());
			System.out.println("Crime Victims: "+s.getVictims());
			System.out.println("Crime Description: "+s.getDescription_Crime());
			System.out.println("Crime Suspected name : "+s.getSuspected_name());
			System.out.println("Crime Case Status: "+s.getCase_Status());
			
			System.out.println("================================================");
			
			System.out.println();
			
			
		});
		
		}catch(Crime_InfoException se) {
			System.out.println(se.getMessage());
		}
		

	}
}
