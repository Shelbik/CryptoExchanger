import java.util.HashMap;

public class AccountsMap {
     private HashMap<Integer, Account> accountHashMap = new HashMap<>();

    /** pridanie ucta do mapy
     *
     * @param account
     * @return
     */
    public boolean addAccToMap(Account account) {
        // ak je ucet null alebo mapa uz obsahuje ucet s takym cislom tak tam ho neprida
        if (account == null || this.accountHashMap.containsKey(account.getAccountsNumber())) {
            return false;
        } else {
            // a mozme hladat ucet podla cisla a dostat ucet ako object
            this.accountHashMap.put(account.getAccountsNumber(), account);
            return true;
        }
    }

    /** Kontrola ci existuje taky ucet a vraca ucet ako objekt
     *
     * @param number
     * @return
     */
        public Account containAcc(int number) {
            return accountHashMap.get(number);
        }

    }

