import org.junit.Assert;
import org.junit.Test;

public class TradePositionTest {
    public TradePositionTest() {
    }


    @Test
    public void openLongSuccessTest() {
        Account account = new Account(new Person("Cristiano", "Ronaldo", 5, 2, 1985, 2022), "1111");
        account.deposit(10000.0);
        Datum datum = new Datum(1, 9, 2022);
        TradePosition tradePosition = new TradePosition(account,datum);
        tradePosition.openLongPosition(5000,2,35,Crypto.SOL);

        Assert.assertEquals(20000,account.getBalance(),0.0);

    }
}
