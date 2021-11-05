package com.company;

import com.company.chapters.chapter1.Chapter1;
import com.company.chapters.chapter2.Car;
import com.company.chapters.chapter2.Point;
import com.company.enums.Exercises;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Arrays.asList(Exercises.values()).forEach(ex -> System.out.println((ex.ordinal()+1) + ") " + ex.name()));
        while (true) {
            System.out.println("Enter a number from 1 to " + (Exercises.values().length));
            if (in.hasNextInt()) {
                int item = in.nextInt();
                if(item > 0 && item <= Exercises.values().length) {
                    switch (Exercises.values()[item-1]) {
                        case CHAPTER_1_EX1:
                            Chapter1.numberTranslator();
                            break;
                        case CHAPTER_1_EX2:
                            Chapter1.injectionChecker();
                            break;
                        case CHAPTER_1_EX3:
                            Chapter1.maxNumOfThree();
                            break;
                        case CHAPTER_1_EX4:
                            Chapter1.printSmallestAndLargestPositiveDoubleValues();
                            break;
                        case CHAPTER_1_EX6:
                            System.out.println(Chapter1.bigIntegerFactorial(1000));
                            break;
                        case CHAPTER_1_EX13:
                            Chapter1.printLotteryCombination();
                            break;
                        case CHAPTER_2_EX5:
                            Point point = new Point(3,4).translate(1,3).scale(0.5);
                            System.out.println(point);
                            break;
                        case CHAPTER_2_EX9:
                            Car car = new Car(10,5,11.4);
                            car.move(100);
                            System.out.println(car.getDistance() + " " + car.getFuelLevel());
                            car.refill(6.4);
                            System.out.println(car.getDistance() + " " + car.getFuelLevel());
                            car.move(100);
                            System.out.println(car.getDistance() + " " + car.getFuelLevel());
                            break;
                    }
                    break;
                }
            }
            in.nextLine();
        }
    }
}
