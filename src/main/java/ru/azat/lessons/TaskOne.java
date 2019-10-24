package ru.azat.lessons;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TaskOne {
    public void run(){

        System.out.println("-----1-----");
        int[] array = new int[]{1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(array));
        stepArray(array);
        System.out.println(Arrays.toString(array));

        System.out.println("-----2-----");
        array = new int[]{1, 2, 3, 4, 5, 3, 2, -1, -1, 0, 1, 2};
        System.out.println(Arrays.toString(array));
        task2(array);

        System.out.println("-----3-----");
        array = new int[]{1, 2, -3, 4, 5, -1, 0, -123};
        System.out.println(Arrays.toString(array));
        sortArray(array);
        System.out.println(Arrays.toString(array));

        System.out.println("-----4-----");
        int[] first = new int[]{1, 1, 1, 1, 1, 2, 2, 3, 4, 4};
        int[] second = new int[]{1, 2, 1, 3, 4, 5, 1, 2, 5, 6, 1, 2};
        System.out.println(Arrays.toString(first));
        System.out.println(Arrays.toString(second));
        task4(first, second);

        System.out.println("-----5-----");
        array = new int[]{1, 2, 2, 3, 7, 7, 474};
        System.out.println(Arrays.toString(array));
        task5(array);

    }

    private void stepArray(int[] array){
        for(int i = array.length - 1; i > 0; i--){
            int buffer = array[i];
            array[i] = array[i - 1];
            array[i - 1] = buffer;
        }
    }

    private void sortArray(int[] array){
        int minus = 0;
        int plus = array.length - 1;

        int[] result = new int[array.length];

        for (int i = 0; i < array.length; i++){
            if (array[i] < 0){
                result[minus] = array[i];
                minus++;
            }else{
                result[plus] = array[i];
                plus--;
            }
        }

        for(int i = 0; i < array.length; i++){
            array[i] = result[i];
        }
    }

    public void task2(int[] array){
        for (int i = 0; i < array.length - 1; i++){
            if(array[i] > array[i+1]){
                System.out.println("Инверсия: " + array[i] + " и " + array[i + 1]);
            }
        }
    }

    public void task4(int[] first, int[] second){
        List<Integer> printedNums = new ArrayList<>();
        for (int i = 0; i < first.length; i ++){
            int countInFirst = 0;
            for(int j = 0; j < first.length; j++){
                if(first[i] == first[j]){
                    countInFirst++;
                }
            }

            int countInSecond = 0;
            for(int j = 0; j < second.length; j++){
                if(first[i] == second[j]){
                    countInSecond++;
                }
            }

            if(countInFirst <= countInSecond && !printedNums.contains(first[i])){
                System.out.println("Число: " + first[i]);
                printedNums.add(first[i]);
            }
        }
    }

    public void task5(int[] array){
        List<Integer> duplicatedNums = new ArrayList<>();
        for (int i = 0; i < array.length; i++){
            for( int j = 0; j < array.length; j++){
                if(i != j && array[i] == array[j] && !duplicatedNums.contains(array[i])){
                    duplicatedNums.add(array[i]);
                    break;
                }
            }
        }

        int max = duplicatedNums.get(0);
        for (int i : duplicatedNums){
            if(i > max){
                max = i;
            }
        }

        System.out.println("Max: " + max);
    }


    private static void swap(int[] array, int first, int second){
        int buff = array[first];
        array[first] = array[second];
        array[second] = buff;
    }

}
