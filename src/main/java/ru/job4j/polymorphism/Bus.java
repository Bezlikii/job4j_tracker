package ru.job4j.polymorphism;

public class Bus implements Transport {

    private final static int PRICE_OF_REFILL = 45;

    @Override
    public void drive() {
        System.out.println("Автобус поехал");
    }

    @Override
    public void passengers(int numbersOfPassengers) {
        System.out.println("В автобусе " + numbersOfPassengers + " пассажиров.");
    }

    @Override
    public int refill(int liters) {
        return PRICE_OF_REFILL * liters;
    }
}
