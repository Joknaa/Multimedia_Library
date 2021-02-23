package MVPPresenters;

import static MVPPresenters.DataBasePresenter.*;
import static MVPPresenters.InputPresenter.*;
import static MVPPresenters.OutputPresenter.*;

public class MainPresenter {
    public static void start() {
        SetUpDataBase();
        SetUpGUI();
    }
    private static void SetUpDataBase() {
        CheckDataBaseConnection();
    }
}
