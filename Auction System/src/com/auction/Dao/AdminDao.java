package com.auction.Dao;

import com.auction.bean.Admin;
import com.auction.exceptions.AdminException;

public interface AdminDao {

	
	public Admin loginAdmin(String username, String password) throws AdminException;
}
