package adlister.models;

import java.util.ArrayList;
import java.util.List;

public class AdSearch {
    public List<Ad> searchByDescription(List<Ad> ads, String query) {
        List<Ad> matchingAds = new ArrayList<>();

        if (query != null) {
            String lowercaseQuery = query.toLowerCase(); // Convert the search query to lowercase

            System.out.println("Search Query: " + query); // Logging the search query

            for (Ad ad : ads) {
                System.out.println("Processing Ad: " + ad.getTitle()); // Logging the ad being processed

                String lowercaseTitle = ad.getTitle().toLowerCase(); // Convert the ad title to lowercase
                String lowercaseDescription = ad.getDescription().toLowerCase(); // Convert the ad description to lowercase

                if (lowercaseTitle.contains(lowercaseQuery) || lowercaseDescription.contains(lowercaseQuery)) {
                    matchingAds.add(ad);
                }
            }
        }

        return matchingAds;
    }
}

