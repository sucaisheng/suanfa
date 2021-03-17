package com.sucaisheng.graph;

/**
 * 将给定的图转换成自己熟悉的图结构，并且完成相关算法测试
 */
public class Test {
    public static void main(String[] args){
        //给定图结构
        int[][] v = {{2,1,2},{2,1,3},{3,2,1},{5,2,4},{1,3,1},{4,3,5},{3,3,4},{2,5,4}};
        //将给定图转换成自己定义的图结构
        Graph graph = creatGraph(v);

        //测试宽度优先算法
        Wfs.wfs(graph.nodes.get(1));

        //测试深度优先算法
        Dfs.dfs(graph.nodes.get(1));
    }

    /**
     * 定义的一个将给定图结构转换成自己熟悉的图结构的方法
     * @param v
     * @return
     */
    public static Graph creatGraph(int[][] v){
        //new一个自己定义好的图结构
        Graph graph = new Graph();
        int weight, from, to;
        for (int i=0; i<v.length; i++){
            //取出给定图中的相关信息
            weight = v[i][0];
            from = v[i][1];
            to = v[i][2];

            //将取出的信息填充入自己的图结构中
            if (!graph.nodes.containsKey(from)){
                graph.nodes.put(from, new Node(from));
            }
            if (!graph.nodes.containsKey(to)){
                graph.nodes.put(to, new Node(to));
            }
            Node fromNode = graph.nodes.get(from);
            Node toNode = graph.nodes.get(to);
            Edge newEdge = new Edge(weight, fromNode, toNode);
            fromNode.nextNodes.add(toNode);
            fromNode.out++;
            toNode.in++;
            fromNode.edges.add(newEdge);
            graph.edges.add(newEdge);
        }
        return graph;
    }
}
