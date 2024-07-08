package com.literalura.challengeLiteralura.methods;

import com.literalura.challengeLiteralura.records.GeneralData;
import com.literalura.challengeLiteralura.services.ApiRequest;
import com.literalura.challengeLiteralura.services.AuthorDataService;
import com.literalura.challengeLiteralura.services.BookDataService;
import com.literalura.challengeLiteralura.services.DataConverter;
import com.literalura.challengeLiteralura.traduction.Author;
import com.literalura.challengeLiteralura.traduction.BookDataC;
import com.literalura.challengeLiteralura.traduction.GutendexResponse;
import org.hibernate.annotations.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;


@Component
public class AuthorSearch {

    ApiRequest apiRequest = new ApiRequest();
    DataConverter converter = new DataConverter();
    Scanner scanner = new Scanner(System.in);


    private final String URL_BASE = "https://gutendex.com/books/";
    private List<GeneralData> generalData = new ArrayList<>();
    private List<Optional> authorData =  new ArrayList<>();

    @Autowired
    private BookDataService bookDataService;
    @Autowired
    private AuthorDataService authorDataService;

    public void showMenu(){
        try {
            var option = -1;
            while (option != 0) {

                var menu = """
                        JAVA BOOK
                        -------------------
                        Found your favorite book,
                        authors and more! :)
                        -------------------
                        
                        1- Search books by title.
                        2- Search authors by name.
                        3- Books browsing history.
                        4- Author browsing history.
                        5- Found alive authors from a specific year.
                        6- List books by language.
                        
                        0- Exit.
                        """;
                System.out.println(menu);
                option = scanner.nextInt();
                scanner.nextLine();

                switch (option){
                    case 1:
                        searchBook();
                        break;
                    case 2:
                        searchAuthor();
                        break;
                    case 3:
                        bookHistory();
                        break;
                    case 4:
                        authorHistory();
                        break;
                    case 5:
                        findAliveAuthors();
                        break;
                    case 6:
                        listBooksByLanguage();
                        break;
                    case 0:
                        System.out.println("Closing aplication... See you soon:)!");
                        break;
                    default:
                        System.out.println("Invalid option!");

                }




            }

       }catch (InputMismatchException e){
            System.out.println("Sorry. That is not valid value. :(");
        }
    }




    public void searchBook(){
            System.out.println("Introduce your favorite book: ");
            var bookName = scanner.nextLine();
            var json = apiRequest.getData(URL_BASE + "?search=" + bookName.toLowerCase().replace(" ", "%20"));
            var data = converter.getData(json, GutendexResponse.class);

            List<BookDataC> books = data.getResults();

            if (books.isEmpty()){
                System.out.println("No books found. :(");
            }else{
                books.forEach(b -> {
                    bookDataService.saveBook(b);
                    System.out.println("Saved book: " + b);
                });
            }
    }

    //This was the first sketch.
    /* public Optional<BookData> getAuthorData(){

            System.out.println("Introduce your favorite author");
            var authorName = scanner.nextLine();
            var json = apiRequest.getData(URL_BASE + "?search=" + authorName.toLowerCase()
                    .replace(" ", "%20"));
            var data = converter.getData(json, GeneralData.class);

            Optional<BookData> searchedAuthor = data.results().stream()
                            .filter(a -> a.autors().toString().contains(authorName)).findAny();

            if (searchedAuthor.isPresent()){
                System.out.println("Top 1 Book: " + searchedAuthor.get().title());
                System.out.println("Downloads: " + searchedAuthor.get().downloads());
                System.out.println("Language: " + searchedAuthor.get().lenguages());
            }else{
                System.out.println("Sorry we did not find the author");
            }
          return searchedAuthor;
    }*/

    private void searchAuthor() {
        System.out.println("Introduce your favorite author's name: ");
        var authorName = scanner.nextLine();
        var json = apiRequest.getData(URL_BASE + "?search=" + authorName.toLowerCase().replace(" ", "%20"));
        var data = converter.getData(json, GutendexResponse.class);
         List<Author> authors = data.getResults()
                 .stream().findAny().get().getAuthors();
        if (authors.isEmpty()){
            System.out.println("No authors found. :(");
        }else{
            authors.forEach(a ->{
                System.out.println(a);
                authorDataService.getAuthors();
            });
        }

    }


    private void bookHistory() {
        List<BookDataC> history = bookDataService.getBooks();
        if (history.isEmpty()) {
            System.out.println("No browsing history.");
        } else {
            history.forEach(System.out::println);
        }

    }



    private void authorHistory() {
        //authorData.forEach(System.out::println);
        List<Author> history = authorDataService.getAuthors();
        if (history.isEmpty()) {
            System.out.println("No author browsing history.");
        } else {
            history.forEach(System.out::println);
        }
    }

    private void findAliveAuthors() {
        System.out.println("Enter the specific year: ");
        int year = scanner.nextInt();
        scanner.nextLine();
        List<Author> aliveAuthors = authorDataService.getAliveAuthors(year);
        if (aliveAuthors.isEmpty()) {
            System.out.println("No alive authors found from year " + year + ".");
        } else {
            aliveAuthors.forEach(System.out::println);
        }
    }



    private void listBooksByLanguage() {
        System.out.println("Enter the language: ");
        String language = scanner.nextLine();
        List<BookDataC> booksByLanguage = bookDataService.getBooksByLanguage(language);
        if (booksByLanguage.isEmpty()) {
            System.out.println("No books found for language: " + language + ".");
        } else {
            booksByLanguage.forEach(System.out::println);
        }
    }
























}
