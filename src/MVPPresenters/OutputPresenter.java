package MVPPresenters;

import MVPViews.OutputView;

public class OutputPresenter {

    public static void SetUpGUI(){ OutputView.SetUpGUI(); }
    public static void DisplayMainMenu(){ OutputView.DisplayMainMenu(); }
    public static void DisplayStorageMenu(){ OutputView.DisplayStorageMenu(); }

    public static void DisplayMessage(String s) { OutputView.DisplayMessage(s); }
    public static void DisplayErrorOld(String s) { OutputView.DisplayErrorOld(s); }

    public static void DisplayConfirmation(String confirmation) { OutputView.DisplayConfirmation(confirmation); }
    public static void DisplayError(String error) { OutputView.DisplayError(error); }
}
