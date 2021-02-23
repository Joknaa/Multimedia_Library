package MVPViews;

import static MVPPresenters.OutputPresenter.*;
import static javax.swing.JOptionPane.*;
import static MVPPresenters.InputPresenter.*;

import MVPPresenters.OutputPresenter;
import MVPViews.UI.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class OutputView {
    private static final AppFrame appFrame = new AppFrame();
    public static final IPanel mainPanel = new MainPanel();
    public static final IPanel signUpPanel = new SignupPanel();

    public static void SetUpGUI() {
        appFrame.SetupOnTimeConfiguration();
        appFrame.SetCurrentPanel(new MainPanel());
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
    public static void OnAction_SwapPanels(IPanel gotoPanel){
        appFrame.GetCurrentPanel().setVisible(false);
        appFrame.SetCurrentPanel(gotoPanel);}
    public static void OnlListSelection_UpdateDescription(String selectedValue, JLabel descriptionImage, JTable descriptionTable) {
        String[] ItemDescription = Try_GetItemDescription(selectedValue);

        descriptionImage.setIcon(new ImageIcon("Resources/LoginScreen/library_120px.png"));
        descriptionTable.getCellEditor(0, 1);
        descriptionTable.setValueAt(selectedValue, 0, 1);
        descriptionTable.setValueAt(ItemDescription[0], 1, 1);
        descriptionTable.setValueAt(ItemDescription[1], 2, 1);
        descriptionTable.setValueAt(ItemDescription[2], 3, 1);

    }

//<editor-fold>
    static public void DisplayMainMenu() {

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

    public static String[] GetListContent(){
        return OutputPresenter.Try_FillList();
    }

    public static void SetupCloseButton(JButton closeButton){
        closeButton.setBackground(new java.awt.Color(76, 96, 133));
        closeButton.setFont(new java.awt.Font("Source Code Pro", Font.PLAIN, 24));
        closeButton.setForeground(new java.awt.Color(52, 66, 91));
        closeButton.setText("X");
        closeButton.setToolTipText("");
        closeButton.setBorder(null);
        closeButton.setContentAreaFilled(false);
        closeButton.setFocusPainted(false);
        closeButton.setFocusable(false);
        closeButton.setMaximumSize(new java.awt.Dimension(100, 38));
        closeButton.setMinimumSize(new java.awt.Dimension(100, 38));
        closeButton.setPreferredSize(new java.awt.Dimension(100, 38));
        closeButton.setFont(new Font("Segoe UI", Font.PLAIN, 24));
        closeButton.addMouseListener(new OnMouseClick_CloseApp());
    }
    public static void SetupSubmitButton(JButton submitButton, ActionListener actionListener) {
        submitButton.setBorder(BorderFactory.createLineBorder(new Color(190, 200, 218)));
        submitButton.setPreferredSize(new Dimension(100, 38));
        submitButton.setMaximumSize(new Dimension(100, 38));
        submitButton.setMinimumSize(new Dimension(100, 38));
        submitButton.setBackground(new Color(76, 96, 133));
        submitButton.setForeground(new Color(190, 200, 218));
        submitButton.setContentAreaFilled(false);
        submitButton.setFocusPainted(false);
        submitButton.setFocusable(false);
        submitButton.setOpaque(false);
        submitButton.addActionListener(actionListener);
    }
    public static void SetupSeparators(JSeparator... separators) {
        for (JSeparator separator : separators) {
            separator.setBackground(new Color(190, 200, 218));
        }
    }
    public static void SetupInputFields(JTextField... inputFields) {
        for (JTextField inputField : inputFields) {
            inputField.setBackground(new Color(76, 96, 133));
            inputField.setForeground(new Color(190, 200, 218));
            inputField.setBorder(null);
        }
    }

    public static class OnMouseClick_CloseApp extends MouseAdapter {
        public void mouseClicked(MouseEvent e) { System.exit(0); }
    }
}