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
public class AccountTest {
    
    public AccountTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void getBalanceTest() {
        String owner = "Marek";
        double amount = 250;
        Account account = new Account(owner);
        assertEquals(0, account.getBalance(), 0);
        account.deposit(amount);   
        assertEquals(amount, account.getBalance(), 0);
        account.deposit(amount);   
        assertEquals(amount * 2, account.getBalance(), 0);
    }

    @Test
    public void depositTest() {
        String owner = "Marek";
        double amount = 500;
        Account account = new Account(owner);
        account.deposit(amount);   
        assertEquals(amount, account.getBalance(), 0);
    }
    
    @Test
    public void withdrawSuccessTest() {
        String owner = "Marek";
        double amount = 500;
        double withdraw = 250;
        Account account = new Account(owner);
        account.deposit(amount);   
        account.withdraw(withdraw);
        assertEquals(amount-withdraw, account.getBalance(), 0);
    }
    
    @Test
    public void withdrawfailTest() {
        String owner = "Marek";
        double amount = 500;
        double withdraw = 600;
        Account account = new Account(owner);
        account.deposit(amount);   
        assertFalse(account.withdraw(withdraw));
        assertEquals(amount, account.getBalance(), 0);
    }
    
    @Test
    public void setBalanceSuccessTest() {
        String owner = "Marek";
        double amount1 = 500;
        double amount2 = 250;
        Account account = new Account(owner);
        account.setBalance(amount1);   
        assertEquals(amount1, account.getBalance(), 0);
        account.setBalance(amount2);
        assertEquals(amount2, account.getBalance(), 0);
    }
    
    @Test
    public void setBalanceFailTest() {
        String owner = "Marek";
        double amount1 = -500;
        Account account = new Account(owner);
        assertFalse(account.setBalance(amount1));
        assertEquals(0, account.getBalance(), 0);
    }
    
    @Test
    public void getNameTest() {
        String owner = "Marek";
        Account account = new Account(owner);
        assertEquals(owner, account.getName());
    }
}
