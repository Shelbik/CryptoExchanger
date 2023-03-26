import java.util.*;


public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static Person person;
    private static Account account;
    private static AccountsMap acoountsMap;
    private static PasswordControl passwordControl;


    private static Staking staking;

    private static ExchangerInterface exchangerInterface;

    private static Datum date;

    private static StakingDays stakingDays;

    private static Transfer transfer;

    private static Crypto crypto;

    private static TradePosition tradePosition;

    private static GeneratingCryptoPrice generatingCryptoPrice;


    public static void main(String[] args) {
        System.out.println("Welcome to Binance Application");
        System.out.println("Lets make your account at our crypto market");
        System.out.println("Enter your first name please");
        String firstName = scanner.nextLine();
        System.out.println("Enter your second name please");
        String secondName = scanner.nextLine();
        System.out.println("Enter day number of your birth please");
        int dayOfBirth = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter month number of your birth please");
        int mountOfBirth = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter year number of your birth please");
        int yearOfBirth = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter current year please");
        int currentYear = scanner.nextInt();
        scanner.nextLine();
        person = new Person(firstName, secondName, dayOfBirth, mountOfBirth, yearOfBirth, currentYear);
        Account accountForTransfer = new Account(new Person("Cristiano", "Ronaldo", 5, 2, 1985, 2022), "2222");


        // ****************************************** 2 **************************************************
        System.out.println("Now lets create your account at our market");
        System.out.println("Create the password");
        String password = scanner.nextLine();
        account = new Account(person, password);

        acoountsMap = new AccountsMap();

        acoountsMap.addAccToMap(account);
        acoountsMap.addAccToMap(accountForTransfer);


        passwordControl = new PasswordControl(account);
        exchangerInterface = new ExchangerInterface(account);
        date = new Datum(27, 11, 2022);
        staking = new Staking(exchangerInterface, date);
        generatingCryptoPrice = new GeneratingCryptoPrice(date);
        generatingCryptoPrice.generateNewPrice();
        transfer = new Transfer(exchangerInterface);
        tradePosition = new TradePosition(account, date);

        crypto = Crypto.BTC;
        stakingDays = StakingDays.Ninety;


        showOptions();


    }

    private static void showOptions() {

        System.out.println("To choose the option of our app, just write the number of option to the console.\n");
        System.out.println("Binance App Sections: ");
        System.out.println("1 - Person");
        System.out.println("2 - Account");
        System.out.println("3 - ExchangerInterface");
        System.out.println("4 - Staking");
        System.out.println("5 - Transfer");
        System.out.println("6 - Open Trade Position");
        System.out.println("7 - Check current coin`s price");
        System.out.println("8 - Datum");
        System.out.println("0 - Exit the App");

        int sectionChoise = scanner.nextInt();
        scanner.nextLine();

        switch (sectionChoise) {
            case 1:
                showPersonOptions(person);
                break;
            case 2:
                showAccountOptions(account);
                break;
            case 3:
                showExchangerInterfaceOptions(exchangerInterface);
                break;
            case 4:
                showStakingOptions(exchangerInterface);
                break;
            case 5:
                showTransferOptions(exchangerInterface);
                break;
            case 6:
                showTradePositionOptions(account, date);
                break;
            case 7:
                showCurrentCoinsPrice();
                break;
            case 8:
                showDatumOptions(date);
                break;
            case 0:
                System.out.println("See you next time");
                scanner.close();
                break;
            default:
                System.out.println("Your option doesnt exist");
                System.out.println("Choose one more time");
                showOptions();
                break;
        }

    }


    private static void showPersonOptions(Person person) {
        System.out.println("Welcome to Person Menu");
        System.out.println("Press number on your keybord to choose the option");
        System.out.println("1 - get First Name");
        System.out.println("2 - set First Name ");
        System.out.println("3 - get Second Name");
        System.out.println("4 - set Second Name ");
        System.out.println("5 - get Age");
        System.out.println("6 - check if you are Adult");
        System.out.println("0 - back to main menu");
        int option = scanner.nextInt();
        scanner.nextLine();
        switch (option) {
            case 1:
                System.out.println(person.getFirstName());
                showPersonOptions(person);
                break;
            case 2:
                System.out.println("Enter your new first name");
                person.setFirstName(scanner.nextLine());
                showPersonOptions(person);
                break;
            case 3:
                System.out.println(person.getSecondName());
                showPersonOptions(person);
                break;
            case 4:
                System.out.println("Enter your new second name");
                person.setSecondName(scanner.nextLine());
                showPersonOptions(person);
                break;
            case 5:
                System.out.println(person.getAge());
                showPersonOptions(person);
                break;
            case 6:
                System.out.println(person.isAdult());
                showPersonOptions(person);
                break;
            case 0:
                showOptions();
                break;
            default:
                System.out.println("Your option doesnt exist");
                System.out.println("Choose one more time");
                showPersonOptions(person);
                break;
        }


    }

    private static void showAccountOptions(Account account) {
        System.out.println("Welcome to Account Menu");
        System.out.println("Press number on your keybord to choose the option");
        System.out.println("1 - get Account Number");
        System.out.println("2 - get Password");
        System.out.println("3 - get Balance");
        System.out.println("4 - deposit");
        System.out.println("5 - withdrawal");
        System.out.println("0 - back to main menu");

        int option = scanner.nextInt();
        switch (option) {
            case 1:
                System.out.println(account.getAccountsNumber());
                showAccountOptions(account);
                break;
            case 2:
                System.out.println(account.getPassword());
                showAccountOptions(account);
                break;
            case 3:
                System.out.println(account.getBalance());
                showAccountOptions(account);
                break;
            case 4:
                System.out.println("Enter amount you want to deposit");
                account.deposit(scanner.nextInt());
                scanner.nextLine();
                showAccountOptions(account);
                break;
            case 5:
                System.out.println("Enter amount you want to withdrawal");
                account.withdrawal(scanner.nextInt());
                scanner.nextLine();
                showAccountOptions(account);
                break;
            case 0:
                showOptions();
                break;
            default:
                System.out.println("Your option doesnt exist");
                System.out.println("Choose one more time");
                showAccountOptions(account);
                break;
        }
    }

    private static void showExchangerInterfaceOptions(ExchangerInterface exchangerInterface) {
        System.out.println("Welcome to Exchanger Interface Menu");
        System.out.println("Press number on your keybord to choose the option");
        System.out.println("1 - buy Coin");
        System.out.println("2 - sell Coin");
        System.out.println("3 - get info about Coins");
        System.out.println("4 - see list of your coins");
        System.out.println("5 - see list of your coins amount");
        System.out.println("0 - back to main menu");

        int option = scanner.nextInt();
        switch (option) {
            case 1:
                System.out.println("At our exchanger you can buy these coins ");
                showCryptoCoinIndexs();
                System.out.println("Type the money amount you want to spend");
                int money = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Choose index of crypto coin");
                int indexForBuying = scanner.nextInt();
                scanner.nextLine();
                exchangerInterface.buyCoin(money, crypto.getCryptoCoin(indexForBuying));

                showExchangerInterfaceOptions(exchangerInterface);
                break;
            case 2:
                System.out.println("Type the coin`s amount you want to sell");
                double coinAmount = scanner.nextInt();
                scanner.nextLine();
                showCryptoCoinIndexs();
                System.out.println("Choose index of crypto coin");
                int indexForSelling = scanner.nextInt();
                scanner.nextLine();
                exchangerInterface.sellCoin(coinAmount, crypto.getCryptoCoin(indexForSelling));
                showExchangerInterfaceOptions(exchangerInterface);
                break;
            case 3:
                exchangerInterface.getCoinsInfo();
                showExchangerInterfaceOptions(exchangerInterface);
                break;
            case 4:
                System.out.println(exchangerInterface.getEachCoinYouHaveByArray());
                showExchangerInterfaceOptions(exchangerInterface);
                break;
            case 5:
                System.out.println(exchangerInterface.getEachCoinsAmountByArray());
                showExchangerInterfaceOptions(exchangerInterface);
                break;
            case 0:
                showOptions();
                break;
            default:
                System.out.println("Your option doesnt exist");
                System.out.println("Choose one more time");
                showExchangerInterfaceOptions(exchangerInterface);
                break;
        }

    }

    private static void showStakingOptions(ExchangerInterface exchangerInterface) {
        System.out.println("Welcome to Staking Menu");
        System.out.println("Press number on your keybord to choose the option");
        System.out.println("1 - Info about Staking");
        System.out.println("2 - Stake coin");
        System.out.println("3 - add Bonus Coins After Staking To Wallet");
        System.out.println("4 - get All Info About Staked Coins Info");
        System.out.println("0 - back to main menu");


        int option = scanner.nextInt();
        switch (option) {
            case 1:
                staking.infoAboutStaking();
                showStakingOptions(exchangerInterface);
                break;
            case 2:
                System.out.println("At our exchanger you can on this days number");
                showStakingDaysIndexs();
                System.out.println("Write index of days you want to stake");
                int indexDaysForStaking = scanner.nextInt();
                scanner.nextLine();

                System.out.println("Type the coin amount you want to stake");
                int coinsAmount = scanner.nextInt();
                scanner.nextLine();

                showCryptoCoinIndexs();
                System.out.println("Choose index of crypto coin");
                int indexCoinForStaking = scanner.nextInt();
                scanner.nextLine();
                staking.stakeCoin(crypto.getCryptoCoin(indexCoinForStaking), stakingDays.getStakingDaysOptional(indexDaysForStaking), coinsAmount);
                showStakingOptions(exchangerInterface);
                break;

            case 3:
                System.out.println("Choose index of crypto coin");
                int indexForStaking = scanner.nextInt();
                scanner.nextLine();

                System.out.println("Write index on how much days you staked coins");
                showStakingDaysIndexs();
                int indexStakedDays = scanner.nextInt();
                scanner.nextLine();
                staking.addBonusCoinsAfterStakingToWallet(crypto.getCryptoCoin(indexForStaking), stakingDays.getStakingDaysOptional(indexStakedDays));
                break;
            case 4:
                staking.getAllInfoAboutStakedCoinsInfo();
                showStakingOptions(exchangerInterface);
                break;
            case 0:
                showOptions();
                break;

            default:
                System.out.println("Your option doesnt exist");
                System.out.println("Choose one more time");
                showStakingOptions(exchangerInterface);
                break;
        }
    }

    private static void showTransferOptions(ExchangerInterface exchangerInterface) {
        System.out.println("Welcome to Person Menu");
        System.out.println("Press number on your keybord to choose the option");
        System.out.println("1 - transfer Coin");
        System.out.println("0 - back to main menu");
        int option = scanner.nextInt();
        scanner.nextLine();
        switch (option) {
            case 1:
                System.out.println("Account`s number you want to make transfer");
                int accountDurationNumber = scanner.nextInt();
                scanner.nextLine();

                System.out.println("Enter CryptoCoin index you want to send");
                showCryptoCoinIndexs();
                int coinIndex = scanner.nextInt();
                scanner.nextLine();

                System.out.println("Enter amount you want to send");
                double coinAmountToTrasnfer = scanner.nextInt();
                scanner.nextLine();

                if (acoountsMap.containAcc(accountDurationNumber) != null) {
                    ExchangerInterface exchangerInterfaceToTrasnfer = new ExchangerInterface(acoountsMap.containAcc(accountDurationNumber));

                    transfer.transferCoin(exchangerInterfaceToTrasnfer, crypto.getCryptoCoin(coinIndex), coinAmountToTrasnfer);
                    exchangerInterfaceToTrasnfer.getCoinsInfo();
                    exchangerInterface.getCoinsInfo();
                } else {
                    System.out.println("Account with this number doesnt exists");
                    showTransferOptions(exchangerInterface);
                }
                showTransferOptions(exchangerInterface);
                break;
            case 0:
                showOptions();
                break;
            default:
                System.out.println("Your option doesnt exist");
                System.out.println("Choose one more time");
                showTransferOptions(exchangerInterface);
                break;
        }
    }

    private static void showDatumOptions(Datum datum) {
        System.out.println("Welcome to Datum Menu");
        System.out.println("Press number on your keybord to choose the option");
        System.out.println("1 - Check if year is Leap");
        System.out.println("2 - Show current date");
        System.out.println("3 - Get current Day");
        System.out.println("4 - Get current Month");
        System.out.println("5 - Get current Year");
        System.out.println("6 - Set New Datum");
        System.out.println("7 - Add one day");
        System.out.println("8 - Add one month");
        System.out.println("9 - Add one Year");
        System.out.println("10 - Add days how much you want");
        System.out.println("0 - Show main menu options");

        int option = scanner.nextInt();
        scanner.nextLine();
        switch (option) {
            case 1:
                System.out.println(datum.isLeapYear());
                showDatumOptions(datum);
                break;
            case 2:
                datum.list();
                showDatumOptions(datum);
                break;
            case 3:
                System.out.println(datum.getDay());
                showDatumOptions(datum);
                break;
            case 4:
                System.out.println(datum.getMonth());
                showDatumOptions(datum);
                break;
            case 5:
                System.out.println(datum.getYear());
                showDatumOptions(datum);
                break;
            case 6:
                System.out.println("Write to the console new day number");
                int setNewDay = scanner.nextInt();
                scanner.nextLine();

                System.out.println("Write to the console new month number");
                int setNewMonth = scanner.nextInt();
                scanner.nextLine();

                System.out.println("Write to the console new year number");
                int setNewYear = scanner.nextInt();
                scanner.nextLine();

                datum.setDate(setNewDay, setNewMonth, setNewYear);
                showDatumOptions(datum);
                break;
            case 7:
                datum.nextDay();
                showDatumOptions(datum);
                break;
            case 8:
                datum.nextMonth();
                showDatumOptions(datum);
                break;
            case 9:
                datum.nextYear();
                showDatumOptions(datum);
                break;
            case 10:
                System.out.println("Write number days you want to skip ");
                int daysForAdd = scanner.nextInt();
                scanner.nextLine();
                datum.addDays(daysForAdd);
                showDatumOptions(datum);
                break;
            case 0:
                showOptions();
                break;
            default:
                System.out.println("Your option doesnt exist");
                System.out.println("Choose one more time");
                showDatumOptions(datum);
                break;

        }
    }

    private static void showTradePositionOptions(Account account, Datum datum) {
        int coinIndex;
        double awaitingPrice;
        double moneyAmount;
        int leverage;

        System.out.println("Welcome to Trade Position Menu");
        System.out.println("Press number on your keybord to choose the option");
        System.out.println("1 - Open short position");
        System.out.println("2 - Open long position");
        System.out.println("0 - Show main menu options");

        int option = scanner.nextInt();
        scanner.nextLine();
        switch (option) {
            case 1:
                System.out.println("Enter money amount you want to use for trade");
                moneyAmount = scanner.nextInt();
                scanner.nextLine();

                System.out.println("Enter leverage");
                leverage = scanner.nextInt();
                scanner.nextLine();

                generatingCryptoPrice.showActualPrice();

                System.out.println("Write the index of coin you want to use");
                showCryptoCoinIndexs();

                coinIndex = scanner.nextInt();
                scanner.nextLine();

                System.out.println("Enter at what price you want to sell coin");
                awaitingPrice = scanner.nextInt();
                scanner.nextLine();


                tradePosition.openShortPosition(moneyAmount, leverage, awaitingPrice, crypto.getCryptoCoin(coinIndex));
                System.out.println("Your balance is " + account.getBalance());
                showTradePositionOptions(account, datum);
                break;
            case 2:
                System.out.println("Enter money amount you want to use for trade");
                moneyAmount = scanner.nextInt();
                scanner.nextLine();

                System.out.println("Enter leverage");
                leverage = scanner.nextInt();
                scanner.nextLine();

                generatingCryptoPrice.showActualPrice();

                System.out.println("Write the index of coin you want to use");
                showCryptoCoinIndexs();

                coinIndex = scanner.nextInt();
                scanner.nextLine();

                System.out.println("Enter at what price you want to sell coin");
                awaitingPrice = scanner.nextInt();
                scanner.nextLine();


                tradePosition.openLongPosition(moneyAmount, leverage, awaitingPrice, crypto.getCryptoCoin(coinIndex));
                System.out.println("Your balance is " + account.getBalance());
                showTradePositionOptions(account, datum);
                break;

            case 0:
                showOptions();
                break;

            default:
                System.out.println("Your option doesnt exist");
                System.out.println("Choose one more time");
                showTradePositionOptions(account, datum);
                break;

        }
    }

    private static void showCurrentCoinsPrice() {
        generatingCryptoPrice.showActualPrice();
        showOptions();
    }


    private static void showCryptoCoinIndexs() {
        System.out.println("***************************");
        System.out.println("Index 1 - BTC");
        System.out.println("Index 2 - ETH");
        System.out.println("Index 3 - SOL");
        System.out.println("Index 4 - APE");
        System.out.println("Index 5 - SAND");
        System.out.println("Index 6 - ATOM");
        System.out.println("Index 7 - BNB");
        System.out.println("***************************");
    }

    private static void showStakingDaysIndexs() {
        System.out.println("***************************");
        System.out.println("Index 1 - 30");
        System.out.println("Index 2 - 60");
        System.out.println("Index 3 - 90");
        System.out.println("Index 4 - 120");
        System.out.println("***************************");
    }
}
