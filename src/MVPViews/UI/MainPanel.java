package MVPViews.UI;

import javax.swing.plaf.basic.BasicScrollBarUI;
import javax.swing.event.*;
import javax.swing.table.*;
import javax.swing.*;
import static MVPViews.OutputView.*;
import static javax.swing.GroupLayout.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainPanel extends JPanel implements IPanel, ActionListener {
    //<editor-fold desc="Variables Declarations">">
    private final JPanel logoPanel = new JPanel();
    private final JPanel headerPanel = new JPanel();
    private final JPanel descriptionPanel = new JPanel();
    private final JPanel listPanel = new JPanel();
    private final JPanel buttonsPanel = new JPanel();
    private final JList<String> list = new JList<>();
    private final JLabel logoLabel = new JLabel(new ImageIcon("Resources/LoginScreen/library_100px.png"));
    private final JLabel greetingLabel = new JLabel("Greeting !");
    private final JScrollPane scrollPanList = new JScrollPane();
    private final JTable descriptionTable = new JTable();
    private final JTextArea logoTextArea = new JTextArea();
    private final JButton closeButton = new JButton("X");
    private final JButton addButton = new JButton("Add");
    private final JButton editButton = new JButton("Edit");
    private final JButton deleteButton = new JButton("Delete");
    private final JButton logOutButton = new JButton("Logout");
    private final DefaultListModel<String> defaultListModel = new DefaultListModel<>();
    //</editor-fold>

    public MainPanel(){
        SetupLogoPanel();
        SetupHeaderPanel();
        SetupDescriptionPanel();
        SetupListPanel();
        SetupButtonsPanel();
        SetupMainPanel();
    }

    private void SetupLogoPanel() {
        SetupLogoTextArea();
        SetupLogoPanelLayout();
        logoPanel.setBackground(PICKLED_BLUEWOOD);
        logoPanel.setPreferredSize(new Dimension(450, 500));
    }
    private void SetupLogoTextArea() {
        logoTextArea.setEditable(false);
        logoTextArea.setBackground(PICKLED_BLUEWOOD);
        logoTextArea.setColumns(5);
        logoTextArea.setFont(new Font("Source Code Pro", Font.PLAIN, 30));
        logoTextArea.setForeground(BLUE_BAYOUX);
        logoTextArea.setRows(1);
        logoTextArea.setTabSize(1);
        logoTextArea.setText("Multimedia Library");
        logoTextArea.setAutoscrolls(false);
        logoTextArea.setFocusable(false);
    }
    private void SetupLogoPanelLayout() {
        GroupLayout LogoPanelLayout = new GroupLayout(logoPanel);
        logoPanel.setLayout(LogoPanelLayout);
        LogoPanelLayout.setHorizontalGroup(
                LogoPanelLayout.createParallelGroup(Alignment.LEADING)
                        .addGroup(LogoPanelLayout.createSequentialGroup()
                                .addComponent(logoLabel)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(logoTextArea, DEFAULT_SIZE, 344, Short.MAX_VALUE)
                        )
        );
        LogoPanelLayout.setVerticalGroup(
                LogoPanelLayout.createParallelGroup(Alignment.LEADING)
                        .addGroup(LogoPanelLayout.createSequentialGroup()
                                .addGroup(LogoPanelLayout.createParallelGroup(Alignment.TRAILING)
                                        .addGroup(LogoPanelLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(logoTextArea, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE)
                                                .addGap(41, 41, 41))
                                        .addComponent(logoLabel))
                                .addGap(0, 0, Short.MAX_VALUE)
                        )
        );
    }

    private void SetupHeaderPanel() {
        headerPanel.setBackground(BLUE_BAYOUX);
        SetupGreetingLabel();
        SetupSubmitButton(logOutButton, this, true, "LogOut");
        SetupHeaderPanelLayout();
    }
    private void SetupGreetingLabel() {
        greetingLabel.setFont(new Font("Source Code Pro", Font.PLAIN, 24));
        greetingLabel.setForeground(BLUE_HAZE);
        greetingLabel.setHorizontalAlignment(SwingConstants.CENTER);
        greetingLabel.setText("Greeting " + GetCurrentUser() + "!");
    }
    private void SetupHeaderPanelLayout() {
        GroupLayout headerPanelLayout = new GroupLayout(headerPanel);
        headerPanel.setLayout(headerPanelLayout);
        headerPanelLayout.setHorizontalGroup(
                headerPanelLayout.createParallelGroup(Alignment.LEADING)
                        .addComponent(greetingLabel, Alignment.TRAILING, DEFAULT_SIZE, DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(Alignment.TRAILING, headerPanelLayout.createSequentialGroup()
                                .addContainerGap(151, Short.MAX_VALUE)
                                .addComponent(logOutButton, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE)
                                .addGap(147, 147, 147))
        );
        headerPanelLayout.setVerticalGroup(
                headerPanelLayout.createParallelGroup(Alignment.LEADING)
                        .addGroup(headerPanelLayout.createSequentialGroup()
                                .addComponent(greetingLabel)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(logOutButton, PREFERRED_SIZE, 23, PREFERRED_SIZE)
                                .addContainerGap(DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }

    private void SetupDescriptionPanel() {
        SetupDescriptionTable();
        SetupDescriptionPanelLayout();
        descriptionPanel.setBackground(BLUE_BAYOUX);
        descriptionPanel.setPreferredSize(new Dimension(450, 500));
    }
    private void SetupDescriptionTable() {
        CreateDescriptionTable();
        descriptionTable.setFont(new Font("Source Code Pro", Font.PLAIN, 15));
        descriptionTable.setForeground(BLUE_HAZE);
        descriptionTable.setBackground(BLUE_BAYOUX);
        descriptionTable.getColumnModel().getColumn(1).setPreferredWidth(300);
        descriptionTable.getTableHeader().setReorderingAllowed(false);
        descriptionTable.getTableHeader().setResizingAllowed(false);
        descriptionTable.setRowSelectionAllowed(false);
        descriptionTable.setShowVerticalLines(false);
        descriptionTable.setFocusable(false);
        descriptionTable.setEnabled(false);
        descriptionTable.setRowHeight(35);
    }
    private void CreateDescriptionTable() {
        String[][] data = {{"Name", null}, {"Added by", null}, {"Date", null}, {"Location", null}};
        String[] columnNames = {"", ""};
        descriptionTable.setModel(new DefaultTableModel(data,columnNames) {
            final boolean[] canEdit = new boolean [] { false, false };
            public boolean isCellEditable(int rowIndex, int columnIndex) { return canEdit [columnIndex]; }
        });
    }
    private void SetupDescriptionPanelLayout() {
        GroupLayout descriptionPanelLayout = new GroupLayout(descriptionPanel);
        descriptionPanel.setLayout(descriptionPanelLayout);
        descriptionPanelLayout.setHorizontalGroup(
                descriptionPanelLayout.createParallelGroup(Alignment.LEADING)
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(descriptionPanelLayout.createParallelGroup(Alignment.LEADING)
                                .addGroup(descriptionPanelLayout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(descriptionTable, DEFAULT_SIZE, DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
                        )
        );
        descriptionPanelLayout.setVerticalGroup(
                descriptionPanelLayout.createParallelGroup(Alignment.LEADING)
                        .addGap(0, 196, Short.MAX_VALUE)
                        .addGroup(descriptionPanelLayout.createParallelGroup(Alignment.LEADING)
                                .addGroup(descriptionPanelLayout.createSequentialGroup()
                                        .addGap(28, 28, 28)
                                        .addComponent(descriptionTable, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE)
                                        .addContainerGap(28, Short.MAX_VALUE)
                                )
                        )
        );
    }

    private void SetupListPanel() {
        SetupScrollPanList();
        SetupListPanelLayout();
        listPanel.setBackground(PICKLED_BLUEWOOD);
    }
    private void SetupScrollPanList() {
        SetupMediaList();
        scrollPanList.setBackground(PICKLED_BLUEWOOD);
        scrollPanList.setBorder(null);
        scrollPanList.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPanList.setEnabled(false);
        scrollPanList.setFocusable(false);
        scrollPanList.setRequestFocusEnabled(false);
        scrollPanList.getVerticalScrollBar().setBackground(new Color(76,96,133));
        scrollPanList.getVerticalScrollBar().setUI(new BasicScrollBarUI() {
            @Override
            protected void configureScrollBarColors() {
                this.thumbColor = BLUE_HAZE;
            }
        });
        scrollPanList.setViewportView(list);
    }
    private void SetupMediaList() {
        CreateMediaList();
        list.setFont(new Font("Source Code Pro", Font.PLAIN, 18));
        list.setSelectionBackground(BLUE_HAZE);
        list.setSelectionForeground(PICKLED_BLUEWOOD);
        list.setBackground(PICKLED_BLUEWOOD);
        list.setForeground(BLUE_HAZE);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.setCursor(new Cursor(Cursor.HAND_CURSOR));
        list.setFixedCellHeight(40);
        list.setFixedCellWidth(40);
        list.setAutoscrolls(false);
        list.addListSelectionListener(this::ListSelectionChanged);
    }
    public void CreateMediaList() {
        String[] listData = GetListContent();
        list.setModel(defaultListModel);
        for (String element : listData) { defaultListModel.addElement(element); }
    }
    private void SetupListPanelLayout() {
        GroupLayout ListPanelLayout = new GroupLayout(listPanel);
        listPanel.setLayout(ListPanelLayout);
        ListPanelLayout.setHorizontalGroup(
                ListPanelLayout.createParallelGroup(Alignment.LEADING)
                        .addGroup(Alignment.TRAILING, ListPanelLayout.createSequentialGroup()
                                .addContainerGap(DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(scrollPanList, PREFERRED_SIZE, 340, PREFERRED_SIZE)
                                .addGap(60, 60, 60))
        );
        ListPanelLayout.setVerticalGroup(
                ListPanelLayout.createParallelGroup(Alignment.LEADING)
                        .addGroup(Alignment.TRAILING, ListPanelLayout.createSequentialGroup()
                                .addContainerGap(49, Short.MAX_VALUE)
                                .addComponent(scrollPanList, PREFERRED_SIZE, 297, PREFERRED_SIZE)
                                .addGap(54, 54, 54))
        );
    }

    private void SetupButtonsPanel() {
        buttonsPanel.setBackground(BLUE_BAYOUX);
        SetupSubmitButton(addButton, this, true, "Add an item to the list");
        SetupSubmitButton(editButton, this, false, "Edit an item in the list");
        SetupSubmitButton(deleteButton, this, false, "Delete an item from the list");
        SetupButtonsPanelLayout();
    }
    private void SetupButtonsPanelLayout() {
        GroupLayout buttonsPanelLayout = new GroupLayout(buttonsPanel);
        buttonsPanel.setLayout(buttonsPanelLayout);
        buttonsPanelLayout.setHorizontalGroup(
                buttonsPanelLayout.createParallelGroup(Alignment.LEADING)
                        .addGroup(Alignment.TRAILING, buttonsPanelLayout.createSequentialGroup()
                                .addContainerGap(36, Short.MAX_VALUE)
                                .addComponent(addButton, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(editButton, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(deleteButton, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE)
                                .addGap(44, 44, 44))
        );
        buttonsPanelLayout.setVerticalGroup(
                buttonsPanelLayout.createParallelGroup(Alignment.LEADING)
                        .addGroup(Alignment.TRAILING, buttonsPanelLayout.createSequentialGroup()
                                .addContainerGap(DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(buttonsPanelLayout.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(editButton, PREFERRED_SIZE, 23, PREFERRED_SIZE)
                                        .addComponent(addButton, PREFERRED_SIZE, 23, PREFERRED_SIZE)
                                        .addComponent(deleteButton, PREFERRED_SIZE, 23, PREFERRED_SIZE))
                                .addGap(33, 33, 33))
        );
    }

    private void SetupMainPanel() {
        SetupCloseButton(closeButton);
        SetupMainPanelLayout();
        setBackground(BLUE_BAYOUX);
        setPreferredSize(new Dimension(900, 500));
    }
    private void SetupMainPanelLayout() {
        GroupLayout MainPanelLayout = new GroupLayout(this);
        this.setLayout(MainPanelLayout);
        MainPanelLayout.setHorizontalGroup(
                MainPanelLayout.createParallelGroup(Alignment.LEADING)
                        .addGroup(MainPanelLayout.createSequentialGroup()
                                .addGroup(MainPanelLayout.createParallelGroup(Alignment.LEADING, false)
                                        .addComponent(logoPanel, DEFAULT_SIZE, DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(listPanel, DEFAULT_SIZE, DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(MainPanelLayout.createParallelGroup(Alignment.LEADING)
                                        .addGroup(MainPanelLayout.createSequentialGroup()
                                                .addGroup(MainPanelLayout.createParallelGroup(Alignment.LEADING)
                                                        .addComponent(descriptionPanel, DEFAULT_SIZE, 433, Short.MAX_VALUE)
                                                        .addGroup(MainPanelLayout.createSequentialGroup()
                                                                .addGap(0, 0, Short.MAX_VALUE)
                                                                .addComponent(buttonsPanel, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE)))
                                                .addGap(8, 8, 8))
                                        .addGroup(MainPanelLayout.createSequentialGroup()
                                                .addComponent(headerPanel, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(closeButton, PREFERRED_SIZE, 21, PREFERRED_SIZE)
                                                .addGap(0, 7, Short.MAX_VALUE))))
        );
        MainPanelLayout.setVerticalGroup(
                MainPanelLayout.createParallelGroup(Alignment.LEADING)
                        .addGroup(MainPanelLayout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addGroup(MainPanelLayout.createParallelGroup(Alignment.LEADING)
                                        .addComponent(headerPanel, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE)
                                        .addComponent(closeButton, PREFERRED_SIZE, 23, PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(descriptionPanel, PREFERRED_SIZE, 196, PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(buttonsPanel, PREFERRED_SIZE, 57, PREFERRED_SIZE)
                                .addGap(84, 84, 84))
                        .addGroup(Alignment.TRAILING, MainPanelLayout.createSequentialGroup()
                                .addComponent(logoPanel, PREFERRED_SIZE, 100, PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(listPanel, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE)
                        )
        );
    }

    private void ListSelectionChanged(ListSelectionEvent evt) {
        String selectedValue = list.getSelectedValue();
        if (!evt.getValueIsAdjusting()) {
            editButton.setEnabled(true);
            deleteButton.setEnabled(true);
            OnListSelection_UpdateDescription(selectedValue, descriptionTable);
        } }

    @Override
    public JPanel GetPanel() { return this; }
    @Override
    public void Activate(){ this.setVisible(true);}
    @Override
    public void Deactivate(){ this.setVisible(false);}
    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getSource().equals(logOutButton))
            OnClick_Logout();
        else if (event.getSource().equals(addButton))
            OnClick_AddMedia(defaultListModel, descriptionTable);
        else if (event.getSource().equals(editButton))
            OnClick_EditMedia(list, defaultListModel, descriptionTable);
        else if (event.getSource().equals(deleteButton)){
            OnClick_DeleteMedia(list, defaultListModel, deleteButton);
        }
    }
}