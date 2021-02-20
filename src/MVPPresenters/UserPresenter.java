package MVPPresenters;

import MVPModels.UserModel;
import java.util.HashMap;

public class UserPresenter {
    private static final HashMap<Integer, UserModel> userList = new HashMap<>();

    public static void AddUser(char[] login, char[] password){
        int id = userList.size() + 1;
        userList.put(id, new UserModel(id, login, password));
    }
}
