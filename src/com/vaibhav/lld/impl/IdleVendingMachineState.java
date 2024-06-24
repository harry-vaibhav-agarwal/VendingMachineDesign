package com.vaibhav.lld.impl;

import com.vaibhav.lld.Coin;
import com.vaibhav.lld.Item;
import com.vaibhav.lld.VendingMachine;
import com.vaibhav.lld.VendingMachineState;

import java.util.ArrayList;
import java.util.List;

public class IdleVendingMachineState implements VendingMachineState {

    public IdleVendingMachineState(VendingMachine vendingMachine) {;
        System.out.println("\n---------Vending machine is in idle state----------\n");
        vendingMachine.setCoinList(new ArrayList<>());
    }

    public IdleVendingMachineState() {;
        System.out.println("\n---------Vending machine is in idle state----------\n");
    }

    @Override
    public void clickOnInsertCoinButton(VendingMachine vendingMachine) throws Exception {
        vendingMachine.setVendingMachineState(new HasMoneyVendingMachineState());
    }

    @Override
    public void clickOnProductSelectionButton(VendingMachine vendingMachine) throws Exception {
        throw new Exception("Product selection cannot be doen in idle state");
    }

    @Override
    public void insertCoin(VendingMachine vendingMachine, Coin coin) throws Exception {
        throw new Exception("Coin cannot be inserted in idle state");
    }

    @Override
    public List<Coin> refundFullMoney(VendingMachine vendingMachine) throws Exception {
        throw new Exception("Money cannot be refunded in idle state");
    }

    @Override
    public Item dispenseProduct(VendingMachine vendingMachine,int codeNumber) throws Exception {
        throw new Exception("Product cannot be dispensed in idle state");
    }

    @Override
    public void cancel(VendingMachine vendingMachine) throws Exception {
        throw new Exception("Invalid operation");
    }

    @Override
    public void updateProduct(VendingMachine vendingMachine, Item item, int codeNumber) throws Exception {
        vendingMachine.getInventory().addItem(item,codeNumber);
    }

    @Override
    public void chooseProduct(VendingMachine vendingMachine, int codeNumber) throws Exception {
        throw new Exception("Product can't be choosed in idle state");
    }

    @Override
    public int getChange(VendingMachine vendingMachine, int changeMoney) throws Exception {
        throw new Exception("Invalid operation");
    }
}
