package repository;

import db.DBConnection;
import model.entity.Book;
import model.entity.Customer;
import repository.impl.BookRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookRepositoryImpl implements BookRepository {



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

    public List<Book> getAllBooks() throws SQLException {
        List<Book> bookList = new ArrayList<>();

        Connection connection = DBConnection.getInstance().getConnection();
        String SQL = "SELECT * FROM Books";
        PreparedStatement preparedStatement = connection.prepareStatement(SQL);

        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            bookList.add(new Book(
                    resultSet.getString("id"),
                    resultSet.getString("title"),
                    resultSet.getString("author"),
                    resultSet.getString("category"),
                    resultSet.getInt("quantity")
            ));
        }
        return bookList;
    }


}
