package booking;

import java.sql.Connection;

public class RoomFairApp {
    public static void main(String[] args) {
        ConnectionManager connectionManager = new ConnectionManager();
        Connection connection = connectionManager.getConnection("jdbc:postgresql://localhost:5432/national10", "postgres", "12345");
        RoomFairService roomFairService = new RoomFairService(connection);
        for (int i = 1000; i <= 1009; i++) {

            Double value = 130.0;
            String season = "summer";
            roomFairService.addRoomFairEntry(new RoomFair(i, value, season));
        }

        for (int i = 1010; i <= 1019; i++) {

            Double value = 120.0;
            String season = "winter";
            roomFairService.addRoomFairEntry(new RoomFair(i, value, season));
        }

        for (int i = 1020; i <= 1024; i++) {

            Double value = 145.0;
            String season = "winter";
            roomFairService.addRoomFairEntry(new RoomFair(i, value, season));
        }

        for (int i = 1025; i <= 1029; i++) {

            Double value = 250.0;
            String season = "summer";
            roomFairService.addRoomFairEntry(new RoomFair(i, value, season));
        }

    }
}