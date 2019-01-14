package models;

public class TreapInEr <T extends Comparable>{
    public Node<T> root = null;

    public T getKthTarget(int k){ // k番目に小さいcontentを返す
        return recGetKthTarget(this.root, k);
    }

    private T recGetKthTarget(Node<T> node, int k){
        if(getSize(node.left) + 1 == k){
            return node.content;
        } else if(getSize(node.left) + 1 > k){
            return recGetKthTarget(node.left, k);
        } else{
            return recGetKthTarget(node.right, k - getSize(node.left) - 1);
        }
    }

    public void add(T content, double priority){
        this.root = recAdd(this.root, content, priority);
        update(this.root);
    }

    public Node<T> recAdd(Node<T> node, T content, double priority){
        if (node == null){
            node = new Node(content, priority);
            update(node);
            return node;

        } else if(content.compareTo(node.content) == -1){ // 挿入するtargetより、されるtargetのほうが小さい
            node.left = recAdd(node.left, content, priority);
            update(node);
            if(node.priority < node.left.priority){
                node = rotateRight(node);
            }

        } else{
            node.right = recAdd(node.right, content, priority);
            update(node);
            if(node.priority < node.right.priority){
                node = rotateLeft(node);
            }
        }
        return node;
    }

    public String toString(){
        if(this.root == null) return "Treap()";

        StringBuffer sb = new StringBuffer();
        sb.append("Treap(");
        recToString(this.root, sb);
        sb.append(")");

        return sb.toString();
    };

    private void recToString(Node node, StringBuffer sb){
        if(node != null){
            recToString(node.left, sb);
            sb.append(node.content.toString() + ": " + node.size + ", ");
            recToString(node.right, sb);
        }
    }

    private Node<T> update(Node<T> node){
        node.size = getSize(node.left) + getSize(node.right) + 1;
        return node;
    }

    private Node<T> rotateRight(Node<T> node){
        Node<T> lnode = node.left;
        node.left     = lnode.right;
        update(node);
        lnode.right   = node;
        update(lnode);
        return lnode;
    }

    private Node<T> rotateLeft(Node<T> node){
        Node<T> rnode = node.right;
        node.right    = rnode.left;
        update(node);
        rnode.left    = node;
        update(rnode);
        return rnode;
    }

    public int getSize(Node node){
        return node == null ? 0 : node.size;
    }

    // TODO: removeの実装
    public Boolean search(Node<T> node, T target){
//        System.out.println("比較対象: " + target.toString() + " 打率: " + ((Record)target).average);
        while(node != null){
            if(node.content.compareTo(target) == 1){
                node = node.left;
            } else if(node.content.compareTo(target) == -1){
                node = node.right;
            } else if(node.content.compareTo(target) == 0){
                return true;
            }
        }

        return false;
    }

}
