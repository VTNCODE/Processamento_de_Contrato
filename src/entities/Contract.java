package entities;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Contract {

    DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    private Integer number;
    private LocalDate contractDate;
    private Double contractValue;
    private final List<Installment> installments = new ArrayList<>();

    public Contract() {
    }

    public Contract(Integer number, LocalDate contractDate, Double contractValue) {
        this.number = number;
        this.contractDate = contractDate;
        this.contractValue = contractValue;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public LocalDate getContractDate() {
        return contractDate;
    }

    public void setContractDate(LocalDate contractDate) {
        this.contractDate = contractDate;
    }

    public Double getContractValue() {
        return contractValue;
    }

    public void setContractValue(Double contractValue) {
        this.contractValue = contractValue;
    }

    public List<Installment> getInstallments() {
        return installments;
    }

    @Override
    public String toString() {
        return "Contrato: " + "\n" + "\n" +
                "Número: " + number + "\n" +
                "Data do contrato: " + contractDate.format(fmt) + "\n" +
                "Valor do contrato: " + String.format("%.2f", contractValue) + "\n";
    }

    public double totalToPay() {
        double total = 0;
        for (Installment i : getInstallments()) {
            total += i.getAmount();
        }
        return total;
    }

}
