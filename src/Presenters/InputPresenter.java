package Presenters;

import java.util.InputMismatchException;
import static Presenters.OutputPresenter.*;
import static Views.InputView.*;

public class InputPresenter {

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

}
