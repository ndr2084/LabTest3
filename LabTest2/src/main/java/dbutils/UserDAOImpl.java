package dbutils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAOImpl implements UserDAO{
	
	private static final String DB_URL = "jdbc:sqlite:/home/william/Desktop/LabTest2/test3_database.db";
	static {
        try {
            Class.forName("org.sqlite.JDBC"); // Explicitly load the SQLite driver
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Failed to load SQLite JDBC driver", e);
        }
    }
	@Override
	public int getUserByName(String first_name, String last_name) {
		String query = "SELECT * FROM User WHERE firstName = ? AND lastName = ?"; 
        try (Connection connection = DriverManager.getConnection(DB_URL);
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, first_name);
            preparedStatement.setString(2, last_name);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getInt("age");
            } else {
                return -101; // User not found
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return -100; // Return null or handle the error appropriately
        }

	}
	

}
