package repository;

import db.DBConnection;
import model.entity.Book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BookRepositoryImpl {


    public void addBook(Book book) throws SQLException {

        Connection  connection = DBConnection.getInstance().getConnection();
        String SQL = "INSERT INTO Books VALUES (?, ?, ?, ?, ?)";

        PreparedStatement preparedStatement = connection.prepareStatement(SQL);

        preparedStatement.setObject(1,book.getId());
        preparedStatement.setObject(2,book.getTitle());
        preparedStatement.setObject(3,book.getAuthor());
        preparedStatement.setObject(4,book.getCategory());
        preparedStatement.setObject(5,book.getQuantity());

        preparedStatement.executeUpdate();


    }


}
