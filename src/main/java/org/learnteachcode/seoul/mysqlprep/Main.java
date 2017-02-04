package org.learnteachcode.seoul.mysqlprep;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.*;
import java.util.List;

public class Main {
    public static void main(String[] args) {

    }

    public static void insertExample() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(
                    "jdbc:mariadb://localhost:3306/class",
                    "java_class",
                    "bestclass"
            );
            String insertQuery = "INSERT INTO example (name) VALUES (?)";
            PreparedStatement statement = connection.prepareStatement(insertQuery);
            statement.setString(1, "Beege");
            statement.execute();
            connection.commit();
        } catch(SQLException e) {
            System.out.println("Hit exception doing database stuff: " + e);
        } finally {
            if(connection != null) {
                try {
                    connection.close();
                } catch (SQLException e1) {
                    System.out.println("Failed to close DB connection: " + e1);
                }
            }
        }
    }

    public static void selectExample() {

        Connection connection = null;
        try {
            connection = DriverManager.getConnection(
                    "jdbc:mariadb://localhost:3306/class",
                    "java_class",
                    "bestclass"
            );
            String insertQuery = "SELECT * FROM example;";
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
            if(connection != null) {
                try {
                    connection.close();
                } catch (SQLException e1) {
                    System.out.println("Failed to close DB connection: " + e1);
                }
            }
        }
    }

    public static EntityManagerFactory setupJPAFactory() {
        return Persistence.createEntityManagerFactory( "org.learnteachcode.seoul.mysqlprep.persistence-unit" );
    }

    public static void closeFactory(EntityManagerFactory factory) {
        factory.close();
    }

    public static void insertJPAExample(EntityManagerFactory entityManagerFactory) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist( new Example( "King Sejong" ) );
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public static void retrieveJPAExample(EntityManagerFactory entityManagerFactory) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        List<Example> result = entityManager.createQuery( "from Example", Example.class ).getResultList();
        for ( Example example : result ) {
            System.out.println(example);
        }
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
