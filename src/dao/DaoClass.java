package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.Book;
import connection.DatabaseConnection;

public class DaoClass implements DaoInterface<Boolean,Book>{
	Connection connection = null;
	@Override
	public Boolean insertBook(Book book) {
		Boolean status = false;
		try {
			connection = DatabaseConnection.getConnection();
			System.out.println(connection.toString());
			PreparedStatement preparedStatement = connection.prepareStatement("select * from book where book_id = ?");
			preparedStatement.setString(1,book.getBookId());
			ResultSet resultSet = preparedStatement.executeQuery();
			System.out.println(resultSet);
			if(!resultSet.isBeforeFirst()){
				preparedStatement = connection.prepareStatement("insert into Book values(?,?,?)");
				preparedStatement.setString(1,book.getBookId());
				preparedStatement.setString(2,book.getBookName());
				preparedStatement.setString(3,book.getAuthorName());
				int count = preparedStatement.executeUpdate();
				if(count > 0){
					status = true;
				}
			}else{
				//Raise Exception: bookId already exists. 
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public Boolean removeBook(Book book) {
		Boolean status = false;
		try {
			connection = DatabaseConnection.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement("select * from Transaction where book_id = ?");
			preparedStatement.setString(1,book.getBookId());
			ResultSet resultSet = preparedStatement.executeQuery();
			if(!resultSet.isBeforeFirst()){
				preparedStatement = connection.prepareStatement("delete from Book where book_id = ?");
				preparedStatement.setString(1, book.getBookId());
				int count = preparedStatement.executeUpdate();
				if(count > 0){
					status = true;
				}
			}else{
				//Raise Exception: BookId cannot be delete as already being used in transction data.;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
				
		return status;
	}
	
}
