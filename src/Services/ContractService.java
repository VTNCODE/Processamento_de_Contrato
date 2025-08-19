package Services;

import entities.Contract;
import entities.Installment;

public class ContractService {
    OnlinePaymentService paymentService;

    public ContractService(OnlinePaymentService paymentService) {
        this.paymentService = paymentService;
    }

    public void processContract(Contract contract, int months) {

        double value = contract.getContractValue() / months;

        for (int i = 1; i <= months; i++) {
            double amountI = paymentService.interest(value, i);
            double amountF = paymentService.paymentFee(value + amountI);
            double totalValue = value + amountI + amountF;
            contract.getInstallments().add(new Installment(contract.getContractDate().plusMonths(i-1), totalValue));

        }
    }


}
