package com.auction.usecases;

import java.util.Scanner;
import com.auction.Dao.BuyerDao;
import com.auction.Dao.BuyerDaoImpl;
import com.auction.bean.Buyer;
import com.auction.exceptions.BuyerException;

public class BuyerUsecases {
	
	public static boolean BuyerloginUsecase() {
		boolean login = false;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Buyer Username");
		String username = sc.next();
		
		System.out.println("Enter Buyer Password");
		String password = sc.next();
		
		BuyerDao Bdao = new BuyerDaoImpl();
		try {
			Buyer buyer = Bdao.loginBuyer(username, password);
			System.out.println("Welcome Buyer " + buyer.getBname());
			login = true;
			
		} catch (BuyerException e) {
			System.out.println(e.getMessage());
		}
		return login;
	}
	
	
	
	public static String BuyerRegisterUsecase() {
		String register = null;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Buyer Name");
		String Bname = sc.next();
		
		System.out.println("Enter Buyer Email");
		String Bemail = sc.next();
		
		System.out.println("Enter Buyer Password");
		String Bpassword = sc.next();
		
		BuyerDao bdao = new BuyerDaoImpl();
		Buyer buyer = new Buyer(Bname, Bemail, Bpassword);
		register = bdao.registerBuyer(buyer);
		return register;
		
	}

}
