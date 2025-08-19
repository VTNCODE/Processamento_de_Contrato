package services;


public class PaypalService implements OnlinePaymentService {

    @Override
    public double interest(double amount, int installment) {
       return amount * ((double) installment / 100);
    }
    @Override
    public double paymentFee(double amount) {
        return amount * 0.02;

    }

}
