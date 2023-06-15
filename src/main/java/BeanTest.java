import java.util.*;

public class BeanTest {
    public static void main(String[] args) {
        // Instantiate some albums
        // Instantiate some albums
        Album album1 = new Album(1, "Led Zeppelin", "Led Zeppelin IV", 1971, 37.0f, "Rock");
        Album album2 = new Album(2, "Metallica", "Master of Puppets", 1986, 6.0f, "Heavy Metal");
        Album album3 = new Album(3, "Rage Against the Machine", "Rage Against the Machine", 1992, 5.0f, "Nu-Metal");
        Album album4 = new Album(4, "Linkin Park", "Hybrid Theory", 2000, 27.0f, "Nu-Metal");
        Album album5 = new Album(5, "Volbeat", "Rewind, Replay, Rebound", 2019, 0.04f, "Punk 'N' Roll");

        // Instantiate some authors
        Author author1 = new Author("Terry Pratchett");
        Author author2 = new Author("Lily Tomlin");
        Author author3 = new Author("Mark Twain");
        Author author4 = new Author("Doug Larson");
        Author author5 = new Author("JRR Tolkien");

        // Instantiate some quotes
        Quote quote1 = new Quote("Build a man a fire, and he'll be warm for a day. Set a man on fire, and he'll be warm for the rest of his life.", author1);
        Quote quote2 = new Quote("The road to success is always under construction.", author2);
        Quote quote3 = new Quote("...mind over matter. If you don’t mind, it doesn’t matter.", author3);
        Quote quote4 = new Quote("If the English language made any sense, lackadaisical would have something to do with a shortage of flowers.", author4);
        Quote quote5 = new Quote("If more of us valued food and cheer and song above hoarded gold, it would be a merrier world.", author5);

        // Create ArrayLists and add the albums, quotes to them
        ArrayList<Album> albums = new ArrayList<>(Arrays.asList(album1, album2, album3, album4, album5));
        ArrayList<Quote> quotes = new ArrayList<>(Arrays.asList(quote1, quote2, quote3, quote4, quote5));

        // Iterate over the albums and print out their details
        for (Album album : albums) {
            System.out.println("Album: " + album.getName());
            System.out.println("Artist: " + album.getArtist());
            System.out.println("Year: " + album.getReleaseDate());
            System.out.println("Sales: " + album.getSales() + " million");
            System.out.println("Genre: " + album.getGenre());
            System.out.println();
        }

        // Iterate over the quotes and print out their content and author
        for (Quote quote : quotes) {
            System.out.println("Quote: " + quote.getContent());
            System.out.println("Author: " + quote.getAuthor().getName());
            System.out.println();
        }
    }
}
