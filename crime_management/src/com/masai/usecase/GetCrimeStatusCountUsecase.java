package com.masai.usecase;

import java.util.Scanner;

import com.masai.dao.CrimeDAO;
import com.masai.dao.CrimeDAOImp;
import com.masai.exception.Crime_InfoException;



public class GetCrimeStatusCountUsecase {

	public static void countSovingCases() {
		CrimeDAO dao = new CrimeDAOImp();
		Scanner sc= new Scanner (System.in);
		System.out.println("Enter the value of Case status");
		String s1=sc.next();
		
		try {
		int c=dao.statuscount(s1);
		System.out.println("Total Number of solved/Unsolved Cases : "+c);	
			
		} 
		catch (Crime_InfoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
}

