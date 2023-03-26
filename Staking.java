import java.util.ArrayList;

public class Staking {

    private ArrayList<Double> stakedCoinsAmountArray = new ArrayList<>();
    private ArrayList<Crypto> stakedCoinsNameArray = new ArrayList<>();
    private ArrayList<Double> stakedPercentArray = new ArrayList<>();
    private Datum datum;
    private Datum secondDatum;


    private ExchangerInterface exchangerInterface;
    private double bonusCoinsAmountByStaking = 0;


    /**
     *
     * @param exchangerInterface
     * @param datum
     */
    public Staking(ExchangerInterface exchangerInterface, Datum datum) {
        this.datum = datum;
        // druhy datum pre porovnanie ci preslo urcity pocet dni od zaciatku staking
        this.secondDatum = new Datum(this.datum.getDay(), this.datum.getMonth(), this.datum.getYear());

        this.exchangerInterface = exchangerInterface;
    }


    public void infoAboutStaking() {
        System.out.println("Hello, on our exchange make a staking for the next number of days : 30, 60, 90, 120");
        System.out.println("Another days are not available for staking.");
    }

    /**
     *
     * @param coin
     * @param daysNumberForStake
     * @param coinsAmount
     * @return
     */
    public boolean stakeCoin(Crypto coin, StakingDays daysNumberForStake, double coinsAmount) {
        // pridave do druheho datumu zvoleny pocet dni na ktory miena bude nedostupna
        this.secondDatum.addDays(daysNumberForStake.getDaysNumber(daysNumberForStake));
        return this.stakingCoinProcess(coin, daysNumberForStake, coinsAmount);
    }

    /** Po ukonceni STAKING pridame bonus coins na nas ucet
     *
     * @param crypto
     * @param stakingDays
     * @return
     */

    /**
     *
     * @param crypto
     * @param stakingDays
     * @return
     */
    public boolean addBonusCoinsAfterStakingToWallet(Crypto crypto, StakingDays stakingDays) {
        // ak datumy su zhodne az vtedy nam dovoli prebrat bonus
        if (this.datum.getDay() == this.secondDatum.getDay() && (this.datum.getMonth() == this.secondDatum.getMonth()) && (this.datum.getYear() == this.secondDatum.getYear())) {
            this.addCoinToArray(this.exchangerInterface.getCoinIndexInArray(crypto));
            return true;
        } else {
            System.out.println("Now you can`t get bonus coins");
            System.out.println("This option will be available at ");
            this.secondDatum.list();
            return false;
        }
    }

    /**
     *
     * @return
     */
    public ArrayList<Double> getStakedCoinsAmountArray() {
        return this.stakedCoinsAmountArray;
    }
    /**
     *
     * @return
     */
    public ArrayList<Crypto> getStakedCoinsNameArray() {
        return this.stakedCoinsNameArray;
    }
    /**
     *
     * @return
     */
    public ArrayList<Double> getStakedPercentArray() {
        return this.stakedPercentArray;
    }

    /** Vypise vsetky miena ktore su v STAKING
     *
     */
    public void getAllInfoAboutStakedCoinsInfo() {
        for (int i = 0; i < this.stakedCoinsNameArray.size(); i++) {
            System.out.println("Coin " + this.stakedCoinsNameArray.get(i) + " is staked in amount "
                    + this.stakedCoinsAmountArray.get(i) + " in " + this.stakedPercentArray.get(i) + "% for "
                    + this.getDaysFromPercent(this.stakedPercentArray.get(i)) + " days.");
        }
    }

    private int getDaysFromPercent(double percent) {
        int days;
        switch ((int)percent) {
            case 5:
                days = 30;
                break;
            case 7:
                days = 60;
                break;
            case 10:
                days = 90;
                break;
            case 15:
                days = 120;
                break;
            default:
                days = 0;
                break;

        }
        return days;
    }

    /** overi ci clovek ma tolko coins na ucte
     *
     * @param amount
     * @param index
     * @return
     */
    private boolean checkCoinsAmount(double amount, int index) {
        return amount <= this.exchangerInterface.getEachCoinsAmountByArray().get(index);
    }

    /** zoberie z ucta tolko coins kolko clovek ulozil do STAKING
     *
     * @param amount
     * @param index
     * @return
     */
    private boolean removeCoinFromArray(double amount, int index) {
        double amountCoinsOnThisIndex = this.exchangerInterface.getEachCoinsAmountByArray().get(index);

        if (amount <= amountCoinsOnThisIndex) {
            // zvysok po staking
            double remainingCoinsAmountAfterStaking = amountCoinsOnThisIndex - amount;
            /** nastavujeme zvysok do arrayList

             **/
            this.exchangerInterface.getEachCoinsAmountByArray().set(index, remainingCoinsAmountAfterStaking);
            return true;
        } else {
            return false;
        }

    }

    /**
     *
     * @param index
     */

    private void addCoinToArray(int index) {
        double previousAmountOfCoins = this.stakedCoinsAmountArray.get(index);

        double futureCoinsAmountAfterStaking = previousAmountOfCoins + bonusCoinsAmountByStaking;

        this.removeIndexFromAllArraysForStaking(index);

        this.exchangerInterface.getEachCoinsAmountByArray().add(index, futureCoinsAmountAfterStaking);

    }

    /** po Staking vymaze vsade
     *
     * @param index
     */
    private void removeIndexFromAllArraysForStaking(int index) {
        this.getStakedCoinsNameArray().remove(index);
        this.getStakedCoinsAmountArray().remove(index);
        this.getStakedPercentArray().remove(index);

    }

    /**
     * Process stakingu
     * @param coinToStake
     * @param daysNumberForStake
     * @param coinsAmount
     * @return
     */
    private boolean stakingCoinProcess(Crypto coinToStake, StakingDays daysNumberForStake, double coinsAmount) {
        // zistime percenta podla dni
        double percentFromStakingDays = daysNumberForStake.getPercent(daysNumberForStake);
        this.bonusCoinsAmountByStaking = coinsAmount / percentFromStakingDays;
        this.stakedPercentArray.add(percentFromStakingDays);


        if (this.checkCoinsAmount(coinsAmount, this.exchangerInterface.getCoinIndexInArray(coinToStake))) {
            this.stakedCoinsNameArray.add(coinToStake);
            this.stakedCoinsAmountArray.add(coinsAmount);

            this.removeCoinFromArray(coinsAmount, this.exchangerInterface.getCoinIndexInArray(coinToStake));

            return true;

        } else {
            return false;
        }
    }


}








