package MVPModels;

public class UserModel {
    private int id;
    private char[] login;
    private char[] password;

    public UserModel(){}
    public UserModel(int id, char[] login, char[] password){
        SetId(id);
        SetLogin(login);
        SetPassword(password);
    }

    public void SetId(int id){ this.id = id;}
    public void SetLogin(char[] login){ this.login = login;}
    public void SetPassword(char[] password){ this.password = password;}

    public int GetId(){ return this.id;}
    public char[] GetLogin(){ return this.login;}
    public char[] GetPassword(){ return this.password;}
}
