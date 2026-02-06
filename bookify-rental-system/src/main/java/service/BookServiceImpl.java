package service;

import model.dto.BookDTO;
import model.dto.CustomerDTO;
import model.entity.Book;
import model.entity.Customer;
import repository.BookRepositoryImpl;
import service.impl.BookService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookServiceImpl implements BookService {

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


    public ArrayList<BookDTO> getAllBooks(){

        ArrayList<BookDTO> bookDTOS = new ArrayList<>();
        try {
            List<Book> bookList = bookRepository.getAllBooks();

            for(Book book : bookList){
                bookDTOS.add(
                        new BookDTO(
                                book.getId(),
                                book.getTitle(),
                                book.getAuthor(),
                                book.getCategory(),
                                book.getQuantity()
                        )
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return bookDTOS;
    }


}
