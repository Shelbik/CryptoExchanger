//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import org.junit.Assert;
import org.junit.Test;

public class ExchangerInterfaceTest {
    public ExchangerInterfaceTest() {
    }

    @Test
    public void buyCoinTestPozitive() {
        Account account = new Account(new Person("Cristiano", "Ronaldo", 5, 2, 1985, 2022), "1111");
        account.deposit(100.0);
        ExchangerInterface exchangerInterface = new ExchangerInterface(account);
        Assert.assertTrue(exchangerInterface.buyCoin(100.0, Crypto.BTC));
    }

    @Test
    public void buyCoinTestNegative() {
        Account account = new Account(new Person("Cristiano", "Ronaldo", 5, 2, 1985, 2022), "1111");
        account.deposit(100.0);
        ExchangerInterface exchangerInterface = new ExchangerInterface(account);
        Assert.assertFalse(exchangerInterface.buyCoin(101.0, Crypto.BTC));
    }

    @Test
    public void summaryOfBuyingSameCoinTest() {
        Account account = new Account(new Person("Cristiano", "Ronaldo", 5, 2, 1985, 2022), "1111");
        account.deposit(100.0);
        ExchangerInterface exchangerInterface = new ExchangerInterface(account);
        exchangerInterface.buyCoin(50.0, Crypto.SAND);
        exchangerInterface.buyCoin(50.0, Crypto.SAND);
        Crypto crypto = Crypto.SAND;
        Assert.assertEquals(100.0, exchangerInterface.getAmountOfCoin(crypto), 0.0);
    }
}
