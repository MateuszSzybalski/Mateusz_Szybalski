package org.vistula.customer;

import org.vistula.basket.BasketItem;

import java.util.ArrayList;
import java.util.List;

public class Customer {

    private String firstName;
    private String lastName;
    private int age;
    private List<BasketItem> basket;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<BasketItem> getBasket() {
        return basket;
    }

    public void setBasket(List<BasketItem> basket) {
        this.basket = basket;
    }

    public Customer(String firstName, String lastName, int age, List<BasketItem> basket) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.basket = basket;
    }

    public boolean isAdult() {
        return age >= 18;
    }

    public float getTotalBasketAmount() {
        if (basket == null) {
            return 0;
        }
        float totalPrice = 0;
        for (BasketItem item: basket) {
            totalPrice = totalPrice + item.getPrice();
        }
        return totalPrice;
    }

    public void addToBasket(BasketItem item) {
        if (basket == null) {
            basket = new ArrayList<>();
        }
        if (item.isAgeRestrictedItem() && !isAdult()) {
            return;
        }
        basket.add(item);
    }

    public void removeFromBasket(BasketItem item) {
        if (basket == null) {
            return;
        }
        if (item == null) {
            return;
        }
        basket.remove(item);

    }

    public void showBasket() {
        if (basket == null) {
            System.out.println(firstName + " has empty basket.");
        }
        System.out.println(firstName + " has in the basket:");
        for (BasketItem item : basket) {
            System.out.println(item.getPrice());
        }
    }

}
