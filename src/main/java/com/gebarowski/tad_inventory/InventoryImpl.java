package com.gebarowski.tad_inventory;

import com.gebarowski.tdd_inventory_item.InventoryItem;

import java.util.Iterator;

/**
 * Created by Michał Gębarowski on 04/04/2018
 */
public class InventoryImpl implements Inventory {
    @Override
    public void setWeightLimit(double limit) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void setCountLimit(int limit) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void add(InventoryItem inventoryItem) {
        throw new UnsupportedOperationException();
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
