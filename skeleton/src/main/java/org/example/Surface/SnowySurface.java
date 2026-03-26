package org.example.Surface;

import org.example.Inventory;
import org.example.Main;
import org.example.Map.Lane;
import org.example.Plowhead.PlowHead;
import org.example.SkeletonHelper;
import org.example.Vehicle.Vehicle;

public class SnowySurface extends Surface {
    @Override
    public boolean handleVehicle(Vehicle v, Lane l) { return true; }
    @Override
    public boolean clean(PlowHead head, Inventory inv, Lane l) {
        String headName = SkeletonHelper.getObjectName(head);
        String laneName = SkeletonHelper.getObjectName(l);

        Main.logMethodCall("SnowySurface", headName, "operate", laneName + ", inv", 3);
        head.operate(l, inv);
        Main.logMethodReturn("void", "", 3);

        if (head instanceof org.example.Plowhead.Sweeper) {
            Main.logMethodCall("SnowySurface", "Lane", "setSurface", "new CleanSurface()", 3);
            l.setSurface(new org.example.Surface.CleanSurface());
            Main.logMethodReturn("void", "", 3);
        }
        return true;
    }
    @Override
    public void receiveSnow(int amount, Lane l) {}
}