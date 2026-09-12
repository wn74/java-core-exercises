package ex1_banking;

import java.math.BigDecimal;

public class Account {
    private String owner;
    private BigDecimal balance =BigDecimal.ZERO;
    private Currency currency;

    public Account(String owner, Currency currency ){
        this.owner = owner;
        this.currency = currency;

    }

    /**
     * 
     * @param amount the value to add to the balance
     * @throws IllegalArgumentException if amount is less or equal to zero
     */
    public void deposit(BigDecimal amount){

        if (amount.compareTo(BigDecimal.ZERO) <= 0) {

            throw new IllegalArgumentException("Amount must be positive!");

        }  


        balance = balance.add(amount);
       
    }

    /**
     * 
     * @param amount the amount to substract from the balance
     * @throws InsufficientFundsException if not enough money in the account 
     * @throws IllegalArgumentException if amount is less or equal to zero
     */
    public void withdraw(BigDecimal amount) throws InsufficientFundsException{

        if (amount.compareTo(BigDecimal.ZERO) <= 0) {

            throw new IllegalArgumentException("Amount must be positive!");

        }  


        if (amount.compareTo(balance) > 0) {

            throw new InsufficientFundsException("Withdraw amount greater than the current balance! ");

        }  

        balance = balance.subtract(amount);

    }

    /**
     * 
     * @param recipient the account receiving the funds
     * @param amount the amount to transfered
     * @throws InsufficientFundsException if sender doesn't have the amount to send
     * @throws CurrencyMismatchException if sender/recipient account currencies don't match
     */
    
    public void transfer(Account recipient, BigDecimal amount) throws InsufficientFundsException, CurrencyMismatchException{

        if (this.currency != recipient.currency) {

            throw new CurrencyMismatchException("Different account currencies! ");

        }  

        this.withdraw(amount);
        recipient.deposit(amount);

    }


    public BigDecimal getBalance(){

        return balance;

    }

    public String getOwner(){

        return owner;

    }

    public Currency getCurrency(){

        return currency;

    }

    @Override
    public String toString(){
        return owner + ": " + balance + " " + currency ;
    }
}
