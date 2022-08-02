package com.trilogyed.gamestorecatalog.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Objects;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "feign_model")
public class FeignModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id")
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
        FeignModel that = (FeignModel) o;
        return id == that.id && quantity == that.quantity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, quantity);
    }

    @Override
    public String toString() {
        return "ConsoleFeign{" +
                "id=" + id +
                ", quantity=" + quantity +
                '}';
    }
}
