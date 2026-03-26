package org.example.Map;

import org.example.Inventory;
import org.example.Main;
import org.example.Plowhead.PlowHead;
import org.example.SkeletonHelper;
import org.example.Surface.Surface;
import org.example.Vehicle.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class Lane {
    private int snowThickness;
    private int iceThickness;
    private List<Vehicle> vehicles = new ArrayList<>();
    private Road parentRoad;
    private Surface surface;
    private boolean isSalted;

    public void setSurface(Surface s) {
        this.surface = s;
    }
    public void weatherTick() {}
    public void propagateCrash() {}
    public boolean acceptVehicle(Vehicle v) { return false; }
    public boolean clean(PlowHead head, Inventory inv) {
        if (surface != null) {
            String headName = SkeletonHelper.getObjectName(head);
            String laneName = SkeletonHelper.getObjectName(this);

            Main.logMethodCall("Lane", "SnowySurface", "clean", headName + ", inv, " + laneName, 2);
            boolean result = surface.clean(head, inv, this);
            Main.logMethodReturn("boolean", String.valueOf(result), 2);
        }
        return true;
    }

    public void receiveSnow(int amount) {}
    public void setSalted(boolean b) {}
}