package com.gebarowski.tad_inventory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
    }

    @Test
    public void setZeroCountLimit() {
        inventory.setCountLimit(0);
    }

    @Test
    public void setNegativeCountLimit() {
        inventory.setCountLimit(-9);
    }
}