package MVPViews;

import static MVPPresenters.OutputPresenter.*;
import static javax.swing.GroupLayout.DEFAULT_SIZE;
import static javax.swing.JOptionPane.*;
import static MVPPresenters.InputPresenter.*;
import MVPPresenters.OutputPresenter;
import MVPViews.UI.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class OutputView {
    private static final AppFrame appFrame = new AppFrame();
    public static final IPanel mainPanel = new MainPanel();
    public static final IPanel signUpPanel = new SignupPanel();

    public static void SetUpGUI() {
        appFrame.SetupOnTimeConfiguration();
        appFrame.SetCurrentPanel(new MainPanel());
    }

    public static void OnClick_SignUp(JTextField login, JPasswordField password, JPasswordField passwordRepeat) {
        String strLogin = login.getText();
        String strPassword = String.valueOf(password.getPassword());
        String strPasswordRepeat = String.valueOf(passwordRepeat.getPassword());
        Try_SignUp(strLogin, strPassword, strPasswordRepeat);
    }
    public static void OnClick_SignIn(JTextField login, JPasswordField password){
        String strLogin = login.getText();
        String strPassword = String.valueOf(password.getPassword());
        Try_SignIn(strLogin, strPassword);
    }
    public static void OnClick_SwapPanels(IPanel gotoPanel){
        appFrame.GetCurrentPanel().setVisible(false);
        appFrame.SetCurrentPanel(gotoPanel);}
    public static void OnlListSelection_UpdateDescription(String selectedValue, JLabel descriptionImage, JTable descriptionTable) {
        String[] ItemDescription = Try_GetMediaDescription(selectedValue);

        descriptionImage.setIcon(new ImageIcon("Resources/LoginScreen/library_120px.png"));
        descriptionTable.getCellEditor(0, 1);
        descriptionTable.setValueAt(selectedValue, 0, 1);
        descriptionTable.setValueAt(ItemDescription[0], 1, 1);
        descriptionTable.setValueAt(ItemDescription[1], 2, 1);
        descriptionTable.setValueAt(ItemDescription[2], 3, 1);
    }
    public static void OnClick_AddMedia(JList<String> list, DefaultListModel<String> listModel, JLabel descriptionImage, JTable descriptionTable){
        String[] mediaData = GetDataFromFile();
        boolean mediaAdded = Try_AddMedia(mediaData);

        if (mediaAdded) {
            OnlListSelection_UpdateDescription(mediaData[0], descriptionImage, descriptionTable);
            listModel.addElement(mediaData[0]);
        }
    }
    private static String[] GetDataFromFile() {
        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);

        System.out.println(chooser.getSelectedFile().getAbsolutePath());
        return chooser.getSelectedFile() == null ?
                null :
                new String[] {
                        chooser.getSelectedFile().getName(),
                        "type place holder",
                        new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()),
                        chooser.getSelectedFile().getAbsolutePath().replaceAll("\\\\", "\\\\\\\\")
        };
    }

    public static void OnClick_EditMedia(JList<String> list, DefaultListModel<String> listModel, JLabel descriptionImage, JTable descriptionTable){
        String itemName = list.getSelectedValue();
        String newItemName = Try_GetNewItemNameInput(listModel);

        Try_EditMedia(itemName, newItemName);
        listModel.setElementAt(newItemName, list.getSelectedIndex());

        OnlListSelection_UpdateDescription(newItemName, descriptionImage, descriptionTable);
    }
    public static void OnClick_DeleteMedia(JList<String> list, DefaultListModel<String> listModel){
        int response = DisplayConfirmation();
        if (response == 0) {
            Try_DeleteMedia(list.getSelectedValue());
            listModel.removeElementAt(list.getSelectedIndex());
        }
    }

    public static String[] GetListContent() {return OutputPresenter.Try_FillList(); };
    public static String GetCurrentUser(){ return OutputPresenter.GetCurrentUser(); }

    public static void SetupCloseButton(JButton closeButton){
        closeButton.setBackground(new java.awt.Color(76, 96, 133));
        closeButton.setFont(new java.awt.Font("Source Code Pro", Font.PLAIN, 24));
        closeButton.setForeground(new java.awt.Color(52, 66, 91));
        closeButton.setText("X");
        closeButton.setToolTipText("Close");
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
    public static void SetupSubmitButton(JButton submitButton, ActionListener actionListener, boolean isEnabled, String toolTip) {
        //todo: add some feed back on clicking the buttons
        submitButton.setBorder(BorderFactory.createLineBorder(new Color(190, 200, 218)));
        submitButton.setPreferredSize(new Dimension(100, 38));
        submitButton.setMaximumSize(new Dimension(100, 38));
        submitButton.setMinimumSize(new Dimension(100, 38));
        submitButton.setBackground(new Color(76, 96, 133));
        submitButton.setForeground(new Color(190, 200, 218));
        submitButton.setToolTipText(toolTip);
        submitButton.setEnabled(isEnabled);
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
    public static void SetupLogoPanelLayout(JPanel logoPanel, JLabel LogoIconPanel, JLabel LogoTextPanel) {
        var logoPanelLayout = new GroupLayout(logoPanel);

        logoPanel.setLayout(logoPanelLayout);
        logoPanelLayout.setHorizontalGroup(
                logoPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(logoPanelLayout.createSequentialGroup()
                                .addGap(165, 165, 165)
                                .addComponent(LogoIconPanel)
                                .addContainerGap(DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(GroupLayout.Alignment.TRAILING, logoPanelLayout.createSequentialGroup()
                                .addContainerGap(105, Short.MAX_VALUE)
                                .addComponent(LogoTextPanel)
                                .addGap(93, 93, 93))
        );
        logoPanelLayout.setVerticalGroup(
                logoPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(logoPanelLayout.createSequentialGroup()
                                .addContainerGap(138, Short.MAX_VALUE)
                                .addComponent(LogoIconPanel)
                                .addGap(18, 18, 18)
                                .addComponent(LogoTextPanel)
                                .addGap(193, 193, 193))
        );
    }

    public static void DisplayInformation(String greeting) {
        showMessageDialog(null, greeting, "Greeting", INFORMATION_MESSAGE);
    }
    public static void DisplayError(String error) {
        System.out.println(error);
        showMessageDialog(null, error, "Error", ERROR_MESSAGE);
    }
    public static int DisplayConfirmation() {
        return JOptionPane.showConfirmDialog(null, "You sure you wanna delete this ?",
                "Confirmation", YES_NO_OPTION);
    }
    public static String DisplayInputDialog() {
        return showInputDialog(null, "Enter the new item name",
                "Editing item", PLAIN_MESSAGE);
    }


    public static class OnMouseClick_CloseApp extends MouseAdapter {
        public void mouseClicked(MouseEvent e) { System.exit(0); }
    }
}