package com.vaibhav.lld;

public class Main {
    public static void main(String[] args) throws Exception {
        try {
            VendingMachine vendingMachine = VendingMachine.getVendingMachine(10);
            vendingMachine.getInventory().display();
            System.out.println("\n--------Adding soda----------\n");
            vendingMachine.getInventory().addItem(new Item(ItemType.SODA, 30), 110);
            vendingMachine.getInventory().display();
            VendingMachineState vendingMachineState = vendingMachine.getVendingMachineState();
            vendingMachineState.clickOnInsertCoinButton(vendingMachine);
            vendingMachineState = vendingMachine.getVendingMachineState();
            vendingMachineState.insertCoin(vendingMachine,new Coin(CoinType.RUPEE_5));
            vendingMachineState.insertCoin(vendingMachine,new Coin(CoinType.RUPEE_10));
            vendingMachineState.insertCoin(vendingMachine,new Coin(CoinType.RUPEE_20));
            vendingMachineState.insertCoin(vendingMachine,new Coin(CoinType.RUPEE_10));
            vendingMachineState.insertCoin(vendingMachine,new Coin(CoinType.RUPEE_5));
            vendingMachineState.insertCoin(vendingMachine,new Coin(CoinType.RUPEE_1));
            System.out.println("\n-------Clicking on product selection state----\n");
            vendingMachineState.clickOnProductSelectionButton(vendingMachine);
            vendingMachineState = vendingMachine.getVendingMachineState();
            vendingMachineState.chooseProduct(vendingMachine,104);
            vendingMachine.getInventory().display();
            System.out.println("\n--------Adding Pepsi----------\n");
            vendingMachine.getInventory().addItem(new Item(ItemType.PEPSI,20),104);
            vendingMachine.getInventory().display();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}