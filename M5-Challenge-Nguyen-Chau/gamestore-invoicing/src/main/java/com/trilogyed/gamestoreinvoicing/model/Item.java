package com.trilogyed.gamestoreinvoicing.model;

import java.math.BigDecimal;
import java.util.Objects;

public class Item {
    private long id;
    private long quantity;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return id == item.id && quantity == item.quantity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, quantity);
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", quantity=" + quantity +
                '}';
    }
}
