package ru.job4j.collection;

import java.util.HashMap;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("lesha@mail.com", "Aleksei Pishechkin");
        map.put("expest@mail.com", "Valerii Lebedev");
        map.put("lesha@mail.com", "Aleksei Pishechkin Vasilevich");

        for (String key : map.keySet()) {
            String value = map.get(key);
            System.out.println(key + " = " + value);
        }
    }
}
