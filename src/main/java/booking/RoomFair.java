package booking;

public class RoomFair {
    private int id;
    private double value;
    String season;

    public RoomFair(int id, double value, String season) {
        this.id = id;
        this.value = value;
        this.season = season;
    }

    public int getId() {
        return id;
    }

    public double getValue() {
        return value;
    }

    public String getSeason() {
        return season;
    }

    @Override
    public String toString() {
        return "RoomFair{" +
                "id=" + id +
                ", value=" + value +
                ", season='" + season + '\'' +
                '}';
    }
}
