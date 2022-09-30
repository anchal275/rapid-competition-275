package com.auction.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.auction.bean.Buyer;
import com.auction.bean.Seller;
import com.auction.exceptions.BuyerException;
import com.auction.exceptions.SellerException;
import com.auction.utility.DBUtil;

public class BuyerDaoImpl implements BuyerDao{

	@Override
	public String registerBuyer(Buyer buyer) {
		 String message = "Buyer Not Inserted";
		 
		 try(Connection conn = DBUtil.ProvideConnection()) {
				PreparedStatement ps = 
				conn.prepareStatement("Insert into Buyer(Bname,Bemail,Bpassword) values(?,?,?)");
				
				ps.setString(1, buyer.getBname());
				ps.setString(2, buyer.getBemail());
				ps.setString(3, buyer.getBpassword());
				
				int x = ps.executeUpdate();
			     if(x>0) {	
			    	 message = "Buyer Registered Successfully";
			    	 
			    	 
			     }	
				 
				} catch (SQLException e) {
					message = e.getMessage();
				}
		return message;
	}
	
	
	

	@Override
	public Buyer loginBuyer(String username, String password) throws BuyerException {
    Buyer buyer = null;
	    
	    
	    try (Connection conn = DBUtil.ProvideConnection()){
	    PreparedStatement ps = 
	    conn.prepareStatement("Select * from Buyer Where Bemail = ? AND Bpassword = ?");
	    
	    ps.setString(1, username);
	    ps.setString(2, password);

	    ResultSet rs = ps.executeQuery();
	    
	    if(rs.next()) {
	    	int id = rs.getInt("BuyerID");
	    	String name = rs.getString("Bname");
	    	String email = rs.getString("Bemail");
	    	String pass = rs.getString("Bpassword");
	    	buyer = new Buyer(id, name, email, pass);
	    	
	    }else {
	      throw new BuyerException("Invalid Username or Password");
	    }
	    
	    
		} catch (SQLException e) {
		  throw new BuyerException(e.getMessage());
		}
	
	    
		return buyer;
	}
	
	
	

}
