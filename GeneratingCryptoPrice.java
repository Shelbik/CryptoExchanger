import java.util.*;

public class GeneratingCryptoPrice {

    private Datum datum;
    private Crypto[] coinsArray;
    private ArrayList<Double> coinsPrice = new ArrayList<>();

    /**
     *
     * @param datum
     */
    public GeneratingCryptoPrice(Datum datum) {
        this.datum = datum;
        // pridave do array vsetky ENUMY
        this.coinsArray = Crypto.values();
        this.generateArraysForPriceAndCoins();
    }

    /**
     *
     */
    private void generateArraysForPriceAndCoins() {
        for (Crypto crypto : this.coinsArray) {
            this.coinsPrice.add(crypto.getDefaultCryptoCoinPrice(crypto));
        }
    }

    /** Generacia ceny
     *
     */
    public void generateNewPrice() {
        // novy den
        this.datum.nextDay();

        Random randomNumber = new Random();
        // random percenta
        double randomPercentForNewPrice = randomNumber.nextInt(50);
        // cena pojde hore alebo dole
        int priceUpOrDown = randomNumber.nextInt(2);
        randomPercentForNewPrice /= 100;

        boolean priceGoUp = false;

        if (priceUpOrDown == 1) {
            priceGoUp = true;
        } else {
            priceGoUp = false;
        }


        if (priceGoUp) {
            for (int indexInArray = 0; indexInArray < this.coinsPrice.size(); indexInArray++) {
                double oldPrice = (double)this.coinsPrice.get(indexInArray);
                double newPrice = oldPrice + (oldPrice * randomPercentForNewPrice);
                this.coinsPrice.set(indexInArray, newPrice);
            }

        } else {

            for (int indexInArray = 0; indexInArray < this.coinsPrice.size(); indexInArray++) {
                double oldPrice = (double)this.coinsPrice.get(indexInArray);
                double newPrice = oldPrice - (oldPrice * randomPercentForNewPrice);
                this.coinsPrice.set(indexInArray, newPrice);

            }
        }
    }

    /** zobrazuje aktualnu cenu
     *
     */
    public void showActualPrice() {
        for (int index = 0; index < this.coinsArray.length; index++) {
            System.out.println("For coin " + this.coinsArray[index] + " is current price " + this.coinsPrice.get(index) + "$");
        }
    }

    /** zobrazuje aktualnu cenu konkretnej mieny
     *
     * @param crypto
     * @return
     */
    public double getActualCoinPrice(Crypto crypto) {
        for (int index = 0; index < this.coinsArray.length; index++) {
            if (this.coinsArray[index] == crypto) {
                return this.coinsPrice.get(index);
            }
        }
        return 0;
    }
}
