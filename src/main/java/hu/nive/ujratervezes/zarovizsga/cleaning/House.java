package hu.nive.ujratervezes.zarovizsga.cleaning;

public class House implements Cleanable {

    public static final int CLEANING_PRICE = 80;
    private String address;
    private int area;
    private BuildingType buildingType = BuildingType.HOUSE;

    public House(String address, int area) {
        this.address = address;
        this.area = area;
    }

    @Override
    public BuildingType getType() {
        return buildingType;
    }

    @Override
    public String getAddress() {
        return address;
    }

    @Override
    public int clean() {
        int price = area * CLEANING_PRICE;
        return price;
    }

}
