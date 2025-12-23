package service.impl;

import model.dto.BookDTO;

public interface BookService {

    public void addBook(BookDTO bookDTO);
    public String getLastBookID();


}
