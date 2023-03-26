//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import org.junit.Assert;
import org.junit.Test;

public class AccountTest {
    public AccountTest() {
    }

    @Test
    public void depositTestNegative() {
        Account account = new Account(new Person("Cristiano", "Ronaldo", 5, 2, 1985, 2022), "1111");
        Assert.assertFalse(account.deposit(-1.0));
    }

    @Test
    public void depositTestPositive() {
        Account account = new Account(new Person("Cristiano", "Ronaldo", 5, 2, 1985, 2022), "1111");
        Assert.assertTrue(account.deposit(100.0));
    }

    @Test
    public void withdrawalTestPositive() {
        Account account = new Account(new Person("Cristiano", "Ronaldo", 5, 2, 1985, 2022), "1111");
        account.deposit(100.0);
        Assert.assertTrue(account.withdrawal(100.0));
    }

    @Test
    public void withdrawalTestNegative() {
        Account account = new Account(new Person("Cristiano", "Ronaldo", 5, 2, 1985, 2022), "1111");
        account.deposit(100.0);
        Assert.assertFalse(account.withdrawal(101.0));
    }
}
