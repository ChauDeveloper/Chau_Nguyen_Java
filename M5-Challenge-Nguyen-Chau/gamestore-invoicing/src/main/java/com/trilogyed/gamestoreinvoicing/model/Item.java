package com.trilogyed.gamestoreinvoicing.model;

import java.math.BigDecimal;
import java.util.Objects;

public class Item {
    private long id;
    private String model;
    private String manufacturer;
    private String memoryAmount;
    private String processor;
    private String title;
    private String esrbRating;
    private String studio;
    private String description;
    private String color;
    private String size;
    private BigDecimal price;
    private long quantity;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String getMemoryAmount() {
        return memoryAmount;
    }

    public void setMemoryAmount(String memoryAmount) {
        this.memoryAmount = memoryAmount;
    }

    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEsrbRating() {
        return esrbRating;
    }

    public void setEsrbRating(String esrbRating) {
        this.esrbRating = esrbRating;
    }

    public String getStudio() {
        return studio;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
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
        return id == item.id && quantity == item.quantity && Objects.equals(model, item.model) && Objects.equals(manufacturer, item.manufacturer) && Objects.equals(memoryAmount, item.memoryAmount) && Objects.equals(processor, item.processor) && Objects.equals(title, item.title) && Objects.equals(esrbRating, item.esrbRating) && Objects.equals(studio, item.studio) && Objects.equals(description, item.description) && Objects.equals(color, item.color) && Objects.equals(size, item.size) && Objects.equals(price, item.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, model, manufacturer, memoryAmount, processor, title, esrbRating, studio, description, color, size, price, quantity);
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", memoryAmount='" + memoryAmount + '\'' +
                ", processor='" + processor + '\'' +
                ", title='" + title + '\'' +
                ", esrbRating='" + esrbRating + '\'' +
                ", studio='" + studio + '\'' +
                ", description='" + description + '\'' +
                ", color='" + color + '\'' +
                ", size='" + size + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}
