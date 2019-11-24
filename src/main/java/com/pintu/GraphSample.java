package com.pintu;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.stream.IntStream;

public class GraphSample {
    public static void main(String[] args) {
        Graph graph = new Graph(8);
        graph.addEdge(0, 1, 2);
        graph.addEdge(1, 0, 3, 4);
        graph.addEdge(2, 0, 5, 6);
        graph.addEdge(3, 1,7 );
        graph.addEdge(4, 1, 7);
        graph.addEdge(5, 2, 7);
        graph.addEdge(6, 2, 7);
        graph.addEdge(7, 3, 4, 5, 6);
        //System.out.println(graph);

        graph.bfs(2);

    }
}

class Graph {

    private LinkedList<Integer>[] adjList;

    private int[] visited;

    public Graph(int size) {
        adjList = new LinkedList[size];
        visited = new int[size];
        for (int i = 0; i < size; i++) {
            adjList[i] = new LinkedList<>();
        }
    }

    public void addEdge(int position, int... adjacents) {
        for (int adj : adjacents) {
            adjList[position].addLast(adj);
        }
    }

    @Override
    public String toString() {
        return "Graph{" +
                "adjList=" + Arrays.toString(adjList) +
                '}';
    }

    public void dfs(int v){
        visited[v] = 1;
        System.out.println(v);
        for (int w: adjList[v]) {
            if (visited[w] == 0) {
                dfs(w);
            }
        }
    }

    void bfs(int v){
        Queue<Integer> q = new ConcurrentLinkedDeque<>();
        visited[v] = 1;
        while (true) {
            System.out.println(v);
            for (int w: adjList[v]) {
                if (visited[w] == 0) {
                    q.add(w);
                    visited[w] = 1;
                }
            }

            if (q.isEmpty()) {
                return;
            }

            v = q.remove();
        }
    }


}

class GNode {

    private int value;

    private GNode link;

    public GNode(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public GNode getLink() {
        return link;
    }

    public void setLink(GNode link) {
        this.link = link;
    }

    @Override
    public String toString() {
        return "GNode{" +
                "value=" + value +
                '}';
    }
}