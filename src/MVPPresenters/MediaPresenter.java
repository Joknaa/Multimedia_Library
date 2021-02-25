package MVPPresenters;

import java.util.HashMap;

public class MediaPresenter {
    private static final HashMap<Integer, String> mediaList = new HashMap<>();


    public static void AddMedia(int ID, String Name) { mediaList.put(ID, Name); }
    public static void RemoveMedia(int ID, String Name) { mediaList.remove(ID, Name); }
    public static void EditMedia(int ID, String Name) { mediaList.put(ID, Name); }
    public static HashMap<Integer, String> GetList() { return mediaList; }






}
