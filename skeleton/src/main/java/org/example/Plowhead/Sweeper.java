package org.example.Plowhead;

import org.example.Inventory;
import org.example.Main;
import org.example.Map.Lane;

public class Sweeper extends PlowHead {
    @Override
    public void operate(Lane l, Inventory inv) {
        Main.logMethodCall("Sweeper", "Lane", "receiveSnow", "amount", 4);
        Main.logMethodReturn("void", "", 4);
    }
}