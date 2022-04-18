package booking;

import java.sql.Connection;

public class AccomodationApp {
    public static void main(String[] args) {
        ConnectionManager connectionManager = new ConnectionManager();
        Connection connection = connectionManager.getConnection("jdbc:postgresql://localhost:5432/national10", "postgres", "12345");
        AccomodationService accomodationService = new AccomodationService(connection);

        for (int i = 1000; i <= 1009; i++) {

            String type = "double room";
            String bedType = "large double bed";
            int maxGuests = 2;
            String description = "This double room has a electric kettle, air conditioning and bathrobe.";
            accomodationService.addAccomodationEntry(new Accomodation(i, type, bedType, maxGuests, description));
        }

        for (int i = 1010; i <= 1019; i++) {

            String type = "platinium double room";
            String bedType = "extra-large double bed";
            int maxGuests = 2;
            String description = "This double room features a flat-screen TV, electric kettle and minibar.";
            accomodationService.addAccomodationEntry(new Accomodation(i, type, bedType, maxGuests, description));
        }
        for (int i = 1020; i <= 1024; i++) {

            String type = "premium double room";
            String bedType = "extra-large double bed";
            int maxGuests = 2;
            String description = "This double room has air conditioning, bathrobe and minibar.";
            accomodationService.addAccomodationEntry(new Accomodation(i, type, bedType, maxGuests, description));
        }

        for (int i = 1025; i <= 1029; i++) {

            String type = "apartment";
            String bedType = "double bed & couch.";
            int maxGuests = 3;
            String description = "This double room has 2 rooms with an extra-large double bed and one extendable couch.";
            accomodationService.addAccomodationEntry(new Accomodation(i, type, bedType, maxGuests, description));
        }
    }
}
