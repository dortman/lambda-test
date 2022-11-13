package dev.ortman;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TestHandler {

    private final List<String> subscribers = new ArrayList<>();

    public List<String> handleRequest() {
        String jdbcUrl = "jdbc:postgresql://database-1.co95zbloxr85.us-west-2.rds.amazonaws.com:5432/";

        try (Connection conn = DriverManager.getConnection(jdbcUrl, "postgres", "spiderman")) {
            if (!conn.isValid(0)) {
                System.out.println("unable to connect to " + jdbcUrl);
                System.exit(0);
            }

            PreparedStatement selectStatement = conn.prepareStatement("select * from subscribers");
            ResultSet rs = selectStatement.executeQuery();

            while (rs.next()) {
                String email = rs.getString("email");
                System.out.println(email);

                subscribers.add(email);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return subscribers;
    }

}
