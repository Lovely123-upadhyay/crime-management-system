package com.masai.usecase;

import java.util.List;
import java.util.Scanner;

import com.masai.bean.Criminal_Info;
import com.masai.dao.Criminal_crimeDAO;
import com.masai.dao.Criminal_crimeDAOImol;
import com.masai.exception.Criminal_InfoException;


public class GetCriminal_crimeUsecase {

	public static void CriminalCrimeRecord() {
		
	Scanner sc= new Scanner (System.in);
	System.out.println("Enter Type Crime Name : ");
	
	String cr=sc.next();
	
	Criminal_crimeDAO dao = new Criminal_crimeDAOImol();
	
	try {
	List<Criminal_Info> criminals= dao.CrimeFile(cr);
	
	criminals.forEach(s ->{
		
		
		System.out.println("Criminal name: "+s.getName());
		System.out.println("Criminal Crime Name: "+s.getCrime_Name());
		
		System.out.println("*******************************************************");
		
		System.out.println();
		
		
	});
	
	
	
	}catch(Criminal_InfoException se) {
		System.out.println(se.getMessage());
	}
	
	
	
}
	
}

