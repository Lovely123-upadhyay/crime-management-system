package com.masai.usecase;

import java.util.List;
import java.util.Scanner;

import com.masai.bean.Crime_Info;
import com.masai.dao.CrimeDAO;
import com.masai.dao.CrimeDAOImp;
import com.masai.exception.Crime_InfoException;

public class GetListOfCrimeBasedOnCrimeNameUsecase {
	
	public static void main() {
		Scanner sc = new Scanner(System.in);
		CrimeDAO  dao = new CrimeDAOImp();
		
		System.out.println("Enter crime name");
		String name = sc.next();
		
		try {
			List<Crime_Info>  list = dao.CrimeName(name);
			System.out.println(list);
		} catch (Crime_InfoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	


}
