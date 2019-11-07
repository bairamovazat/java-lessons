package ru.azat.lessons.control;

import java.util.Iterator;

public abstract class AbstractPolynomial implements Polynomial<Double> {

    public abstract void setCoefficient(int index, Double coefficient);

    public abstract Double getCoefficient(int index);

    public abstract int getLength();

    @Override
    public Double getFunctionResult(Double x) {
        double result = 0;
        for (int i = 0; i < getLength(); i++) {
            result += getCoefficient(i) * Math.pow(x, i);
        }
        return result;
    }

    @Override
    public int getLastIndex() {
        int lastCoeff = 0;
        for (int i = 0; i < getLength(); i++) {
            if (getCoefficient(i) != 0) {
                lastCoeff = i;
            }
        }
        return lastCoeff;
    }

    @Override
    public abstract AbstractPolynomial newInstance(int resultLength);

    //Делает поэлементно оперицию
    private Polynomial<Double> elementwise(Polynomial<Double> polynomial, boolean isSum) {
        int resultLength = Math.max(polynomial.getLength(), this.getLength());
        AbstractPolynomial result = newInstance(resultLength);

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
    private AbstractPolynomial elementwise(Double number, boolean isSum) {
        AbstractPolynomial result = newInstance(getLength());

        for (int i = 0; i < getLength(); i++) {
            double newValue = isSum ?
                    this.getCoefficient(i) + number :
                    this.getCoefficient(i) - number;
            result.setCoefficient(i, newValue);
        }
        return result;
    }


    @Override
    public Polynomial<Double> sum(Polynomial<Double> polynomial) {
        return elementwise(polynomial, true);
    }

    @Override
    public Polynomial<Double> minus(Polynomial<Double> polynomial) {
        return elementwise(polynomial, false);
    }

    @Override
    public Polynomial<Double> sum(Double number) {
        return elementwise(number, true);
    }

    @Override
    public Polynomial<Double> minus(Double number) {
        return elementwise(number, false);
    }

    @Override
    public Polynomial<Double> multiple(Polynomial<Double> polynomial) {
        AbstractPolynomial result = newInstance(polynomial.getLastIndex() + 1 + this.getLastIndex());
        double previousValue;
        for (int i = 0; i <= this.getLastIndex(); i++) {
            for (int j = 0; j <= polynomial.getLastIndex(); j++) {
                previousValue = result.getCoefficient(i + j);
                result.setCoefficient(i + j,
                        previousValue + polynomial.getCoefficient(j) * this.getCoefficient(i));
            }
        }
        return result;
    }

    @Override
    public Polynomial<Double> multiple(Double number) {
        AbstractPolynomial result = newInstance(getLength());
        for (int i = 0; i <= this.getLastIndex(); i++) {
            result.setCoefficient(i, this.getCoefficient(i) * number);
        }
        return result;
    }

    @Override
    public Polynomial<Double> division(Double number) {
        AbstractPolynomial result = newInstance(getLength());
        for (int i = 0; i <= this.getLastIndex(); i++) {
            result.setCoefficient(i, this.getCoefficient(i) / number);
        }
        return result;
    }

    @Override
    public Iterator<Double> iterator() {
        return new PolynomialIterator(this);
    }
}
