package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import models.Ad;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLAdsDao implements Ads {

    private Connection connection;

    public MySQLAdsDao(Config config) {
        try {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            this.connection = DriverManager.getConnection(
                    config.getUrl(),
                    config.getUser(),
                    config.getPassword()
            );
        } catch (SQLException e) {
            throw new RuntimeException("Error connecting to the database!", e);
        }
    }

    @Override
    public List<Ad> all() {
        // 1. make a new list
        List<Ad> ads = new ArrayList<>();
        try {
            // 2. make a statement
            Statement st = connection.createStatement();
            // 3. execute the statement getting a resultset
            ResultSet adData = st.executeQuery("select * from ads");
            // 4. iterate over the resultset
            while (adData.next()) {
                Ad ad = new Ad(
                        adData.getLong("id"),
                        adData.getLong("user_id"),
                        adData.getString("title"),
                        adData.getString("description")
                );
                ads.add(ad);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return ads;
    }

    @Override
    public Long insert(Ad ad) {
        try {
            Statement st = connection.createStatement();
            String sql = "insert into ads"
                    + "(user_id, title, description)"
                    + " values (" + ad.getUserId()
                    + ", '" + ad.getTitle() + "'"
                    + ", '" + ad.getDescription() + "')";
            st.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);

            ResultSet keys = st.getGeneratedKeys();
            if (keys.next()) {
                return keys.getLong(1);
            } else {
                throw new RuntimeException("Could not insert ad");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
