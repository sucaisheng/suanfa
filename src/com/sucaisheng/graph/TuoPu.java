package com.sucaisheng.graph;

import java.util.*;

/**
 * 图的拓扑排序，图必须为无环有向图
 */
public class TuoPu {
    public static List<Node> tuoPuPaiXu(Graph graph){
        //创建一个hashMap来存储图中的节点和节点的入度值
        HashMap<Node, Integer> inHashMap = new HashMap<>();
        //创建一个队列来记录只有入度为0的节点
        Queue<Node> zeroQueue = new LinkedList<>();
        for (Node node : graph.nodes.values()){
            inHashMap.put(node, node.in);
            if(node.in == 0){
                zeroQueue.add(node);
            }
        }
        //创建一个数组，将拓扑排序的结果放入其中
        List<Node> resultList = new ArrayList<>();
        while(!zeroQueue.isEmpty()){
            Node cur = zeroQueue.poll();
            resultList.add(cur);
            //将该节点直接到的点的入度-1
            for (Node nextNode : cur.nextNodes){
                inHashMap.put(nextNode,inHashMap.get(nextNode) - 1);
                if (inHashMap.get(nextNode) == 0){
                    zeroQueue.add(nextNode);
                }
            }
        }
        return resultList;
    }
}
