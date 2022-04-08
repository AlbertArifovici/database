package booking;

import booking.Accomodation;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.UUID;

public class App {
    public static void main(String[] args) {
        ConnectionManager connectionManager = new ConnectionManager();
        Connection connection = connectionManager.getConnection("jdbc:postgresql://localhost:5432/national10", "postgres", "12345");

        try (Statement query = connection.createStatement()) {
            ResultSet response = query.executeQuery("selecT * FROM accomodation");
            while (response.next()) {
                Accomodation accomodation = new Accomodation(
                        response.getInt("id"),
                        response.getString("type"),
                        response.getString("bed_type"),
                        response.getInt("max_guests"),
                        response.getString("description") );
                System.out.println(accomodation);
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }
}
