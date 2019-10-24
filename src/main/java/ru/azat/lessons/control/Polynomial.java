package ru.azat.lessons.control;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Polynomial {
    private double[] coefficients;

    public Polynomial(int coefficientsCount) {
        this.coefficients = new double[coefficientsCount];
    }

    public Polynomial(double... coefficients) {
        this.coefficients = new double[coefficients.length];
        for (int i = 0; i < coefficients.length; i++) {
            setCoefficient(i, coefficients[i]);
        }
    }

    public void setCoefficient(int index, double coefficient) {
        coefficients[index] = coefficient;
    }

    public double getCoefficient(int index) {
        return coefficients[index];
    }

    public int getLength() {
        return this.coefficients.length;
    }

    public double getFunctionResult(double x) {
        double result = 0;
        for (int i = 0; i < coefficients.length; i++) {
            result += coefficients[i] * Math.pow(x, i);
        }
        return result;
    }

    public int getLastIndex() {
        int lastCoeff = coefficients.length;
        for (int i = 0; i < coefficients.length; i++) {
            if (getCoefficient(i) != 0) {
                lastCoeff = i;
            }
        }
        return lastCoeff;
    }

    //Делает поэлементно оперицию
    private Polynomial elementwise(Polynomial polynomial, boolean isSum) {
        int resultLength = Math.max(polynomial.getLength(), this.getLength());
        Polynomial result = new Polynomial(resultLength);

        for (int i = 0; i < Math.max(polynomial.getLength(), this.getLength()); i++) {
            if (polynomial.getLength() > i && this.getLength() > i) {
                double newValue = isSum ?
                        polynomial.getCoefficient(i) + this.getCoefficient(i) :
                        polynomial.getCoefficient(i) - this.getCoefficient(i);
                result.setCoefficient(i, newValue);

            } else if (polynomial.getLength() > i) {
                result.setCoefficient(i, isSum ?
                        polynomial.getCoefficient(i) :
                        polynomial.getCoefficient(i) * -1
                );

            } else if (this.getLength() > i) {
                result.setCoefficient(i, this.getCoefficient(i));
            }
        }
        return result;
    }

    //Делает поэлементно оперицию
    private Polynomial elementwise(double number, boolean isSum) {
        Polynomial result = new Polynomial(getLength());

        for (int i = 0; i < getLength(); i++) {
                double newValue = isSum ?
                        this.getCoefficient(i) + this.getCoefficient(i) :
                        this.getCoefficient(i) - this.getCoefficient(i);
                result.setCoefficient(i, newValue);
        }
        return result;
    }


    public Polynomial sum(Polynomial polynomial) {
        return elementwise(polynomial, true);
    }

    public Polynomial minus(Polynomial polynomial) {
        return elementwise(polynomial, false);
    }

    public Polynomial sum(double number) {
        return elementwise(number, true);
    }

    public Polynomial minus(double number) {
        return elementwise(number, false);
    }

    public Polynomial multiple(Polynomial polynomial){
        Polynomial result = new Polynomial(polynomial.getLastIndex() + 1 + this.getLastIndex());
        double previousValue;
        for (int i = 0; i <= this.getLastIndex(); i++){
            for (int j = 0; j <= polynomial.getLastIndex(); j++){
                previousValue = result.getCoefficient(i + j);
                result.setCoefficient(i + j,
                        previousValue + polynomial.getCoefficient(j) * this.getCoefficient(i));
            }
        }
        return result;
    }

    @Override
    public String toString() {
        return Arrays.toString(coefficients);
    }
}