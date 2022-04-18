package booking;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class AccomodationService {
    private Connection connection;

    public AccomodationService(Connection connection) {
        this.connection = connection;
    }

    // Create
    public void addAccomodationEntry(Accomodation accomodation) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO accomodation VALUES (?, ?, ?, ?, ?)");
            preparedStatement.setInt(1, accomodation.getId());
            preparedStatement.setString(2, accomodation.getType());
            preparedStatement.setString(3, accomodation.getBedType());
            preparedStatement.setInt(4, accomodation.getMaxGuests());
            preparedStatement.setString(5, accomodation.getDescription());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Read
    public Accomodation getAccomodationEntry(int accomodationId) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM accomodation WHERE id = ?");
            preparedStatement.setObject(1, accomodationId);
            ResultSet result = preparedStatement.executeQuery();
            result.next();
            return new Accomodation(
                    result.getInt("id"),
                    result.getString("type"),
                    result.getString("bed_type"),
                    result.getInt("max_guests"),
                    result.getString("description"));

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Accomodation> getAccomodationByMaxGuests(int MaxGuests) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM accomodation WHERE max_guests LIKE ?");
            preparedStatement.setInt(4, MaxGuests);
            ResultSet result = preparedStatement.executeQuery();
            List<Accomodation> entries = new ArrayList<>();
            while (result.next()) {
                entries.add(new Accomodation(
                        result.getInt("id"),
                        result.getString("type"),
                        result.getString("bed_type"),
                        result.getInt("max_guests"),
                        result.getString("description")));
            }
            return entries;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    // Update
    public void updateAccomodation(Accomodation updatedAccomodation) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE accomodation SET name = ?, phone_number = ? WHERE id = ?");
            preparedStatement.setObject(1, updatedAccomodation.getId());
            preparedStatement.setString(2, updatedAccomodation.getType());
            preparedStatement.setString(3, updatedAccomodation.getBedType());
            preparedStatement.setInt(4, updatedAccomodation.getMaxGuests());
            preparedStatement.setString(5, updatedAccomodation.getDescription());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Delete
    public void deleteAccomodation(int id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM accomodation WHERE id = ?");
            preparedStatement.setObject(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
