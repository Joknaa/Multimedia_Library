package MVPPresenters;

import MVPModels.LogStatus;
import MVPModels.UserModel;

public class UserPresenter {
    private static LogStatus adminLogStatus = LogStatus.LoggedOut;

    public static void Login(String login){
        adminLogStatus = LogStatus.LoggedIn;
        UserModel.SetLogin(login);
    }
    public static String GetCurrentUser(){ return UserModel.GetLogin(); }
    public static void LogOut(){ adminLogStatus = LogStatus.LoggedOut;}
}
