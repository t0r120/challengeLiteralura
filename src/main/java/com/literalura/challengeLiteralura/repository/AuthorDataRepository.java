package com.literalura.challengeLiteralura.repository;


import com.literalura.challengeLiteralura.traduction.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

//WHAT IS THIS: We have an Interface with methods that interact with the database. This Interface extends from JPARepository.


@Repository
public interface AuthorDataRepository extends JpaRepository<Author, Long> {
    List<Author> findByDeathYearGreaterThan(int year);
}
