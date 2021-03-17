package com.sucaisheng.graph;

import java.util.ArrayList;

/**
 * 图的节点
 */
public class Node {
    public int value;
    public int in;
    public int out;
    public ArrayList<Node> nextNodes;
    public ArrayList<Edge> edges;
    public Node(int value){
        this.value = value;
        this.in = 0;
        this.out = 0;
        this.nextNodes = new ArrayList<Node>();
        this.edges = new ArrayList<Edge>();
    }
}
