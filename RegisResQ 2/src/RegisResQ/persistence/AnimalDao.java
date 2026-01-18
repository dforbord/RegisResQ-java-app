package RegisResQ.persistence;

import RegisResQ.application.Animal;
import RegisResQ.application.*;
import java.sql.*;
import java.util.*;

public class AnimalDao implements Dao<Animal> {
    private Connection conn;
    private List<Animal> animals;

    public AnimalDao() {
        animals = new ArrayList<>();
        try {
            // 🔄 Load the MySQL driver explicitly
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 🔄 Set up the database URL, username, and password
            String url = "jdbc:mysql://localhost:3306/animals?serverTimezone=UTC";
            String username = "cs444";         // your MySQL username
            String password = "p@sswordCS444"; // your MySQL password

            // 🔄 Connect to the database
            conn = DriverManager.getConnection(url, username, password);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Animal> getAll() {
        animals.clear();
        try (Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery("SELECT * FROM adoptable_pets");
            while (rs.next()) {
                String type = rs.getString("type");       // dog or cat
                String breed = rs.getString("breed");
                String name = rs.getString("name");
                Boolean sterilized = rs.getBoolean("sterilized");
                String arrived = rs.getString("arrived");

                if ("dog".equalsIgnoreCase(type)) {
                    animals.add(new Dog(breed, name, sterilized, arrived));
                } else if ("cat".equalsIgnoreCase(type)) {
                    animals.add(new Cat(breed, name, sterilized, arrived));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return animals;
    }

    @Override
    public Boolean add(Animal a) {
        String sql = "INSERT INTO adoptable_pets (type, breed, name, sterilized, arrived) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, a.getSpecies());       // "dog" or "cat"
            stmt.setString(2, a.getBreed());
            stmt.setString(3, a.getName());
            stmt.setBoolean(4, a.getSterilized());    // Use getSterilized()!
            stmt.setString(5, a.getDateArrived());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Boolean update(Animal a) {
        String sql = "UPDATE adoptable_pets SET type=?, breed=?, sterilized=?, arrived=? WHERE name=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, a.getSpecies());
            stmt.setString(2, a.getBreed());
            stmt.setBoolean(3, a.getSterilized());     // Use getSterilized()!
            stmt.setString(4, a.getDateArrived());
            stmt.setString(5, a.getName());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Boolean delete(Animal a) {
        String sql = "DELETE FROM adoptable_pets WHERE name=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, a.getName());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
