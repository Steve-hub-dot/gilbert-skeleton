package org.example;

import org.example.Map.Lane;
import org.example.Map.Node;
import org.example.Player.Snowplow;
import org.example.Plowhead.Salter;
import org.example.Plowhead.Sweeper;
import org.example.Resource.Salt;
import org.example.Surface.SnowySurface;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    private static SkeletonHelper skeletonHelper = new SkeletonHelper();
    public static void main(String[] args) {
        boolean running = true;
        while(running) {
            displayMainMenu();
            skeletonHelper.reset();
            int choice = getUserInput();

            switch (choice){
                case 1:
                    runSnowplowTests();
                    break;
                case 0:
                    return;
            }
        }
    }

    private static void displayMainMenu() {
        System.out.println("\nVálasszon kategóriát:");
        System.out.println("1 - Hókotró tesztek");
        System.out.println("0 - Kilépés");
        System.out.print("Választás: ");
    }

    private static int getUserInput() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private static void runSnowplowTests() {
        while (true) {
            System.out.println("\nHókotró tesztek:");
            System.out.println("1 - " + getSnowplowTestDescription(1) + " [5.3.1 Szekvencia]");
            System.out.println("2 - " + getSnowplowTestDescription(2) + " [5.3.4 Szekvencia]");
            System.out.println("0 - Vissza a főmenübe");
            System.out.print("Választás: ");

            int choice = getUserInput();
            if (choice == 0) break;

            switch (choice) {
                case 1:
                    runSoproFejTeszt();
                    break;
                case 2:
                    runSozoFejTeszt();
                    break;
                default:
                    System.out.println("[i] Érvénytelen választás!");
                break;
            }
        }
    }

    private static void runSoproFejTeszt() {
        skeletonHelper.reset();

        Inventory inv = new Inventory();
        Lane l2 = new Lane();
        Node node = new Node();
        Snowplow sp = new Snowplow(inv);
        Sweeper sw = new Sweeper();
        SnowySurface sSurf = new SnowySurface();

        skeletonHelper.addSnowplow("sp", sp);
        skeletonHelper.addHead("sw", sw);
        skeletonHelper.addLane("l2", l2);
        skeletonHelper.addNode("node", node);

        l2.setSurface(sSurf);
        sp.changeHead(sw);

        System.out.println("\n--- 5.3.1. Takarítás sweeper fejjel teszt indítása ---");

        sp.move(node, l2);

        System.out.println("--- Teszt vége ---\n");
    }

    private static void runSozoFejTeszt() {
        skeletonHelper.reset();

        Inventory inv = new Inventory();
        Lane l2 = new Lane();
        Node node = new Node();
        Snowplow sp = new Snowplow(inv);
        Salter sh = new Salter();
        SnowySurface sSurf = new SnowySurface();

        skeletonHelper.addSnowplow("sp", sp);
        skeletonHelper.addHead("sh", sh);
        skeletonHelper.addLane("l2", l2);

        l2.setSurface(sSurf);
        sp.changeHead(sh);

        System.out.println("\n--- 5.3.4. Hókotró sót szór teszt indítása ---");

        sp.move(node, l2);

        System.out.println("--- Teszt vége ---\n");
    }
    private static String getSnowplowTestDescription(int choice) {
        String[] descriptions = {
                "Hókotró takarít (sweeper fejjel)",
                "Hókotró sót szór"
        };
        return descriptions[choice - 1];
    }

    public static void logMethodCall(String callerClass, String targetClass, String methodName, String parameters, int indent) {
        for (int i = 0; i < indent; i++) System.out.print("\t");
        System.out.println("-> " + targetClass + ": " + methodName + "(" + parameters + ")");
    }

    public static void logMethodReturn(String returnType, String value, int indent) {
        for (int i = 0; i < indent; i++) System.out.print("\t");
        if (returnType.equals("void")) {
            System.out.println("<- void");
        } else {
            System.out.println("<- " + returnType + ": " + value);
        }
    }
}