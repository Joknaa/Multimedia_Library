package MVPViews;

import MVPPresenters.InputPresenter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class InputView {
    private static final Scanner sc = new Scanner(System.in);

    public static int GetInt() throws InputMismatchException { return sc.nextInt();}
    public static String GetString() throws InputMismatchException{ return sc.nextLine();}
    public static void ClearInputBuffer() { sc.nextLine(); }

    public static void CheckSignUpData(String login, String password) {
        InputPresenter.SignUpUser(login, password);
    }
    public static int CheckSignInData(String login, String password) {
        return InputPresenter.SignInUser(login, password);
    }
}
