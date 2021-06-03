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

    public int sellStock(String item, int quantity) {
        StockItem inStock = list.getOrDefault(item, null);
        if ((inStock != null) && (inStock.quantityInStock() >= quantity) && (quantity > 0)) {
            inStock.adjustStock(-quantity);
            return quantity;
        }
//       return 0  if there is no item in Stock, or not enough quantity is less then quantity customer want to buy
//        or quantity passwd as argument is less or equal to 0
        return 0;
    }

    public StockItem get(String key) {
        return list.get(key);
    }

    public Map<String, StockItem> Items() {
//       Stock items may have ways to display stock items inm different way
//        read only view, wrapper from Collection class
        return Collections.unmodifiableMap(list);
    }

    @Override
    public String toString() {
//        only in this chellenge, to print values, easly you will not do this normally in production
        StringBuilder builder = new StringBuilder();
        builder.append("\nStock List\n");
        double totalCost = 0.0;
        for (Map.Entry<String, StockItem> item : list.entrySet()) {
            StockItem stockItem = item.getValue();
            double itemValue = stockItem.getPrice() * stockItem.quantityInStock();
            builder.append(stockItem).append(". There are ").append(stockItem.quantityInStock()).append(" in stock. ");
            builder.append("Value of items: ").append(String.format("%.2f", itemValue)).append("\n");
            totalCost += itemValue;
        }
        builder.append("Total stock value: ").append(String.format("%.2f", totalCost));
        return builder.toString();
    }
}
