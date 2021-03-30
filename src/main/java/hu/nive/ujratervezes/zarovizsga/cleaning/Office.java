package hu.nive.ujratervezes.zarovizsga.cleaning;

public class Office implements Cleanable {

    public static final int CLEANING_PRICE = 100;
    private String address;
    private int area;
    private int floors;
    private BuildingType buildingType = BuildingType.OFFICE;


    public Office(String address, int area, int floors) {
        this.address = address;
        this.area = area;
        this.floors = floors;
    }

    public static int getCleaningPrice() {
        return CLEANING_PRICE;
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
        int price = area * floors * CLEANING_PRICE;
        return price;
    }


}
