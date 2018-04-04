package com.gebarowski.tdd_inventory_item;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;


/**
 * Created by Michał Gębarowski on 31/03/2018
 */
public class InventoryItemImplTest {


    @Test
    public void create() {
        final var inventoryItem = InventoryItemImpl.of("Item1", 12.51);
        assertAll(
                () -> assertThat(inventoryItem.getName()).isEqualTo("Item1"),
                () -> assertThat(inventoryItem.getWeight()).isEqualTo(12.51)
        );
    }

    @Test
    public void createWithNullName() {
        assertThrows(IllegalArgumentException.class, () -> InventoryItemImpl.of(null, 12.51));
    }

    @Test
    public void createWithEmptyName() {
        assertThrows(IllegalArgumentException.class, () -> InventoryItemImpl.of("", 13.41));
    }

    @Test
    public void creativeWithNegativeWeight() {
        assertThrows(IllegalArgumentException.class, () -> InventoryItemImpl.of("Item2", -10.41));
    }

    @Test
    public void equalsAndHashCode() {
        EqualsVerifier.forClass(InventoryItemImpl.class).verify();
    }

    @Test
    public void stringification() {
        final var item = InventoryItemImpl.of("Item1", 12.91);
        assertThat(item.toString()).isEqualTo("Item1, 12.91");
    }
}
