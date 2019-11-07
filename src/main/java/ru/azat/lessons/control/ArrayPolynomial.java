package ru.azat.lessons.control;

import java.util.Arrays;

public class ArrayPolynomial extends AbstractPolynomial {
    private double[] coefficients;

    public ArrayPolynomial(int coefficientsCount) {
        this.coefficients = new double[coefficientsCount];
    }

    public ArrayPolynomial(double... coefficients) {
        this.coefficients = new double[coefficients.length];
        for (int i = 0; i < coefficients.length; i++) {
            setCoefficient(i, coefficients[i]);
        }
    }

    @Override
    public void setCoefficient(int index, Double coefficient) {
        coefficients[index] = coefficient;
    }

    @Override
    public Double getCoefficient(int index) {
        return coefficients[index];
    }

    @Override
    public int getLength() {
        return this.coefficients.length;
    }

    @Override
    public AbstractPolynomial newInstance(int resultLength) {
        return new ArrayPolynomial();
    }

    @Override
    public String toString() {
        return Arrays.toString(coefficients);
    }
}