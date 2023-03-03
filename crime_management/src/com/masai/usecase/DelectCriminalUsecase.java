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

		Criminal_Info criminal=new Criminal_Info();
	
		criminal.setCid(id);
		
      String result= dao.DeleteCriminal(criminal);
		
		System.out.println(result);
		
		
	}
	
}
