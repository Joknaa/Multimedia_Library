package MVPPresenters;

import MVPViews.OutputView;
import java.sql.SQLException;

import static MVPPresenters.DataBasePresenter.*;

public class OutputPresenter {
    public static void SetUpGUI(){ OutputView.SetUpGUI(); }

    public static void DisplayError(String error) { OutputView.DisplayError(error);}

    public static String[] Try_GetItemDescription(String selectedValue) {
            String[] ItemDescription = {"", "", "", ""};
        try {
            ItemDescription = GetItemDescription(selectedValue);
        } catch (SQLException | ClassNotFoundException e) {
            DisplayError(e.getMessage());
        }
        return ItemDescription;
    }
    public static void Try_EditItem(String itemName, String newItemName) {
        try {
            EditItem(itemName, newItemName);
        } catch (SQLException | ClassNotFoundException e) {
            DisplayError(e.getMessage());
        }
    }
    public static void Try_DeleteItem(String itemName) {
        try {
            DeleteItem(itemName);
        } catch (SQLException | ClassNotFoundException e) {
            DisplayError(e.getMessage());
        }
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
    public static String GetCurrentUser() { return UserPresenter.GetCurrentUser(); }
}
