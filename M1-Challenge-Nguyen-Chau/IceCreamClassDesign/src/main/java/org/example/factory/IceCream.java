package org.example.factory;

import java.util.Objects;

public class IceCream {
    private String name;
    private String flavor;
    private String topping;
    private int sugarContentInGram;
    private int milkContentInGram;
    private int productionCost;
    private int productionTime;
    private int salePrice;
    private int totalProduct;
    boolean supplyFilled;


    public String createRecipe(String name, String flavor, String topping, int sugarContentInGram, int milkContentInGram){
        String newRecipe = "Ingredients of " + name + " ice cream: \n" +
                "Flavor: " +flavor + "\n" +
                "Topping: " + topping + "\n" +
                "Sugar: " + sugarContentInGram + "\n" +
                "Milk: " + milkContentInGram;
        System.out.println(newRecipe);
        return newRecipe;
    }

    public int calculatePricePerUnit(int a){
        this.setSalePrice(a);
        return salePrice;
    }

    public int calculateTotalProductionSalePrice(int a, int b){
        this.setSalePrice(a);
        this.setTotalProduct(b);
        return salePrice * totalProduct;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFlavor() {
        return flavor;
    }

    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }

    public String getTopping() {
        return topping;
    }

    public void setTopping(String topping) {
        this.topping = topping;
    }

    public int getSugarContentInGram() {
        return sugarContentInGram;
    }

    public void setSugarContentInGram(int sugarContentInGram) {
        this.sugarContentInGram = sugarContentInGram;
    }

    public int getMilkContentInGram() {
        return milkContentInGram;
    }

    public void setMilkContentInGram(int milkContentInGram) {
        this.milkContentInGram = milkContentInGram;
    }

    public int getProductionCost() {
        return productionCost;
    }

    public void setProductionCost(int productionCost) {
        this.productionCost = productionCost;
    }

    public int getProductionTime() {
        return productionTime;
    }

    public void setProductionTime(int productionTime) {
        this.productionTime = productionTime;
    }

    public int getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(int salePrice) {
        this.salePrice = salePrice;
    }

    public boolean isSupplyFilled() {
        return supplyFilled;
    }

    public void setSupplyFilled(boolean supplyFilled) {
        this.supplyFilled = supplyFilled;
    }
    public int getTotalProduct() {
        return totalProduct;
    }

    public void setTotalProduct(int totalProduct) {
        this.totalProduct = totalProduct;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IceCream iceCream = (IceCream) o;
        return sugarContentInGram == iceCream.sugarContentInGram && milkContentInGram == iceCream.milkContentInGram && productionCost == iceCream.productionCost && productionTime == iceCream.productionTime && salePrice == iceCream.salePrice && totalProduct == iceCream.totalProduct && supplyFilled == iceCream.supplyFilled && Objects.equals(name, iceCream.name) && Objects.equals(flavor, iceCream.flavor) && Objects.equals(topping, iceCream.topping);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, flavor, topping, sugarContentInGram, milkContentInGram, productionCost, productionTime, salePrice, totalProduct, supplyFilled);
    }

    @Override
    public String toString() {
        return "IceCream{" +
                "name='" + name + '\'' +
                ", flavor='" + flavor + '\'' +
                ", topping='" + topping + '\'' +
                ", sugarContentInGram=" + sugarContentInGram +
                ", milkContentInGram=" + milkContentInGram +
                ", productionCost=" + productionCost +
                ", productionTime=" + productionTime +
                ", salePrice=" + salePrice +
                ", totalProduct=" + totalProduct +
                ", supplyFilled=" + supplyFilled +
                '}';
    }

}
