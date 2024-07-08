package com.literalura.challengeLiteralura.records;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record BookData(
        @JsonAlias("title") String title,
        @JsonAlias("authors") List<AuthorData> autors,
        @JsonAlias("languages") List<String> lenguages,
        @JsonAlias("download_count") Double downloads

) {
}
