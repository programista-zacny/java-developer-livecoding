package pl.programistazacny.javadeveloperlivecoding.cart;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;

@RequiredArgsConstructor
@Getter
public enum Product {
    BANANA(new BigDecimal("3.51")),
    ORANGE(new BigDecimal("1.23"));

    private final BigDecimal prize;
}
