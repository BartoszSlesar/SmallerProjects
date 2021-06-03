package pl.challenges.adventuregame.immutable;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AdventureGame {
    private final Map<Integer, LocationImmutable> locations;
    private final Map<String, String> vocabulary;

    public AdventureGame() {
        locations = new HashMap<>();
        vocabulary = initializeVocabulary();



        locations.put(0, new LocationImmutable(0, "You are sitting in front of a computer learning Java", null));

        Map<String, Integer> tempExits = new HashMap<>();
        tempExits.put("W", 2);
        tempExits.put("E", 3);
        tempExits.put("S", 4);
        tempExits.put("N", 5);
        locations.put(1, new LocationImmutable(1, "You are standing at the end of a road before a small brick building", tempExits));

        tempExits = new HashMap<>();
        tempExits.put("N", 5);
        locations.put(2, new LocationImmutable(2, "You are at the top of a hill", tempExits));

        tempExits = new HashMap<>();
        tempExits.put("W", 1);
        locations.put(3, new LocationImmutable(3, "You are inside a building, a well house for a small spring", tempExits));

        tempExits = new HashMap<>();
        tempExits.put("N", 1);
        tempExits.put("W", 2);
        locations.put(4, new LocationImmutable(4, "You are in a valley beside a stream", tempExits));

        tempExits = new HashMap<>();
        tempExits.put("S", 1);
        tempExits.put("W", 2);
        locations.put(5, new LocationImmutable(5, "You are in the forest", tempExits));
    }

    public void start() {
        Scanner scan = new Scanner(System.in);
        int loc = 1;
        while (true) {

            LocationImmutable location = locations.get(loc);
            System.out.println(location.getDescription());
            if (loc < 1) {
                break;
            }

            Map<String, Integer> exits = location.getExits();
            System.out.println("Available exists from your location");

            exits.keySet().forEach(e -> System.out.print(e + " "));
            System.out.println("\nchoose wisely");

            String direction = scan.nextLine().toUpperCase();
            if (!exits.containsKey(direction)) {
                String[] dirTemp = direction.split(" ");
                for (String var : dirTemp) {
                    if (vocabulary.containsKey(var)) {
                        direction = vocabulary.get(var);
                        break;
                    }
                }
            }

            if (exits.containsKey(direction)) {
                loc = exits.get(direction);
            } else {
                System.out.println("You can't go to that location");
            }


        }
    }

    private static Map<String, String> initializeVocabulary() {
        Map<String, String> vocabulary = new HashMap<>();
        vocabulary.put("NORTH", "N");
        vocabulary.put("SOUTH", "S");
        vocabulary.put("EAST", "E");
        vocabulary.put("WEST", "W");
        vocabulary.put("QUIT", "Q");
        return vocabulary;
    }

}
