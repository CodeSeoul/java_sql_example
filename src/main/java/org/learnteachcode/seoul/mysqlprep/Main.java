package org.learnteachcode.seoul.mysqlprep;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
        selectExample();
    }

    public static void insertExample() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(
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
        } finally {
            try {
                connection.close();
            } catch(SQLException e1) {
                System.out.println("Failed to close DB connection: " + e1);
            }
        }
    }

    public static void selectExample() {

        Connection connection = null;
        try {
            connection = DriverManager.getConnection(
                    "jdbc:mariadb://localhost:3306/classprep",
                    "java_class",
                    "bestclass"
            );
            String insertQuery = "SELECT * FROM examples;";
            PreparedStatement statement = connection.prepareStatement(insertQuery);
            statement.execute();
            ResultSet results = statement.getResultSet();
            while(results.next()) {
                String name = results.getString("name");
                System.out.println("name: " + name);
            }
            connection.commit();
        } catch(SQLException e) {
            System.out.println("Hit exception doing database stuff: " + e);
        } finally {
            try {
                connection.close();
            } catch(SQLException e1) {
                System.out.println("Failed to close DB connection: " + e1);
            }
        }
    }
}
