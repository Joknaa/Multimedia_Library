package Presenters;

import Models.UserModel;
import java.util.HashMap;

public class UserPresenter {
    private static final HashMap<Integer, UserModel> userList = new HashMap<>();

    public static void AddMedia(UserModel user){ userList.put(user.GetId(), user);}
    public static void DeleteMedia(UserModel user){ userList.remove(user.GetId(), user);}
}
