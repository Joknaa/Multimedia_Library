package MVPViews.UI;

import static MVPViews.OutputView.*;
import javax.swing.*;
import static javax.swing.GroupLayout.*;
import java.awt.*;
import java.awt.event.*;

public class LoginPanel extends JPanel implements IPanel, ActionListener {
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

    private void SetupLogoPanel() {
        logoPanel.setBackground(new Color(52, 66, 91));
        SetupLogoTextPanel();
        SetupLogoPanelLayout();
    }
    private void SetupLogoPanelLayout() {
        var logoPanelLayout = new GroupLayout(logoPanel);

        logoPanel.setLayout(logoPanelLayout);
        logoPanelLayout.setHorizontalGroup(
                logoPanelLayout.createParallelGroup(Alignment.LEADING)
                        .addGroup(logoPanelLayout.createSequentialGroup()
                                .addGap(165, 165, 165)
                                .addComponent(LogoIconPanel)
                                .addContainerGap(DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(Alignment.TRAILING, logoPanelLayout.createSequentialGroup()
                                .addContainerGap(105, Short.MAX_VALUE)
                                .addComponent(LogoTextPanel)
                                .addGap(93, 93, 93))
        );
        logoPanelLayout.setVerticalGroup(
                logoPanelLayout.createParallelGroup(Alignment.LEADING)
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
        SetupInputFields(loginField, passwordField);
        SetupSeparators(loginSeparator,passwordSeparator);
        SetupSubmitButton(signInButton, this);
        SetupSubmitButton(signUpButton, this);
        SetupCloseButton(closeButton);
        SetupInputPanelLayout();
    }
    private void SetupSeparators(JSeparator... separators) {
        for (JSeparator separator : separators) {
            separator.setBackground(new Color(190, 200, 218));
        }
    }
    private void SetupInputFields(JTextField... inputFields) {
        for (JTextField inputField : inputFields) {
            inputField.setBackground(new Color(76, 96, 133));
            inputField.setForeground(new Color(190, 200, 218));
            inputField.setBorder(null);
        }
    }
    private void SetupInputPanelLayout() {
        var inputPanelLayout = new GroupLayout(inputPanel);

        inputPanel.setLayout(inputPanelLayout);
        inputPanelLayout.setHorizontalGroup(
                inputPanelLayout.createParallelGroup(Alignment.LEADING)
                        .addGroup(inputPanelLayout.createSequentialGroup()
                                .addGap(83, 83, 83)
                                .addGroup(inputPanelLayout.createParallelGroup(Alignment.TRAILING)
                                        .addGroup(inputPanelLayout.createSequentialGroup()
                                                .addComponent(signInButton, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE)
                                                .addGap(34, 34, 34)
                                                .addComponent(signUpButton, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE)
                                                .addGap(15, 15, 15))
                                        .addGroup(inputPanelLayout.createSequentialGroup()
                                                .addGroup(inputPanelLayout.createParallelGroup(Alignment.LEADING, false)
                                                        .addComponent(passwordLabel, DEFAULT_SIZE, DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(loginLabel, DEFAULT_SIZE, DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addGap(26, 26, 26)
                                                .addGroup(inputPanelLayout.createParallelGroup(Alignment.LEADING, false)
                                                        .addComponent(loginSeparator)
                                                        .addComponent(loginField)
                                                        .addComponent(passwordField)
                                                        .addComponent(passwordSeparator, Alignment.TRAILING, PREFERRED_SIZE, 226, PREFERRED_SIZE))))
                                .addContainerGap(85, Short.MAX_VALUE))
                        .addGroup(Alignment.TRAILING, inputPanelLayout.createSequentialGroup()
                                .addContainerGap(DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(closeButton, PREFERRED_SIZE, 21, PREFERRED_SIZE)
                                .addGap(8, 8, 8))
        );
        inputPanelLayout.setVerticalGroup(
                inputPanelLayout.createParallelGroup(Alignment.LEADING)
                        .addGroup(inputPanelLayout.createSequentialGroup()
                                .addGap(8, 8, 8)
                        .addComponent(closeButton, PREFERRED_SIZE, 23, PREFERRED_SIZE)
                                .addGap(73, 73, 73)
                                .addGroup(inputPanelLayout.createParallelGroup(Alignment.TRAILING)
                                        .addComponent(loginLabel)
                                        .addComponent(loginField, PREFERRED_SIZE, 40, PREFERRED_SIZE))
                                .addComponent(loginSeparator, PREFERRED_SIZE, 10, PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(inputPanelLayout.createParallelGroup(Alignment.TRAILING)
                                        .addComponent(passwordField, PREFERRED_SIZE, 39, PREFERRED_SIZE)
                                        .addComponent(passwordLabel))
                                .addGap(0, 0, 0)
                                .addComponent(passwordSeparator, PREFERRED_SIZE, 13, PREFERRED_SIZE)
                                .addGap(29, 29, 29)
                                .addGroup(inputPanelLayout.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(signInButton, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE)
                                        .addComponent(signUpButton, DEFAULT_SIZE, DEFAULT_SIZE, Short.MAX_VALUE))
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
                mainPanelLayout.createParallelGroup(Alignment.LEADING)
                        .addGroup(mainPanelLayout.createSequentialGroup()
                                .addComponent(logoPanel, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(inputPanel, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE))
        );
        mainPanelLayout.setVerticalGroup(
                mainPanelLayout.createParallelGroup(Alignment.LEADING)
                        .addComponent(logoPanel, DEFAULT_SIZE, DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(inputPanel, DEFAULT_SIZE, DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }


    @Override
    public JPanel GetPanel() { return this; }
    @Override
    public void Activate(){ setVisible(true);}
    @Override
    public void Deactivate(){ setVisible(false);}
    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getSource().equals(signInButton))
            OnAction_SignIn(loginField, passwordField);
        else if (event.getSource().equals(signUpButton))
            OnAction_SwapPanels(signUpPanel);

    }

}