package com.masai.usecase;

import java.util.List;
import java.util.Scanner;

import com.masai.bean.Crime_Info;
import com.masai.dao.CrimeDAO;
import com.masai.dao.CrimeDAOImp;
import com.masai.exception.Crime_InfoException;

public class GetCrimeBasesOnCrimeAndStatusUsecase {
	
	public static void main() {
		Scanner sc = new Scanner(System.in);
		CrimeDAO  dao = new CrimeDAOImp();
		
		System.out.println("Enter crime name");
		String name = sc.next();
		
		System.out.println("enter crime status solved and unsolved");
		String status = sc.next();
		
		 try {
			List<Crime_Info>  list = dao.getListBaseonCrimeAndStstus(name, status);
			System.out.println(list);
		} catch (Crime_InfoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
