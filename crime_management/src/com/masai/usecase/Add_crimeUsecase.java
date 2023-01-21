package com.masai.usecase;

import java.util.Scanner;

import com.masai.bean.Crime_Info;
import com.masai.dao.CrimeDAO;
import com.masai.dao.CrimeDAOImp;


public class Add_crimeUsecase {

	public static void AddCrimeRecord() {
			
			Scanner sc= new Scanner (System.in);
			
			
			System.out.println("Enter the Crime Date: ");
			String date1=sc.nextLine();
			
			System.out.println("Enter the Crime Place : ");
			String place=sc.nextLine();
			
			
			System.out.println("Enter the Crime Type Name : ");
			String crime=sc.nextLine();
			
			System.out.println("Enter the Crime Victims : ");
			String victim=sc.nextLine();
			
			System.out.println("Enter Detail Description of crime: ");
			String desc=sc.nextLine();
			
			System.out.println("Enter the Crime Suspected name : ");
			String suspect=sc.nextLine();
			
			CrimeDAO dao1=new CrimeDAOImp();

			Crime_Info crime1=new Crime_Info();
			
			crime1.setCdate(date1);
			crime1.setCplace(place);
			crime1.setCrime(crime);
			crime1.setVictims(victim);;
			crime1.setDescription_Crime(desc);
			crime1.setSuspected_name(suspect);
			
			String result= dao1.AddCrime(crime1);
			
			System.out.println(result);
			
	}

	
}
