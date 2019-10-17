package ru.azat.lessons;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Graph {
    private int[][] lenMap;

    public Graph(int nodeCount) {
        lenMap = new int[nodeCount][nodeCount];
    }

    public Graph(int[][] lenMap) {
        if (lenMap.length != lenMap[0].length) {
            throw new IllegalArgumentException("Карта данных должна быть квадратной");
        }
        this.lenMap = lenMap;
    }


    public void setLen(int startNode, int endNode, int value) {
        lenMap[startNode][endNode] = value;
    }

    public int getNodeCount() {
        return lenMap.length;
    }

    public int[][] getLenMap() {
        return lenMap;
    }

    public boolean canGo(int start, int end) {
        List<Integer> visitedNodes = new ArrayList<Integer>();
        return canGo(start, end, visitedNodes);
    }


    private boolean canGo(int start, int end, List<Integer> visitedNodes) {
        if (start == end) {
            return true;
        }
        visitedNodes.add(start);

        List<Integer> nextNodes = new ArrayList<Integer>();
        for (int i = 0; i < getLenMap()[start].length; i++) {
            if (!visitedNodes.contains(i) && start != i && getLenMap()[start][i] != 0) {
                nextNodes.add(i);
            }
        }

        for (int nextNode : nextNodes) {
            if (canGo(nextNode, end, visitedNodes)){
                return true;
            }
        }
        return false;
    }



    public List<Integer> getDekstor(int start) {
        List<Integer> calculated = new ArrayList<Integer>();
        calculated.add(0, 0);
        getDekstor(start, 0, calculated);
        return calculated;
    }


    public void getDekstor(int currentElement, int currentLength, List<Integer> calculated) {
        for (int i = 0; i < getLenMap()[currentElement].length; i++) {
            if (currentElement != i && getLenMap()[currentElement][i] != 0) {
                int lengthToNextElement = currentLength + getLenMap()[currentElement][i];
                if(calculated.size() <= i || calculated.get(i) > lengthToNextElement){
                    calculated.set(i, lengthToNextElement);
                    getDekstor(i, lengthToNextElement, calculated);
                }
            }
        }
    }

}
