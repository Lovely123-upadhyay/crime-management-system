package com.masai.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.masai.bean.Crime_Info;
import com.masai.exception.Crime_InfoException;
import com.masai.utility.DBUtil;


public class CrimeDAOImp implements CrimeDAO{

//	for adding crime 
	@Override
	public String AddCrime(Crime_Info crimeInfo) {
		String res = "Not Insertd ....";
		
	
		try(Connection conn= DBUtil.provideConnection();) {
			PreparedStatement ps = conn.prepareStatement
					("insert into criminfo (cdate, cplace, Crime_name, Victims, Description_crime, suspected_name)"
												+ "values (?,?,?,?,?,?)");
			
			ps.setString(1,crimeInfo.getCdate());
			ps.setString(2, crimeInfo.getCplace());
			ps.setString(3,crimeInfo.getCrime());
			ps.setString(4,crimeInfo.getVictims());
			ps.setString(5,crimeInfo.getDescription_Crime());
			ps.setString(6,crimeInfo.getSuspected_name());
			
			
			
			int x=ps.executeUpdate();
			
			if(x>0) {
				
				res="Crime Added Sucessfully !";
			}
		} catch (SQLException e) {
		
			
			e.printStackTrace();
			System.out.println(e.getMessage());
			
		}
		
		
		return res;
	}

//	view list or crimes
	@Override
	public List<Crime_Info> ViewCrime() throws Crime_InfoException {
		List<Crime_Info> list = new ArrayList<>();


		try(Connection conn= DBUtil.provideConnection();) {
		
			PreparedStatement ps = conn.prepareStatement ("select * from criminfo");
			
			ResultSet rs= ps.executeQuery();
			while(rs.next()) {
			
				int id= rs.getInt("crimeId");
				String n= rs.getString("cdate");
				String a= rs.getString("cplace");
				String g= rs.getString("Crime_name");
				String ad= rs.getString("Victims");
				String fm= rs.getString("Description_Crime");
				String  area= rs.getString("suspected_name");
				String crn= rs.getString("case_Status");
				
				
			Crime_Info cri=new Crime_Info(id, n, a, g, ad, fm, area, crn);
			
	        list.add(cri);
	
			}
			} catch (SQLException e) {
				throw new Crime_InfoException(e.getMessage());
				
			}
			
			
			if(list.size() == 0)
				throw new Crime_InfoException("No crime found..");
		
			
			return list;
	
	}

//	for getting count of crime or pending or completed cases
	@Override
	public int statuscount(String s1) throws Crime_InfoException {
		
		int count=0;
		
			
			try (Connection conn= DBUtil.provideConnection();){
				PreparedStatement ps = conn.prepareStatement ("select count(*) from criminfo where case_status=?");
					ps.setString(1,s1);
				ResultSet rs= ps.executeQuery();
				if(rs.next()) {
					
					count= rs.getInt("count(*)");
				}
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		return count;
	}
	
//	get the pending no of cases between months

	@Override
	public int Monthcount(String s1, String s2) throws Crime_InfoException {
		int count=0;
		
		
		try (Connection conn= DBUtil.provideConnection();){
			PreparedStatement ps = conn.prepareStatement ("select count(*) from criminfo where cdate between ? AND ?");
				ps.setString(1,s1);
				ps.setString(2, s2);
		
				
			ResultSet rs= ps.executeQuery();
			if(rs.next()) {
				
				count= rs.getInt("count(*)");
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	return count;
	}
	
//	get the list or crime according to place

	@Override
	public List<Crime_Info>CrimeArea(String n) throws Crime_InfoException {
		
		List<Crime_Info> list = new ArrayList<>();
		
		try (Connection conn= DBUtil.provideConnection();){
			PreparedStatement ps = conn.prepareStatement ("select * from criminfo where cplace=?");
			
	          ps.setString(1, n);
				
			ResultSet rs= ps.executeQuery();
			while(rs.next()) {
				int id= rs.getInt("crimId");
				String d= rs.getString("cdate");
				String a= rs.getString("cplace");
				String g= rs.getString("Crime_name");
				String ad= rs.getString("Victims");
				String fm= rs.getString("Description_Crime");
				String  area= rs.getString("suspected_name");
				String crn= rs.getString("case_Status");
				
				
			Crime_Info cri=new Crime_Info(id, d, a, g, ad, fm, area, crn);
		    list.add(cri);
	    
				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	

		if(list.size() == 0)
			throw new Crime_InfoException("No crime found..");
	
		
		return list;

	}
	
//	for updating the crime
	
	@Override
	public String UpdateCrime(Crime_Info crimeInfo) {
		
		String res = "Not Updated.";
		
		try(Connection conn= DBUtil.provideConnection();) {
			PreparedStatement ps = conn.prepareStatement("update criminfo set case_status=? where crimeId=?");
				
			
			ps.setString(1, crimeInfo.getCase_Status());
			ps.setInt(2, crimeInfo.getCrimeId());
			ps.executeUpdate();
			
		
				
				res ="Case Status Updated Successfully";
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return res;
	}
	
	@Override
	public String DeleteCrime(int crimeId) {
		
       String res ="Not Updated....";
		
		try(Connection conn= DBUtil.provideConnection();) {
			PreparedStatement ps = conn.prepareStatement("DELETE FROM criminfo WHERE crimeid=?");
			
		
			ps.setInt(1, crimeId);
			 ps.executeUpdate();
		
				res ="Data deleted Successfully";
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return res;
		
	
	}
	
//	get list or crime based on crime type and status

	@Override
	public List<Crime_Info> getListBaseonCrimeAndStstus(String crime, String satus) throws Crime_InfoException {
		List<Crime_Info> list = new ArrayList<>();


		try(Connection conn= DBUtil.provideConnection();) {
		
			PreparedStatement ps = conn.prepareStatement ("select * from criminfo where crime_name = ? and crime_status = ?");
			
			 ps.setString(1, crime);
			 ps.setString(2, satus);
			
			ResultSet rs= ps.executeQuery();
			while(rs.next()) {
			
				int id= rs.getInt("crimeId");
				String n= rs.getString("cdate");
				String a= rs.getString("cplace");
				String g= rs.getString("Crime_name");
				String ad= rs.getString("Victims");
				String fm= rs.getString("Description_Crime");
				String  area= rs.getString("suspected_name");
				String crn= rs.getString("case_Status");
				
				
			Crime_Info cri=new Crime_Info(id, n, a, g, ad, fm, area, crn);
			
	        list.add(cri);
	
			}
			} catch (SQLException e) {
				throw new Crime_InfoException(e.getMessage());
				
			}
			
			
			if(list.size() == 0)
				throw new Crime_InfoException("No crime found..");
		
			
			return list;
	}

	
//	get list of crime based on crime name
	@Override
	public List<Crime_Info> CrimeName(String crimeName) throws Crime_InfoException {
	List<Crime_Info> list = new ArrayList<>();
		
		try (Connection conn= DBUtil.provideConnection();){
			PreparedStatement ps = conn.prepareStatement ("select * from criminfo where crime_name=?");
			
	          ps.setString(1, crimeName);
				
			ResultSet rs= ps.executeQuery();
			while(rs.next()) {
				int id= rs.getInt("crimId");
				String d= rs.getString("cdate");
				String a= rs.getString("cplace");
				String g= rs.getString("Crime_name");
				String ad= rs.getString("Victims");
				String fm= rs.getString("Description_Crime");
				String  area= rs.getString("suspected_name");
				String crn= rs.getString("case_Status");
				
				
			Crime_Info cri=new Crime_Info(id, d, a, g, ad, fm, area, crn);
		    list.add(cri);
	    
				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	

		if(list.size() == 0)
			throw new Crime_InfoException("No crime found..");
	
		
		return list;
	}
	
	}
	
	

	


