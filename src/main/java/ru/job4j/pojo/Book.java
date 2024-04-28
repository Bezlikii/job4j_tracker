package ru.job4j.pojo;

import java.util.Objects;

public class Book {
    private String name;
    private int numbersOfPages;

    public Book(String name, int numbersOfPages) {
        this.name = name;
        this.numbersOfPages = numbersOfPages;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumbersOfPages() {
        return numbersOfPages;
    }

    public void setNumbersOfPages(int numbersOfPages) {
        this.numbersOfPages = numbersOfPages;
    }

    @SuppressWarnings("checkstyle:NeedBraces")
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return numbersOfPages == book.numbersOfPages && Objects.equals(name, book.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, numbersOfPages);
    }
}
