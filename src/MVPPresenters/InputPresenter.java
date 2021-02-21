package MVPPresenters;

import static MVPViews.InputView.*;
import PubSubPublisher.Subscriber;
import java.util.InputMismatchException;

public class InputPresenter extends Subscriber {

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

    public static void SignUpUser(String login, String password){
        DataBasePresenter.Try_SignUp(login, password);
    }
    public static int SignInUser(String login, String password){
        return DataBasePresenter.Try_SignIn(login, password);
    }

    @Override
    public void DoSomething() {
        System.out.println("Subscriber Informed !!");
    }
}
