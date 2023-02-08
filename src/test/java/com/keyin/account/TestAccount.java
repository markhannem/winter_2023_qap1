package com.keyin.account;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestAccount {
    // MAIN OUTPUTS
    public static void main(String[] args) {
        // Creating 2 Accounts
        Account A1 = new Account("123", "Mark Hannem", 5000);
        Account A2 = new Account("124", "Brad Hannem", 4000);

        // Initial balances

        System.out.println("Account 1 Balance: " + A1.getBalance());
        System.out.println("Account 2 Balance: " + A2.getBalance());

        // 1000 transfer from A1 to A2
        A1.transferTo(1000, A2);

        System.out.println("Account 1 Closing Balance: " + A1.getBalance());
        System.out.println("Account 2 Closing Balance: " + A2.getBalance());
    }

    // TESTS

    // TEST1: Test to see if a transfer will work as intended.
    @Test
    public void testTransfer() {
        // 2 accounts: Mark & Brad
        Account A1 = new Account("123", "Mark", 200);
        Account A2 = new Account("124", "Brad", 0);

        // transfer 100 to brads account
        A1.transferTo(100, A2);

        // Test Case: is balance 100?
        Assertions.assertTrue(A2.getBalance() == 100);

        System.out.println("Account 1 balance: " + A1.getBalance());
        System.out.println("Account 2 balance: " + A2.getBalance());
    }

    // TEST2: Test to see if a transfer higher than amount in the account will fail
    // and reject the transfer of money
    @Test
    public void testTransferLowBalance() {
        // 2 accounts: Mark & Brad
        Account A1 = new Account("123", "Mark", 50);
        Account A2 = new Account("124", "Brad", 0);

        // transfer 100 to brads account
        A1.transferTo(100, A2);

        // Test Case: is balance not 100?
        Assertions.assertFalse(A2.getBalance() == 100);

        System.out.println("Account 1 balance: " + A1.getBalance());
        System.out.println("Account 2 balance: " + A2.getBalance());
    }

    // TEST3: Test to show balance transfer as in Dr.Malik's QAP1
    @Test
    public void testTransferAsInQAP() {
        Account A1 = new Account("123", "Mark", 5000);
        Account A2 = new Account("124", "Brad", 4000);

        // transfer 1000 to brads account
        A1.transferTo(1000, A2);

        // Test Case: is balance 5000?
        Assertions.assertTrue(A2.getBalance() == 5000.00);

        System.out.println("Account 1 balance: " + A1.getBalance());
        System.out.println("Account 2 balance: " + A2.getBalance());
    }

    // TEST4: Test account withdraw amount with enough in account
    @Test
    public void testDebitWithdrawSufficient() {
        Account A3 = new Account("125","Bob", 500);

        A3.debit(100);

        // Test Case: is balance 400?
        Assertions.assertEquals(400, A3.getBalance());

        System.out.println("Account 3 balance: " + A3.getBalance());

    }


    // TEST4: Test account withdraw amount with not enough in account
    @Test
    public void testDebitWithdrawInsufficient() {
        Account A3 = new Account("125","Bob", 100);

        A3.debit(500);

        // Test Case: is balance 100?
        Assertions.assertEquals(100, A3.getBalance());

        System.out.println("Account 3 balance: " + A3.getBalance());

    }

    // TEST5: Test account deposit
    @Test
    public void testDeposit() {
        Account A3 = new Account("125","Bob", 100);

        A3.credit(100);

        // Test Case: is balance 100?
        Assertions.assertEquals(200, A3.getBalance());

        System.out.println("Account 3 balance: " + A3.getBalance());

    }


}
