package Presenters;

import Views.OutputView;

public class OutputPresenter {

    public static void SetUpGUI(){ OutputView.SetUpGUI(); }
    public static void DisplayMainMenu(){ OutputView.DisplayMainMenu(); }
    public static void DisplayStorageMenu(){ OutputView.DisplayStorageMenu(); }

    public static void DisplayMessage(String s) { OutputView.DisplayMessage(s); }
    public static void DisplayError(String s) { OutputView.DisplayError(s); }

}
