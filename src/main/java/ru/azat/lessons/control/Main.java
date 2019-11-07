package ru.azat.lessons.control;

import java.lang.reflect.Array;

public class Main {
    public static void main(String[] args) {
        ListPolynomial polynomial1 = new ListPolynomial(1, 1, 1, 1);

        ArrayPolynomial polynomial2 = new ArrayPolynomial(1, 1, 1, 1);

        double x = 2.3;
        System.out.println("Первый полином: ");
        System.out.println(polynomial1);
        System.out.println("Второй полином: ");
        System.out.println(polynomial2);
        System.out.println("Значение при х = " + x);
        System.out.println(polynomial1.getFunctionResult(x));

        System.out.println("Сумма первого полинома и второго: ");
        System.out.println(polynomial1.sum(polynomial2));
        System.out.println("Разность первого полинома и второго: ");
        System.out.println(polynomial1.minus(polynomial2));
        System.out.println("Произведение первого полинома и второго: ");
        System.out.println(polynomial1.multiple(polynomial2));

        System.out.println("Сумма первого полинома и числа x = " + x);
        System.out.println(polynomial1.sum(x));
        System.out.println("Разность первого полинома и числа x = " + x);
        System.out.println(polynomial1.minus(x));
        System.out.println("Произведение первого полинома и числа x = " + x);
        System.out.println(polynomial1.multiple(x));
        System.out.println("Деление первого полинома и числа x = " + x);
        System.out.println(polynomial1.division(x));
    }
}
