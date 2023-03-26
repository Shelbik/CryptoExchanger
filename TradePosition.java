public class TradePosition {

    private Account account;
    private Datum datum;

    /**
     *
     * @param account
     * @param datum
     */
    public TradePosition(Account account, Datum datum) {
        this.account = account;
        this.datum = datum;
    }

    /**
     *
     * @param moneyAmount
     * @param leverage
     * @param awaitingPrice
     * @param crypto
     * @return
     */
    public boolean openShortPosition(double moneyAmount, int leverage, double awaitingPrice, Crypto crypto) {
        if (this.account.getBalance() < moneyAmount) {
            return false;
        }
        int maxLeverage = (int)(this.account.getBalance() * 0.01);
        int currentLeverage;
        if (leverage >= maxLeverage) {
            currentLeverage = maxLeverage;
        } else {
            currentLeverage = leverage;
        }


        GeneratingCryptoPrice generatingCryptoPrice = new GeneratingCryptoPrice(this.datum);
        generatingCryptoPrice.generateNewPrice();
        // pocet peniaze na ktore si bude kupovat coin ked oni padnu v cene
        double moneyForOperation = moneyAmount * currentLeverage;
        // kolko si coins si pozicial od kryptomen obhcodu
        double loandedCoinAmount = (moneyAmount * currentLeverage) / generatingCryptoPrice.getActualCoinPrice(crypto);

        if (awaitingPrice < generatingCryptoPrice.getActualCoinPrice(crypto)) {
            double alreadyReturnCoin = moneyForOperation / awaitingPrice;
            if (alreadyReturnCoin >= loandedCoinAmount) {
                double profit = ((alreadyReturnCoin - loandedCoinAmount) * awaitingPrice) - moneyForOperation;
                this.account.deposit(profit);



                return true;
            }
        } else if (awaitingPrice > generatingCryptoPrice.getActualCoinPrice(crypto)) {
            if (this.account.getBalance() >= moneyAmount * currentLeverage) {
                this.account.withdrawal(moneyAmount * currentLeverage);
            } else {
                // ak nema tolko peniaze aby vratil co pozicial tak sa zobereme jemu vsetko co ma
                this.account.withdrawal(this.account.getBalance());


            }

            return false;

        }
        return false;
    }

    /**
     *
     * @param moneyAmount
     * @param leverage
     * @param awaitingPrice
     * @param crypto
     * @return
     */
    public boolean openLongPosition(double moneyAmount, int leverage, double awaitingPrice, Crypto crypto) {
        if (this.account.getBalance() < moneyAmount) {
            return false;
        }

        int maxLeverage = (int)(this.account.getBalance() * 0.01);
        int currentLeverage;
        if (leverage >= maxLeverage) {
            currentLeverage = maxLeverage;
        } else {
            currentLeverage = leverage;
        }

        GeneratingCryptoPrice generatingCryptoPrice = new GeneratingCryptoPrice(this.datum);
        generatingCryptoPrice.generateNewPrice();
        // pocet peniaze na ktore si bude kupovat coin ked oni padnu v cene
        double moneyForOperation = moneyAmount * currentLeverage;
        // kolko si coins si pozicial od kryptomen obhcodu
        double loandedCoinAmount = (moneyAmount * currentLeverage) / generatingCryptoPrice.getActualCoinPrice(crypto);

        if (awaitingPrice > generatingCryptoPrice.getActualCoinPrice(crypto)) {
            double profit = (loandedCoinAmount * awaitingPrice) - moneyForOperation;
            this.account.deposit(profit);


            return true;

        } else if (awaitingPrice < generatingCryptoPrice.getActualCoinPrice(crypto)) {
            if (this.account.getBalance() >= moneyAmount * currentLeverage) {
                this.account.withdrawal(moneyAmount * currentLeverage);
            } else {
                // ak nema tolko peniaze aby vratil co pozicial tak sa zobereme jemu vsetko co ma
                this.account.withdrawal(this.account.getBalance());


            }

            return false;
        }
        return false;
    }
}
