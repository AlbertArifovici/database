package booking;

import java.util.UUID;

public class Accomodation {
    private int id;
    private String type;
    private String bedType;
    private int maxGuests;
    private String description;

    public Accomodation(int maxGuests) {
        this.maxGuests = maxGuests;
    }

    public Accomodation(UUID id, String description, String string, String max_guests, String bed_type) {
        this.description = description;
    }

    public Accomodation(int id, String type, String bedType, int maxGuests, String description) {
        this.id = id;
        this.type = type;
        this.bedType = bedType;
        this.maxGuests = maxGuests;
        this.description = description;

    }

    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public String getBedType() {
        return bedType;
    }

    public int getMaxGuests() {
        return maxGuests;
    }

    public String getDescription() {
        return description;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setBedType(String bedType) {
        this.bedType = bedType;
    }

    public void setMaxGuests(int maxGuests) {
        this.maxGuests = maxGuests;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Accomodation{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", bedType='" + bedType + '\'' +
                ", maxGuests=" + maxGuests +
                ", description='" + description + '\'' +
                '}';
    }
}