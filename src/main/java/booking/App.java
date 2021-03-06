package booking;

import java.sql.*;

public class App {
    public static void main(String[] args) throws SQLException {
        ConnectionManager connectionManager = new ConnectionManager();
        Connection connection = connectionManager.getConnection("jdbc:postgresql://localhost:5432/national10", "postgres", "12345");

        try (Statement query = connection.createStatement()) {
            ResultSet response = query.executeQuery("SELECT * FROM accomodation");
            while (response.next()) {
                Accomodation accomodation = new Accomodation(response.getInt("id"), response.getString("type"), response.getString("bed_type"), response.getInt("max_guests"), response.getString("description"));
                System.out.println(accomodation);
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }

        System.out.println();

        try (Statement query = connection.createStatement()) {
            ResultSet response = query.executeQuery("SELECT * FROM room_fair");
            while (response.next()) {
                RoomFair roomFair = new RoomFair(response.getInt("id"), response.getDouble("value"), response.getString("season"));
                System.out.println(roomFair);
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }

        try (Statement query = connection.createStatement()) {
            ResultSet response = query.executeQuery("SELECT accomodation.type, room_fair.season, room_fair.value
FROM ((accomodation
INNER JOIN room_fair ON accomodation.id = room_fair.id)
INNER JOIN accomodation_fair_relation ON accomodation.id= accomodation_fair_relation.id);");
            while (response.next()) {
                System.out.println(response.getString("type"));
                System.out.println(response.getString("season"));
                System.out.println(response.getDouble("value"));
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }

    }
}