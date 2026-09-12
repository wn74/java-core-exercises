package ex1_banking;

import java.math.BigDecimal;

public class Main {

    public static void main(String[] args){


    //STEP 1. Initialise example accounts
    Account alice = new Account("Alice", Currency.EUR);
    Account bob = new Account("Bob", Currency.EUR);

    //STEP 2. Deposit starting capital onto the accounts
    alice.deposit(new BigDecimal(100));
    bob.deposit(new BigDecimal(50));

    //STEP 3. Perform functions that might throw errors
    try{
        alice.transfer(bob, new BigDecimal(40));
    } catch (InsufficientFundsException e) {

        System.out.println("Handled error: " + e.getMessage());

    } catch (CurrencyMismatchException e) {

        System.out.println("Handled error: " + e.getMessage());

    }


    //STEP 4. Final check
    System.out.println(bob);
    System.out.println(alice);

}

}
