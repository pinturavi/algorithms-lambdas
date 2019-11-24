package com.pintu;

import java.util.ArrayList;
import java.util.List;

public class StackSample {

    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(45);
        stack.push(34);
        stack.push(90);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }

}


class Stack {

    private List<Integer> values = new ArrayList<>();

    void push(int value){
        this.values.add(value);
    }

    int pop(){
        final var size = this.values.size() - 1;
        final var result = this.values.get(size);
        this.values.remove(size);
        return result;
    }
}