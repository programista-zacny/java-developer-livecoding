package pl.programistazacny.javadeveloperlivecoding.cart;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

class CartTest {

    private Cart cart = new Cart();

    @BeforeEach
    public void clearCart() {
        cart = new Cart();
    }

    @Test
    void shouldCalculateTotalPrizeAfterAdding() {
        // when
        cart.addProduct(Product.BANANA, 5);
        cart.addProduct(Product.ORANGE, 3);

        // then
        assertThat(cart.totalPrize())
                .isEqualByComparingTo(new BigDecimal("21.24"));
    }

    @Test
    void shouldCalculateTotalPrizeAfterMultipleAdding() {
        // when
        cart.addProduct(Product.BANANA, 4);
        cart.addProduct(Product.BANANA, 1);
        cart.addProduct(Product.ORANGE, 2);
        cart.addProduct(Product.ORANGE, 1);

        // then
        assertThat(cart.totalPrize())
                .isEqualByComparingTo(new BigDecimal("21.24"));
    }

    @Test
    void shouldCalculateTotalPrizeAfterAddingAndRemoving() {
        // given
        cart.addProduct(Product.BANANA, 5);
        cart.addProduct(Product.ORANGE, 3);

        // when
        cart.removeProduct(Product.BANANA, 1);
        cart.removeProduct(Product.ORANGE, 1);

        // then
        assertThat(cart.totalPrize())
                .isEqualByComparingTo(new BigDecimal("16.50"));
    }

    @Test
    void shouldCalculateTotalPrizeAfterTooManyRemoving() {
        // given
        cart.addProduct(Product.BANANA, 5);
        cart.addProduct(Product.ORANGE, 3);

        // when
        cart.removeProduct(Product.BANANA, 10);
        cart.removeProduct(Product.ORANGE, 10);

        // then
        assertThat(cart.totalPrize())
                .isEqualByComparingTo(BigDecimal.ZERO);
    }

    @Test
    void shouldCalculateTotalPrizeAfterChangingQuantity() {
        // when
        cart.addOrRemoveProductQuantity(Product.BANANA, 5);
        cart.addOrRemoveProductQuantity(Product.ORANGE, 3);

        // then
        assertThat(cart.totalPrize())
                .isEqualByComparingTo(new BigDecimal("21.24"));
    }

    @Test
    void shouldCalculateTotalPrizeAfterChangingQuantity2() {
        // given
        cart.addOrRemoveProductQuantity(Product.BANANA, 5);
        cart.addOrRemoveProductQuantity(Product.ORANGE, 3);

        // when
        cart.addOrRemoveProductQuantity(Product.BANANA, -1);
        cart.addOrRemoveProductQuantity(Product.ORANGE, -1);

        // then
        assertThat(cart.totalPrize())
                .isEqualByComparingTo(new BigDecimal("16.50"));
    }

    @Test
    void shouldCalculateTotalPrizeAfterChangingQuantity3() {
        // when
        cart.addOrRemoveProductQuantity(Product.BANANA, 4);
        cart.addOrRemoveProductQuantity(Product.BANANA, 1);
        cart.addOrRemoveProductQuantity(Product.ORANGE, 2);
        cart.addOrRemoveProductQuantity(Product.ORANGE, 1);

        // then
        assertThat(cart.totalPrize())
                .isEqualByComparingTo(new BigDecimal("21.24"));
    }
}