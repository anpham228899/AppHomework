package com.example.models;

import java.util.ArrayList;

public class ListPaymentMethod {
    ArrayList<PaymentMethod> paymentMethods;

    public ListPaymentMethod(ArrayList<PaymentMethod> paymentMethods) {
        this.paymentMethods = paymentMethods;
    }

    public ListPaymentMethod(){
        paymentMethods=new ArrayList<>();
    }

    public ArrayList<PaymentMethod> getPaymentMethods() {
        return paymentMethods;
    }

    public void setPaymentMethods(ArrayList<PaymentMethod> paymentMethods) {
        this.paymentMethods = paymentMethods;
    }
    public void generate_sample_payment(){
        paymentMethods.add(new PaymentMethod(1, "Banking Account", "Transfer through bank"));
        paymentMethods.add(new PaymentMethod(2, "Credit Card", "Pay with credit card"));
        paymentMethods.add(new PaymentMethod(3, "Momo", "Pay with e-wallet"));
        paymentMethods.add(new PaymentMethod(4, "Cash", "Cash on delivery"));
    }
}

