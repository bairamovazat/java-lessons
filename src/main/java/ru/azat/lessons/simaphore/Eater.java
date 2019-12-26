package ru.azat.lessons.simaphore;

public class Eater implements Runnable{
    private Cafe cafe;
    private int number;

    public Eater(Cafe cafe, int number) {
        this.cafe = cafe;
        this.number = number;
        new Thread(this).start();
    }
    
    @Override
    public void run() {
        for(int j = 0; j < 3; j++) {
            System.out.println("//----" + number + " человек ждёт еду----//");

            cafe.get(5);
            System.out.println("//-----" + number + " человек поел " + j + " раз-----//");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
