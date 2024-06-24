package com.vaibhav.lld;

public class ItemShelf {
    private Item item;
    private boolean isSoldOut;

    private int codeNumber;

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public boolean isSoldOut() {
        return isSoldOut;
    }

    public void setSoldOut(boolean soldOut) {
        isSoldOut = soldOut;
    }

    public int getCodeNumber() {
        return codeNumber;
    }

    public void setCodeNumber(int codeNumber) {
        this.codeNumber = codeNumber;
    }

    @Override
    public String toString() {
        if(item != null)
            return "ItemShelf{" +
                "item=" + item +
                ", isSoldOut=" + isSoldOut +
                ", codeNumber=" + codeNumber +
                '}';
        return "ItemShelf{" + "item=null" + ", isSoldOut=" + isSoldOut +
                ", codeNumber=" + codeNumber +
                '}';
    }
}
