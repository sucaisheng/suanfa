package com.sucaisheng.graph;

import java.util.HashSet;
import java.util.Stack;

/**
 * 深度优先遍历
 */
public class Dfs {
    public static void dfs(Node node){
        if (node == null){
            return;
        }
        //创建一个栈来保存正在遍历的节点
        Stack<Node> stack = new Stack<>();
        //创建一个set集合来保存遍历过的点
        HashSet<Node> hashSet = new HashSet<>();
        stack.push(node);
        hashSet.add(node);
        System.out.println(node.value);
        while(!stack.isEmpty()){
            //cur记录当前遍历的节点
            Node cur = stack.pop();
            for (Node next : cur.nextNodes){
                if(!hashSet.contains(next)){
                    hashSet.add(next);
                    stack.push(cur);
                    stack.push(next);
                    System.out.println(next.value);
                    break;
                }
            }
        }
    }
}
