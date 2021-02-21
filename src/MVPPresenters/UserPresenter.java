package MVPPresenters;

import MVPModels.UserModel;

public class UserPresenter {

    public static void SetCurrentUser(String login){
        UserModel.SetLogin(login);
    }
}
