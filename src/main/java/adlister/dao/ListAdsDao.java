package adlister.dao;

import adlister.models.Ad;

import java.util.ArrayList;
import java.util.List;

public class ListAdsDao implements Ads {
    private List<Ad> ads;

    @Override
    public List<Ad> all() {
        if (ads == null) {
            ads = generateAds();
        }
        return ads;
    }

    @Override
    public Ad findById(long id) {
        if (ads == null) {
            ads = generateAds();
        }
        for (Ad ad : ads) {
            if (ad.getId() == id) {
                return ad;
            }
        }
        return null; // Return null if ad with given id is not found
    }

    @Override
    public Long insert(Ad ad) {
        if (ads == null) {
            ads = generateAds();
        }
        ad.setId((long) ads.size());
        ads.add(ad);
        return ad.getId();
    }

    @Override
    public List<Ad> searchAds(String query) {
        if (ads == null) {
            ads = generateAds();
        }

        List<Ad> matchingAds = new ArrayList<>();
        for (Ad ad : ads) {
            if (ad.getTitle().toLowerCase().contains(query.toLowerCase()) ||
                    ad.getDescription().toLowerCase().contains(query.toLowerCase())) {
                matchingAds.add(ad);
            }
        }

        return matchingAds;
    }

    @Override
    public List<Ad> getAdsByUser(long userId) {
        if (ads == null) {
            ads = generateAds();
        }

        List<Ad> userAds = new ArrayList<>();
        for (Ad ad : ads) {
            if (ad.getUserId() == userId) {
                userAds.add(ad);
            }
        }

        return userAds;
    }

    private List<Ad> generateAds() {
        List<Ad> ads = new ArrayList<>();
        ads.add(new Ad(
                1,
                1,
                "playstation for sale",
                "This is a slightly used playstation"
        ));
        ads.add(new Ad(
                2,
                1,
                "Super Nintendo",
                "Get your game on with this old-school classic!"
        ));
        ads.add(new Ad(
                3,
                2,
                "Junior Java Developer Position",
                "Minimum 7 years of experience required. You will be working in the scripting language for Java, JavaScript"
        ));
        ads.add(new Ad(
                4,
                2,
                "JavaScript Developer needed",
                "Must have strong Java skills"
        ));
        return ads;
    }
    @Override
    public void delete(long id) {
        ads.removeIf(ad -> ad.getId() == id);
    }



    @Override
    public void update(Ad ad) {
        for (Ad existingAd : ads) {
            if (existingAd.getId() == ad.getId()) {
                existingAd.setTitle(ad.getTitle());
                existingAd.setDescription(ad.getDescription());
                for (int i = 0; i < ads.size(); i++) {
                    if (ads.get(i).getId() == ad.getId()) {
                        ads.set(i, ad);
                        return;
                    }
                }
            }
        }
    }
}
