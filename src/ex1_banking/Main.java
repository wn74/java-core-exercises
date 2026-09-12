package ex1_banking;

import java.math.BigDecimal;
//=========================Banking system========================= 
//--Bank account:
//  [x] Create
//      [x]Currency enum
//      [x]owner
//      [x]balance
//--Balance
//  [x] Deposit
//  [x] Withdraw
//  [x] Transfer
//  [x] Error handling


public class Main {

    public static void main(String[] args){

    Account alice = new Account("Alice", Currency.EUR);
    Account bob = new Account("Bob", Currency.EUR);
    alice.deposit(new BigDecimal(100));
    bob.deposit(new BigDecimal(50));

    try{
        alice.transfer(bob, new BigDecimal(40));
    } catch (InsufficientFundsException e) {

        System.out.println("Handled error: " + e.getMessage());

    } catch (CurrencyMismatchException e) {

        System.out.println("Handled error: " + e.getMessage());

    }

    System.out.println(bob);
    System.out.println(alice);

}



    
}
