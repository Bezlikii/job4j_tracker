package ru.job4j.collection;

import java.util.Comparator;

public class LexSort implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        String[] partsString = left.split("\\.");
        int number  = Integer.parseInt(partsString[0]);

        String[] partsString2 = right.split("\\.");
        int number2 = Integer.parseInt(partsString2[0]);

        return Integer.compare(number, number2);

    }
}