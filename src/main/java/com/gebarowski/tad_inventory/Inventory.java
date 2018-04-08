package com.gebarowski.tad_inventory;

import com.gebarowski.tdd_inventory_item.InventoryItem;

/**
 * Created by Michał Gębarowski on 04/04/2018
 */
public interface Inventory extends Iterable<InventoryItem> {
    int getCountLimit();

    void setCountLimit(int limit);

    double getWeightLimit();

    void setWeightLimit(double limit);

    void add(InventoryItem inventoryItem);

    void remove(InventoryItem inventoryItem);

    InventoryItem get(int index);

    int size();

    double getTotalWeight();
}