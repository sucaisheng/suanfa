package com.sucaisheng.graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * 图的宽度优先遍历
 */
public class Wfs {
    public static void wfs(Node node){
        if (node == null){
            return;
        }
        //创建一个队列来存放图中的点
        Queue<Node> queue = new LinkedList();
        //创建一个set集合来记录遍历过的点
        Set<Node> set = new HashSet<>();
        queue.add(node);
        set.add(node);
        while(!queue.isEmpty()){
            //cur记录当前遍历的点
            Node cur = queue.poll();
            System.out.println(cur.value);
            //将该节点的下一个可到节点加入到队列
            for (Node next : cur.nextNodes){
                if (!set.contains(next)){
                    set.add(next);
                    queue.add(next);
                }
            }
        }
    }
}
