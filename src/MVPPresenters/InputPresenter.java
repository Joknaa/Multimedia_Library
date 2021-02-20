package MVPPresenters;

import static MVPPresenters.OutputPresenter.*;
import static MVPViews.InputView.*;
import PubSubPublisher.Subscriber;
import java.util.InputMismatchException;

public class InputPresenter extends Subscriber {

    public static int Try_GetInt(){
        int input = -1;
        try {
            input = GetInt();
        } catch (InputMismatchException WrongInput){
            DisplayError("Wrong Input type ! Please Enter: int");
            ClearInputBuffer();
        }
        return input;
    }
    public static String Try_GetString(){
        String input = "";
        try {
            input = GetString();
        } catch (InputMismatchException WrongInput){
            DisplayError("Wrong Input type ! Please Enter: String");
            ClearInputBuffer();
        }
        return input;
    }

    public static void SignUpUser(char[] login, char[] password){
        UserPresenter.AddUser(login, password);
    }

    @Override
    public void DoSomething() {
        System.out.println("Subscriber Informed !!");
    }
}
