package ru.job4j.collection;

import java.util.ArrayList;

public class UsageArrayList {
    public static void main(String[] args) {
        ArrayList<String> collectionArray = new ArrayList<>();
        collectionArray.add("Petr");
        collectionArray.add("Ivan");
        collectionArray.add("Stepan");
        for (String name : collectionArray) {
            System.out.println(name);
        }
    }
}
