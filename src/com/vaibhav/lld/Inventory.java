package com.vaibhav.lld;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Inventory {
    private final List<ItemShelf> itemShelves;
    private final int capacity;
    public Inventory(int capacity) {
        itemShelves = new ArrayList<>();
        this.capacity = capacity;
        initialize();

    }

    public void addItem(Item item, int codeNumber) throws Exception {
        if(itemShelves.size() > capacity)
            throw new Exception("Capacity is full");
        for(int i=0;i<capacity;i++) {
            if(itemShelves.get(i).isSoldOut() && itemShelves.get(i).getCodeNumber() == codeNumber) {
                itemShelves.get(i).setItem(item);
                itemShelves.get(i).setSoldOut(false);
                return;
            }
        }
        throw new Exception("Invalid codeNumber provided or space unavailable");
    }

    public void initialize() {
        int startCode = 101;
        for(int i=0;i<capacity;i++) {
            ItemShelf itemShelf = new ItemShelf();
            itemShelf.setSoldOut(true);
            itemShelf.setCodeNumber(startCode);
            if(i<3) {
                itemShelf.setItem(new Item(ItemType.YOGURT, 30));
                itemShelf.setSoldOut(false);
            }
            if(i>=3 && i<6) {
                itemShelf.setItem(new Item(ItemType.LAYS, 10));
                itemShelf.setSoldOut(false);
            }
            if(i>=6 && i<9) {
                itemShelf.setItem(new Item(ItemType.PEPSI, 20));
                itemShelf.setSoldOut(false);
            }
            itemShelves.add(itemShelf);
            startCode++;
        }
    }

    public void display() {
        System.out.println("\n--------------------Displaying Inventory----------------------------\n");
        for (int i=0;i<capacity ;i++) {
            System.out.println(itemShelves.get(i));
        }
        System.out.println("\n--------------------END----------------------------\n");
    }

    public Item getItem(int codeNumber) {
        Optional<ItemShelf> optionalItemShelf = itemShelves.stream().filter(itemShelf -> itemShelf.getCodeNumber() == codeNumber && !itemShelf.isSoldOut()).findFirst();
        return optionalItemShelf.map(ItemShelf::getItem).orElse(null);
    }

    public void updateSoldOutItem(int codeNumber) {
        Optional<ItemShelf> shelf = itemShelves.stream().filter(it -> it.getCodeNumber() == codeNumber).findFirst();
        shelf.ifPresent(itemShelf -> itemShelf.setSoldOut(true));
    }
}
