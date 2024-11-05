package com.demo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.demo.config.Constants;
import com.demo.entities.Question;


public class QuestionDAO {
	
	private static final String SELECT_ALL_QUESTION = "select * from question";
	
	private Connection getConnection() throws ClassNotFoundException  {

		Connection connection = null;

		Class.forName(Constants.dbDriver);
		try {
			connection = DriverManager.getConnection(Constants.jdbcURL, Constants.jdbcUsername, Constants.jdbcPassword);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return connection;
	}

	public QuestionDAO() {
	}
	
	public List<Question> getAllQuestion(){
		List<Question> questions = new ArrayList<Question>();
		
		try (Connection connection = getConnection();
			// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_QUESTION);) {
			//preparedStatement.setInt(1, id);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				// Get Data and add to questions
				

				//questions.add( new Question(id, name, email, country));
			}
		} catch (SQLException e) {
			printSQLException(e);
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		
		
		return questions;
	}
	
    private void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }

	

}
