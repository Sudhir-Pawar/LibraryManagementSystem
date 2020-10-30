package connection;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseConnection {
	public static Connection connection;
	public static Connection getConnection(){
		try {
		FileReader fileReader = new FileReader("C:\\Users\\Admin\\workspace\\LibraryManagementSystem\\src\\config.properties");
		Properties properties = new Properties();
		properties.load(fileReader);
		
		Class.forName(properties.getProperty("drivername"));
		connection = DriverManager.getConnection(properties.getProperty("url"), properties.getProperty("username"), properties.getProperty("password"));

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		return connection;
	}
}
