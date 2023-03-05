package com.masai.usecase;

import java.util.List;
import java.util.Scanner;

import com.masai.bean.Criminal_Info;
import com.masai.dao.CriminalDAO;
import com.masai.dao.CriminalDAOImpl;
import com.masai.exception.Criminal_InfoException;

public class ViewCriminalListBasedOnGenderUsecase {
	
	public static void main() {
		
		
		Scanner sc = new Scanner(System.in);
		System.out.println("enter criminal gender m or f");
		String gen = sc.next();
		
		CriminalDAO dao = new CriminalDAOImpl();
		 try {
			List<Criminal_Info> list =  dao.ViewCriminalListBasedOnGender(gen);
			System.out.println(list);
		} catch (Criminal_InfoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
