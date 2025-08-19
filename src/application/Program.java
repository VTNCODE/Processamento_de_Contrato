package application;


import services.ContractService;
import services.PaypalService;
import entities.Contract;
import entities.Installment;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String [] args){
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");


        System.out.println("Entre os dados do contrato: ");
        System.out.print("Numero: ");
        int number = sc.nextInt();
        System.out.print("Data (dd/MM/yyyy): ");
        LocalDate contractDate = LocalDate.parse(sc.next(), fmt);
        System.out.print("Valor do contrato: ");
        double contractValue = sc.nextDouble();
        Contract contract = new Contract(number, contractDate, contractValue);
        System.out.print("Entre com o número de parcelas: ");
        int parcelas = sc.nextInt();
        System.out.println();

        System.out.println("PARCELAS: ");

        ContractService service = new ContractService(new PaypalService());
        service.processContract(contract, parcelas);

        for (Installment i : contract.getInstallments()) {
            System.out.println(i);
        }


        sc.close();

    }
}
