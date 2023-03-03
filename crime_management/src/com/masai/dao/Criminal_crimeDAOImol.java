package com.masai.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.masai.bean.Criminal_Info;
import com.masai.utility.DBUtil;
import com.masai.exception.Criminal_InfoException;


public class Criminal_crimeDAOImol implements Criminal_crimeDAO {

	
//	get the list of criminal info base on crime name
	@Override
	public List<Criminal_Info> CrimeFile(String cname) throws Criminal_InfoException {
		List<Criminal_Info> Criminals_list = new ArrayList<>();


		try(Connection conn= DBUtil.provideConnection();) {
		
			PreparedStatement ps = conn.prepareStatement ("select c.cname, cr.crime_name from criminal c INNER JOIN criminfo cr INNER JOIN "
					+ "criminal_crime ccr ON ccr.crimId=cr.crimId AND "
					+ "ccr.cid=c.cid AND cr.crime_name=?");
			ps.setString(1,cname );
			ResultSet rs= ps.executeQuery();
			while(rs.next()) {
				
            Criminal_Info cri=new Criminal_Info();
            
			cri.setName(rs.getString("cname"));
			cri.setCrime_Name(rs.getString("Crime_name"));
     
	        Criminals_list.add(cri);
	
			   }
			
			} catch (SQLException e) {
				throw new Criminal_InfoException(e.getMessage());
				
			  }
			
			
			if(Criminals_list.size() == 0)
				throw new Criminal_InfoException("No Criminal crime found..");
			
			return Criminals_list;
	
	}

//	for adding criminal crime in database
	@Override
	public String AddCriminalCrime(int id, int id1) {
		String res = "not inserted";
		try (Connection con = DBUtil.provideConnection()){
			
		PreparedStatement ps =	con.prepareStatement("insert into criminal_crime values(?,?)");
		ps.setInt(1, id);
		ps.setInt(2, id1);
		
		int x = ps.executeUpdate();
		if(x>0) {
			res = "Criminal crime addedd succesfully";
		}
		else {
			res = "unable to add";
		}
			
		} catch (SQLException e) {
			res = e.getMessage();
		}
		return res;
	}

}
