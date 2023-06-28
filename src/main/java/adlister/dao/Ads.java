package adlister.dao;

import adlister.models.Ad;
import adlister.models.User;

import java.util.List;

public interface Ads {
    // get a list of all the ads
    List<Ad> all();

    Ad findById(long id);
    // insert a new ad and return the new ad's id
    Long insert(Ad ad);

    void delete(long id);
    void update(Ad ad);


    List<Ad> searchAds(String query);
}


