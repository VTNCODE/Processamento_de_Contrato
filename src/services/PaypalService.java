package services;


public class PaypalService implements OnlinePaymentService {

    @Override
    public double interest(double amount, int months) {
       return amount * ((double) months / 100);
    }
    @Override
    public double paymentFee(double amount) {
        return amount * 0.02;

    }

}
