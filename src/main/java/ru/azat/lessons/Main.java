package ru.azat.lessons;

public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph(4);
        GraphUtils.fillRandom(graph);
//        for (int i = 0; i < graph.getNodeCount(); i++){
//            graph.setLen(0, i, 0);
//        }
        GraphUtils.printGraph(graph);
        System.out.println("Граф связанный: " + GraphUtils.isConnected(graph));
        System.out.println("Граф полный: " + GraphUtils.isComplete(graph));
        Graph dlc = GraphUtils.getDlc(graph);
        GraphUtils.printGraph(dlc);
        System.out.println(graph.getDekstor(0));
        int debug = 0;
    }
}
