package com.java.cms;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class MenuDAO {

	
	Connection connection;
	PreparedStatement pst;
	public List<Menu> showMenu() throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "select * from menu";
		pst = connection.prepareStatement(cmd);
		ResultSet rs = pst.executeQuery();
		List<Menu> menuList = new ArrayList<Menu>();
		Menu menu = null;
		while(rs.next()) {
			menu = new Menu();
			menu.setMenuId(rs.getInt("menuid"));
			menu.setRestaurantId(rs.getInt("restaurantid"));
			menu.setItemName(rs.getString("itemname"));
			menu.setMenutype(rs.getString("menutype"));
			menu.setCalories(rs.getInt("calories"));
			menu.setPrice(rs.getInt("Price"));
			menuList.add(menu);
		}
		return menuList;
	}
	
	
	public Menu searchMenu(int menuId) throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "select * from menu where menuid=?";
		pst = connection.prepareStatement(cmd);
		pst.setInt(1, menuId);
		ResultSet rs = pst.executeQuery();
		Menu menu = null;
		if(rs.next()) {
			menu = new Menu();
			menu.setMenuId(rs.getInt("menuid"));
			menu.setRestaurantId(rs.getInt("restaurantid"));
			menu.setItemName(rs.getString("itemname"));
			menu.setMenutype(rs.getString("menutype"));
			menu.setCalories(rs.getInt("calories"));
			menu.setPrice(rs.getInt("Price"));
		}
		return menu;
		
	}
	
	public String addMenu(Menu menu) throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		int menuid = generateMenuId();
		menu.setMenuId(menuid);
		String cmd = "Insert into Menu(menuid,restaurantid,itemname,menutype,calories,"
				+ "price) values(?,?,?,?,?,?)";
		pst = connection.prepareStatement(cmd);
		pst.setInt(1, menuid);
		pst.setInt(2, menu.getRestaurantId());
		pst.setString(3, menu.getItemName());
		pst.setString(4, menu.getMenutype());
		pst.setInt(5, menu.getCalories());
		pst.setInt(6, menu.getPrice());
		pst.executeUpdate();
		return "Menu Added...";
	}
	
	public int generateMenuId() throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "select case when max(menuId) IS NULL then 1 "
				+ " else Max(menuId)+1 end menuid from Menu";
		pst = connection.prepareStatement(cmd);
		ResultSet rs = pst.executeQuery();
		rs.next();
		int menuid = rs.getInt("menuid");
		return menuid;
	}
	
	
}
