package com.vaibhav.lld.impl;

import com.vaibhav.lld.Coin;
import com.vaibhav.lld.Item;
import com.vaibhav.lld.VendingMachine;
import com.vaibhav.lld.VendingMachineState;

import java.util.List;

public class DispensingVendingMachineState implements VendingMachineState {

    public DispensingVendingMachineState(VendingMachine vendingMachine, int codeNumber) throws Exception {
        System.out.println("\n-------Vending Machine is in dispensing state-------\n");
        dispenseProduct(vendingMachine,codeNumber);
    }
    @Override
    public void clickOnInsertCoinButton(VendingMachine vendingMachine) throws Exception {
        throw new Exception("Insert coin can't be done at dispense state");
    }

    @Override
    public void clickOnProductSelectionButton(VendingMachine vendingMachine) throws Exception {
        throw new Exception("Product can't be selected at dispense state");
    }

    @Override
    public void insertCoin(VendingMachine vendingMachine, Coin coin) throws Exception {
        throw new Exception("Insert coin can't be done at dispense state");
    }

    @Override
    public List<Coin> refundFullMoney(VendingMachine vendingMachine) throws Exception {
        throw new Exception("Money can't be refunded at dispense state");
    }

    @Override
    public Item dispenseProduct(VendingMachine vendingMachine,int codeNumber) throws Exception {
        System.out.println("Product has been dispensed");
        Item item = vendingMachine.getInventory().getItem(codeNumber);
        vendingMachine.getInventory().updateSoldOutItem(codeNumber);
        vendingMachine.setVendingMachineState(new IdleVendingMachineState());
        return item;
    }

    @Override
    public void updateProduct(VendingMachine vendingMachine, Item item, int codeNumber) throws Exception {
        throw new Exception("Update not allowed at dispense state");
    }

    @Override
    public void cancel(VendingMachine vendingMachine) throws Exception {
        throw new Exception("Cancellation not allowed at dispensing state");
    }

    @Override
    public void chooseProduct(VendingMachine vendingMachine, int codeNumber) throws Exception {
        throw new Exception("Product can't be choosed in dispensing state");
    }

    @Override
    public int getChange(VendingMachine vendingMachine, int changeMoney) throws Exception {
        throw new Exception("No change allowed at dispense state");
    }
}
