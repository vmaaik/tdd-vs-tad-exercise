package com.gebarowski.tdd_inventory_item;

import com.google.common.base.Preconditions;
import com.google.common.base.Strings;

import javax.annotation.Nonnull;
import java.io.Serializable;

/**
 * Created by Michał Gębarowski on 31/03/2018
 */
public class InventoryItemImpl implements InventoryItem, Serializable {

    @Nonnull
    private final String name;
    private final double weight;

    private InventoryItemImpl(final String name, final double weight) {
        Preconditions.checkArgument(!Strings.isNullOrEmpty(name), "No item name specified");
        Preconditions.checkArgument(weight >= 0.0, "Item weight has to be non-negative");
        this.name = name;
        this.weight = weight;
    }

    public static InventoryItem of(final String name, final double weight) {
        return new InventoryItemImpl(name, weight);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public final int hashCode() {
        return name.hashCode() + Double.hashCode(weight);
    }

    @Override
    public final boolean equals(final Object rightSide) {
        if (!(rightSide instanceof InventoryItem)) {
            return false;
        }
        final InventoryItem that = (InventoryItem) rightSide;
        return (this == that) || name.equals(that.getName()) && Double.compare(weight, that.getWeight()) == 0;
    }

    @Override
    public String toString() {
        return new StringBuilder(name)
                .append(", ")
                .append(weight)
                .toString();
    }

    @Override
    public double getWeight() {
        return weight;
    }
}
