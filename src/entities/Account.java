package entities;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account {

    public static double DEPOSIT_FEE_PERCENTAGE = 0.02;

    private Long id;

    @Setter(AccessLevel.NONE)
    private Double balance;

    public void deposit(double amount){
        if(amount > 0){
            amount -= amount*DEPOSIT_FEE_PERCENTAGE;
            balance += amount;
        }
    }

    public void withdraw(double amount){
        if(amount > balance){
            throw new IllegalArgumentException();
        }
        balance -= amount;
    }

    public double fullWithdraw(){
        double aux = balance;
        balance = 0.0;
        return aux;
    }
}
