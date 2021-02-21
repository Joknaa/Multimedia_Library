package MVPViews;

import static javax.swing.JOptionPane.*;

import MVPPresenters.DataBasePresenter;
import MVPViews.UI.*;
import javax.swing.*;
import java.awt.event.*;

public class OutputView {
    public static final String CONFIRM_SIGNIN = "SignIn Successful @Confirmation";
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
        public void actionPerformed(ActionEvent event) {
            try {
                Check_NoSignUpEmptyFieldsExist();
                Check_PasswordMatch();
                ReadSignUpData();
            } catch (EmptyInputFieldException | PasswordMismatchException e) {
                DisplayError(e.getMessage());
            }
        }
        private void Check_NoSignUpEmptyFieldsExist() throws EmptyInputFieldException{
            boolean loginEmpty = loginField.getText().trim().length() == 0;
            boolean passwordEmpty = passwordField.getPassword().length == 0;
            boolean passwordRepeatEmpty = passwordRepeatField.getPassword().length == 0;
            if (loginEmpty || passwordEmpty || passwordRepeatEmpty)
                throw new EmptyInputFieldException("Pls fill all the fields @Error");
        }
        private void Check_PasswordMatch() throws PasswordMismatchException{
            char[] password = passwordField.getPassword();
            char[] passwordRepeat = passwordRepeatField.getPassword();

            if (passwordRepeat.length != password.length)
                throw new PasswordMismatchException("Password doesnt match @Error");
            for (int i = 0; i < password.length; i++) {
                if (password[i] != passwordRepeat[i])
                    throw new PasswordMismatchException("Password doesnt match @Error");
            }
        }
        private void ReadSignUpData() {
            String login = loginField.getText();
            String password = String.valueOf(passwordField.getPassword());
            InputView.CheckSignUpData(login, password);
        }
    }
    public static class OnAction_SignIn implements  ActionListener {
        JTextField loginField;
        JPasswordField passwordField;
        public OnAction_SignIn(JTextField login, JPasswordField password){
            this.loginField = login;
            this.passwordField = password;
        }
        @Override
        public void actionPerformed(ActionEvent event) {
            try {
                Check_NoSignInEmptyFieldsExist();
                if (ReadSignInData() == -1)
                    throw new Exception();
            } catch (EmptyInputFieldException e) {
                DisplayError(e.getMessage());
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("going to main menu");
            new OnAction_SwapPanels(mainPanel);
        }
        private void Check_NoSignInEmptyFieldsExist() throws EmptyInputFieldException {
            boolean loginEmpty = loginField.getText().trim().length() == 0;
            boolean passwordEmpty = passwordField.getPassword().length == 0;

            if (loginEmpty || passwordEmpty)
                throw new EmptyInputFieldException("Pls fill all the fields @Error");
        }
        private int ReadSignInData() {
            String login = loginField.getText();
            String password = String.valueOf(passwordField.getPassword());
            return InputView.CheckSignInData(login, password);
        }
    }
    public static class OnMouseClick_CloseApp extends MouseAdapter {
        public void mouseClicked(MouseEvent e) { System.exit(0); }
    }

    public static class EmptyInputFieldException extends Exception { EmptyInputFieldException(String s){ super(s);}}
    public static class PasswordMismatchException extends Exception { PasswordMismatchException(String s){ super(s);}}
}