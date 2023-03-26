
import java.util.ArrayList;

public class ExchangerInterface {
    // atributy
    private Account account;

    private ArrayList<Crypto> cryptoBase = new ArrayList<>();
    private ArrayList<Double> fullCoinsAmount = new ArrayList<>();

    /**
     *
     * @param account
     */

    public ExchangerInterface(Account account) {

        this.account = account;

    }

    /** nakup kryptomeny
     *
     * @param money
     * @param cryptoCoin
     * @return
     */
    public boolean buyCoin(double money, Crypto cryptoCoin) {
        return this.buyingCoinProcess(money, cryptoCoin);
    }

    /** predaj kryptomeny
     *
     * @param coinsAmount
     * @param cryptoCoin
     * @return
     */
    public boolean sellCoin(double coinsAmount, Crypto cryptoCoin) {
        return this.sellingCoinProcess(coinsAmount, cryptoCoin);
    }

    /** vypis vsetkych nasych mien
     *
     */
    public void getCoinsInfo() {
        for (int coinIndex = 0; coinIndex < this.cryptoBase.size(); coinIndex++) {
            System.out.println("Coin " + this.cryptoBase.get(coinIndex) + " is in amount " + this.fullCoinsAmount.get(coinIndex));
        }
    }

    /**
     *
     * @return
     */
    public ArrayList<Crypto> getEachCoinYouHaveByArray() {
        return this.cryptoBase;
    }

    /**
     *
     * @return
     */
    public ArrayList<Double> getEachCoinsAmountByArray() {
        return this.fullCoinsAmount;
    }

    /** pomocna metoda aby sme vedeli na ktorom indexe sa nachadza nasa miena
     *
     * @param coin
     * @return
     */
    public int getCoinIndexInArray(Crypto coin) {
        return this.getEachCoinYouHaveByArray().indexOf(coin);

    }

    /** vypise kolko mame mnozstva mien podla objektu
     *
     * @param coin
     * @return
     */
    public double getAmountOfCoin(Crypto coin) {
        return this.fullCoinsAmount.get(this.getCoinIndexInArray(coin));
    }

    /** proces nakupu mieny
     *
     * @param money
     * @param coin
     * @return
     */
    private boolean buyingCoinProcess(double money, Crypto coin) {
        // mnozstvo
        double coinAmount = money / coin.getDefaultCryptoCoinPrice(coin);
        // nemozeme mouzit viac peniazov ako mame na ucte
        if (money > this.account.getBalance()) {
            return false;

        } else {
            // ak uz mame na ucte  danu kryptomenu tak len pripocitame cislo
            if (this.cryptoBase.contains(coin)) {
                double currentCoinAmountAtAccount = this.fullCoinsAmount.get(this.cryptoBase.indexOf(coin));  // plus amount of coints on cryptocoin index
                currentCoinAmountAtAccount += coinAmount;
                this.account.withdrawal(money);
                this.fullCoinsAmount.set(this.cryptoBase.indexOf(coin), currentCoinAmountAtAccount);


            } else {
                // ak nemame na ucte tak len doplnime
                this.cryptoBase.add(coin);
                this.fullCoinsAmount.add(coinAmount);
                this.account.withdrawal(money);
            }
        }
        return true;
    }

    /** process predaja mien
     *
     * @param coinsAmount
     * @param cryptoCoin
     * @return
     */
    private boolean sellingCoinProcess(double coinsAmount, Crypto cryptoCoin) {
        // podla objektu ziskame mnozstvo kolko mame na ucte
        int amountOfCoinToSell = this.cryptoBase.indexOf(cryptoCoin);
        // skontrolujeme ci pozadovane mnozstvo je menej alebo sa rovna to kolko mame
        if (coinsAmount <= this.fullCoinsAmount.get(amountOfCoinToSell)) {
            double moneyAfterSaleCoin = coinsAmount * cryptoCoin.getDefaultCryptoCoinPrice(cryptoCoin);
            // zistime kolko mame
            double currentCoinAmount = this.fullCoinsAmount.get(amountOfCoinToSell);
            currentCoinAmount -= coinsAmount;
            // prenastavujeme mnozstva
            this.fullCoinsAmount.set(amountOfCoinToSell, currentCoinAmount);
            this.account.deposit(moneyAfterSaleCoin);
            return true;

        } else {
            return false;
        }
    }

}


