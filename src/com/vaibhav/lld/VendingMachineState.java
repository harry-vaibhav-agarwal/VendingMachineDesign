package com.vaibhav.lld;

import java.util.List;

public interface VendingMachineState {
    void clickOnInsertCoinButton(VendingMachine vendingMachine) throws Exception;
    void clickOnProductSelectionButton(VendingMachine vendingMachine) throws Exception;
    void insertCoin(VendingMachine vendingMachine, Coin coin) throws Exception;
    List<Coin> refundFullMoney(VendingMachine vendingMachine) throws Exception;
    Item dispenseProduct(VendingMachine vendingMachine, int codeNumber) throws  Exception;
    void updateProduct(VendingMachine vendingMachine,Item item, int codeNumber) throws Exception;
    void cancel(VendingMachine vendingMachine) throws Exception;
    void chooseProduct(VendingMachine vendingMachine,int codeNumber) throws Exception;
    int getChange(VendingMachine vendingMachine, int changeMoney) throws Exception;
}
