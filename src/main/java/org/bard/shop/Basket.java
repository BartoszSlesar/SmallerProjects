package org.bard.shop;

import java.util.*;

public class Basket {
    private final String name;
    private final Map<StockItem, Integer> list;

    public Basket(String name) {
        this.name = name;
//     using treemap to have content in order.
        this.list = new TreeMap<>();
    }

    public int addToBasket(StockItem item, int quantity) {
        if ((item != null)) {
            int inBasket = list.getOrDefault(item, 0);
            if (inBasket >= Math.abs(quantity)) {
                list.put(item, inBasket + quantity);
                return inBasket;
            }

        }
        return 0;
    }

    public void removeFromBasket(StockItem item, int quantity) {
        int value = addToBasket(item, -quantity);
        if (value <= 0 && item != null) {
            list.remove(item);
        }
    }

    public void clearBasket() {
        list.clear();
    }

    public Map<StockItem, Integer> Items() {
        return Collections.unmodifiableMap(this.list);
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("\nShopping basket ").append(this.name).append(" contains ").append(list.size()).append(" items\n");
        double totalCost = 0.0;
        for (Map.Entry<StockItem, Integer> item : list.entrySet()) {
            s.append(item.getKey()).append(". ").append(item.getValue()).append(" purchased\n");
            totalCost += item.getKey().getPrice() * item.getValue();
        }
        s.append("Total cost: ").append(totalCost);
        return s.toString();
    }
}
