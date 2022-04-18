package booking;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RoomFairService {
    private Connection connection;

    public RoomFairService(Connection connection) {
        this.connection = connection;
    }

    // Create
    public void addRoomFairEntry(RoomFair roomFair) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO room_fair VALUES (?, ?, ?)");
            preparedStatement.setInt(1, roomFair.getId());
            preparedStatement.setDouble(2, roomFair.getValue());
            preparedStatement.setString(3, roomFair.getSeason());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Read
    public RoomFair getRoomFairEntry(int roomFairId) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM room_fair WHERE id = ?");
            preparedStatement.setObject(1, roomFairId);
            ResultSet result = preparedStatement.executeQuery();
            result.next();
            return new RoomFair(result.getInt("id"), result.getDouble("value"), result.getString("season"));

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Delete
    public void deleteRoomFair(int id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM room_fair WHERE id = ?");
            preparedStatement.setObject(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
