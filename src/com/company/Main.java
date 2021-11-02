package com.company;

public class Main {

    public static void main(String[] args) {

        System.out.println("123");

        Test test = new Test(){
            private int id = 1;
            private String name = "Ilya";


        };

        System.out.println(test);

    }
}
