package org.example.pointofsale;

import java.util.Objects;

public class IceCream {
    private int price;
    private int scoopPrice;
    private int quantityScoop;
    private int orderQuantity;
    boolean cup;
    boolean cone;
    private int customers;
    private int orderNumber;

    public IceCream(){}
    public IceCream(int scoopPrice, int quantityScoop, int orderQuantity, boolean cup, boolean cone, int customers, int orderNumber) {
        this.scoopPrice = scoopPrice;
        this.quantityScoop = quantityScoop;
        this.orderQuantity = orderQuantity;
        this.cup = cup;
        this.cone = cone;
        this.customers = customers;
        this.orderNumber = orderNumber;
    }

    //customers have to choose either cup or cone
    // extra $1 if order ice cream with cone
    public int conePrice() {
        if (cone == true) {
            return 1;
        }
        return 0;
    }

    // no extra money if order ice cream with cup
    public int cupPrice() {
        if (cup == true) {
            return 0;
        }
        return conePrice();
    }

    public int calculateOrderPrice() {
        return (scoopPrice * quantityScoop + conePrice()) * orderQuantity;
    }

    //I understand this is not the right formula to calculate total earning per day in actual life.
    public int totalEarning() {
        return calculateOrderPrice() * customers;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getScoopPrice() {
        return scoopPrice;
    }

    public void setScoopPrice(int scoopPrice) {
        this.scoopPrice = scoopPrice;
    }

    public int getQuantityScoop() {
        return quantityScoop;
    }

    public void setQuantityScoop(int quantityScoop) {
        this.quantityScoop = quantityScoop;
    }

    public int getOrderQuantity() {
        return orderQuantity;
    }

    public void setOrderQuantity(int orderQuantity) {
        this.orderQuantity = orderQuantity;
    }

    public boolean isCup(boolean b) {
        return cup;
    }

    public void setCup(boolean cup) {
        this.cup = cup;
    }

    public boolean isCone() {
        return cone;
    }

    public void setCone(boolean cone) {
        this.cone = cone;
    }

    public int getCustomers() {
        return customers;
    }

    public void setCustomers(int customers) {
        this.customers = customers;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IceCream iceCream = (IceCream) o;
        return price == iceCream.price && scoopPrice == iceCream.scoopPrice && quantityScoop == iceCream.quantityScoop && orderQuantity == iceCream.orderQuantity && cup == iceCream.cup && cone == iceCream.cone && customers == iceCream.customers && orderNumber == iceCream.orderNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(price, scoopPrice, quantityScoop, orderQuantity, cup, cone, customers, orderNumber);
    }

    @Override
    public String toString() {
        return "IceCream{" +
                "price=" + price +
                ", scoopPrice=" + scoopPrice +
                ", quantityScoop=" + quantityScoop +
                ", orderQuantity=" + orderQuantity +
                ", cup=" + cup +
                ", cone=" + cone +
                ", customers=" + customers +
                ", orderNumber=" + orderNumber +
                '}';
    }

    public void isCone(boolean b) {
    }
}