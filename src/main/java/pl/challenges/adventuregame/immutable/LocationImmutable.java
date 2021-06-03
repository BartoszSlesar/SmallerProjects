package pl.challenges.adventuregame.immutable;

import java.util.HashMap;
import java.util.Map;

public class LocationImmutable {
    private final int locationID;
    private final String description;
    private final Map<String, Integer> exits;

    public LocationImmutable(int locationID, String description, Map<String, Integer> exits) {
        this.locationID = locationID;
        this.description = description;
//        in here we are making sure that to exist will be new HashMap with new id,
//        that it will not be able to modify it after initialization
        this.exits = new HashMap<>(exits);
        this.exits.put("Q", 0);
    }

    public int getLocationID() {
        return locationID;
    }

    public String getDescription() {
        return description;
    }

    public Map<String, Integer> getExits() {
        return new HashMap<>(exits);
    }
}
