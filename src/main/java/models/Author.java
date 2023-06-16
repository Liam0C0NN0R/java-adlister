package models;

import lombok.*;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Author {
    private int id;
    private String name;

    public Author(String name) {
        this.name = name;
    }
}
