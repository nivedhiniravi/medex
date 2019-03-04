package org.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import org.beans.Patient;
import org.dao.Dao;
import org.util.DBConstants;
import org.util.DBUtil;

import java.sql.PreparedStatement;


public class DaoImpl implements Dao {

	@Override
	public boolean insert(Patient p) {
		Connection con=null;
		PreparedStatement pst=null;
		boolean b=false;
		try {
			con=(Connection) DBUtil.getConnection(DBConstants.DRIVER, DBConstants.URL, DBConstants.UNAME, DBConstants.PWD);
			pst=con.prepareStatement("insert into patient_details (fname,lname,pwd,gender,age,email,contact,address,city,zipcode) values(?,?,?,?,?,?,?,?,?,?)");
			pst.setString(1, p.getFname());
			pst.setString(2, p.getLname());
			pst.setString(3, p.getPasswd());
			pst.setString(4, p.getGender());
			pst.setInt(5, p.getAge());
			pst.setString(6, p.getEmail());
			pst.setString(7, p.getContact());
			pst.setString(8, p.getAddress());
			pst.setString(9, p.getCity());
			pst.setString(10, p.getZipcode());
			int r=pst.executeUpdate();
			
			if(r>0)
				b=true;
			else
				b=false;
			con.close();
			
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		return b;
		
	}
	}

