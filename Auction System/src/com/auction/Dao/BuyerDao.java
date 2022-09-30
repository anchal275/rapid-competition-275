package com.auction.Dao;

import com.auction.bean.Buyer;
import com.auction.exceptions.BuyerException;


public interface BuyerDao {
	
	public String registerBuyer(Buyer buyer);
	
	public Buyer loginBuyer(String username, String password) throws BuyerException;
}
