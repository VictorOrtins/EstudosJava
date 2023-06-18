package services;

import java.time.LocalDate;

import entities.Contract;
import entities.Installment;

public class ContractService {
    private OnlinePaymentService paymentService;


    public ContractService() {
        this.paymentService = null;
    }

    public ContractService(OnlinePaymentService paymentService) {
        this.paymentService = paymentService;
    }

    public void proccesContract(Contract contract, int months){
        double installmentValue;

        Installment tempInstallment;

        for(int i = 1; i <= months; i++){
            tempInstallment = new Installment();

            installmentValue = (contract.getValue() * 1.0) / months;

            installmentValue += paymentService.interest(installmentValue, i);
            installmentValue += paymentService.paymentFee(installmentValue);

            tempInstallment.setAmount(installmentValue);
            tempInstallment.setDueDate(contract.getDate().plusMonths(i));

            contract.addInstallment(tempInstallment);
        }

    }

    public OnlinePaymentService getPaymentService() {
        return this.paymentService;
    }

    public void setPaymentService(OnlinePaymentService paymentService) {
        this.paymentService = paymentService;
    }
}
