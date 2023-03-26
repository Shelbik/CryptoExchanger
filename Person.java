public class Person {
    private String firstName;
    private String secondName;
    private int currentAge;

    private int yearOfBirth;
    private int dayOfBirth;
    private int monthOfBirth;
    private boolean isAdult = true;
    private int currentYear;

    /**
     *
     * @param firstName
     * @param secondName
     * @param dayOfBirth
     * @param monthOfBirth
     * @param yearOfBirth
     * @param currentYear
     */
    public Person(String firstName, String secondName, int dayOfBirth, int monthOfBirth, int yearOfBirth, int currentYear) {
        this.secondName = secondName;
        this.firstName = firstName;
        this.currentYear = currentYear;
        this.yearOfBirth = yearOfBirth;

        this.currentAge = this.currentYear - this.yearOfBirth;

        if (this.currentAge < 18) {
            this.isAdult = false;
            System.out.println("Vstup zakazany,nemate rokov 18");
        }

    }

    /**
     *
     * @return
     */
    public String getFirstName() {
        return this.firstName;
    }

    /**
     *
     * @param firstName
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     *
     * @return
     */
    public String getSecondName() {
        return this.secondName;
    }

    /**
     *
     * @param secondName
     */
    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    /**
     *
     * @return
     */
    public int getAge() {
        return this.currentAge;
    }

    /**
     *
     * @return
     */
    public boolean isAdult() {
        return this.isAdult;

    }


}
