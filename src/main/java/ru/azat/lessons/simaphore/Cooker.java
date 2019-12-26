package ru.azat.lessons.simaphore;

import java.util.stream.IntStream;

public class Cooker implements Runnable {
    private Cafe cafe;

    public Cooker(Cafe cafe) {
        this.cafe = cafe;
        new Thread(this).start();
    }

    @Override
    public void run() {

        IntStream.range(0, 10).forEach(i -> {
            System.out.println("//---------Повар готовит---------//");
            cafe.set(15);
            System.out.println("//---Повар приготовил 15 штук---//");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }
}
