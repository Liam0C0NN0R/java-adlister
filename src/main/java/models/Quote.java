package models;

import lombok.*;
import models.Author;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Quote {
    private int id;
    private String content;
    private Author author;

    public Quote(String content, Author author) {
        this.content = content;
        this.author = author;
    }
}