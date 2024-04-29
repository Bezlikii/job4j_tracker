package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book book1 = new Book("Рисуем опыт для прохождения собеседований", 50);
        Book book2 = new Book("Clean code", 760);
        Book book3 = new Book("Философия Java", 840);
        Book book4 = new Book("Грокаем алгоритмы", 350);

        Book[] listOfBooks = {book1, book2, book3, book4};
        for (int i = 0; i < listOfBooks.length; i++) {
            Book book = listOfBooks[i];
            System.out.println("Книга: " + book.getName() + ", Страниц: " + book.getNumbersOfPages());
        }

        System.out.println(System.lineSeparator() + "Замена книги с индексом 0 на 3.");
        Book temp = listOfBooks[0];
        listOfBooks[0] = listOfBooks[3];
        listOfBooks[3] = temp;
        System.out.println("Книга под индексом 0: " + listOfBooks[0].getName());
        System.out.println("Книга под индексом 3: " + listOfBooks[3].getName());

        for (Book book : listOfBooks) {
            if ("Clean code".equals(book.getName())) {
                System.out.println(System.lineSeparator() + "Книга нашлась: " + book.getName() + ", Страниц: " + book.getNumbersOfPages());
            }
        }

    }
}
