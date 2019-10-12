package sa.elm.hr.drivers;

public class Trip {


    private String source;
    private String destination;
    private String rideDate;
    private String price;
    private int img;


    public Trip(String source, String destination, String rideDate, String price, int img) {
        this.source = source;
        this.destination = destination;
        this.rideDate = rideDate;
        this.price = price;
        this.img = img;
    }

    public String getSource() {
        return source;
    }

    public String getDestination() {
        return destination;
    }

    public String getRideDate() {
        return rideDate;
    }

    public String getPrice() {
        return price;
    }

    public int getImg() {
        return img;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setRideDate(String rideDate) {
        this.rideDate = rideDate;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setImg(int img) {
        this.img = img;
    }
}
