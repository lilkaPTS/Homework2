package com.company.chapters.chapter2;

import java.text.DecimalFormat;
import java.util.Objects;

/**
 * Implement a class Car that models a car traveling along the x-axis, consuming
 * gas as it moves. Provide methods to drive by a given number of
 * miles, to add a given number of gallons to the gas tank, and to get the
 * current distance from the origin and fuel level. Specify the fuel efficiency
 * (in miles/gallons) in the constructor. Should this be an immutable class?
 * Why or why not? <br/>
 * I believe that this class should not be finalized, since the text of the task
 * mean changing the fields of the object.
 */
public class Car {

    private final DecimalFormat df = new DecimalFormat("0.###");

    private final double INITIAL_X;

    private double x;
    private double fuelLevel;
    private double fuelEfficiency;

    public Car(double x, double fuelLevel, double fuelEfficiency) {
        INITIAL_X = x;
        this.x = x;
        this.fuelLevel = fuelLevel;
        this.fuelEfficiency = fuelEfficiency;
        if(fuelLevel < 0) {
            throw new IllegalArgumentException("FuelLevel cannot be negative");
        }
        if(fuelEfficiency < 0) {
            throw new IllegalArgumentException("FuelEfficiency cannot be negative");
        }
    }

    /**
     *
     * @param dX distance to travel
     */
    public void move(double dX) {
        double requiredFuel = (dX/100) * fuelEfficiency;
        if(fuelLevel < requiredFuel) {
            System.out.printf("Not enough fuel, possible to drive: %s", df.format(fuelLevel/fuelEfficiency * 100));
            System.out.printf("\nYou need to add at least %s liters of fuel\n", df.format(requiredFuel-fuelLevel));
        } else {
            fuelLevel-=requiredFuel;
            x+=dX;
        }
    }

    public double getDistance() {
        return Math.abs(x - INITIAL_X);
    }

    public double getFuelLevel() {
        return fuelLevel;
    }

    /**
     *
     * @param fuelQuantity the amount of fuel to be added
     */
    public void refill(double fuelQuantity) {
        if(fuelQuantity<0){
            throw new IllegalArgumentException("The amount of fuel cannot be negative");
        }
        fuelLevel+=fuelQuantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Double.compare(car.INITIAL_X, INITIAL_X) == 0 && Double.compare(car.x, x) == 0 && Double.compare(car.fuelLevel, fuelLevel) == 0 && Double.compare(car.fuelEfficiency, fuelEfficiency) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(INITIAL_X, x, fuelLevel, fuelEfficiency);
    }

    @Override
    public String toString() {
        return "Car{" +
                "INITIAL_X=" + INITIAL_X +
                ", x=" + x +
                ", fuelLevel=" + fuelLevel +
                ", fuelEfficiency=" + fuelEfficiency +
                '}';
    }
}
