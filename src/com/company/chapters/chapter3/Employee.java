package com.company.chapters.chapter3;

import java.util.Objects;

/**
 * Provide an interface Measurable with a method double getMeasure() that measures
 * an object in some way. Make Employee implement Measurable. Provide
 * a method average(Measurable[] objects) that computes the average
 * measure. Use it to compute the average salary of an array of employees.
 * <br/><br/>
 * Continue with the preceding exercise and provide a method Measurable
 * largest(Measurable[] objects). Use it to find the name of the employee with
 * the largest salary. Why do you need a cast?
 */
public class Employee implements Measurable {

    private String name;
    private double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    /**
     *
     * @param objects Employee or children employee
     * @return average salary
     */
    public static double average(Measurable[] objects) {
        double general = 0.0;
        for (Measurable object : objects) {
            if(object instanceof Employee) {
                general += ((Employee) object).getSalary();
            }
        }
        return general/objects.length;
    }

    /**
     *
     * @param objects Employee or children employee
     * @return Measurable with largest salary
     */
    public static Measurable largest(Measurable[] objects) {
        Measurable empWithLargestSalary = objects[0];
        for (Measurable object : objects) {
            if(object instanceof Employee) {
                empWithLargestSalary = ((Employee)empWithLargestSalary).getSalary() < ((Employee)object).getSalary() ? object : empWithLargestSalary;
            }
        }
        return empWithLargestSalary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public double getMeasure() {
        return salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Double.compare(employee.salary, salary) == 0 && name.equals(employee.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, salary);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}
