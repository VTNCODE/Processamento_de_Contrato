package services;

import entities.Contract;
import entities.Installment;

public class ContractService {
    OnlinePaymentService paymentService;

    public ContractService(OnlinePaymentService paymentService) {
        this.paymentService = paymentService;
    }

    public void processContract(Contract contract, int totalInstallments) {

        double baseValueOfInstallments = contract.getContractValue() / totalInstallments;

        for (int i = 1; i <= totalInstallments; i++) {
            double interestValue = paymentService.interest(baseValueOfInstallments, i);
            double valueOfFees = paymentService.paymentFee(baseValueOfInstallments + interestValue);
            double totalValue = baseValueOfInstallments + interestValue + valueOfFees;
            contract.getInstallments().add(new Installment(contract.getContractDate().plusMonths(i), totalValue));

        }
    }


}
