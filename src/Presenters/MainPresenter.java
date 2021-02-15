package Presenters;

import static Presenters.DataBasePresenter.*;
import static Presenters.InputPresenter.*;
import static Presenters.OutputPresenter.*;

public class MainPresenter {
    public static void start() {
        int Option = 1;
        SetUpDataBase();
        SetUpGUI();
        while (Option != 0) {
            DisplayMainMenu();
            Option = Try_GetInt();
            ApplyOption(Option);
        }
    }

    private static void ApplyOption(int option) {
        switch (option) {
            case 1 -> StoragePresenter.ManageStorage();
            case 0 -> System.exit(0);
        }
    }

    private static void SetUpDataBase() {
        Connect();
    }
}
