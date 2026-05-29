package com.upskill.models;

import java.util.Objects;

public final class Account {

    //Atributos
    private final long accountId;
    private final String ownerName;
    private final double balance;

    private Account(long accountId, String ownerName, double balance){
        this.accountId = accountId;
        this.ownerName = ownerName;
        this.balance = balance;
    }

    public static Account create(
            long accountId,
            String ownerName,
            double balance
    ){

        if(accountId <= 0) {
            throw new IllegalArgumentException("El id es obligatorio");
        }

        if(balance < 0) {
            throw new IllegalArgumentException("No se permite balance negativo");
        }

        if(ownerName == null || ownerName.isBlank()){
            throw new IllegalArgumentException("Tiene que tenere un owner");
        }

        return new Account(accountId,ownerName,balance);
    }


    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Account other)) {
            return false;
        }

        return Objects.equals(this.accountId, other.accountId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountId);
    }

    public long getAccountId() {
        return accountId;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public double getBalance() {
        return balance;
    }
}
