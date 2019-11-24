package com.pintu;

import java.util.ArrayList;
import java.util.List;

public class QueueSample {
    public static void main(String[] args) {
        Queue q = new Queue();
        q.add(34);
        q.add(14);
        q.add(24);
        q.add(44);
        q.add(54);

        System.out.println(q.get());
        System.out.println(q.get());
        System.out.println(q.get());
        System.out.println(q.get());
        System.out.println(q.get());
    }

}

class Queue {
    private List<Integer> values = new ArrayList<>();

    void add(int value){
        values.add(value);
    }

    int get(){
        final var result = this.values.get(0);
        this.values.remove(0);
        return result;
    }
}
