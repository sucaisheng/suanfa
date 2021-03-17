package com.sucaisheng.graph;

/**
 * 图中节点之间的边
 */
public class Edge {
    private int weight;
    private Node from;
    private Node to;

    public Edge(int weight, Node from, Node to){
        this.weight = weight;
        this.from = from;
        this.to = to;
    }
}
