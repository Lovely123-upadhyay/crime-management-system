package com.masai.usecase;

import java.util.Scanner;

import com.masai.dao.Criminal_crimeDAO;
import com.masai.dao.Criminal_crimeDAOImol;


public class Getcriminal_crimeInsertUsecase {

	public static void AddCriminalCrime() {
		
		Scanner sc= new Scanner (System.in);
		
		
		System.out.println("Enter Crime Id: ");
		int id=sc.nextInt();
		
		System.out.println("Enter Criminal Id : ");
		int id1=sc.nextInt();
		
		Criminal_crimeDAO dao1=new Criminal_crimeDAOImol();
	
		
		String res = dao1.AddCriminalCrime(id, id1);
		
		System.out.println(res);
	
		
}


	
}
