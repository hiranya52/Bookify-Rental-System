package repository;

import db.DBConnection;
import model.entity.Book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BookRepositoryImpl {



    public String getLastBookId() throws SQLException {

        String lastId = null;

        Connection connection = DBConnection.getInstance().getConnection();

        String SQL = "SELECT id FROM books ORDER BY id DESC LIMIT 1";

        PreparedStatement preparedStatement = connection.prepareStatement(SQL);
        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            lastId = resultSet.getString(1);
        }

        return lastId;
    }


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
