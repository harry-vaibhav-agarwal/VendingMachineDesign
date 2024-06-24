package com.vaibhav.lld;

import com.vaibhav.lld.impl.IdleVendingMachineState;

import java.util.List;

public class VendingMachine {
    private VendingMachineState vendingMachineState;
    private final int capacity;
    private List<Coin> coinList;
    private final Inventory inventory;
    private VendingMachine(int capacity) {
        this.capacity = capacity;
        inventory = new Inventory(capacity);
        vendingMachineState = new IdleVendingMachineState(this);
    }
    private static VendingMachine vendingMachine;

    public static VendingMachine getVendingMachine(int capacity) {
        if(vendingMachine == null)
            vendingMachine = new VendingMachine(capacity);
        return vendingMachine;
    }

    public VendingMachineState getVendingMachineState() {
        return vendingMachineState;
    }

    public void setVendingMachineState(VendingMachineState vendingMachineState) {
        this.vendingMachineState = vendingMachineState;
    }

    public List<Coin> getCoinList() {
        return coinList;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCoinList(List<Coin> coinList) {
        this.coinList = coinList;
    }

    public void dispenseMoneyInTray(List<Coin> coins) {
        System.out.println("Collect your coins " + coins.toString());
    }
}
