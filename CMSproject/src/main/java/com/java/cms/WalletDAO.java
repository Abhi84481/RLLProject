package com.java.cms;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;




public class WalletDAO {
	Connection connection;
	PreparedStatement pst;
	
	public List<Wallet> searchByCustomerId(int customerId) throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "select * from wallet where customerid=?";
		pst = connection.prepareStatement(cmd);
		pst.setInt(1, customerId);
		ResultSet rs = pst.executeQuery();
		List<Wallet> walletList = new ArrayList<Wallet>();
		Wallet wallet = null;
		while(rs.next()) {
			wallet = new Wallet();
			wallet.setWalletId(rs.getInt("walletid"));
			wallet.setCustomerId(rs.getInt("customerid"));
			wallet.setWallettype(rs.getString("wallettype"));
			wallet.setAmount(rs.getInt("amount"));
			walletList.add(wallet);
		}
		return walletList;
		
	}
	
	public String deductBalance(int walletId, int billAmount) throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "update wallet set amount=amount-? where walletId=?";
		pst = connection.prepareStatement(cmd);
		pst.setInt(1, billAmount);
		pst.setInt(2, walletId);
		pst.executeUpdate();
		return "Amount Deducted...";
	}
	
	
	public Wallet searchByWalletId(int walletId) throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "select * from wallet where walletid=?";
		pst = connection.prepareStatement(cmd);
		pst.setInt(1, walletId);
		ResultSet rs = pst.executeQuery();
		Wallet wallet = null;
		if(rs.next()) {
			wallet = new Wallet();
			wallet.setWalletId(rs.getInt("walletid"));
			wallet.setCustomerId(rs.getInt("customerid"));
			wallet.setWallettype(rs.getString("wallettype"));
			wallet.setAmount(rs.getInt("amount"));
		}
		return wallet;
		
	}
	
	
	
	

}
