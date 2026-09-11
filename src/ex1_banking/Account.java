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

    public void deposit(){
       
    }

    public void withdraw(){

    }

    public void transfer(){

    }
}
