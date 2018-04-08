package com.gebarowski.tad_inventory;

import com.gebarowski.tdd_inventory_item.InventoryItemImpl;
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
        inventory.add(InventoryItemImpl.of("Item1", 1.0));
        inventory.add(InventoryItemImpl.of("Item2", 3.0));
        inventory.setCountLimit(2);
    }

    @Test
    public void countLimitTooLow() {
        inventory.setCountLimit(3);
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
        inventory.add(InventoryItemImpl.of("Item1", 1.0));
        inventory.add(InventoryItemImpl.of("Item2", 3.0));
        inventory.setWeightLimit(4.0);
    }

    @Test
    public void weightLimitTooLow() {
        inventory.setWeightLimit(5.0);
        inventory.add(InventoryItemImpl.of("Item1", 1.0));
        inventory.add(InventoryItemImpl.of("Item2", 3.0));
        assertThrows(IllegalArgumentException.class, () -> inventory.setWeightLimit(1.0));
    }

}