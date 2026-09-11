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
       
    }

    public void withdraw(BigDecimal amount){

    }

    public void transfer(String recepient, BigDecimal amount){

    }
}
