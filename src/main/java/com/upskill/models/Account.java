package com.upskill.models;

public record Account (
        long accountId,
        String ownerName,
        double balance
) {

    public static Account of(
            long accountId,
            String ownerName,
            double balance
    ){

        if(accountId < 0) {
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
}
