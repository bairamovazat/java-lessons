package ru.azat.lessons.control;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ListPolynomial extends AbstractPolynomial {
    private List<Double> coefficients = new LinkedList<>();

    public ListPolynomial(int coefficientsCount) {
        for (int i = 0; i < coefficientsCount; i ++){
            coefficients.add(0D);
        }
    }

    public ListPolynomial(double... coefficients) {
        for (int i = 0; i < coefficients.length; i ++){
            this.coefficients.add(coefficients[i]);
        }
    }

    @Override
    public void setCoefficient(int index, Double coefficient) {
        coefficients.set(index, coefficient);
    }

    @Override
    public Double getCoefficient(int index) {
        return coefficients.get(index);
    }

    @Override
    public int getLength() {
        return this.coefficients.size();
    }

    @Override
    public AbstractPolynomial newInstance(int resultLength) {
        return new ListPolynomial();
    }

    @Override
    public String toString() {
        return coefficients.toString();
    }
}