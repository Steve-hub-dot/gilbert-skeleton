package org.example;

import org.example.Map.Lane;
import org.example.Map.Node;
import org.example.Player.Snowplow;
import org.example.Plowhead.PlowHead;
import org.example.Vehicle.Vehicle;

import java.util.HashMap;

public class SkeletonHelper {
    private static HashMap<String, Lane> lanes = new HashMap<>();
    private static HashMap<String, Snowplow> snowplows = new HashMap<>();
    private static HashMap<String, PlowHead> heads = new HashMap<>();
    private static HashMap<String, Vehicle> vehicles = new HashMap<>();
    private static HashMap<String, Node> nodes = new HashMap<>();
    private static Game game;
    private static Shop shop;

    public static void reset() {
        lanes.clear();
        snowplows.clear();
        heads.clear();
        vehicles.clear();
        nodes.clear();
        game = new Game();
        shop = new Shop();
    }


    public static void addLane(String name, Lane lane) {
        lanes.put(name, lane);
    }
    public static void addSnowplow(String name, Snowplow sp) {
        snowplows.put(name, sp);
    }

    public static void addHead(String name, PlowHead head) {
        heads.put(name, head);
    }

    public static void addVehicle(String name, Vehicle v) {
        vehicles.put(name, v);
    }
    public static void addNode(String name, Node n) {
        nodes.put(name, n);
    }
    public static String getObjectName(Object obj) {
        // Végigpörgetjük az összes tárolót, hogy megkeressük az objektum nevét
        for (var entry : lanes.entrySet()) if (entry.getValue() == obj) return entry.getKey();
        for (var entry : snowplows.entrySet()) if (entry.getValue() == obj) return entry.getKey();
        for (var entry : heads.entrySet()) if (entry.getValue() == obj) return entry.getKey();
        for (var entry : vehicles.entrySet()) if (entry.getValue() == obj) return entry.getKey();
        for (var entry : nodes.entrySet()) if (entry.getValue() == obj) return entry.getKey();

        if (obj == game) return "game";
        if (obj == shop) return "shop";

        return "Unknown";
    }


    public static Lane getLane(String name) { return lanes.get(name); }
    public static Snowplow getSnowplow(String name) { return snowplows.get(name); }
    public static PlowHead getHead(String name) { return heads.get(name); }
    public static Node getNode(String name) { return nodes.get(name); }
    public static Game getGame() { return game; }
}