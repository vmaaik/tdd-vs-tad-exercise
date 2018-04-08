package com.gebarowski.tad_inventory;

import com.gebarowski.tdd_inventory_item.InventoryItem;
import com.google.common.base.Preconditions;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Michał Gębarowski on 04/04/2018
 */
public class InventoryImpl implements Inventory {

    private final List<InventoryItem> items = new ArrayList<>();
    private int countLimit;
    private double weightLimit;

    public static Inventory create() {
        return new InventoryImpl();
    }

    public double getWeightLimit() {
        return weightLimit;
    }

    @Override
    public void setWeightLimit(double weightLimit) {
        this.weightLimit = weightLimit;
    }

    @Override
    public int getCountLimit() {
        return countLimit;
    }

    @Override
    public void setCountLimit(final int limit) {
        Preconditions.checkArgument(limit >= 0, "Count countLimit can not be negative");
        Preconditions.checkArgument(limit >= items.size(), "Limit too low");
        this.countLimit = limit;
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
