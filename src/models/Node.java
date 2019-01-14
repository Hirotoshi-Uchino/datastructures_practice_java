package models;

import javafx.util.Pair;

public class Node <T extends Comparable>{
    T content;
    Node<T> left, right;
    double priority;
    int size; // 部分技のサイズ

    public Node(T content, double priority){
        this.content   = content;
        this.priority  = priority;
        this.left      = null;
        this.right     = null;
    }

}
