package ru.azat.lessons;

import java.util.Random;

public class GraphUtils {

    //Является ли связанным
    public static boolean isConnected(Graph graph){
        for (int i = 0; i < graph.getLenMap().length; i++){
            for (int j = 0; j < graph.getLenMap()[i].length; j++){
                if(!graph.canGo(i, j)){
                    return false;
                }
            }
        }
        return true;
    }

    //Является ли полным
    public static boolean isComplete(Graph graph){
        for (int i = 0; i < graph.getLenMap().length; i++){
            for (int j = 0; j < graph.getLenMap()[i].length; j++){
                if (i != j && graph.getLenMap()[i][j] == 0){
                    return false;
                }
            }
        }
        return true;
    }

    //Получить дополнение
    public static Graph getDlc(Graph graph){
        Graph dlc = new Graph(graph.getNodeCount());
        for (int i = 0; i < graph.getLenMap().length; i++){
            for (int j = 0; j < graph.getLenMap()[i].length; j++){
                if(i != j && graph.getLenMap()[i][j] == 0){
                    dlc.setLen(i, j, 1);
                }
            }
        }
        return dlc;
    }





    public static void printGraph(Graph graph){
        for (int i = 0; i < graph.getLenMap().length; i++){
            for (int j = 0; j < graph.getLenMap()[i].length; j++){
                System.out.print(graph.getLenMap()[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static Graph fillRandom(Graph graph) {
        int[][] lenMap = graph.getLenMap();

        Random random = new Random();

        for (int i = 0; i < graph.getNodeCount(); i++) {
            for (int j = 0; j < graph.getNodeCount(); j++) {
                if (i != j) {
                    int value = random.nextInt(10);
                    graph.setLen(i, j, value);
                    graph.setLen(j, i, value);
                }
            }
        }

        return graph;
    }
}
