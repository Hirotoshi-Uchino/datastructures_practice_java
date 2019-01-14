//package models;
//
//import javafx.util.Pair;
//
//public class TreapSpMe<T extends Comparable> extends Node<T>{
//
//    private Node root = null;
////    private static int SEED = 1; // priority用の乱数の種
//
//
//
//    public Node update(Node node){
//        node.size = node.left.getSize() + node.right.getSize() + 1;
//        return node;
//    }
//
//    public Node merge(Node left, Node right){
//        if(left == null || right == null){
//            return left == null ? right : left;
//        }
//        if(left.priority > right.priority){
//            left.right = merge(left.right, right);
//            return update(left);
//        } else{
//            right.left = merge(right.left, left);
//            return update(right);
//        }
//    }
//
//    // node をたどることになる。k番目のノードで再帰が止まる
//    //    [0,1,2,...,k-1,k,...]
//    // -> [0,1,2,...,k-1] [k,...]
//    //
//    public Pair<Node, Node> split(Node node, int k){
//        if(node == null) return new Pair(null, null);
//
//        if(k <= node.getSize()){
//            Pair<Node, Node> s = split(node.left, k);
//            node.left = s.getValue();
//            return new Pair(s.getKey(), update(node));
//        } else{
//            Pair<Node, Node> s = split(node.right, k - node.left.getSize() - 1);
//            node.right = s.getKey();
//            return new Pair(update(node), s.getValue());
//        }
//    }
//
//    public void add(T target, double priority){
//        if(this.root == null){
//            this.root = new Node(target, priority);
//            update(this.root);
//        }
//
//        Node node = this.root;
//
//        while(true){
//            if(priority < node.priority){
//
//            } else{
//
//            }
//
//        }
//
////        if(priority < this.root.priority){
////
////        } else{
////
////        }
//
//    }
//
//
//}
