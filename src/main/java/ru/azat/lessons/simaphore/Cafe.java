package ru.azat.lessons.simaphore;

import java.util.concurrent.Semaphore;
import java.util.stream.IntStream;

public class Cafe {
    private Semaphore semaphore;

    public Cafe(int maxSize) {
        this.semaphore = new Semaphore(maxSize);
    }

    public int get(int size) {
        try {
            semaphore.acquire(size);
        } catch (InterruptedException e) {
            throw new IllegalArgumentException(e);
        }
        return size;
    }

    public void set(int size) {
        semaphore.release(size);
    }

    public static void main(String[] args) {
        final Cafe cafe = new Cafe(0);
        //Повар
        Cooker cooker = new Cooker(cafe);

        for (int i = 0; i < 10; i ++) {
            int finalI = i;
            new Thread(() -> {
              Eater eater = new Eater(cafe, finalI);
            }).start();
        }


    }
}
