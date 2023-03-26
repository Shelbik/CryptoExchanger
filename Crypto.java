public enum Crypto {

    //ENUMY
    BTC, ETH, SOL, APE, SAND, ATOM, BNB;

    /** DOSTAT enum podla indexu
     *
     * @param optionalNumber
     * @return
     */
    public Crypto getCryptoCoin(int optionalNumber) {
        switch (optionalNumber) {
            case 1:
                return Crypto.BTC;
            case 2:
                return Crypto.ETH;
            case 3:
                return Crypto.SOL;
            case 4:
                return Crypto.APE;
            case 5:
                return Crypto.SAND;
            case 6:
                return Crypto.ATOM;
            case 7:
                return Crypto.BNB;
            default:
                return null;


        }


    }

    /** dostat default cenu podla vybratej kryptomeny
     *
     * @param cryptoCoin
     * @return
     */
    public double getDefaultCryptoCoinPrice(Crypto cryptoCoin) {
        switch (cryptoCoin) {
            case BTC:
                return 21000;
            case ETH:
                return 1600;
            case SOL:
                return 40;
            case APE:
                return 5.5;
            case SAND:
                return 1;
            case ATOM:
                return 2;
            case BNB:
                return 300;
            default:
                return -1;
        }

    }

}
