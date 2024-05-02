package ru.job4j.cast;

public class Airplane implements Vehicle {
    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() + " летит по воздуху.");
    }

    @Override
    public void brake() {
        System.out.println(getClass().getSimpleName() + " снижает скорость в воздухе.");
    }
}
