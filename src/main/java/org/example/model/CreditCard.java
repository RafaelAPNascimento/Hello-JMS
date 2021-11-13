package org.example.model;

import java.io.Serializable;

public class CreditCard implements Serializable {

    private String cvv;
    private String number;

    public CreditCard(String cvv, String number) {
        this.cvv = cvv;
        this.number = number;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "CreditCard{" +
                "cvv='" + cvv + '\'' +
                ", number='" + number + '\'' +
                '}';
    }
}
