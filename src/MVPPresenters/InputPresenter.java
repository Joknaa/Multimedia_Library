package MVPPresenters;

import static MVPViews.OutputView.*;
import static MVPPresenters.DataBasePresenter.*;
import java.sql.SQLException;

public class InputPresenter {
    public static void Try_SignUp(String login, String password, String passwordRepeat) {
        try {
            //todo: Login format and characters check ..
            Check_NoEmptyFieldsExist(login, password, passwordRepeat);
            Check_PasswordMatch(password, passwordRepeat);
            SignUp(login, password);
            DisplayInformation("You Signed Up Successfully !");
            OnClick_SwapPanels(mainPanel);
        } catch (ClassNotFoundException | SQLException | EmptyInputFieldException | PasswordMismatchException | UserAlreadyExistException e ) {
            DisplayError(e.getMessage());
        }
    }
    public static void Check_NoEmptyFieldsExist(String... inputFields) throws EmptyInputFieldException{
        for (String field : inputFields ) {
            if (field.isEmpty()) throw new EmptyInputFieldException("Pls fill all the fields");
        }
    }
    public static void Check_PasswordMatch(String password, String passwordRepeat) throws PasswordMismatchException{
        if (!password.equals(passwordRepeat))
            throw new PasswordMismatchException("Password doesnt match");
    }

    public static void Try_SignIn(String login, String password) {
        try {
            Check_NoEmptyFieldsExist(login, password);
            SignIn(login, password);
            DisplayInformation("Welcome " + login + " !@Confirmation");
            OnClick_SwapPanels(mainPanel);
        } catch (EmptyInputFieldException | SQLException | ClassNotFoundException | UserNotFoundException e) {
            DisplayError(e.getMessage());
        }
    }

    public static class EmptyInputFieldException extends Exception { EmptyInputFieldException(String s){ super(s);}}
    public static class PasswordMismatchException extends Exception { PasswordMismatchException(String s){ super(s);}}
}
