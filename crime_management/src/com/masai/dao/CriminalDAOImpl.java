package com.masai.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.masai.utility.DBUtil;
import com.masai.bean.Criminal_Info;
import com.masai.exception.Criminal_InfoException;


public class CriminalDAOImpl  implements CriminalDAO {

	
//	for adding criminal in database
	@Override
	public String AddCriminal(Criminal_Info criminalInfo) {

		String  res= "Not Insertd ....";
		
	
		
		try(Connection conn= DBUtil.provideConnection();) {
			PreparedStatement ps = conn.prepareStatement
					("insert into criminal (Cname, Age, Gender, Address, Face_mark, Crime_Area, Crime_Name) "
							+ "values (?,?,?,?,?,?,?)");
			
			ps.setString(1,criminalInfo.getName());
			ps.setInt(2, criminalInfo.getAge());
			ps.setString(3,criminalInfo.getGender());
			ps.setString(4,criminalInfo.getAddress());
			ps.setString(5,criminalInfo.getIdentify_face_mark());
			ps.setString(6,criminalInfo.getCrime_Area());
			ps.setString(7,criminalInfo.getCrime_Name());
			
			int x=ps.executeUpdate();
			
			if(x>0) {
				
				res ="Criminal Added Sucessfully !";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return res;
	}
	
//	for viewing list of criminal

	@Override
	public List<Criminal_Info> ViewCriminal() throws Criminal_InfoException {
		List<Criminal_Info> Criminals_list= new ArrayList<>();


		try(Connection conn= DBUtil.provideConnection();) {
		
			PreparedStatement ps = conn.prepareStatement ("select * from criminal");
			
			ResultSet rs= ps.executeQuery();
			while(rs.next()) {
			
				int id= rs.getInt("CId");
				String n= rs.getString("Cname");
				int a= rs.getInt("Age");
				String g= rs.getString("Gender");
				String ad= rs.getString("Address");
				String fm= rs.getString("Face_mark");
				String  area= rs.getString("Crime_Area");
				String crn= rs.getString("Crime_Name");
				
				
			Criminal_Info cri=new Criminal_Info(id, n, a, g, ad, fm, area, crn);
			
			Criminals_list.add(cri);
	
			}
			} catch (SQLException e) {
				throw new Criminal_InfoException(e.getMessage());
				
			}
			
			
			if(Criminals_list.size() == 0)
				throw new Criminal_InfoException("No criminal found..");
			
			
			
			
			return Criminals_list;
	
	}
	
//	for getting criminal info by criminal id

	@Override
	public Criminal_Info getcriminalByCId(int Cid) throws Criminal_InfoException {
		
		Criminal_Info criminal = null;
		
try (Connection conn= DBUtil.provideConnection()){
			
			PreparedStatement ps= conn.prepareStatement("select * from criminal where Cid=?");
			
			
			ps.setInt(1, Cid);
			
			ResultSet rs= ps.executeQuery();
			
			if(rs.next()) {
				int id= rs.getInt("CId");
				String n= rs.getString("Cname");
				int a= rs.getInt("Age");
				String g= rs.getString("Gender");
				String ad= rs.getString("Address");
				String fm= rs.getString("Face_mark");
				String  area= rs.getString("Crime_Area");
				String crn= rs.getString("Crime_Name");
				
				
			criminal=new Criminal_Info(id, n, a, g, ad, fm, area, crn);	
				
				
			}else
				throw new Criminal_InfoException("Criminal does not exist with ID "+Cid);
			
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
			throw new Criminal_InfoException(e.getMessage());
			
			
		}
	
		return criminal;
	}
	
//	for updating criminal based on id

	@Override
	public String UpdateCriminal(Criminal_Info criminalInfo) {
		
		String res =  "Not Updated....";
		
		try(Connection conn= DBUtil.provideConnection();) {
			PreparedStatement ps = conn.prepareStatement("update criminal set Cname=? where Cid=?");
			
			ps.setString(1, criminalInfo.getName());
			ps.setInt(2, criminalInfo.getCid());
			ps.executeUpdate();
			
			
				res="criminal Updated Successfully";
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return res;
	}

//	for deleting criminal based on id
	@Override
	public String DeleteCriminal(Criminal_Info criminalInfo) {
		
       String res = "Not Updated....";
		
		try(Connection conn= DBUtil.provideConnection();) {
			PreparedStatement ps = conn.prepareStatement("DELETE FROM criminal WHERE Cid=?");
			
		
			ps.setInt(1, criminalInfo.getCid());
			ps.executeUpdate();
		
				res ="Criminal deleted Successfully";
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return res;

	}
		
}
