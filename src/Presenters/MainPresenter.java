package Presenters;

import static Presenters.DataBasePresenter.*;
import static Presenters.InputPresenter.*;
import static Presenters.OutputPresenter.*;
import static Presenters.StoragePresenter.*;

public class MainPresenter {

    public static void start() {
        int Option = 1;
        SetUpDataBase();
        while (Option != 0) {
            DisplayMainMenu();
            Option = Try_GetInt();
            ApplyOption(Option);
        }
    }

    private static void ApplyOption(int option) {
        switch (option) {
            case 1 -> StoreMedia();
            case 0 -> ExitProgram();
        }
    }
    private static void ExitProgram(){ System.exit(0); }

    private static void SetUpDataBase() {
        Connect();
    }
}
