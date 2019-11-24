package com.pintu;

public class LNode {

    private int value;

    private LNode link;

    public LNode(int value) {
        this.value = value;
    }

    public LNode getLink() {
        return link;
    }

    public void setLink(LNode link) {
        this.link = link;
    }

    @Override
    public String toString() {
        return "LNode{" +
                "value=" + value +
                '}';
    }
}
