package ru.azat.lessons.control;

public class Main {
    public static void main(String[] args) {
        Polynomial polynomial1 = new Polynomial(1, 1, 1, 1);

        Polynomial polynomial2 = new Polynomial(1, 1, 1, 1);
        System.out.println(polynomial1.getFunctionResult(1));
        System.out.println(polynomial1.sum(polynomial2));
        System.out.println(polynomial1.minus(polynomial2));
        System.out.println(polynomial1.multiple(polynomial2));
    }
}
