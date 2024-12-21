package com.demo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.demo.config.Constants;
import com.demo.entities.User;

public class UserDAO {

	private static final String SELECT_ALL_USER = "select * from users";
	private static final String INSERT_USER = "INSERT INTO users (username, email, avatar) VALUES (?, ?, ?)";
	private Connection jdbcConnection;

	public UserDAO() {
	}

	private void connect() throws SQLException {
		if (jdbcConnection == null || jdbcConnection.isClosed()) {
			try {
				Class.forName(Constants.dbDriver);
				jdbcConnection = DriverManager.getConnection(Constants.jdbcURL, Constants.jdbcUsername,
						Constants.jdbcPassword);
			} catch (ClassNotFoundException e) {
				throw new SQLException(e);
			}
		}
	}

	private void disconnect() throws SQLException {
		if (jdbcConnection != null && !jdbcConnection.isClosed()) {
			jdbcConnection.close();
		}
	}

	public List<User> getAllUser() throws SQLException {
		List<User> users = new ArrayList<User>();
		connect();

		Statement statement = jdbcConnection.createStatement();
		ResultSet rs = statement.executeQuery(SELECT_ALL_USER);

		while (rs.next()) {
			long id = rs.getLong("id");
			String userName = rs.getString("username");
			String email = rs.getString("email");
			String avatar = rs.getString("avatar");
			users.add(new User(id, userName, email, avatar));
		}

		rs.close();
		statement.close();
		disconnect();

		return users;
	}
	
	public void saveUser(User user) throws SQLException {
		connect();
		PreparedStatement statement = jdbcConnection.prepareStatement(INSERT_USER);
        statement.setString(1, user.getUserName());
        statement.setString(2, user.getEmail());
        statement.setString(3, user.getAvatar());
        statement.executeUpdate();
	}

}
