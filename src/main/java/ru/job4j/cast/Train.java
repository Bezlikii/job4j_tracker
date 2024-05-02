package ru.job4j.cast;

public class Train implements Vehicle {
    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() + " едет по рельсам.");
    }

    @Override
    public void brake() {
        System.out.println(getClass().getSimpleName() + " тормозит на рельсах.");
    }
}
