package booking;

import java.sql.Connection;

public class AccomodationApp {
    public static void main(String[] args) {
        ConnectionManager connectionManager = new ConnectionManager();
        Connection connection = connectionManager.getConnection("jdbc:postgresql://localhost:5432/national10", "postgres", "12345");
        AccomodationService accomodationService = new AccomodationService(connection);


        int id = 12345;
        String type = "double room";
        String bedType = "king size";
        int maxGuests = 2;
        String description = "This double room has a electric kettle, air conditioning and bathrobe.";
        //String phoneNumber = "123123432'); DROP TABLE admins;--";
        accomodationService.addAccomodationEntry(new Accomodation(id, type, bedType, maxGuests, description));
        System.out.println(accomodationService.getAccomodationEntry(123455));

        
    }
}
