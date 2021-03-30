package hu.nive.ujratervezes.zarovizsga.cleaning;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CleaningService {

    private List<Cleanable> cleanables = new ArrayList<>();

    public List<Cleanable> getCleanables() {
        return cleanables;
    }

    public void add(Cleanable buiding) {
        cleanables.add(buiding);
    }

    public int cleanAll() {
        int sumOfPrice = 0;
        for (Cleanable cleanable : cleanables) {
            sumOfPrice += cleanable.clean();
        }
        cleanables.clear();
        return sumOfPrice;
    }

    public int cleanOnlyOffices() {
        int priceOfOffices = 0;
        Iterator<Cleanable> iterator = cleanables.iterator();
        while (iterator.hasNext()) {
            Cleanable cleanable = iterator.next();

            if (cleanable.getType() == BuildingType.OFFICE) {
                priceOfOffices += cleanable.clean();
                iterator.remove();
            }
        }
        return priceOfOffices;
    }


    List<Cleanable> findByAddressPart(String address) {
        List<Cleanable> addresses = new ArrayList<>();
        for (Cleanable cleanable : cleanables) {
            if (cleanable.getAddress().contains(address)) {
                addresses.add(cleanable);
            }
        }
        return addresses;
    }

    public String getAddresses() {
        if (cleanables.size() == 0) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (Cleanable cleanable : cleanables) {
            stringBuilder.append(cleanable.getAddress()).append(", ");
        }
        return stringBuilder.subSequence(0, stringBuilder.length() - 2).toString();
    }

    public String getAddresses2() {
        if (cleanables.size() == 0) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(cleanables.get(0).getAddress());

        for (Cleanable cleanable : cleanables) {
            stringBuilder.append(", ").append(cleanable.getAddress());
        }
        return stringBuilder.toString();
    }

}
