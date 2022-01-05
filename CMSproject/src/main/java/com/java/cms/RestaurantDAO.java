package com.java.cms;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RestaurantDAO {

	Connection connection;
	PreparedStatement pst;
	public List<Restaurant> showRestaurant() throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "select * from restaurant";
		pst = connection.prepareStatement(cmd);
		ResultSet rs = pst.executeQuery();
		List<Restaurant> restaurantList = new ArrayList<Restaurant>();
		Restaurant restaurant = null;
		while(rs.next()) {
			restaurant = new Restaurant();
			restaurant.setRid(rs.getInt("rid"));
			restaurant.setRname(rs.getString("rname"));
			restaurant.setCity(rs.getString("city"));
			restaurant.setBranch(rs.getString("branch"));
			restaurant.setEmail(rs.getString("email"));
			restaurant.setContactNo(rs.getString("ContactNo"));
			restaurantList.add(restaurant);
		}
		return restaurantList;
	}
	
	public Restaurant searchRestaurant(int restaurantId) throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "select * from restaurant where rid=?";
		pst = connection.prepareStatement(cmd);
		pst.setInt(1, restaurantId);
		ResultSet rs = pst.executeQuery();
		Restaurant restaurant = null;
		if(rs.next()) {
			restaurant = new Restaurant();
			restaurant.setRid(rs.getInt("rid"));
			restaurant.setRname(rs.getString("rname"));
			restaurant.setCity(rs.getString("city"));
			restaurant.setBranch(rs.getString("branch"));
			restaurant.setEmail(rs.getString("email"));
			restaurant.setContactNo(rs.getString("ContactNo"));
		}
		return restaurant;
		
	}
	
	public String addRestaurant(Restaurant restaurant) throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		int rid = generateRestaurantId();
		restaurant.setRid(rid);
		String cmd = "Insert into Restaurant(rid,rname,city,branch,email,"
				+ "contactNo) values(?,?,?,?,?,?)";
		pst = connection.prepareStatement(cmd);
		pst.setInt(1, rid);
		pst.setString(2, restaurant.getRname());
		pst.setString(3, restaurant.getCity());
		pst.setString(4, restaurant.getBranch());
		pst.setString(5, restaurant.getEmail());
		pst.setString(6, restaurant.getContactNo());
		pst.executeUpdate();
		return "Restaurant Added...";
	}
	
	
	public int generateRestaurantId() throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "select case when max(rId) IS NULL then 1 "
				+ " else Max(rId)+1 end rid from Restaurant";
		pst = connection.prepareStatement(cmd);
		ResultSet rs = pst.executeQuery();
		rs.next();
		int rid = rs.getInt("rid");
		return rid;
	}
	
}
 