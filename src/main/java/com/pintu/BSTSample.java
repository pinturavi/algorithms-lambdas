package com.pintu;

import javax.swing.plaf.nimbus.NimbusLookAndFeel;

public class BSTSample {
    public static void main(String[] args) {
        BST bst = new BST(new Node(34));
        bst.add(new Node(23));
        bst.add(new Node(12));
        bst.add(new Node(78));
        bst.add(new Node(99));
        bst.add(new Node(12));

        bst.traverseInOrder();

    }
}

class BST{
    private Node root;

    public BST(Node root) {
        this.root = root;
    }

    public BST() {
    }

    public void add(Node node){

        addNode(root, node);
    }

    private void addNode(Node parent, Node node) {
               if (parent.getValue() > node.getValue() && parent.getLeft() == null) {
                parent.setLeft(node);
        } else if( parent.getValue() <= node.getValue() && parent.getRight() == null) {
            parent.setRight(node);
        } else if (parent.getValue() > node.getValue()) {
            addNode(parent.getLeft(), node);
        } else {
            addNode(parent.getRight(), node);
        }
    }


    public void traverseInOrder(){
        printAll(root);
    }

    private void printAll(Node node) {
        if (node == null) {
            return;
        }

        printAll(node.getLeft());
        System.out.println(node);
        printAll(node.getRight());

    }
}


class Node {
    private int value;

    private Node left;
    private Node right;

    public Node(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }
}
