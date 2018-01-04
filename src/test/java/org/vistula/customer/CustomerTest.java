package org.vistula.customer;

import org.junit.Assert;
import org.junit.Test;
import org.vistula.basket.BasketItem;
import org.vistula.basket.PromoItem;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CustomerTest {

    @Test
    public void customerIsAdult() {
        Customer mateusz = new Customer("Mateusz", "Szybalski", 28, null);
        Assert.assertTrue(mateusz.isAdult());
    }

    @Test
    public void customerGetTotalBasketAmount() {
        BasketItem smartfon = new BasketItem(2000, false);
        BasketItem alkohol = new BasketItem(30, true);
        List<BasketItem> basket = new ArrayList<>();
        basket.add(smartfon);
        basket.add(alkohol);
        Customer mateusz = new Customer("Mateusz", "Szybalski", 28, basket);
        assertThat(mateusz.getTotalBasketAmount()).isEqualTo(2030);
        Customer jan = new Customer("Jan", "Kowalski", 40, null);
        assertThat(jan.getTotalBasketAmount()).isEqualTo(0);
    }

    @Test
    public void customerAddItemToBasket() {
        BasketItem alkohol = new BasketItem(30, true);
        BasketItem smartfon = new BasketItem(2000, false);
        Customer mateusz = new Customer("Mateusz", "Szybalski", 28, null);
        mateusz.addToBasket(alkohol);
        mateusz.addToBasket(smartfon);
        assertThat(mateusz.getTotalBasketAmount()).isEqualTo(2030);
        assertThat(mateusz.getBasket().size()).isEqualTo(2);
        mateusz.showBasket();
        Customer janusz = new Customer("Janusz", "Cebulak", 17, null);
        janusz.addToBasket(alkohol);
        janusz.addToBasket(smartfon);
        assertThat(janusz.getTotalBasketAmount()).isEqualTo(2000);
        assertThat(janusz.getBasket().size()).isEqualTo(1);
        janusz.showBasket();
    }

    @Test
    public void customerRemoveItemFromBasket() {
        BasketItem alkohol = new BasketItem(30, true);
        BasketItem smartfon = new BasketItem(2000, false);
        Customer mateusz = new Customer("Mateusz", "Szybalski", 28, null);
        mateusz.addToBasket(alkohol);
        mateusz.addToBasket(smartfon);
        assertThat(mateusz.getTotalBasketAmount()).isEqualTo(2030);
        assertThat(mateusz.getBasket().size()).isEqualTo(2);
        mateusz.showBasket();
        mateusz.removeFromBasket(alkohol);
        assertThat(mateusz.getTotalBasketAmount()).isEqualTo(2000);
        assertThat(mateusz.getBasket().size()).isEqualTo(1);
        mateusz.showBasket();
    }

    @Test
    public void customerAddToBasketPromoItem() {
        PromoItem alkohol = new PromoItem(30, true);
        alkohol.setDiscount(10);
        PromoItem smartfon = new PromoItem(2000, false);
        smartfon.setDiscount(5);
        Customer mateusz = new Customer("Mateusz", "Szybalski", 28, null);
        mateusz.addToBasket(alkohol);
        mateusz.addToBasket(smartfon);
        assertThat(mateusz.getTotalBasketAmount()).isEqualTo(1927);
        assertThat(mateusz.getBasket().size()).isEqualTo(2);
        assertThat(mateusz.getBasket().get(0).getPrice()).isEqualTo(27);
        assertThat(mateusz.getBasket().get(1).getPrice()).isEqualTo(1900);
        mateusz.showBasket();
    }

}
