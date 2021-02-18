package Views;

import Views.UI.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OutputView {
    private static final AppFrame appFrame = new AppFrame();
    public static final IPanel mainPanel = new MainPanel();
    public static IPanel signupPanel = new SignupPanel();
    public static IPanel loginPanel = new LoginPanel();

    public static void SetUpGUI() {
        appFrame.SetupOnTimeConfiguration();
        appFrame.SetCurrentPanel(new LoginPanel());
    }

    public static class OnClick_SwapPanels implements ActionListener {
        private final IPanel gotoPanel;
        public OnClick_SwapPanels(IPanel gotoPanel){
            this.gotoPanel = gotoPanel;
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            appFrame.GetCurrentPanel().setVisible(false);
            appFrame.SetCurrentPanel(gotoPanel);
            System.out.println("test");
        }
    }

    static public void DisplayMainMenu() {
        System.out.println();
        System.out.println("#######################[ MainMenu ]#######################");
        System.out.println("|| -----------------> 1 : StoreMedia <----------------- ||");
        System.out.println("|| -----------------> 0 : Exit       <----------------- ||");
        System.out.println("##########################################################");
        System.out.print("#-> Option : ");
    }
    static public void DisplayLoginMenu() {
        System.out.println();
        System.out.println("#####################[ LoginMenu ]###################");
        System.out.println("|| -----------------> 1 : Login  <---------------- ||");
        System.out.println("|| -----------------> 2 : SignUp <---------------- ||");
        System.out.println("|| -----------------> 0 : Exit   <---------------- ||");
        System.out.println("#####################################################");
        System.out.print("#-> Option : ");
    }
    static public void DisplayStorageMenu() {
        System.out.println();
        System.out.println("####################[ StorageMenu ]##################");
        System.out.println("|| -----------------> 1 : Store  <---------------- ||");
        System.out.println("|| -----------------> 2 : Edit   <---------------- ||");
        System.out.println("|| -----------------> 3 : Delete <---------------- ||");
        System.out.println("|| -----------------> 0 : Back   <---------------- ||");
        System.out.println("#####################################################");
        System.out.print("#-> Option : ");
    }
    public static void DisplayError(String s) {
        System.out.print(s);
    }
    public static void DisplayMessage(String s) {
        System.out.print(s);
    }
}