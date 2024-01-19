package main.java.passengers;

import java.util.concurrent.atomic.AtomicInteger;

public class Passenger {
    private static final AtomicInteger passengerCounter = new AtomicInteger(0);

    private String name;
    private String passengerNumber;
    protected double balance; // Change here: Set the balance field to protected

    public Passenger(String name) {
        this.name = name;
        this.passengerNumber = generatePassengerNumber();
    }

    public Passenger(String name, String passengerNumber) {
        this.name = name;
        validatePassengerNumber(passengerNumber);
        this.passengerNumber = passengerNumber;
    }

    public String getName() {
        return name;
    }

    public String getPassengerNumber() {
        return passengerNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setPassengerNumber(String passengerNumber) {
        validatePassengerNumber(passengerNumber);
        this.passengerNumber = passengerNumber;
    }

    private void validatePassengerNumber(String passengerNumber) {
        if (!passengerNumber.matches("PN\\d+")) {
            throw new IllegalArgumentException("Invalid passenger number format.");
        }
    }

    private String generatePassengerNumber() {
        return "PN" + passengerCounter.incrementAndGet();
    }
}
