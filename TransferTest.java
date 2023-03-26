import org.junit.Assert;
import org.junit.Test;

public class TransferTest {
    public TransferTest() {
    }


    @Test
    public void transferTest() {
        Account account = new Account(new Person("Cristiano", "Ronaldo", 5, 2, 1985, 2022), "1111");
        account.deposit(10000.0);


        ExchangerInterface exchangerInterface = new ExchangerInterface(account);
        exchangerInterface.buyCoin(5000, Crypto.SOL);

        Account accountForTransfer = new Account(new Person("Lox", "Ronaldo", 5, 2, 1985, 2022), "2222");
        ExchangerInterface exchangerInterfaceAccountForTransfer = new ExchangerInterface(accountForTransfer);

        AccountsMap acoountsMap = new AccountsMap();

        acoountsMap.addAccToMap(account);
        acoountsMap.addAccToMap(accountForTransfer);

        Transfer transfer = new Transfer(exchangerInterface);

        transfer.transferCoin(exchangerInterfaceAccountForTransfer, Crypto.SOL, 100);
        Assert.assertEquals(100, exchangerInterfaceAccountForTransfer.getAmountOfCoin(Crypto.SOL), 0.0);
    }
}
