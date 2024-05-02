package ru.job4j.polymorphism;

public interface Transport {
    void drive();

    void passengers(int numbersOfPassengers);

    int refill(int liters);
}
