package MVPPresenters;

import static MVPViews.InputView.*;
import static MVPViews.OutputView.*;
import static MVPPresenters.DataBasePresenter.*;

import java.sql.SQLException;
import java.util.InputMismatchException;

public class InputPresenter {

    public static int Try_GetInt(){
        int input = -1;
        try {
            input = GetInt();
        } catch (InputMismatchException WrongInput){
            OutputPresenter.DisplayErrorOld("Wrong Input type ! Please Enter: int");
            ClearInputBuffer();
        }
        return input;
    }
    public static String Try_GetString(){
        String input = "";
        try {
            input = GetString();
        } catch (InputMismatchException WrongInput){
            OutputPresenter.DisplayErrorOld("Wrong Input type ! Please Enter: String");
            ClearInputBuffer();
        }
        return input;
    }


    public static void Try_SignUp(String login, String password, String passwordRepeat) {
        try {
            //todo: Login format and characters check ..
            Check_NoSignUpEmptyFieldsExist(login, password, passwordRepeat);
            Check_PasswordMatch(password, passwordRepeat);
            SignUp(login, password);
            DisplayConfirmation("You Signed Up Successfully !@Confirmation");
        } catch (Exception e) {
            DisplayError(e.getMessage());
        }
    }
    public static void Check_NoSignUpEmptyFieldsExist(String login, String password, String passwordRepeat) throws EmptyInputFieldException{
        if (login.isEmpty() || password.isEmpty() || passwordRepeat.isEmpty())
            throw new EmptyInputFieldException("Pls fill all the fields @Error");
    }
    public static void Check_PasswordMatch(String password, String passwordRepeat) throws PasswordMismatchException{
        if (!password.equals(passwordRepeat))
            throw new PasswordMismatchException("Password doesnt match @Error");
    }


    public static void Try_SignIn(String login, String password) {
        try {
            Check_NoSignInEmptyFieldsExist(login, password);
            SignIn(login, password);
            DisplayConfirmation("Welcome " + login + " !@Confirmation");
        } catch (EmptyInputFieldException | SQLException | ClassNotFoundException | UserNotFoundException e) {
            DisplayError(e.getMessage());
        }
    }
    public static void Check_NoSignInEmptyFieldsExist(String login, String password) throws EmptyInputFieldException{
        if (login.isEmpty() || password.isEmpty())
            throw new EmptyInputFieldException("Pls fill all the fields @Error");
    }

    public static class EmptyInputFieldException extends Exception { EmptyInputFieldException(String s){ super(s);}}
    public static class PasswordMismatchException extends Exception { PasswordMismatchException(String s){ super(s);}}
}
