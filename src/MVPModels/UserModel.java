package MVPModels;

public class UserModel {
    static private String Login;
    static private String Password;

    public static void SetLogin(String login){ Login = login;}
    public static void SetPassword(String password){ Password = password;}

    public static String GetLogin(){ return Login;}
    public static String GetPassword(){ return Password;}
}
