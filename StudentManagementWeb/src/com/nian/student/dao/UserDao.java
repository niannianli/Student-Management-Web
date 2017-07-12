package com.nian.student.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.nian.student.pojo.User;

public class UserDao {

	// all db happens here in Dao
	
	// public User getUserByUserNameAndPassword(String username, String
	// password, Boolean value){
	
	//Retrieve data
	public User getUserByUsernameAndPassword(String username, String password) {
		
		Connection connection = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/java_392", "root", "love");

		//	String sql = "select * from user where username = ?";
			// if(value == true){
			// criteria
			// }else{
			// sql = sql + " password = ?";
			// }

			PreparedStatement preparedStatement = connection
					.prepareStatement("select * from user where username = ? and password = ?");
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, password);
			
			//query
			ResultSet rs = preparedStatement.executeQuery();
		
			User user = null;
			
			while (rs.next()) {
				user = new User();
				
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setAddress(rs.getString("address"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setDob(rs.getDate("dob"));
			}

			return user;

		} catch (Exception e) {
			return null;
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

	}

	
	//retrieve all data
	public List<User> findAllUsers() {

		Connection connection = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/java_392", "root", "love");
			
			PreparedStatement preparedStatement = connection.prepareStatement("select * from user");

			//query
			ResultSet rs = preparedStatement.executeQuery();

			List<User> userList = new ArrayList<User>();

			while (rs.next()) {
				User user1 = new User();
				
				user1.setId(rs.getInt("id"));
				user1.setName(rs.getString("name"));
				user1.setAddress(rs.getString("address"));
				user1.setUsername(rs.getString("username"));
				user1.setPassword(rs.getString("password"));
				user1.setDob(rs.getDate("dob"));

				userList.add(user1);
			}

			return userList;

		} catch (Exception e) {
			return null;
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

	}

	
	//delete data
	public void deleteUserById(Integer id) {

		Connection connection = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/java_392", "root", "love");
			
			PreparedStatement preparedStatement = connection.prepareStatement("delete from user where id = ?");
			preparedStatement.setInt(1, id);

			//update
			preparedStatement.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
	}


	//add data, insert
	public void addUser(User user) {

		Connection connection = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/java_392", "root", "love");

			String sql = "insert into user(name, address, username, password, dob) values(?,?,?,?,?)";

			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setString(1, user.getName());
			preparedStatement.setString(2, user.getAddress());
			preparedStatement.setString(3, user.getUsername());
			preparedStatement.setString(4, user.getPassword());
			preparedStatement.setDate(5, new java.sql.Date(user.getDob().getTime()));

			//update
			preparedStatement.executeUpdate();

		} catch (Exception e) {
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

	}
	
	//using hibernate(better than jdbc) to implement dynamic query

	public void updateUser(User user) {
		
		Connection connection = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/java_392", "root", "love");

			System.out.println("old dob" + user.getDob());
			String sql = "update user set name = ?,  address = ?, username = ?,  password = ?, dob = ? where id = ?";

			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setString(1, user.getName());
			preparedStatement.setString(2, user.getAddress());
			preparedStatement.setString(3, user.getUsername());
			preparedStatement.setString(4, user.getPassword());
			preparedStatement.setDate(5, new java.sql.Date(user.getDob().getTime()));
			
			//update?
			preparedStatement.executeUpdate();
			System.out.println("new dob" + user.getDob());

		} catch (Exception e) {
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

	}

	//get user by id
	public User getUserById(Integer id) {
		
         Connection connection = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/java_392", "root", "love");
			
			PreparedStatement preparedStatement = connection.prepareStatement("select * from user where id = ?");
			preparedStatement.setInt(1, id);

			//update
			ResultSet rs = preparedStatement.executeQuery();
			
			User user = null;
			
			while(rs.next()){
				user = new User();
				
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setAddress(rs.getString("address"));
				user.setDob(rs.getDate("dob"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
			}
			
			return user;

		} catch (Exception e) {
			return null;
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		
	}

}