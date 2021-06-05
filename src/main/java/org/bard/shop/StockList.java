package org.bard.shop;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class StockList {
    private final Map<String, StockItem> list;

    public StockList() {
        this.list = new LinkedHashMap<>();
    }

    public int addStock(StockItem item) {
        if (item != null) {
//            get item if already exist use item otherwise
            StockItem inStock = list.getOrDefault(item.getName(), item);
//            if there already stock on this item, adjust the quantity
            if (inStock != item) {
                item.adjustStock(inStock.quantityInStock());
            }

            list.put(item.getName(), item);
            return item.quantityInStock();
        }
        return 0;
    }

    public int reserveStock(String item, int quantity) {
        StockItem inStock = list.getOrDefault(item, null);
        if ((inStock != null) && (inStock.quantityInStock() - inStock.reservedItems() >= quantity) && (quantity > 0)) {
            inStock.adjustReserved(quantity);
            return quantity;
        }
        return 0;
    }

    public int unReserveStock(String item, int quantity) {
        StockItem inStock = list.getOrDefault(item, null);
        if ((inStock != null) && (inStock.reservedItems() >= quantity) && (quantity > 0)) {
            inStock.adjustReserved(-quantity);
            return quantity;
        }
        return 0;
    }

    //    used during checkouts, return value that has been payed
    public double sellStock(StockItem item, int quantity) {
        if ((item != null)) {
            item.adjustStock(-quantity);
            item.adjustReserved(-quantity);
            return item.getPrice() * quantity;
        }
        return 0;
    }

    public Map<String, Double> PriceList() {
        Map<String, Double> prices = new LinkedHashMap<>();
        for (Map.Entry<String, StockItem> item : list.entrySet()) {
            prices.put(item.getKey(), item.getValue().getPrice());
        }
        return Collections.unmodifiableMap(prices);
    }

    public StockItem get(String key) {
        return list.get(key);
    }

    public Map<String, StockItem> Items() {
        return Collections.unmodifiableMap(list);
    }

    @Override
    public String toString() {
        //   only in this chellenge, to print values, easly you will not do this normally in production
        StringBuilder build = new StringBuilder();
        build.append("\nStock List\n");
        double totalCost = 0.0;
        for (Map.Entry<String, StockItem> item : list.entrySet()) {
            StockItem stockItem = item.getValue();
            double itemValue = stockItem.getPrice() * (stockItem.quantityInStock() - stockItem.reservedItems());
            build.append(stockItem).append(". There are ").append(stockItem.quantityInStock() - stockItem.reservedItems());
            build.append(" in stock. ");
            build.append("Value of items: ").append(String.format("%.2f", itemValue)).append("\n");
            totalCost += itemValue;
        }
        build.append("Total stock value: ").append(String.format("%.2f", totalCost));
        return build.toString();
    }
}
