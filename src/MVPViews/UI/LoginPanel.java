package MVPViews.UI;

import static MVPViews.OutputView.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginPanel extends JPanel implements IPanel {
    private final JPanel logoPanel = new JPanel();
    private final JPanel inputPanel = new JPanel();
    private final JSeparator loginSeparator = new JSeparator();
    private final JSeparator passwordSeparator = new JSeparator();
    private final JLabel LogoIconPanel = new JLabel(new ImageIcon("Resources/LoginScreen/library_120px.png"));
    private final JLabel passwordLabel = new JLabel(new ImageIcon("Resources/LoginScreen/lock_30px.png"));
    private final JLabel loginLabel = new JLabel(new ImageIcon("Resources/LoginScreen/user_30px.png"));
    private final JLabel LogoTextPanel = new JLabel("Multimedia Library");
    private final JButton signInButton = new JButton("Sign In");
    private final JButton signUpButton = new JButton("Sign Up");
    private final JButton closeButton = new JButton("X");
    private final JPasswordField passwordField = new JPasswordField();
    private final JTextField loginField = new JTextField();

    public LoginPanel() {
        SetupLogoPanel();
        SetupInputPanel();
        SetupMainPanel();
    }

    @Override
    public JPanel GetPanel() { return this; }
    @Override
    public void Activate(){ setVisible(true);}
    @Override
    public void Deactivate(){ setVisible(false);}

    private void SetupLogoPanel() {
        logoPanel.setBackground(new Color(52, 66, 91));
        SetupLogoTextPanel();
        SetupLogoPanelLayout();
    }
    private void SetupLogoPanelLayout() {
        var logoPanelLayout = new GroupLayout(logoPanel);

        logoPanel.setLayout(logoPanelLayout);
        logoPanelLayout.setHorizontalGroup(
                logoPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(logoPanelLayout.createSequentialGroup()
                                .addGap(165, 165, 165)
                                .addComponent(LogoIconPanel)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
    private void SetupLogoTextPanel() {
        LogoTextPanel.setForeground(new Color(76, 96, 133));
        LogoTextPanel.setFont(new Font("Source Code Pro", Font.PLAIN, 24));
    }

    private void SetupInputPanel() {
        inputPanel.setBackground(new Color(76, 96, 133));
        SetupSeparator(loginSeparator);
        SetupSeparator(passwordSeparator);
        SetupInputField(loginField);
        SetupInputField(passwordField);
        SetupSubmitButton(signInButton, new OnAction_SignIn(loginField, passwordField));
        SetupSubmitButton(signUpButton, new OnAction_SwapPanels(signupPanel));
        SetupCloseButton();
        SetupInputPanelLayout();
    }
    private void SetupSeparator(JSeparator separator) {
        separator.setBackground(new Color(190, 200, 218));
    }
    private void SetupInputField(JTextField inputField) {
        inputField.setBackground(new Color(76, 96, 133));
        inputField.setForeground(new Color(190, 200, 218));
        inputField.setBorder(null);
    }
    private void SetupSubmitButton(JButton submitButton, ActionListener actionListener) {
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

    private void SetupCloseButton() {
        closeButton.setBackground(new Color(76, 96, 133));
        closeButton.setFont(new Font("Source Code Pro", 0, 24));
        closeButton.setForeground(new Color(52, 66, 91));
        closeButton.setText("X");
        closeButton.setToolTipText("");
        closeButton.setBorder(null);
        closeButton.setContentAreaFilled(false);
        closeButton.setFocusPainted(false);
        closeButton.setFocusable(false);
        closeButton.setMaximumSize(new Dimension(100, 38));
        closeButton.setMinimumSize(new Dimension(100, 38));
        closeButton.setPreferredSize(new Dimension(100, 38));
        closeButton.setFont(new Font("Segoe UI", Font.PLAIN, 24));
        closeButton.addMouseListener(new OnMouseClick_CloseApp());
    }
    private void SetupInputPanelLayout() {
        var inputPanelLayout = new GroupLayout(inputPanel);

        inputPanel.setLayout(inputPanelLayout);
        inputPanelLayout.setHorizontalGroup(
                inputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(inputPanelLayout.createSequentialGroup()
                                .addGap(83, 83, 83)
                                .addGroup(inputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(inputPanelLayout.createSequentialGroup()
                                                .addComponent(signInButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(34, 34, 34)
                                                .addComponent(signUpButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(15, 15, 15))
                                        .addGroup(inputPanelLayout.createSequentialGroup()
                                                .addGroup(inputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(passwordLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(loginLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addGap(26, 26, 26)
                                                .addGroup(inputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(loginSeparator)
                                                        .addComponent(loginField)
                                                        .addComponent(passwordField)
                                                        .addComponent(passwordSeparator, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addContainerGap(85, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, inputPanelLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(closeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(8, 8, 8))
        );
        inputPanelLayout.setVerticalGroup(
                inputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(inputPanelLayout.createSequentialGroup()
                                .addGap(8, 8, 8)
                        .addComponent(closeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(73, 73, 73)
                                .addGroup(inputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(loginLabel)
                                        .addComponent(loginField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(loginSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(inputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(passwordLabel))
                                .addGap(0, 0, 0)
                                .addComponent(passwordSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)
                                .addGroup(inputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(signInButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(signUpButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(194, 194, 194))
        );
    }

    private void SetupMainPanel() {
        SetupMainPanelLayout();
    }
    private void SetupMainPanelLayout() {
        var mainPanelLayout = new GroupLayout(this);

        this.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
                mainPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(mainPanelLayout.createSequentialGroup()
                                .addComponent(logoPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(inputPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        );
        mainPanelLayout.setVerticalGroup(
                mainPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(logoPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(inputPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }
}