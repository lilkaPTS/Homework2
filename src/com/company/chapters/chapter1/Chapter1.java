package com.company.chapters.chapter1;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;

public class Chapter1 {

    /**
     Write a program that reads an integer and prints it in binary, octal, and hexadecimal.
     Print the reciprocal as a hexadecimal floating-point number.
     */
    public static void numberTranslator() {
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.println("Enter an integer");
            if(in.hasNextInt()) {
                int number = in.nextInt();
                System.out.println(number + " to binary -> " + Integer.toBinaryString(number));
                System.out.println(number + " to octal -> " + Integer.toOctalString(number));
                System.out.println(number + " to hexadecimal -> " + Integer.toHexString(number));
                System.out.println(number + " the reciprocal as a hexadecimal floating-point number -> " + Double.toHexString(1.0/number));
                break;
            }
            in.nextLine();
        }
        in.close();
    }

    /**
     * Write a program that reads an integer angle (which may be positive or
     * negative) and normalizes it to a value between 0 and 359 degrees. Try
     * it first with the % operator, then with floorMod.
     */
    public static void injectionChecker(){
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.println("Enter an integer angle");
            if(in.hasNextInt()) {
                int angleValue = in.nextInt();

                if (angleValue >= 0) {
                    System.out.println(angleValue + " % 359 = " + angleValue % 359);
                } else {
                    int multiplier = (Math.abs(angleValue) / 359) + 1; //расширяет диапозон от -359 - +infinity (2147483647) -> -infinity (-2147483648) - + infinity
                    System.out.println(angleValue + " % 359 = " + (angleValue + (359*multiplier)) % 359);
                }

                System.out.println("Math.floorMod(" + angleValue + ", 359) = " + Math.floorMod(angleValue, 359));
                break;
            }
            in.nextLine();
        }
        in.close();
    }

    /**
     * Using only the conditional operator, write a program that reads three
     * integers and prints the largest. Repeat with Math.max.
     */
    public static void maxNumOfThree() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter three integer number");
        int[] threeNum = new int[3];
        for (int i = 0; i < threeNum.length; i++) {
            while (true) {
                System.out.print(i+1 + " - ");
                if(in.hasNextInt()){
                    threeNum[i] = in.nextInt();
                    break;
                }
                in.nextLine();
            }
            in.nextLine();
        }
        System.out.println(Math.max(Math.max(threeNum[0],threeNum[1]), threeNum[2]));
        in.close();
    }

    /**
     * Write a program that prints the smallest and largest positive double values.
     * Hint: Look up Math.nextUp in the Java API.
     */
    public static void printSmallestAndLargestPositiveDoubleValues() {
        System.out.println(Math.nextUp(Double.MIN_VALUE));
        System.out.println(Math.nextUp(Double.MAX_VALUE));
    }

    /**
     * Write a program that computes the factorial n! = 1 × 2 × . . . × n, using
     * BigInteger. Compute the factorial of 1000.
     */
    public static BigInteger bigIntegerFactorial(int num) {
        if(num < 0) {
            throw new IllegalArgumentException("The number must be positive");
        }
        BigInteger output = BigInteger.valueOf(1);
        for (int i = 2; i <= num; i++){
            output = output.multiply(BigInteger.valueOf(i));
        }
        return output;
    }

    public static BigInteger bigIntegerFactorialV2(BigInteger num) {
        if(num.intValue() < 0) {
            throw new IllegalArgumentException("The number must be positive");
        }
        if(num.intValue() == 0 || num.intValue() == 1){
            return BigInteger.ONE;
        } else {
            return num.multiply(bigIntegerFactorialV2(num.subtract(BigInteger.ONE)));
        }
    }

    /**
     * Write a program that prints a lottery combination, picking six distinct
     * numbers between 1 and 49. To pick six distinct numbers, start with an
     * array list filled with 1...49. Pick a random index and remove the element.
     * Repeat six times. Print the result in sorted order.
     */
    public static void printLotteryCombination() {
        String lotteryCombination = "";
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 1; i <= 49; i++) {
            arrayList.add(i);
        }
        for (int i = 0; i < 6; i++) {
            int deleteIndex = (int)(Math.random() * arrayList.size());
            lotteryCombination += arrayList.get(deleteIndex) + " ";
            arrayList.remove(deleteIndex);
        }
        System.out.println(lotteryCombination);
    }
}
