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

    public void deposit(BigDecimal amount){

        if (amount.compareTo(BigDecimal.ZERO) <= 0) {

            throw new IllegalArgumentException("Amount must be positive!");

        }  


        balance = balance.add(amount);
       
    }

    public void withdraw(BigDecimal amount) throws InsufficientFundsException{

        if (amount.compareTo(BigDecimal.ZERO) < 0) {

            throw new IllegalArgumentException("Amount must be positive!");

        }  


        if (amount.compareTo(balance) > 0) {

            throw new InsufficientFundsException("Withdraw amount greater than the current balance! ");

        }  

        balance = balance.subtract(amount);

    }

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
