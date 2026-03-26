package org.example.Plowhead;

import org.example.Inventory;
import org.example.Main;
import org.example.Map.Lane;

public class Salter extends PlowHead {
    @Override
    public void operate(Lane l, Inventory inv) {

        boolean hasSalt = inv.consumeSalt();

        if (hasSalt) {
            Main.logMethodCall("Salter", "Lane", "setSalted", "true", 4);
            l.setSalted(true);
            Main.logMethodReturn("void", "", 4);
        }
    }
}