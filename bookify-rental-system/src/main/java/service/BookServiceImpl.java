package service;

import model.dto.BookDTO;
import model.entity.Book;
import repository.BookRepositoryImpl;

import java.sql.SQLException;

public class BookServiceImpl {

    BookRepositoryImpl bookRepository = new BookRepositoryImpl();

    public void addBook(BookDTO bookDTO) {

        Book book = new Book(
                bookDTO.getId(),
                bookDTO.getTitle(),
                bookDTO.getAuthor(),
                bookDTO.getCategory(),
                bookDTO.getQuantity()
        );

        try {

            bookRepository.addBook(book);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


    public String getLastBookID() {

        try {
            return bookRepository.getLastBookId();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


}
