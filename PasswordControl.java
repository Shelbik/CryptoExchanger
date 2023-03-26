import java.util.Random;
import java.util.Scanner;

public class PasswordControl {
    private Account account;
    private String password;

    /**
     *
     * @param account
     */
    public PasswordControl(Account account) {

        this.account = account;
        this.password = account.getPassword();

    }


    /**
     * show us our password
     *
     * @return
     */
    public String getPassword() {
        return this.password;
    }

    /**
     * set new Password
     *
     * @return
     */
    public String setNewPassword(String newPassword) {
        this.password = newPassword;
        return this.password;
    }

    /**
     * check if password is correct
     *
     * @return
     */
    public boolean checkPassword(String password) {
        return (this.password.equals(password));
    }


    /**
     * write captcha
     *
     * @return
     */
    public boolean checkSupportElement() {
        Scanner scanner = new Scanner(System.in);

        Random generator;

        generator = new Random();
        int captcha = generator.nextInt(10000);


        System.out.println("Rewrite " + captcha);
        int rewrite = scanner.nextInt();
        System.out.println("You wrote " + rewrite);

        return (captcha == rewrite);
    }

    /**
     * check correct password with captcha
     *
     * @return
     */
    public boolean checkSecuirityElement(String password) {
        return (this.checkPassword(password) && this.checkSupportElement());
    }
}

