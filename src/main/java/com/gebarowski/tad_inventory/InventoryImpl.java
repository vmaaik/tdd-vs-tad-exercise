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
        Preconditions.checkArgument(weightLimit >= 0, "Weight limit can not be negative");
        Preconditions.checkArgument(weightLimit >= getTotalWeight(), "Weight limit too low");
        this.weightLimit = weightLimit;
    }

    @Override
    public int getCountLimit() {
        return countLimit;
    }

    @Override
    public void setCountLimit(final int limit) {
        Preconditions.checkArgument(limit >= 0, "Count limit can not be negative");
        Preconditions.checkArgument(limit >= items.size(), "Count too low");
        this.countLimit = limit;
    }

    @Override
    public void add(InventoryItem item) {
        Preconditions.checkNotNull(item, "Item can not be null");
        Preconditions.checkState(size() < getCountLimit(), "Cannot exceed item count limit");
        Preconditions.checkState(getTotalWeight() + item.getWeight() <= getWeightLimit(), "Cannot exceed  total item weight limit");
        items.add(item);
    }

    @Override
    public void remove(InventoryItem inventoryItem) {
        throw new UnsupportedOperationException();
    }

    @Override
    public InventoryItem get(int index) {
        return items.get(index);
    }

    @Override
    public int size() {
        return items.size();
    }

    @Override
    public double getTotalWeight() {
        return items.stream()
                .mapToDouble(item -> item.getWeight())
                .sum();
    }

    @Override
    public Iterator<InventoryItem> iterator() {
        throw new UnsupportedOperationException();
    }
}
