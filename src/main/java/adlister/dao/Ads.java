package adlister.dao;

import adlister.models.Ad;

import java.util.List;

public interface Ads {
    List<Ad> all();
    Ad findById(long id);
    Long insert(Ad ad);
    List<Ad> searchAds(String query);
    List<Ad> getAdsByUser(long userId); // New method to retrieve ads by user
}



