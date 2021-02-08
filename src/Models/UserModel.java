package Models;

public class UserModel {
    private int id;
    private String login;
    private String password;

    UserModel(){}
    UserModel(int id, String login, String password){
        SetId(id);
        SetLogin(login);
        SetPassword(password);
    }

    public void SetId(int id){ this.id = id;}
    public void SetLogin(String login){ this.login = login;}
    public void SetPassword(String password){ this.password = password;}

    public int GetId(){ return this.id;}
    public String GetLogin(){ return this.login;}
    public String GetPassword(){ return this.password;}
}
