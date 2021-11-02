package com.company;

import com.company.chapters.Chapter1;
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
                    }
                    break;
                }
            }
            in.nextLine();
        }
    }
}
