package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.entities.User;

public class UserDAO {

	private Connection conn;

	public UserDAO(Connection conn) {
		super();
		this.conn = conn;
	}

	public boolean addUser(User u) {
		boolean f = false;

		try {

			String q = "INSERT INTO user (name,email,password) VALUES(?,?,?);";
			PreparedStatement pst = conn.prepareStatement(q);
			pst.setString(1, u.getName());
			pst.setString(2, u.getEmail());
			pst.setString(3, u.getPassword());

			int r = pst.executeUpdate();

			if (r == 1) {
				f = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return f;
	}

	public User userLogin(String email, String password) {
		User user = null;

		try {
			String q = "SELECT * FROM user WHERE email=? AND password=?;";
			PreparedStatement pst = conn.prepareStatement(q);
			pst.setString(1, email);
			pst.setString(2, password);
			
			ResultSet rs=pst.executeQuery();
			
			while(rs.next()) {
				user=new User();
				user.setId(rs.getInt(1));
				user.setName(rs.getString(2));
				user.setEmail(rs.getString(3));
				user.setPassword(rs.getString(4));
				 
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

}
