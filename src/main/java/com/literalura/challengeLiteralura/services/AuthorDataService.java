package com.literalura.challengeLiteralura.services;

import com.literalura.challengeLiteralura.traduction.Author;
import com.literalura.challengeLiteralura.repository.AuthorDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;


@Service
public class AuthorDataService {
    @Autowired
    private AuthorDataRepository authorDataRepository;

    public List<Author> getAuthors(){
        return authorDataRepository.findAll();
    }

    public List<Author> getAliveAuthors(int year){
        return authorDataRepository.findByDeathYearGreaterThan(year);
    }
}
