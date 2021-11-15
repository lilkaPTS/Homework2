package com.company;

import com.company.chapters.chapter1.Chapter1;
import com.company.chapters.chapter2.Car;
import com.company.chapters.chapter2.Point;
import com.company.chapters.chapter3.Employee;
import com.company.chapters.chapter3.Measurable;
import com.company.chapters.chapter4.Circle;
import com.company.chapters.chapter4.Line;
import com.company.chapters.chapter4.Rectangle;
import com.company.chapters.chapter4.Shape;
import com.company.enums.Exercises;

import java.math.BigInteger;
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
                            System.out.println("Factorial version 1:");
                            System.out.println("0! = " + Chapter1.bigIntegerFactorial(0));
                            System.out.println("1! = " + Chapter1.bigIntegerFactorial(1));
                            System.out.println("1000! = " + Chapter1.bigIntegerFactorial(1000));
                            System.out.println("Factorial version 2:");
                            System.out.println("0! = " + Chapter1.bigIntegerFactorialV2(BigInteger.valueOf(0)));
                            System.out.println("1! = " + Chapter1.bigIntegerFactorialV2(BigInteger.valueOf(1)));
                            System.out.println("1000! = " + Chapter1.bigIntegerFactorialV2(BigInteger.valueOf(1000)));
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
                        case CHAPTER_3_EX1_AND_EX2:
                            Employee emp1 = new Employee("Ilya", 333333);
                            Employee emp2 = new Employee("Vasya", 222222);
                            Employee emp3 = new Employee("Petya", 411111);
                            Measurable[] arr = new Measurable[]{emp1, emp2, emp3};
                            Arrays.asList(emp1, emp2, emp3).forEach(System.out::println);
                            System.out.println("Average salary: " + Employee.average(arr) + "\nEmployee with largest salary: " + Employee.largest(arr));
                            break;
                        case CHAPTER_4_EX4_AND_EX5:
                            Circle circle = new Circle(new Point(1,2), 5);
                            Rectangle rectangle = new Rectangle(new Point(2,1),2,3);
                            Line line = new Line(new Point(0,3), new Point(3,0));
                            System.out.println(circle + " - " + circle.getCenter());
                            System.out.println(rectangle + " - " + rectangle.getCenter());
                            System.out.println(line + " - " + line.getCenter());
                            break;
                    }
                    break;
                }
            }
            in.nextLine();
        }
    }
}
