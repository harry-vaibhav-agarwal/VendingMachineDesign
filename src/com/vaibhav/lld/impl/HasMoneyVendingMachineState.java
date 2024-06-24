package com.vaibhav.lld.impl;

import com.vaibhav.lld.Coin;
import com.vaibhav.lld.Item;
import com.vaibhav.lld.VendingMachine;
import com.vaibhav.lld.VendingMachineState;

import java.util.List;

public class HasMoneyVendingMachineState implements VendingMachineState {

    public HasMoneyVendingMachineState() {
        System.out.println("Currently Machine is in HasMoney State");
    }
    @Override
    public void clickOnInsertCoinButton(VendingMachine vendingMachine) throws Exception {
    }

    @Override
    public void clickOnProductSelectionButton(VendingMachine vendingMachine) throws Exception {
        vendingMachine.setVendingMachineState(new SelectionVendingMachineState());
    }

    @Override
    public void insertCoin(VendingMachine vendingMachine, Coin coin) throws Exception {
        System.out.println("Accepted the coin of denomination " + coin);
        vendingMachine.getCoinList().add(coin);
    }

    @Override
    public List<Coin> refundFullMoney(VendingMachine vendingMachine) throws Exception {
        List<Coin> coins = vendingMachine.getCoinList();
        vendingMachine.dispenseMoneyInTray(coins);
        vendingMachine.setVendingMachineState(new IdleVendingMachineState(vendingMachine));
        return coins;
    }

    @Override
    public Item dispenseProduct(VendingMachine vendingMachine,int codeNumber) throws Exception {
        throw new Exception("Product can't be dispensed in hasMoney state");
    }

    @Override
    public void cancel(VendingMachine vendingMachine) throws Exception {
        refundFullMoney(vendingMachine);
    }

    @Override
    public void updateProduct(VendingMachine vendingMachine, Item item, int codeNumber) throws Exception {
        throw new Exception("No update can be done in the hasMoney state");
    }

    @Override
    public void chooseProduct(VendingMachine vendingMachine, int codeNumber) throws Exception {
        throw new Exception("Product can't be choosed in hasMoney state");
    }

    @Override
    public int getChange(VendingMachine vendingMachine,int changeMoney) throws Exception {
        throw new Exception("You can't get change in the HasMoney state");
    }
}
