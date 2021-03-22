package hu.nive.ujratervezes.zarovizsga.cleaning;

public class House implements Cleanable {

    private String address;
    private int area;

    public House(String address, int area) {
        this.address = address;
        this.area = area;
    }

    @Override
    public String getAddress() {
        return address;
    }

    @Override
    public int clean() {
        int price = area * 80;
        return price;
    }

}
