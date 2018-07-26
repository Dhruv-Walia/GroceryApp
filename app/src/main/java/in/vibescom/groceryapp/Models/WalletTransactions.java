package in.vibescom.groceryapp.Models;

import java.io.Serializable;

import in.vibescom.groceryapp.Constants.Constants;

public class WalletTransactions implements Serializable,Constants {

    private Double amount;
    private String heading;
    private String date;
    private Boolean transactionType;

    public WalletTransactions(String head, Double amount, String date,Boolean type){
        this.heading = head;
        this.amount = amount;
        this.date = date;
        this.transactionType = type;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Boolean getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(Boolean transactionType) {
        this.transactionType = transactionType;
    }
}
