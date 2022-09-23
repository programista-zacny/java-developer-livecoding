package pl.programistazacny.javadeveloperlivecoding.cart;

import java.math.BigDecimal;
import java.util.EnumMap;
import java.util.Map;

/**
 * Goal of the exercise is to build a simple shopping cart. You should be able to:
 * - add and remove products from the cart in a given quantity - for example, as a user of the cart,
 * I want to be able to add N items of product A and then remove M items of product B
 * - calculate the total price of the cart
 * <p>
 * Key assumptions:
 * - products are priced independently (each product has its price defined)
 * - each product has its unique identifier
 * - a cart can have different amounts of different products (I can have 2 apples, 3 bananas, etc.)
 * - we are interested only in a domain model (no REST, DB, repositories, etc.), everything can happen in memory
 */
public class Cart {

    private final Map<Product, Integer> items = new EnumMap<>(Product.class);

    public void addProduct(Product product, Integer quantityToAdd) {
        items.compute(product, (key, value) -> {
            if (value == null) {
                return quantityToAdd;
            } else {
                return quantityToAdd + value;
            }
        });
    }

    public void removeProduct(Product product, Integer quantityToRemove) {
        items.computeIfPresent(product, (key, value) -> {
            if (value - quantityToRemove < 0) {
                return null;
            } else {
                return value - quantityToRemove;
            }
        });
    }

    public void addOrRemoveProductQuantity(Product product, Integer quantity) {
        items.compute(product, (key, value) -> {
            if (value == null) {
                return quantity > 0 ? quantity : null;
            } else {
                return value + quantity <= 0 ? null : value + quantity;
            }
        });
    }

    public BigDecimal totalPrize() {
        return items.entrySet().stream()
                .map(entry -> entry.getKey().getPrize().multiply(new BigDecimal(entry.getValue())))
                .reduce(BigDecimal::add)
                .orElse(BigDecimal.ZERO);
    }
}
