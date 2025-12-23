package repository.impl;

import model.entity.Book;

import java.sql.SQLException;

public interface BookRepository {

    public String getLastBookId() throws SQLException;
    public void addBook(Book book) throws SQLException;

}
