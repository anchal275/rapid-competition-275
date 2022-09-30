package com.auction.Dao;

import com.auction.bean.Seller;
import com.auction.exceptions.SellerException;

public interface SellerDao {
	
	public String registerSeller(Seller seller);
	
	public Seller loginSeller(String username, String password) throws SellerException;
	

}
