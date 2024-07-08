package com.literalura.challengeLiteralura.records;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)

public record Lenguages(
        @JsonAlias("en") String en,
        @JsonAlias("en")String es,
        @JsonAlias("en")String fr

) {
}
