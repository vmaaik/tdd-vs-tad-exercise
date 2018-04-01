package com.gebarowski.tdd_inventory;

import java.io.Serializable;

/**
 * Created by Michał Gębarowski on 31/03/2018
 */
public class InventoryItemImpl implements InventoryItem, Serializable {

    private InventoryItemImpl(final String name, final double weight) {
    }

    public static InventoryItem of(final String name, final double weight) {
        return new InventoryItemImpl(name, weight);
    }

    @Override
    public String getName() {
        throw new UnsupportedOperationException();
    }

    @Override
    public int hashCode() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean equals(final Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException();
    }

    @Override
    public double getWeight() {
        throw new UnsupportedOperationException();
    }
}
