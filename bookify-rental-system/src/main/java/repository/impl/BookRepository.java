package repository.impl;

import model.entity.Book;

import java.sql.SQLException;
import java.util.List;

public interface BookRepository {

    public String getLastBookId() throws SQLException;
    public void addBook(Book book) throws SQLException;
    public List<Book> getAllBooks() throws SQLException;

}
