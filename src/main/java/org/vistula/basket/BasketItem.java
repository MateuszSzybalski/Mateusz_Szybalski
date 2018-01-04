package org.vistula.basket;

public class BasketItem {

    private float price;
    boolean ageRestrictedItem;

    public BasketItem(float price, boolean ageRestrictedItem) {
        this.price = price;
        this.ageRestrictedItem = ageRestrictedItem;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public boolean isAgeRestrictedItem() {
        return ageRestrictedItem;
    }

    public void setAgeRestrictedItem(boolean ageRestrictedItem) {
        this.ageRestrictedItem = ageRestrictedItem;
    }
}
