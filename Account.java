/**
 *
 *
 * @author (Vitalii Martiniuc)
 * @version (9.01.2022)
 */




public class Account {
    //atributs
    private String password;
    private double balance = 0;
    private Person person;
    private PasswordControl ps;

    private static int grow = 1;

    private final int accountNumber;


    /**
     *
     * @param person
     * @param password
     */

    public Account(Person person, String password) {
        this.person = person;
        this.password = password;
        this.accountNumber = getGrow();
        grow++;

        if (this.person.isAdult()) {
            System.out.println("Welcome to crypto World");

        }

    }

    /** vyuziva sa na vypocitanie cislo uctu
     *
     * @return
     */
    public static int getGrow() {
        return grow;
    } //

    /** vraca cislo uctu
     *
     * @return
     */
    public int getAccountsNumber() {
        return this.accountNumber;
    }

    /** vraca heslo
     *
     * @return
     */
    public String getPassword() {
        return this.password;
    }

    /** nastavenie noveho hesla
     *
     * @param password
     */
    public void setNewPassword(String password) {
        this.ps.setNewPassword(password);
    }

    /** vraca pocet peniazi na ucte
     *
     * @return
     */
    public double getBalance() {
        return this.balance;
    }

    /** vkladanie penize na ucet
     *
     * @param money
     * @return
     */
    public boolean deposit(double money) {
        // pocet peniazov musi byt kladny
        if (money > 0) {
            this.balance += money;
            return true;
        } else {
            return false;

        }
    }

    /** vybranie z uctu
     *
     * @param money
     * @return
     */
    public boolean withdrawal(double money) {
        // nedasa vybrat viac ako je na ucte
        if (money <= balance) {
            this.balance -= money;
            return true;
        } else {
            return false;

        }
    }

}



