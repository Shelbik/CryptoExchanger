public class Transfer {
    private ExchangerInterface sourceAccount;

    /**
     *
     * @param sourceAccount
     */
    public Transfer(ExchangerInterface sourceAccount) {
        this.sourceAccount = sourceAccount;
    }

    /**
     *
     * @param destinationAccount
     * @param coin
     * @param amount
     * @return
     */
    public boolean transferCoin(ExchangerInterface destinationAccount, Crypto coin, double amount) {

        if (this.sourceAccount.getAmountOfCoin(coin) < amount) {
            return false;
        }

        if (amount <= this.sourceAccount.getAmountOfCoin(coin)) {
            double previousAmount = this.sourceAccount.getAmountOfCoin(coin);
            double newAmount = previousAmount - amount;
            this.sourceAccount.getEachCoinsAmountByArray().set(this.sourceAccount.getCoinIndexInArray(coin), newAmount);


            if (destinationAccount.getEachCoinYouHaveByArray().contains(coin)) {
                int index = destinationAccount.getCoinIndexInArray(coin);
                double beforeTransfer = destinationAccount.getAmountOfCoin(coin);
                double afterTransfer = beforeTransfer + amount;
                destinationAccount.getEachCoinsAmountByArray().set(index, afterTransfer);
            } else {

                destinationAccount.getEachCoinYouHaveByArray().add(coin);
                destinationAccount.getEachCoinsAmountByArray().add(amount);
            }
            return true;
        }
        return false;
    }
}
