package entities;

import java.time.LocalDate;

public class Installment {

    private LocalDate localDate;
    private Double amount;


    public Installment(LocalDate localDate, Double amount) {
        this.localDate = localDate;
        this.amount = amount;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }



}
