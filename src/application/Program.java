package application;


import services.ContractService;
import services.PaypalService;
import entities.Contract;
import entities.Installment;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String [] args){
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String path = "c:\\temp\\exercicios_em_java_\\processamentoDeContrato\\registrosParcelados";
        String textPath ="c:\\temp\\exercicios_em_java_\\processamentoDeContrato\\registrosParcelados\\contratoComParcelas.txt";
        File file = new File(path);
        boolean fileCreated = file.mkdirs();
        
        System.out.println("Entre os dados do contrato: ");
        System.out.print("Numero: ");
        int number = sc.nextInt();
        System.out.print("Data (dd/MM/yyyy): ");
        LocalDate contractDate = LocalDate.parse(sc.next(), fmt);
        System.out.print("Valor do contrato: ");
        double contractValue = sc.nextDouble();
        Contract contract = new Contract(number, contractDate, contractValue);
        System.out.print("Entre com o número de parcelas: ");
        int installments = sc.nextInt();
        System.out.println();

        ContractService service = new ContractService(new PaypalService());
        service.processContract(contract, installments);

        try (BufferedWriter bf = new BufferedWriter(new FileWriter(textPath, true))){
            bf.write(contract.toString());
            bf.newLine();
            System.out.println(contract);
            System.out.println("Parcelas: ");
            for (Installment i : contract.getInstallments()) {
                bf.write(i.toString());
                bf.newLine();
                System.out.println(i);
            }
            bf.newLine();
            bf.write("Valor ao final do contrato: " + contract.totalToPay());
            bf.newLine();
            bf.newLine();
        }
        catch (Exception e) {
            System.out.println("Error" + e.getMessage());
        }
        System.out.println();
        System.out.println("Valor total a pagar ao final do contrato: " + String.format("%.2f", contract.totalToPay()));
        System.out.println();

        if (fileCreated) {
            System.out.println();
        }
        else {
            System.out.println("Programa encerrado.");
        }

        sc.close();

    }
}
