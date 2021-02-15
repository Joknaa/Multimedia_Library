package Views.UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import static Views.OutputView.*;

public class LoginPanelTest extends JPanel implements IPanel {
    private final JPanel logoPanel = new JPanel();
    private final JPanel inputPanel = new JPanel();
    private final JSeparator loginSeparator = new JSeparator();
    private final JSeparator passwordSeparator = new JSeparator();
    private final JLabel LogoIconPanel = new JLabel(new ImageIcon("Resources/LoginScreen/library_120px.png"));
    private final JLabel passwordLabel = new JLabel(new ImageIcon("Resources/LoginScreen/lock_30px.png"));
    private final JLabel loginLabel = new JLabel(new ImageIcon("Resources/LoginScreen/user_30px.png"));
    private final JLabel LogoTextPanel = new JLabel("Multimedia Library");
    private final JButton SignInButton = new JButton("Sign In");
    private final JButton SignUpButton = new JButton("Sign Up");
    private final JLabel closeLabel = new JLabel("X");
    private final JPasswordField passwordField = new JPasswordField("password");
    private final JTextField loginField = new JTextField("username");

    public LoginPanelTest() {
        SetupLogoPanel();
        SetupInputPanel();
        SetupMainPanel();
    }

    @Override
    public void Activate(){ this.setVisible(true);}
    @Override
    public void Deactivate(){ this.setVisible(false);}

    private void SetupLogoPanel() {
        logoPanel.setBackground(new Color(52, 66, 91));
        SetupLogoPanelLayout();
        SetupLogoTextPanel();
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
        inputPanel.setBackground(new Color(76, 200, 133));
        SetupLoginArea();
        SetupPasswordArea();
        SetupSubmitButton(SignInButton);
        SetupSubmitButton(SignUpButton);
        SetupClosePanel();
        SetupInputPanelLayout();
    }
    private void SetupLoginArea() {
        loginField.setBackground(new Color(76, 96, 133));
        loginField.setForeground(new Color(190, 200, 218));
        loginField.setBorder(null);
        loginField.addFocusListener(new OnFocusAction());
        loginField.addActionListener(new OnClickAction());
        loginSeparator.setBackground(new Color(190, 200, 218));
    }
    private void SetupPasswordArea() {
        passwordField.setBackground(new Color(76, 96, 133));
        passwordField.setForeground(new Color(190, 200, 218));
        passwordField.setBorder(null);
        passwordField.addFocusListener(new OnFocusAction());
        passwordSeparator.setBackground(new Color(190, 200, 218));
    } //Todo: refactoring Login and Password setup functions into one ?
    private void SetupSubmitButton(JButton submitButton) {
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
        submitButton.addActionListener(new OnClick_SwapPanels(LoginPanelTest, loginPanel));
    }

    private void SetupClosePanel() {
        closeLabel.setFont(new Font("Segoe UI", Font.PLAIN, 24));
        closeLabel.addMouseListener(new OnMouseClickAction());
    }
    private void SetupInputPanelLayout() {
        var inputPanelLayout = new GroupLayout(inputPanel);

        inputPanel.setLayout(inputPanelLayout);
        inputPanelLayout.setHorizontalGroup(
                inputPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(inputPanelLayout.createSequentialGroup()
                                .addContainerGap(93, Short.MAX_VALUE)
                                .addGroup(inputPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addGroup(inputPanelLayout.createSequentialGroup()
                                                .addComponent(SignInButton, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addGap(34, 34, 34)
                                                .addComponent(SignUpButton, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addGap(15, 15, 15))
                                        .addGroup(inputPanelLayout.createSequentialGroup()
                                                .addGroup(inputPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(passwordLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(loginLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addGap(26, 26, 26)
                                                .addGroup(inputPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(loginSeparator)
                                                        .addComponent(loginField)
                                                        .addComponent(passwordField)
                                                        .addComponent(passwordSeparator, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 226, GroupLayout.PREFERRED_SIZE))))
                                .addContainerGap(88, Short.MAX_VALUE))
                        .addGroup(GroupLayout.Alignment.TRAILING, inputPanelLayout.createSequentialGroup()
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(closeLabel, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
                                .addGap(8, 8, 8))
        );
        inputPanelLayout.setVerticalGroup(
                inputPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(inputPanelLayout.createSequentialGroup()
                                .addComponent(closeLabel, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                                .addGap(124, 124, 124)
                                .addGroup(inputPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addComponent(loginLabel)
                                        .addComponent(loginField, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
                                .addComponent(loginSeparator, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(inputPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addComponent(passwordField, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(passwordLabel))
                                .addGap(0, 0, 0)
                                .addComponent(passwordSeparator, GroupLayout.PREFERRED_SIZE, 13, GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)
                                .addGroup(inputPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(SignInButton, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(SignUpButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }

    private void SetupMainPanel() {
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

    class OnFocusAction extends FocusAdapter {
        @Override
        public void focusGained(FocusEvent e) { EmptyPlaceHolder((JTextField) e.getComponent()); }
    }
    class OnMouseClickAction extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) { CloseApp(); }
    }
    static class OnClickAction implements ActionListener {
        JPanel fromPanel;
        JPanel toPanel;

        OnClickAction(){}
        OnClickAction(JPanel fromPanel, JPanel toPanel){
            this.fromPanel = fromPanel;
            this.toPanel = toPanel;
        }

        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }

    private void CloseApp() { System.exit(0); }
    private void EmptyPlaceHolder(JTextField field) { field.setText(""); }
}