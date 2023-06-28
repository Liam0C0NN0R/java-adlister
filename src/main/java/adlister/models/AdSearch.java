package adlister.models;

import java.util.ArrayList;
import java.util.List;

public class AdSearch {
    public List<Ad> searchByDescription(List<Ad> ads, String query) {
        List<Ad> matchingAds = new ArrayList<>();

        for (Ad ad : ads) {
            if (ad.getTitle().contains(query) || ad.getDescription().contains(query)) {
                matchingAds.add(ad);
            }
        }

        return matchingAds;
    }
}
