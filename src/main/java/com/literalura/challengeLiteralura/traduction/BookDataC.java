package com.literalura.challengeLiteralura.traduction;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
public class BookDataC {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonProperty("id")
    private int bookId;

    private String title;

    @ElementCollection //I´m notifying to JPA, this is a collection of elements o embedded class.
    @CollectionTable(name = "book_authors", joinColumns = @JoinColumn(name = "book_id")) // I'm representing the SQL Language on java.
    @AttributeOverrides({
            @AttributeOverride(name = "name", column = @Column(name = "author_name")),
            @AttributeOverride(name = "birthYear", column = @Column(name = "birth_year")),
            @AttributeOverride(name = "deathYear", column = @Column(name = "death_year"))
    })
    private List<Author> authors;

    @ElementCollection
    private List<String> languages;

    private int download;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @JsonProperty("id")
    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    @JsonProperty("authors")
    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    @JsonProperty("languages")
    public List<String> getLanguages() {
        return languages;
    }

    public void setLanguages(List<String> languages) {
        this.languages = languages;
    }

    @JsonProperty("download_count")
    public int getDownload() {
        return download;
    }

    public void setDownload(int download) {
        this.download = download;
    }

    @Override
    public String toString() {
        return "BookDataC{" +
                "id=" + id +
                ", bookId=" + bookId +
                ", title='" + title + '\'' +
                ", authors=" + authors +
                ", languages=" + languages +
                ", download=" + download +
                '}';
    }
}
