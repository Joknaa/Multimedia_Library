package Models;

public class TextModel implements MediaModel{
    private int id;
    private String url;

    TextModel(){}
    TextModel(int id, String url){
        SetId(id);
        SetURL(url);
    }

    public void SetId(int id){ this.id = id;}
    public void SetURL(String login){ this.url = login;}

    public int GetId(){ return this.id;}
    public String GetURL(){ return this.url;}
}
