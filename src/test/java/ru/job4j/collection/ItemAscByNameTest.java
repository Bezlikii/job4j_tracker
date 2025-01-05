package ru.job4j.collection;

import org.junit.Test;
import ru.job4j.tracker.Item;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ItemAscByNameTest {

    @Test
    public void whenItemAscSortByName() {
        List<Item> items = new ArrayList<>();
        Item item1 = new Item(1, "Василиса");
        Item item2 = new Item(2, "Андрей");
        Item item3 = new Item(3, "Юрий");
        items.add(item1);
        items.add(item2);
        items.add(item3);

        List<Item> expected = new ArrayList<>();
        expected.add(item2);
        expected.add(item1);
        expected.add(item3);

        Collections.sort(items, new ItemAscByName());
        assertEquals(expected, items);
    }
}