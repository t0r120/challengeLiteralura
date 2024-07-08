package com.literalura.challengeLiteralura.traduction;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)

public class GutendexResponse {
    private int count;

    private String next;

    private List<BookDataC> results;

    // GETTERS AND SETTERS



    public int getCount(){
        return count;
    }

    public void setCount(int count){
        this.count = count;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public List<BookDataC> getResults() {
        return results;
    }

    public void setResults(List<BookDataC> results) {
        this.results = results;
    }

    @Override
    public String toString() {
        return "GutendexResponse{" +
                "results=" + results +
                '}';
    }

}
