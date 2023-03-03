package com.masai.usecase;

import java.util.Scanner;

import com.masai.bean.Crime_Info;
import com.masai.dao.CrimeDAO;
import com.masai.dao.CrimeDAOImp;


public class DeleteCrimeUsecase {

	public static void DelectCrimeRecord() {
		
			Scanner sc=new Scanner(System.in);
			
			System.out.println("Enter the Cid: ");
			int id=sc.nextInt();
			
			CrimeDAO dao=new CrimeDAOImp();

			Crime_Info crime=new Crime_Info();
		
			crime.setCrimeId(id);;
			
	        String result= dao.DeleteCrime(id);
			
			System.out.println(result);

	}
}

