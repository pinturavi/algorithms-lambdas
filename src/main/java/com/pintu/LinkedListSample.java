package com.pintu;

public class LinkedListSample {

    public static void main(String[] args) {
        LinkedList ll = new LinkedList(new LNode(23));
        ll.add(new LNode(55));
        ll.add(new LNode(66));
        ll.add(new LNode(77));
        ll.add(new LNode(89));

        ll.print();
    }
}

class LinkedList{

    private LNode root;

    private LNode link;

    public LinkedList(LNode root) {
        this.root = root;
    }

    public void add(LNode node){
        addNode(root, node);
    }

   private   void addNode(LNode parent, LNode node) {
        if (parent.getLink() == null) {
            parent.setLink(node);
            return;
        }
        addNode(parent.getLink(), node);
    }

    void print(){
        printAll(root);
    }

    private void printAll(LNode node) {
        if (node == null) {
            return;
        }

        System.out.println(node);
        printAll(node.getLink());
    }
}
