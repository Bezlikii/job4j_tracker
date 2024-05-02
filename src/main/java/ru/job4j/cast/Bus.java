package ru.job4j.cast;

public class Bus implements Vehicle {
    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() + " едет по дороге.");
    }

    @Override
    public void brake() {
        System.out.println(getClass().getSimpleName() + " тормозит на дороге.");
    }
}
