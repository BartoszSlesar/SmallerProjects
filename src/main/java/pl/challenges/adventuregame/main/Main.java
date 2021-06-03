package pl.challenges.adventuregame.main;

import pl.challenges.adventuregame.logic.Location;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static final Map<Integer, Location> locations = new HashMap<>();
    private static final Map<String, String> vocabulary = new HashMap<>();

    public static void main(String[] args) {
        vocabulary.putAll(initializeVocabulary());
        locations.put(0, new Location(0, "You are sitting in front of a computer learning Java"));
        locations.put(1, new Location(1, "You are standing at the end of a road before a small brick building"));
        locations.put(2, new Location(2, "You are at the top of a hill"));
        locations.put(3, new Location(3, "You are inside a building, a well house for a small spring"));
        locations.put(4, new Location(4, "You are in a valley beside a stream"));
        locations.put(5, new Location(5, "You are in the forest"));

        locations.get(1).addExit("W", 2);
        locations.get(1).addExit("E", 3);
        locations.get(1).addExit("S", 4);
        locations.get(1).addExit("N", 5);

        locations.get(2).addExit("N", 5);

        locations.get(3).addExit("W", 1);

        locations.get(4).addExit("N", 1);
        locations.get(4).addExit("W", 2);

        locations.get(5).addExit("S", 1);
        locations.get(5).addExit("W", 2);
        command();
    }

    public static void command() {
        Scanner scan = new Scanner(System.in);
        int loc = 1;
        while (true) {

            Location location = locations.get(loc);
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
        return vocabulary;
    }

}
