package ru.job4j.ex;

public class FindEl {
    public static int indexOf(String[] value, String key) throws ElementNotFoundException {
        int result = -1;
        for (int i = 0; i < value.length; i++) {
            if (value[i].equals(key)) {
                result = i;
                break;
            }
        }
        if (result == -1) {
            throw new ElementNotFoundException("Такого элемента нет в массиве.");
        }
        return result;
    }

    public static void main(String[] args) {
        String[] value = new String[] {"Первый", "Второй", "3", "Четвертый"};
        try {
            FindEl.indexOf(value, "0");
        } catch (ElementNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}