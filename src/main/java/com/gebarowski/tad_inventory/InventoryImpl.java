package com.gebarowski.tad_inventory;

import com.gebarowski.tdd_inventory_item.InventoryItem;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Michał Gębarowski on 04/04/2018
 */
public class InventoryImpl implements Inventory {

    private final List<InventoryItem> items = new ArrayList<>();
    private int limit;

    public static Inventory create() {
        return new InventoryImpl();
    }

    @Override
    public void setWeightLimit(double limit) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int getCountLimit() {
        return limit;
    }

    @Override
    public void setCountLimit(final int limit) {
        Preconditions.checkArgument(limit >= 0, "Count limit can not be negative");
        Preconditions.checkArgument(limit >= items.size(), "Limit too low");
        this.limit = limit;
    }

    @Override
    public void add(InventoryItem inventoryItem) {
        items.add(inventoryItem);
    }

    @Override
    public void remove(InventoryItem inventoryItem) {
        throw new UnsupportedOperationException();
    }

    @Override
    public InventoryItem get(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int size() {
        throw new UnsupportedOperationException();
    }

    @Override
    public double getTotalWeight() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterator<InventoryItem> iterator() {
        throw new UnsupportedOperationException();
    }
}
