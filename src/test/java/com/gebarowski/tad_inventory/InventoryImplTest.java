package com.gebarowski.tad_inventory;

import com.gebarowski.tdd_inventory_item.InventoryItem;
import com.gebarowski.tdd_inventory_item.InventoryItemImpl;
import org.assertj.core.data.Offset;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Created by Michał Gębarowski on 04/04/2018
 */
class InventoryImplTest {

    private Inventory inventory;

    @BeforeEach
    public void before() {
        inventory = InventoryImpl.create();
    }

    @Test
    public void setPositiveCountLimit() {
        inventory.setCountLimit(5);
        assertThat(inventory.getCountLimit()).isEqualTo(5);
    }

    @Test
    public void setZeroCountLimit() {
        inventory.setCountLimit(0);
        assertThat(inventory.getCountLimit()).isZero();
    }

    @Test
    public void setNegativeCountLimit() {
        assertThrows(IllegalArgumentException.class, () -> inventory.setCountLimit(-9));
    }

    @Test
    public void lowerCountLimit() {
        inventory.setCountLimit(3);
        inventory.setWeightLimit(6.0);
        inventory.add(InventoryItemImpl.of("Item1", 1.0));
        inventory.add(InventoryItemImpl.of("Item2", 3.0));
        inventory.setCountLimit(2);
    }

    @Test
    public void countLimitTooLow() {
        inventory.setCountLimit(3);
        inventory.setWeightLimit(5.0);
        inventory.add(InventoryItemImpl.of("Item1", 1.0));
        inventory.add(InventoryItemImpl.of("Item2", 3.0));
        assertThrows(IllegalArgumentException.class, () -> inventory.setCountLimit(1));
    }

    @Test
    public void setPositiveWeightLimit() {
        inventory.setWeightLimit(5.0);
        assertThat(inventory.getWeightLimit()).isEqualTo(5.0);
    }

    @Test
    public void setZeroWeightLimit() {
        inventory.setWeightLimit(0);
        assertThat(inventory.getWeightLimit()).isZero();
    }

    @Test
    public void setNegativeWeightLimit() {
        assertThrows(IllegalArgumentException.class, () -> inventory.setWeightLimit(-9.0));
    }

    @Test
    public void lowerWeightLimit() {
        inventory.setWeightLimit(5.0);
        inventory.setCountLimit(5);
        inventory.add(InventoryItemImpl.of("Item1", 1.0));
        inventory.add(InventoryItemImpl.of("Item2", 3.0));
        inventory.setWeightLimit(4.0);
    }

    @Test
    public void weightLimitTooLow() {
        inventory.setWeightLimit(5.0);
        inventory.setCountLimit(6);
        inventory.add(InventoryItemImpl.of("Item1", 1.0));
        inventory.add(InventoryItemImpl.of("Item2", 3.0));
        assertThrows(IllegalArgumentException.class, () -> inventory.setWeightLimit(1.0));
    }

    @Test
    public void emptyInventoryHasToWeight() {
        assertThat(inventory.getTotalWeight()).isZero();
    }

    @Test
    public void getTotalWeight() {
        inventory.setWeightLimit(5.0);
        inventory.setCountLimit(5);
        inventory.add(InventoryItemImpl.of("Item1", 1.1));
        inventory.add(InventoryItemImpl.of("Item2", 3.2));
        assertThat(inventory.getTotalWeight()).isEqualTo(4.3, Offset.offset(0.01));
    }

    @Test
    public void addNull() {
        assertThrows(NullPointerException.class, () -> inventory.add(null));
    }

    @Test
    public void addExceedingCountLimit() {
        inventory.setCountLimit(0);
        inventory.setWeightLimit(3.0);
        assertThrows(IllegalStateException.class, () -> inventory.add(InventoryItemImpl.of("Item1", 1.1)));
    }

    @Test
    public void addExceedingWeightLimit() {
        inventory.setWeightLimit(0.9);
        inventory.setCountLimit(9);
        assertThrows(IllegalStateException.class, () -> inventory.add(InventoryItemImpl.of("Item1", 1.1)));
    }

    @Test
    public void add() {
        inventory.setCountLimit(10);
        inventory.setWeightLimit(2.9);
        inventory.add(InventoryItemImpl.of("Item1", 1.1));
        inventory.add(InventoryItemImpl.of("Item2", 1.5));
        assertThat(inventory.size()).isEqualTo(2);
    }

    @Test
    public void getNegatve() {
        assertThrows(IndexOutOfBoundsException.class, () -> inventory.get(-1));
    }

    @Test
    public void getFromEmpty() {
        assertThrows(IndexOutOfBoundsException.class, () -> inventory.get(0));
    }

    @Test
    public void getExceedingEnd() {
        inventory.setCountLimit(2);
        inventory.setWeightLimit(10.0);
        inventory.add(InventoryItemImpl.of("Item1", 1.1));
        assertThrows(IndexOutOfBoundsException.class, () -> inventory.get(1));
    }

    @Test
    public void get() {
        inventory.setCountLimit(2);
        inventory.setWeightLimit(10.0);
        final InventoryItem item = InventoryItemImpl.of("Item1", 1.1);
        inventory.add(item);
        assertThat(inventory.get(0)).isSameAs(item);
    }

    @Test
    public void iterator() {
        inventory.setCountLimit(2);
        inventory.setWeightLimit(10.0);
        final InventoryItem item = InventoryItemImpl.of("Item1", 1.1);
        final InventoryItem item1 = InventoryItemImpl.of("Item2", 1.1);
        inventory.add(item);
        inventory.add(item1);
        assertThat(inventory).containsOnly(item, item1);
    }

    @Test
    public void removeNull() {
        assertThrows(IllegalArgumentException.class, () -> inventory.remove(null));
    }

    @Test
    public void removeNonExistent() {
        inventory.setCountLimit(2);
        inventory.setWeightLimit(10.0);
        final InventoryItem item = InventoryItemImpl.of("Item1", 1.1);
        final InventoryItem item1 = InventoryItemImpl.of("Item2", 1.1);
        inventory.add(item);
        assertThrows(IllegalArgumentException.class, () -> inventory.remove(item1));
    }

    @Test
    public void remove() {
        inventory.setCountLimit(2);
        inventory.setWeightLimit(10.0);
        final InventoryItem item = InventoryItemImpl.of("Item1", 1.1);
        final InventoryItem item1 = InventoryItemImpl.of("Item2", 1.1);
        inventory.add(item);
        inventory.add(item1);
        inventory.remove(item);
        assertThat(inventory).containsOnly(item1);
    }


}