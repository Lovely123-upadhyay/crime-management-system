package com.masai.usecase;

import java.util.Scanner;

import com.masai.bean.Criminal_Info;
import com.masai.dao.CriminalDAO;
import com.masai.dao.CriminalaDAOImpl;


public class UpdateCriminalUsecase {

	public static void Updatecriminal() {
		
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter the Criminal Name: ");
		String name=sc.next();
		
		System.out.println("Enter the 2Cid: ");
		int id=sc.nextInt();
		
		CriminalDAO dao=new CriminalaDAOImpl();

		Criminal_Info criminal=new Criminal_Info();
		
		
		criminal.setName(name);
		criminal.setCid(id);
		
      String result= dao.UpdateCriminal(criminal);
		
		System.out.println(result);
		
		
	}
	
}

