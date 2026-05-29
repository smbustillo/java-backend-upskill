package com.upskill.models;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class AccountTest {

    @Test
    @DisplayName("No deja crear una cuenta con balance negativo")
    void testNegativeBalanceThrowsException() {

        assertThrows(
                IllegalArgumentException.class,
                () -> Account.create(1911, "Susana", -100)
        );
    }

    @Test
    @DisplayName("No deja crear una cuenta con owner a null")
    void testNullOwnerThrowsException() {

        assertThrows(
                IllegalArgumentException.class,
                () -> Account.create(1911, null, 1000)
        );
    }

    @Test
    @DisplayName("No deja crear una cuenta con id a cero")
    void testWithoutIdThrowsException() {

        assertThrows(
                IllegalArgumentException.class,
                () -> Account.create(0, "Susana", 1000)
        );
    }

    @Test
    @DisplayName("Comprueba se crea la cuenta correctamente")
    void testAccountCreation() {

        Account account =
                Account.create(1910, "Susana", 1000);

        assertEquals(1910, account.getAccountId());
        assertEquals("Susana", account.getOwnerName());
        assertEquals(1000.0, account.getBalance());
    }

    @Test
    @DisplayName("Comprueba dos cuentas con solo el id. igual, son la misma cuenta")
    void testAccountEqualityByAccountId() {

        Account a1 =
                Account.create(1915, "Susana", 1000);

        Account a2 =
                Account.create(1915, "Ana", 5000);

        assertEquals(a1, a2);
        assertEquals(a1.hashCode(), a2.hashCode());
    }

    @Test
    @DisplayName("Comprueba dos cuentas que difieren en el id. son diferentes")
    void testAccountInequalityByAccountId() {

        Account a1 =
                Account.create(1915, "Susana", 1000);

        Account a2 =
                Account.create(1914, "Susana", 1000);

        assertNotEquals(a1, a2);

    }

}
