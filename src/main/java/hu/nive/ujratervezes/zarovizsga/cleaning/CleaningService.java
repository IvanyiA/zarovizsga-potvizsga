package hu.nive.ujratervezes.zarovizsga.cleaning;

import java.util.ArrayList;
import java.util.List;

public class CleaningService {

    List<Cleanable> cleanables = new ArrayList<>();

    public List<Cleanable> getCleanables() {
        return cleanables;
    }

    public void add(Cleanable buiding) {
        cleanables.add(buiding);
    }

    public int cleanAll() {
        int sum = 0;
        for (Cleanable cleanable : cleanables) {
            sum += cleanable.clean();
        }
        cleanables.clear();
        return sum;
    }

    public int cleanOnlyOffices() {
        return 0;
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
        StringBuilder stringBuilder = new StringBuilder();
        for (Cleanable cleanable : cleanables) {
            stringBuilder.append(cleanable.getAddress()).append(", ");
        }
        return stringBuilder.subSequence(0, stringBuilder.length() - 2).toString();
    }
}
