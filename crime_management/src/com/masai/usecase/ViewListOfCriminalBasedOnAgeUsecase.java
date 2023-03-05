package com.masai.usecase;

import java.util.List;
import java.util.Scanner;

import com.masai.bean.Criminal_Info;
import com.masai.dao.CriminalDAO;
import com.masai.dao.CriminalDAOImpl;
import com.masai.exception.Criminal_InfoException;

public class ViewListOfCriminalBasedOnAgeUsecase {

	public static void main() {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter criminal age");
		int age = sc.nextInt();
		
		CriminalDAO dao = new CriminalDAOImpl();
               try {
				List<Criminal_Info>   list =  dao.ViewCriminalListBasedOnAge(age);
				System.out.println(list);
			} catch (Criminal_InfoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

}
