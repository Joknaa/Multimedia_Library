package Presenters;

import static Presenters.InputPresenter.*;
import static Presenters.OutputPresenter.*;

public class StoragePresenter {
    private static int Option = 1;

    public static void ManageStorage() {
        while (Option != 0) {
            DisplayStorageMenu();
            Option = Try_GetInt();
            ApplyOption(Option);
        }
    }

    private static void ApplyOption(int option) {
        switch (option) {
            case 1 -> Store();
            case 2 -> Edit();
            case 3 -> Delete();
            case 0 -> Back2MainMenu();
        }
    }

    private static void Store(){
        int id = Try_GetInt();
        String url = Try_GetString();

        System.out.printf("Storing: {id = '%d', url = '%s'}", id, url);
    }
    private static void Edit(){ }
    private static void Delete(){ }
    private static void Back2MainMenu() { Option = 0;}
}