package service.impl;

import model.dto.BookDTO;

import java.util.ArrayList;

public interface BookService {

    public void addBook(BookDTO bookDTO);
    public String getLastBookID();
    public ArrayList<BookDTO> getAllBooks();

}
