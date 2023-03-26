public enum StakingDays {

    Thirty, Sixty, Ninety, OneHundredTwenty;

    /** Vrati Enum objekt podla indexu na kolko dni mozme dat staking
     *
     * @param index
     * @return
     */
    public StakingDays getStakingDaysOptional(int index) {

        switch (index) {
            case 1:
                return Thirty;
            case 2:
                return Sixty;
            case 3:
                return Ninety;
            case 4:
                return OneHundredTwenty;
            default:
                return null;
        }

    }

    /**
     * Vrati percetna podla dni
     * @param days
     * @return
     */
    public double getPercent(StakingDays days) {
        switch (days) {
            case Thirty:
                return 5;
            case Sixty:
                return 7;
            case Ninety:
                return 10;
            case OneHundredTwenty:
                return 15;
            default:
                return 0;

        }
    }

    /**
     * Vrati pocet dni ako cislo
     * @param stakingDays
     * @return
     */
    public int getDaysNumber(StakingDays stakingDays) {
        switch (stakingDays) {
            case Thirty:
                return 30;
            case Sixty:
                return 60;
            case Ninety:
                return 90;
            case OneHundredTwenty:
                return 120;
            default:
                return 0;
        }

    }
}
