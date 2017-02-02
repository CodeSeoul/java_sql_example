package org.learnteachcode.seoul.mysqlprep;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection(
                    "jdbc:mariadb://localhost:3306/classprep",
                    "java_class",
                    "bestclass"
            );
            String insertQuery = "INSERT INTO examples (name) VALUES (?)";
            PreparedStatement statement = connection.prepareStatement(insertQuery);
            statement.setString(1, "Beege");
            statement.execute();
            connection.commit();
        } catch(SQLException e) {
            System.out.println("Hit exception doing database stuff: " + e);
        }
    }
}
