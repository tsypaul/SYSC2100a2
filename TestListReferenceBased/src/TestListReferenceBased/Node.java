package TestListReferenceBased;

import java.util.Objects;

/**
 * Created by shaoyutan on 2017-02-01.
 */
public class Node {
    private int item;
    private Node next;

    public Node (int a){
        item = a;
        next = null;
    }

    public Node(int a, Node n){
        item = a;
        next = n;
    }

    public int getItem(){
        return item;
    }

    public Node getNext(){
        return next;
    }

    public void setItem(int a){
        item = a;
    }

    public void setNext(Node n){
        next = n;
    }
}
