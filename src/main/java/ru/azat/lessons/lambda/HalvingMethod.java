package ru.azat.lessons.lambda;

import java.util.function.Function;

public class HalvingMethod {

    public static void main(String[] args) {
        HalvingMethod halvingMethod = new HalvingMethod((x) -> 2 * x + 1, -2, 3, 0.01);
        System.out.println(halvingMethod.calculate());
    }

    private Function<Double, Double> function;
    private double start;
    private double end;
    private double delta;

    public HalvingMethod(Function<Double, Double> function, double start, double end, double delta) {
        this.function = function;
        this.start = start;
        this.end = end;
        this.delta = delta;
    }

    public double calculate() {
        while (nextStep()) {
        }
        return (end - start) / 2;
    }

    private boolean nextStep() {
        double middle = (end + start) / 2;

        if (function.apply(start) * function.apply(middle) > 0) {
            start = middle;
        } else {
            end = middle;
        }
        return ((end - start) > delta);
    }
}

