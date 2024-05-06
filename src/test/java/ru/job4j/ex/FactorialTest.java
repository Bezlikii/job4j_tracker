package ru.job4j.ex;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FactorialTest {

    Factorial factorial = new Factorial();

    @Test
    public void whenIsInterrupt() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> factorial.calc(-1)
        );
        assertThat(exception.getMessage()).isEqualTo("Number could not be less than 0");
    }

    @Test
    public void whenIsNotInterrupt() {
        int expected = 6;
        int result = factorial.calc(3);
        assertThat(result).isEqualTo(expected);
    }
}