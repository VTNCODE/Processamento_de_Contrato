package entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Installment {

    DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    private LocalDate dueDate;
    private Double amount;


    public Installment(LocalDate localDate, Double amount) {
        this.dueDate = localDate;
        this.amount = amount;
    }

    public LocalDate getLocalDate() {
        return dueDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.dueDate = localDate;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return dueDate.format(fmt) + " - " + String.format("%.2f", amount);
    }
}
