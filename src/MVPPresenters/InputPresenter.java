package MVPPresenters;

import static MVPViews.InputView.*;
import static MVPViews.OutputView.*;
import static MVPPresenters.DataBasePresenter.*;
import java.sql.SQLException;
import java.util.InputMismatchException;

public class InputPresenter {
//<editor-fold>
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
//</editor-fold>

    public static void Try_SignUp(String login, String password, String passwordRepeat) {
        try {
            //todo: Login format and characters check ..
            Check_NoEmptyFieldsExist(login, password, passwordRepeat);
            Check_PasswordMatch(password, passwordRepeat);
            SignUp(login, password);
            DisplayConfirmation("You Signed Up Successfully !@Confirmation");
            OnAction_SwapPanels(mainPanel);
        } catch (ClassNotFoundException | SQLException | EmptyInputFieldException | PasswordMismatchException | UserAlreadyExistException e ) {
            DisplayError(e.getMessage());
        }
    }
    public static void Check_NoEmptyFieldsExist(String... inputFields) throws EmptyInputFieldException{
        for (String field : inputFields ) {
            if (field.isEmpty()) throw new EmptyInputFieldException("Pls fill all the fields @Error");
        }
    }
    public static void Check_PasswordMatch(String password, String passwordRepeat) throws PasswordMismatchException{
        if (!password.equals(passwordRepeat))
            throw new PasswordMismatchException("Password doesnt match @Error");
    }

    public static void Try_SignIn(String login, String password) {
        try {
            Check_NoEmptyFieldsExist(login, password);
            SignIn(login, password);
            DisplayConfirmation("Welcome " + login + " !@Confirmation");
            OnAction_SwapPanels(mainPanel);
        } catch (EmptyInputFieldException | SQLException | ClassNotFoundException | UserNotFoundException e) {
            DisplayError(e.getMessage());
        }
    }

    public static class EmptyInputFieldException extends Exception { EmptyInputFieldException(String s){ super(s);}}
    public static class PasswordMismatchException extends Exception { PasswordMismatchException(String s){ super(s);}}
}
