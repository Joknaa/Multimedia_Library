package MVPPresenters;

import MVPViews.OutputView;

import java.sql.SQLException;

import static MVPPresenters.DataBasePresenter.*;

public class OutputPresenter {

    public static void SetUpGUI(){ OutputView.SetUpGUI(); }
    public static void DisplayMainMenu(){ OutputView.DisplayMainMenu(); }
    public static void DisplayStorageMenu(){ OutputView.DisplayStorageMenu(); }
    public static void DisplayErrorOld(String s) { OutputView.DisplayErrorOld(s); }
    public static void DisplayError(String error) { OutputView.DisplayError(error);}

        public static String[] Try_GetItemDescription(String selectedValue) {
            String[] ItemDescription = {"", "", "", ""};
        try {
            // Todo: get the media ID from the selection ..
            ItemDescription = GetItemDescription(selectedValue);
            // Todo: get the media data from Database based on the selection ID ..
        } catch (SQLException | ClassNotFoundException e) {
            DisplayError(e.getMessage());
        }
        return ItemDescription;
    }

    public static String[] Try_FillList() {
        String[] listData = new String[]{};
        try{
            listData = GetListItems();
        } catch (Exception e) {
            DisplayError(e.getMessage());
        }
        return listData;
    }
}
