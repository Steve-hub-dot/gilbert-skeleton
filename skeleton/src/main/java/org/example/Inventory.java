package org.example;

import org.example.Plowhead.PlowHead;
import org.example.Resource.BioKerosene;
import org.example.Resource.Resource;
import org.example.Resource.Salt;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Inventory {
    private List<PlowHead> storedHeads = new ArrayList<>();
    private Salt salt;
    private BioKerosene kerosene;

    public void addHead(PlowHead h) {}
    public void removeHead(PlowHead h) {}
    public boolean consumeSalt() {
        Main.logMethodCall("Salter", "Inventory", "consumeSalt", "", 4);

        System.out.print("\t\t\t\t[?] Van még elegendő só a raktárban? (I/N): ");
        Scanner sc = new Scanner(System.in);
        String answer = sc.nextLine();

        boolean success = answer.equalsIgnoreCase("I");
        Main.logMethodReturn("boolean", String.valueOf(success), 4);
        return success;
    }
    public boolean consumeKerosene() { return false; }
    public void addResource(Resource type, int amount) {}
}