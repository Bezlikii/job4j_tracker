package ru.job4j.tracker.input;

import org.junit.jupiter.api.Test;
import ru.job4j.tracker.output.Output;
import ru.job4j.tracker.output.StubOutput;

import static org.assertj.core.api.Assertions.assertThat;

class ValidateInputTest {

    @Test
    void whenInvalidInput() {
        Output output = new StubOutput();
        Input in = new MockInput(
                new String[] {"one", "1"}
        );
        ValidateInput input = new ValidateInput(output, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(1);
    }

    @Test
    void whenValidInput() {
        Output output = new StubOutput();
        Input in = new MockInput(
                new String[] {"5"}
        );
        ValidateInput input = new ValidateInput(output, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(5);
    }

    @Test
    void whenManyValidInput() {
        Output output = new StubOutput();
        Input in = new MockInput(
                new String[] {"3", "4", "2"}
        );
        ValidateInput input = new ValidateInput(output, in);
        int[] expected = {3, 4, 2};

        int selected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(expected[0]);

        int selected2 = input.askInt("Enter menu:");
        assertThat(selected2).isEqualTo(expected[1]);

        int selected3 = input.askInt("Enter menu:");
        assertThat(selected3).isEqualTo(expected[2]);
    }

    @Test
    void whenNegativeNumber() {
        Output output = new StubOutput();
        Input in = new MockInput(
                new String[] {"-1"}
        );
        ValidateInput input = new ValidateInput(output, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(-1);
    }
}