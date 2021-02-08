package Presenters;

import Models.MediaModel;
import java.util.HashMap;

public class MediaPresenter {
    private static final HashMap<Integer, MediaModel> mediaList = new HashMap<>();

    public static void AddMedia(MediaModel media){ mediaList.put(media.GetId(), media);}
    public static void DeleteMedia(MediaModel media){ mediaList.remove(media.GetId(), media);}
}
