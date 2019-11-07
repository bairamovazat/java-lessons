package ru.azat.lessons.control;

import java.util.Iterator;

public class PolynomialIterator implements Iterator<Double> {
    private AbstractPolynomial abstractPolynomial;
    private int currentIndex = -1;

    public PolynomialIterator(AbstractPolynomial abstractPolynomial){
        this.abstractPolynomial = abstractPolynomial;
    }

    @Override
    public boolean hasNext() {
        return currentIndex < abstractPolynomial.getLength() - 1;
    }

    @Override
    public Double next() {
        return abstractPolynomial.getCoefficient(++currentIndex);
    }
}
