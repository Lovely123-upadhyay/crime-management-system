package com.masai.usecase;


import java.util.Scanner;

import com.masai.bean.Criminal_Info;
import com.masai.dao.CriminalDAO;
import com.masai.dao.CriminalDAOImpl;

public class DelectCriminalUsecase {

public static void DeleteCriminal() {
		
		Scanner sc=new Scanner(System.in);

		System.out.println("Enter the Cid: ");
		int id=sc.nextInt();
		
		CriminalDAO dao=new CriminalDAOImpl();

	
		
      String result= dao.DeleteCriminal(id);
		
		System.out.println(result);
		
		
	}
	
}
