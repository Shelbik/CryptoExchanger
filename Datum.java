public class Datum {
    /**
     * @author (Vitalii Martiniuc)
     * @version (9.01.2022)
     */

    //atributs
    private int day;
    private int month;
    private int year;

    /**
     *
     * @param day
     * @param month
     * @param year
     */
    public Datum(int day, int month, int year) {
        this.setDay(day);
        this.setMonth(month);
        this.setYear(year);

    }


    /** show us if year is leap or not
     *
     * @return
     */
    public boolean isLeapYear() {
        return ((((this.year % 4) == 0) && ((this.year % 100) != 0)) || ((this.year % 400) == 0));
    }

    /**
     *
     * @return
     */
    private int giveTheNumberOfDaysInTheMonth() {
        switch (this.month) {
            case 2:
                if (this.isLeapYear()) {
                    return 29;
                } else {
                    return 28;
                }

            case 4:
            case 6:
            case 9:
            case 11:
                return 30;

            default:
                return 31;
        }
    }

    /** show us the datum we choose
     *
     */
    public void list() {
        System.out.println(this.day + "." + this.month + "." + this.year);
    }

    /** vrati zvoleny den
     *
     * @return
     */
    public int getDay() {
        return this.day;
    }

    /** vrati zvoleny mesiac
     *
     * @return
     */
    public int getMonth() {
        return this.month;
    }

    /** Vrati zvoleny rok
     *
     * @return
     */
    public int getYear() {
        return this.year;
    }

    /** nastavujeme den ktory chceme
     *
     * @param newDay
     */
    private void setDay(int newDay) {
        // kontrola ci den je  viac ako jedna a menej ako max pocet dni v tomto mesiaci
        if (newDay < 1 || newDay > this.giveTheNumberOfDaysInTheMonth()) {
            this.day = 1;
        } else {
            this.day = newDay;
        }

    }

    /** nastavujeme mesiac ktory chceme
     *
     * @param month
     */
    private void setMonth(int month) {
        // kontrola ci je viac ako 0 a menej alebo rovnasa poctu max mesiacev v roku
        if (month > 0 && month <= 12) {
            this.month = month;
        } else {
            this.month = 1;
        }
    }

    /**
     *
     * @param year
     */
    private void setYear(int year) {
        this.year = Math.max(year, 2022);
    }

    /** celkova zmena Datumu
     *
     * @param dayNumber
     * @param monthNumber
     * @param yearNumber
     */
    public void setDate(int dayNumber, int monthNumber, int yearNumber) {
        this.setDay(dayNumber);
        this.setMonth(monthNumber);
        this.setYear(yearNumber);
    }

    /** prida den
     *
     * @return
     */
    public int nextDay() {
        this.setDay(this.day + 1);
        return  this.day;
    }

    /** prida mesiac
     *
     * @return
     */
    public int nextMonth() {
        this.setMonth(this.month + 1);
        return this.month;
    }

    /** prida rok
     *
     * @return
     */
    public int nextYear() {
        this.setYear(this.year + 1);
        return this.year;
    }

    /** pridava neurcety pocet dni
     *
     * @param days
     * @return
     */
    public int addDays(int days) {
        this.day += days;
        // pokial pocet dni je viac ako max v mesiaci tak odpocitavae a pridavame pocet mesiacov
        while (this.day > this.giveTheNumberOfDaysInTheMonth()) {
            int temp = this.day - this.giveTheNumberOfDaysInTheMonth();
            this.day = temp;
            this.nextMonth();

        }
        return this.day;
    }
}

