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

    public double getX(double x) {
        double result = 0;
        for (int i = 0; i < coefficients.length; i++) {
            result += coefficients[i] * Math.pow(x, i);
        }
        return result;
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

    public Polynomial sum(Polynomial polynomial) {
        return elementwise(polynomial, true);
    }

    public Polynomial minus(Polynomial polynomial) {
        return elementwise(polynomial, false);
    }

    @Override
    public String toString() {
        return Arrays.toString(coefficients);
    }
}