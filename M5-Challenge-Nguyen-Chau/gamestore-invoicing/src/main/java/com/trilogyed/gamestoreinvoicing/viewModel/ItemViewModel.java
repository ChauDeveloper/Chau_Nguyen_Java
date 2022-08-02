package com.trilogyed.gamestoreinvoicing.viewModel;

import java.util.Objects;

public class ItemViewModel {
    private long id;
    private long quantity;
    private String description;
    private String model;
    private String manufacturer;
    private String title;
    private String color;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemViewModel that = (ItemViewModel) o;
        return id == that.id && quantity == that.quantity && Objects.equals(description, that.description) && Objects.equals(model, that.model) && Objects.equals(manufacturer, that.manufacturer) && Objects.equals(title, that.title) && Objects.equals(color, that.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, quantity, description, model, manufacturer, title, color);
    }

    @Override
    public String toString() {
        return "ItemViewModel{" +
                "id=" + id +
                ", quantity=" + quantity +
                ", description='" + description + '\'' +
                ", model='" + model + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", title='" + title + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
