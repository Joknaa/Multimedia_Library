package MVPViews;

import static javax.swing.JOptionPane.*;
import MVPViews.UI.*;
import javax.swing.*;
import java.awt.event.*;

public class OutputView {
    private static final AppFrame appFrame = new AppFrame();
    public static final IPanel mainPanel = new MainPanel();
    public static IPanel signupPanel = new SignupPanel();

    public static void SetUpGUI() {
        appFrame.SetupOnTimeConfiguration();
        appFrame.SetCurrentPanel(new LoginPanel());
    }

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
    public static class OnAction_SignUp implements  ActionListener {
        JTextField loginField;
        JPasswordField passwordField;
        JPasswordField passwordRepeatField;
        public OnAction_SignUp(JTextField login, JPasswordField password, JPasswordField passwordRepeat){
            this.loginField = login;
            this.passwordField = password;
            this.passwordRepeatField = passwordRepeat;
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            if (ThereIsEmptyField()) {
                showMessageDialog(null, "Pls fill all the fields", "Error", ERROR_MESSAGE);
                return;
            }
            if (PasswordDoesntMatch()) {
                showMessageDialog(null, "Password doesnt match", "Warning", WARNING_MESSAGE);
                return;
            }

            ReadSignUpData();
            showMessageDialog(null, "SignUp Successful", "Confirmation", INFORMATION_MESSAGE);
        }
        private boolean ThereIsEmptyField() {
            boolean loginEmpty = loginField.getText().trim().length() == 0;
            boolean passwordEmpty = passwordField.getPassword().length == 0;
            boolean passwordRepeatEmpty = passwordRepeatField.getPassword().length == 0;
            return loginEmpty || passwordEmpty || passwordRepeatEmpty;
        }
        private boolean PasswordDoesntMatch() {
            char[] password = passwordField.getPassword();
            char[] passwordRepeat = passwordRepeatField.getPassword();

            if (passwordRepeat.length != password.length) return true;
            for (int i = 0; i < password.length; i++) {
                if (password[i] != passwordRepeat[i]) return true;
            }
            return false;
        }
        private void ReadSignUpData() {
            char[] login = loginField.getText().toCharArray();
            char[] password = passwordField.getPassword();
            char[] passwordRepeat = passwordRepeatField.getPassword();
            InputView.StoreSignUpData(login, password, passwordRepeat);
        }
    }
    public static class OnMouseClick_CloseApp extends MouseAdapter {
        public void mouseClicked(MouseEvent e) { System.exit(0); }
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