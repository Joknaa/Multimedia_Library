package MVPPresenters;

import MVPViews.OutputView;
import java.sql.SQLException;
import static MVPPresenters.DataBasePresenter.*;

public class OutputPresenter {
    public static void SetUpGUI(){ OutputView.SetUpGUI(); }

    public static String[] Try_FillList() {
        String[] listData = new String[]{};
        try{
            listData = GetMediaList();
        } catch (Exception e) {
            DisplayError(e.getMessage());
        }
        return listData;
    }
    public static String[] Try_GetMediaDescription(String selectedValue) {
            String[] mediaDescription = {"", "", "", ""};
        try {
            mediaDescription = GetMediaDescription(selectedValue);
        } catch (SQLException | ClassNotFoundException e) {
            DisplayError(e.getMessage());
        }
        return mediaDescription;
    }

    public static String GetCurrentUser() { return UserPresenter.GetCurrentUser(); }
    public static void DisplayError(String error) { OutputView.DisplayError(error);}
}
