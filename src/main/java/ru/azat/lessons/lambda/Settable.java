package ru.azat.lessons.lambda;

interface Settable<T> extends SetNameAge {
    void set(T t, String name, int a);
}