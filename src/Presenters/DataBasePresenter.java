package Presenters;

import static Presenters.OutputPresenter.DisplayMessage;

public class DataBasePresenter {
    public static void Connect(){ DisplayMessage("Connecting to DB"); }
    public static void Disconnect(){ DisplayMessage("Disconnecting from DB"); }
    public static void Authenticate(){ DisplayMessage("Authentication ... "); }


}
