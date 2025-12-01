package advancedConcepts.inventoryManagementSystem;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class RecentlyViewedItems {
    private LinkedList<Item> recentlyViewedItems;
    private Integer MAX_SIZE = 3;

    public RecentlyViewedItems() {
        this.recentlyViewedItems = new LinkedList<>();
    }

    public void addRecentlyViewedItem(Item item) {
        //remove the item if its already present
        recentlyViewedItems.remove(item); // if exists removes and returns true, else returns false

        recentlyViewedItems.addFirst(item); // adding item at the start
        if(recentlyViewedItems.size() > MAX_SIZE) {
            recentlyViewedItems.removeLast(); // removing item from the last
        }
    }

    public List<Item> getRecentlyViewedItems() {
        return new ArrayList<>(recentlyViewedItems);
    }
}
/*
    B1, C1, E1

    B1

    C1, E1, B1

 */