package Models;

public class DataBaseModel {
    private String url;
    private String login;
    private String password;

    DataBaseModel(){}
    DataBaseModel(String url, String login, String password){
        SetUrl(url);
        SetLogin(login);
        SetPassword(password);
    }

    public void SetUrl(String id){ this.url = id;}
    public void SetLogin(String login){ this.login = login;}
    public void SetPassword(String password){ this.password = password;}

    public String GetUrl(){ return this.url;}
    public String GetLogin(){ return this.login;}
    public String GetPassword(){ return this.password;}
}
