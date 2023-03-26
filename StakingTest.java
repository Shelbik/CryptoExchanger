import org.junit.Assert;
import org.junit.Test;

public class StakingTest {
    public StakingTest() {
    }

    @Test
    public void stakeCoinTest() {
        Account account = new Account(new Person("Cristiano", "Ronaldo", 5, 2, 1985, 2022), "1111");
        account.deposit(10000.0);
        ExchangerInterface exchangerInterface = new ExchangerInterface(account);
        exchangerInterface.buyCoin(5000, Crypto.BTC);
        Datum datum = new Datum(1, 9, 2022);
        Staking staking = new Staking(exchangerInterface, datum);

        Assert.assertTrue(staking.stakeCoin(Crypto.BTC, StakingDays.Sixty, 0.15));
    }
    @Test
    public void addBonusCoinsAfterStakingToWallet() {
        Account account = new Account(new Person("Cristiano", "Ronaldo", 5, 2, 1985, 2022), "1111");
        account.deposit(10000.0);
        ExchangerInterface exchangerInterface = new ExchangerInterface(account);
        exchangerInterface.buyCoin(5000, Crypto.SOL);
        Datum datum = new Datum(1, 9, 2022);
        Staking staking = new Staking(exchangerInterface, datum);
        staking.stakeCoin(Crypto.SOL, StakingDays.Sixty, 125);
        datum.addDays(60);
        staking.addBonusCoinsAfterStakingToWallet(Crypto.SOL, StakingDays.Sixty);
        Assert.assertEquals(0.142,exchangerInterface.getAmountOfCoin(Crypto.SOL),0.0);
    }
}

