package MVPViews;

import static MVPPresenters.OutputPresenter.*;
import static javax.swing.GroupLayout.DEFAULT_SIZE;
import static javax.swing.JOptionPane.*;
import static MVPPresenters.InputPresenter.*;
import MVPPresenters.OutputPresenter;
import MVPPresenters.UserPresenter;
import MVPViews.UI.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class OutputView {
    private static final AppFrame appFrame = new AppFrame();
    public static final Color PICKLED_BLUEWOOD = new Color(52, 66, 91);
    public static final Color BLUE_BAYOUX = new Color(76, 96, 133);
    public static final Color BLUE_HAZE = new Color(190, 200, 218);
    public static final IPanel mainPanel = new MainPanel();
    public static final IPanel loginPanel = new LoginPanel();
    public static final IPanel signUpPanel = new SignupPanel();

    public static void SetUpGUI() {
        appFrame.SetupOnTimeConfiguration();
        appFrame.SetCurrentPanel(new LoginPanel());
    }

    public static void OnClick_Logout(){
        UserPresenter.LogOut();
        OnClick_SwapPanels(loginPanel);
    }
    public static void OnClick_SignUp(JTextField login, JPasswordField password, JPasswordField passwordRepeat) {
        String strLogin = login.getText().trim();
        String strPassword = String.valueOf(password.getPassword()).trim();
        String strPasswordRepeat = String.valueOf(passwordRepeat.getPassword()).trim();
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
    public static void OnListSelection_UpdateDescription(String selectedValue, JTable descriptionTable) {
        String[] ItemDescription = Try_GetMediaDescription(selectedValue);

        descriptionTable.getCellEditor(0, 1);
        descriptionTable.setValueAt(selectedValue, 0, 1);
        descriptionTable.setValueAt(ItemDescription[0], 1, 1);
        descriptionTable.setValueAt(ItemDescription[1], 2, 1);
        descriptionTable.setValueAt(ItemDescription[2], 3, 1);
    }
    public static void OnClick_AddMedia(DefaultListModel<String> listModel, JTable descriptionTable){
        String[] mediaData = Try_AddMedia(listModel);
        if (mediaData == null || mediaData.length == 0) return;
        OnListSelection_UpdateDescription(mediaData[0], descriptionTable);
        listModel.addElement(mediaData[0]);
    }
    public static void OnClick_EditMedia(JList<String> list, DefaultListModel<String> listModel, JTable descriptionTable){
        String[] listContent = ConvertListContentToStringArray(listModel);
        String newItemName = Try_EditMedia(list.getSelectedValue(), listContent);
        if (newItemName == null || newItemName.length() == 0) return;
        OnListSelection_UpdateDescription(newItemName, descriptionTable);
        listModel.setElementAt(newItemName, list.getSelectedIndex());
    }
    public static void OnClick_DeleteMedia(JList<String> list, DefaultListModel<String> listModel, JButton deleteButton){
        int response = DisplayConfirmation();
        if (response == 0) {
            Try_DeleteMedia(list.getSelectedValue());
            listModel.removeElementAt(list.getSelectedIndex());
            deleteButton.setEnabled(false);
        }
    }

    private static String[] ConvertListContentToStringArray(DefaultListModel<String> listModel) {
        String[] listContent = new String[listModel.getSize()];
        for (int i = 0; i < listContent.length; i++) {
            listContent[i] = String.valueOf(listModel.getElementAt(i));
        }
        return listContent;
    }
    public static String[] GetListContent() {return Try_FillList(); };
    public static String GetCurrentUser(){ return OutputPresenter.GetCurrentUser(); }

    public static void SetupCloseButton(JButton closeButton){
        closeButton.setBackground(BLUE_BAYOUX);
        closeButton.setFont(new java.awt.Font("Source Code Pro", Font.PLAIN, 24));
        closeButton.setForeground(PICKLED_BLUEWOOD);
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
        submitButton.setBorder(BorderFactory.createLineBorder(BLUE_HAZE));
        submitButton.setPreferredSize(new Dimension(100, 38));
        submitButton.setMaximumSize(new Dimension(100, 38));
        submitButton.setMinimumSize(new Dimension(100, 38));
        submitButton.setBackground(BLUE_BAYOUX);
        submitButton.setForeground(BLUE_HAZE);
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
            separator.setBackground(BLUE_HAZE);
        }
    }
    public static void SetupInputFields(JTextField... inputFields) {
        for (JTextField inputField : inputFields) {
            inputField.setBackground(BLUE_BAYOUX);
            inputField.setForeground(BLUE_HAZE);
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
        showMessageDialog(null, error, "Error", ERROR_MESSAGE);
    }
    public static int DisplayConfirmation() {
        return JOptionPane.showConfirmDialog(null, "You sure you wanna delete this ?",
                "Confirmation", YES_NO_OPTION);
    }


    public static class OnMouseClick_CloseApp extends MouseAdapter {
        public void mouseClicked(MouseEvent e) { System.exit(0); }
    }
}