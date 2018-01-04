package org.vistula.basket;

public class PromoItem extends BasketItem {

    private int discount;

    public PromoItem(float price, boolean ageRestrictedItem) {
        super(price, ageRestrictedItem);
    }

    @Override
    public float getPrice() {
        return super.getPrice() - (super.getPrice() * discount) / 100;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }
}
