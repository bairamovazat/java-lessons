package ru.azat.lessons.control;

import java.util.Iterator;

public interface Polynomial <T extends Number> extends Iterable<T> {

    void setCoefficient(int index, T coefficient);

    T getCoefficient(int index);

    int getLength();

    T getFunctionResult(T x);

    int getLastIndex();

    Polynomial<T> newInstance(int resultLength);

    Polynomial<T> sum(Polynomial<T> polynomial) ;

    Polynomial<T> minus(Polynomial<T> polynomial);

    Polynomial<T> sum(T number);

    Polynomial<T> minus(T number);

    Polynomial<T> multiple(Polynomial<T> polynomial);

    Polynomial<T> multiple(T number);

    Polynomial<T> division(T number);

    @Override
    Iterator<T> iterator();
}
