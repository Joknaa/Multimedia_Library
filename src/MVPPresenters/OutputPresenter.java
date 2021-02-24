package MVPPresenters;

import MVPViews.OutputView;
import java.sql.SQLException;

import static MVPPresenters.DataBasePresenter.*;

public class OutputPresenter {
    public static void SetUpGUI(){ OutputView.SetUpGUI(); }

    public static void DisplayError(String error) { OutputView.DisplayError(error);}

    public static String[] Try_GetMediaDescription(String selectedValue) {
            String[] mediaDescription = {"", "", "", ""};
        try {
            mediaDescription = GetMediaDescription(selectedValue);
        } catch (SQLException | ClassNotFoundException e) {
            DisplayError(e.getMessage());
        }
        return mediaDescription;
    }
    public static void Try_EditMedia(String mediaName, String newMediaName) {
        try {
            EditMedia(mediaName, newMediaName);
        } catch (SQLException | ClassNotFoundException e) {
            DisplayError(e.getMessage());
        }
    }
    public static void Try_DeleteMedia(String mediaName) {
        try {
            DeleteMedia(mediaName);
        } catch (SQLException | ClassNotFoundException e) {
            DisplayError(e.getMessage());
        }
    }
    public static String[] Try_FillList() {
        String[] listData = new String[]{};
        try{
            listData = GetMediaList();
        } catch (Exception e) {
            DisplayError(e.getMessage());
        }
        return listData;
    }
    public static String GetCurrentUser() { return UserPresenter.GetCurrentUser(); }
}
