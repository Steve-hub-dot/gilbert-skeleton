package org.example.Player;

import org.example.Inventory;
import org.example.Main;
import org.example.Map.Lane;
import org.example.Map.Node;
import org.example.Plowhead.PlowHead;
import org.example.Resource.Resource;
import org.example.SkeletonHelper;

public class Snowplow {
    private Inventory inventory;
    private PlowHead activeHead;
    private int remainingMoves;
    private Node currentNode;

    public Snowplow(Inventory inventory) {
        this.inventory = inventory;
    }
    public boolean move(Node targetNode, Lane viaLane) {
        Main.logMethodCall("Tester", "Snowplow", "move", "node, l2", 0);

        if (activeHead != null) {
            String headName = SkeletonHelper.getObjectName(activeHead);
            Main.logMethodCall("Snowplow", "Lane", "clean", headName + ", inv", 1);

            boolean success = viaLane.clean(activeHead, this.inventory);

            Main.logMethodReturn("boolean", String.valueOf(success), 1);
        }

        Main.logMethodReturn("boolean", "true", 0);
        return true;
    }
    public void changeHead(PlowHead newHead) {
        this.activeHead = newHead;
    }
    public void addResource(Resource type, int amount) {}
}