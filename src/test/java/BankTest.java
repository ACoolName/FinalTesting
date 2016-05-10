/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author teo
 */
public class BankTest {
    
    Account account1, account2;
    Bank bank;
    
    public BankTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        account1 = new Account("Marek");
        account1.setBalance(500);
        account2 = new Account("Peter");
        account2.setBalance(5000);
        bank = new Bank("Best Bank");
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void addAccountSuccessTest() {
        boolean result1 = bank.addAccount(account1);
        assertEquals(1, bank.getAccounts().size());
        boolean result2 = bank.addAccount(account2);
        assertEquals(2, bank.getAccounts().size());
        assertTrue(result1);
        assertTrue(result2);
    }
    
    @Test
    public void addAccountFailTest() {
        bank.addAccount(account1);
        assertEquals(1, bank.getAccounts().size());
        boolean result = bank.addAccount(account1);
        assertEquals(1, bank.getAccounts().size());
        assertFalse(result);
    }
    
    @Test
    public void removeAccountByNameTest() {
        bank.addAccount(account1);
        bank.addAccount(account2);
        Account removedAccount = bank.removeAccountByName("Marek");
        assertEquals("Marek", removedAccount.getName());
        assertEquals(1, bank.getAccounts().size());
    }
    
    @Test
    public void removeAccountByNameFailTest() {
        bank.addAccount(account1);
        bank.addAccount(account2);
        Account removedAccount = bank.removeAccountByName("John");
        assertEquals(null, removedAccount);
        assertEquals(2, bank.getAccounts().size());
    }
    
    @Test
    public void removeAccountByIndexTest() {
        bank.addAccount(account1);
        bank.addAccount(account2);
        Account removedAccount = bank.removeAccountByIndex(0);
        assertEquals("Marek", removedAccount.getName());
        assertEquals(1, bank.getAccounts().size());
    }
    
    @Test
    public void removeAccountByIndexFailTest() {
        bank.addAccount(account1);
        bank.addAccount(account2);
        Account removedAccount = bank.removeAccountByIndex(3);
        assertEquals(null, removedAccount);
        assertEquals(2, bank.getAccounts().size());
    }
    
    @Test
    public void transferSuccessTest() {
        bank.addAccount(account1);
        bank.addAccount(account2);
        boolean result = bank.transfer("Peter", "Marek", 500);
        assertTrue(result);
        assertEquals(1000, account1.getBalance(), 0);
        assertEquals(4500, account2.getBalance(), 0);
    }
    
    @Test
    public void transferFailTest() {
        bank.addAccount(account1);
        bank.addAccount(account2);
        boolean result = bank.transfer("Peter", "Marek", 500);
        assertTrue(result);
        assertEquals(1000, account1.getBalance(), 0);
        assertEquals(4500, account2.getBalance(), 0);
    }
    
    @Test
    public void transferFailInvalidSenderTest() {
        bank.addAccount(account1);
        bank.addAccount(account2);
        boolean result = bank.transfer("John", "Marek", 500);
        assertFalse(result);
        assertEquals(500, account1.getBalance(), 0);
        assertEquals(5000, account2.getBalance(), 0);
    }
    
    @Test
    public void transferFailInvalidReceiverTest() {
        bank.addAccount(account1);
        bank.addAccount(account2);
        boolean result = bank.transfer("Peter", "John", 500);
        assertFalse(result);
        assertEquals(500, account1.getBalance(), 0);
        assertEquals(5000, account2.getBalance(), 0);
    }
    
    @Test
    public void transferFailInvalidAccountsTest() {
        bank.addAccount(account1);
        bank.addAccount(account2);
        boolean result = bank.transfer("John", "Boyko", 500);
        assertFalse(result);
        assertEquals(500, account1.getBalance(), 0);
        assertEquals(5000, account2.getBalance(), 0);
    }
    
    @Test
    public void transferFailSelfToSelfTest() {
        bank.addAccount(account1);
        bank.addAccount(account2);
        boolean result = bank.transfer("Peter", "Peter", 500);
        assertFalse(result);
        assertEquals(500, account1.getBalance(), 0);
        assertEquals(5000, account2.getBalance(), 0);
    }
    
    @Test
    public void transferFailZeroMoneyTest() {
        bank.addAccount(account1);
        bank.addAccount(account2);
        boolean result = bank.transfer("Peter", "Marek", 0);
        assertFalse(result);
        assertEquals(500, account1.getBalance(), 0);
        assertEquals(5000, account2.getBalance(), 0);
    }
    
    @Test
    public void transferFailNegaveAmountTest() {
        bank.addAccount(account1);
        bank.addAccount(account2);
        boolean result = bank.transfer("Peter", "Marek", -500);
        assertFalse(result);
        assertEquals(500, account1.getBalance(), 0);
        assertEquals(5000, account2.getBalance(), 0);
    }
    
    @Test
    public void transferFailInsufficientFundsTest() {
        bank.addAccount(account1);
        bank.addAccount(account2);
        boolean result = bank.transfer("Peter", "Marek", 10000);
        assertFalse(result);
        assertEquals(500, account1.getBalance(), 0);
        assertEquals(5000, account2.getBalance(), 0);
    }
}
