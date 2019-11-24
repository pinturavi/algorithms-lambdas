package com.pintu;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class KnapSack {
    public static void main(String[] args) {
        final List<Item> result = getSolution();

        System.out.println(result);
    }

    private static List<Item> getSolution() {
        final List<Item> result = new ArrayList<>();
        float maxWeight = 15;
        final var items = List.of(new Item(10, 2), new Item(5, 3), new Item(15, 5), new Item(7, 7), new Item(6, 1), new Item(18, 4), new Item(3, 1));

        final var sortedItems = items.stream().sorted(Comparator.comparing(Item::getPpu).reversed()).collect(toList());
        //sortedItems.stream().
        for (var item : sortedItems) {
            if (maxWeight == 0) {
                break;
            }
            if (item.getWeight() < maxWeight) {
                maxWeight -= item.getWeight();
                result.add(item);
            } else {
                result.add(new Item(item.getPpu() * maxWeight, maxWeight));
                maxWeight = 0;
            }
        }
        return result;
    }
}

class Item {
    private float profit;

    private float weight;

    public float getPpu() {
        return ppu;
    }

    public void setPpu(float ppu) {
        this.ppu = ppu;
    }

    private float ppu;

    public Item(float profit, float weight) {
        this.profit = profit;
        this.weight = weight;
        this.ppu = profit / weight;
    }


    public float getProfit() {
        return profit;
    }

    public void setProfit(int profit) {
        this.profit = profit;
    }

    @Override
    public String toString() {
        return "Item{" +
                "profit=" + profit +
                ", weight=" + weight +
                '}';
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
