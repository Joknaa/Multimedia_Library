package MVPViews;

import static javax.swing.JOptionPane.*;
import static MVPPresenters.InputPresenter.*;
import MVPViews.UI.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Arrays;

public class OutputView {
    private static final AppFrame appFrame = new AppFrame();
    public static final IPanel mainPanel = new MainPanel();
    public static final IPanel signupPanel = new SignupPanel();

    public static void SetUpGUI() {
        appFrame.SetupOnTimeConfiguration();
        appFrame.SetCurrentPanel(new LoginPanel());
    }

    public static void DisplayConfirmation(String confirmation) {
        showMessageDialog(null, confirmation.split("@")[0],
                confirmation.split("@")[1], INFORMATION_MESSAGE);
    }
    public static void DisplayError(String error) {
        showMessageDialog(null, error.split("@")[0],
                error.split("@")[1], ERROR_MESSAGE);
    }

    public static void OnAction_SignUp(JTextField login, JPasswordField password, JPasswordField passwordRepeat) {
        String strLogin = login.getText();
        String strPassword = String.valueOf(password.getPassword());
        String strPasswordRepeat = String.valueOf(passwordRepeat.getPassword());
        Try_SignUp(strLogin, strPassword, strPasswordRepeat);
    }

    public static void OnAction_SignIn(JTextField login, JPasswordField password){
        String strLogin = login.getText();
        String strPassword = String.valueOf(password.getPassword());
        Try_SignIn(strLogin, strPassword);

    }

//<editor-fold>
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
    public static void DisplayErrorOld(String s) {

    }
    public static void DisplayMessage(String s) {
        System.out.print(s);
    }
//</editor-fold>

    public static class OnAction_SwapPanels implements ActionListener {
        private final IPanel gotoPanel;
        public OnAction_SwapPanels(IPanel gotoPanel){
            this.gotoPanel = gotoPanel;
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            appFrame.GetCurrentPanel().setVisible(false);
            appFrame.SetCurrentPanel(gotoPanel);
        }
    }
    public static class OnMouseClick_CloseApp extends MouseAdapter {
        public void mouseClicked(MouseEvent e) { System.exit(0); }
    }

}