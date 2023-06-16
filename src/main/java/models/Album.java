package models;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Album {
    private int id;
    private String artist;
    private String name;
    private int releaseDate;
    private float sales;
    private String genre;
}
