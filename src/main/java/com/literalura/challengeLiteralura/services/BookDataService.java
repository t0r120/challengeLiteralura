package com.literalura.challengeLiteralura.services;

import com.literalura.challengeLiteralura.traduction.BookDataC;
import com.literalura.challengeLiteralura.repository.BookDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BookDataService {

    @Autowired
    private BookDataRepository bookDataRepository;


    public void saveBook(BookDataC bookDataC){
        bookDataRepository.save(bookDataC);
    }

    public List<BookDataC> getBooks(){
        return bookDataRepository.findAll();
    }

    public List<BookDataC> getBooksByLanguage(String language){
        return bookDataRepository.findByLanguages(language);
    }
}
