package com.vaibhav.lld.impl;

import com.vaibhav.lld.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SelectionVendingMachineState implements VendingMachineState {

    public SelectionVendingMachineState(){
        System.out.println("VendingMachine is in product selection state");
    }
    @Override
    public void clickOnInsertCoinButton(VendingMachine vendingMachine) throws Exception {
        throw new Exception("Insert Coin not allowed in Selection state");
    }

    @Override
    public void clickOnProductSelectionButton(VendingMachine vendingMachine) throws Exception {
    }

    @Override
    public void insertCoin(VendingMachine vendingMachine, Coin coin) throws Exception {
        throw new Exception("Insert Coin not allowed in Selection state");
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
        throw new Exception("Product can't be dispensed at this stage");
    }

    @Override
    public void cancel(VendingMachine vendingMachine) throws Exception {
        refundFullMoney(vendingMachine);
    }

    @Override
    public void updateProduct(VendingMachine vendingMachine, Item item, int codeNumber) throws Exception {
        throw new Exception("Product can't be updated at Selection State");
    }

    @Override
    public void chooseProduct(VendingMachine vendingMachine, int codeNumber) throws Exception {
        System.out.println("\n-------User selected the product " + codeNumber + " -----------\n");
        Item item = vendingMachine.getInventory().getItem(codeNumber);
        if(item == null)
            throw new Exception("Invalid product selection");
        int depositedMoney = vendingMachine.getCoinList().stream().map(Coin::getDenomination).reduce(0,(a,b) -> a+b);
        System.out.println("Money deposited by user is " + depositedMoney);
        System.out.println("ItemPrice is " + item.getPrice() + " and ItemSelected is " + item.getItemType());
        if(item.getPrice() > depositedMoney) {
            System.out.println("Insufficient Amount, Product you selected is for price: " + item.getPrice() + " and you paid: " + depositedMoney);
            refundFullMoney(vendingMachine);
            throw new Exception("insufficient amount");
        }
        else {
            int change = depositedMoney - item.getPrice();
            vendingMachine.setVendingMachineState(new DispensingVendingMachineState(vendingMachine,codeNumber));
            if(change > 0)
                getChange(vendingMachine,change);
        }
    }

    @Override
    public int getChange(VendingMachine vendingMachine, int changeMoney) throws Exception {
        System.out.println("Refunding the amount " + changeMoney);
        List<Coin> coins = getCoins(changeMoney);
        vendingMachine.dispenseMoneyInTray(coins);
        vendingMachine.setCoinList(new ArrayList<>());
        return changeMoney;
    }

    private static List<Coin> getCoins(int changeMoney) {
        List<Coin> coins = new ArrayList<>();
        int totalValue = changeMoney;
        List<Integer> denominations = Arrays.stream(CoinType.values()).map(CoinType::getValue).sorted(Comparator.reverseOrder()).collect(Collectors.toList());

        for(Integer denomination: denominations) {
            int coinsOfGivenDenomination = totalValue/denomination;
            for(int i=0;i<coinsOfGivenDenomination;i++)
                coins.add(new Coin(CoinType.getCoin(denomination)));
            totalValue = totalValue % denomination;
        }

        return coins;
    }
}
