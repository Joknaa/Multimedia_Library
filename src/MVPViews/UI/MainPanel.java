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
    private final JList<String> list = new JList<>();
    private final JLabel logoLabel = new JLabel(new ImageIcon("Resources/LoginScreen/library_80px Dark.png"));
    private final JLabel greetingLabel = new JLabel("Greeting Oknaa!");
    private final JLabel descriptionImage = new JLabel();
    private final JScrollPane scrollPanList = new JScrollPane();
    private final JTable descriptionTable = new JTable();
    private final JTextArea logoTextArea = new JTextArea();
    private final JButton closeButton = new JButton("X");
    private final JButton addButton = new JButton("Add");
    private final JButton editButton = new JButton("Edit");
    private final JButton deleteButton = new JButton("Delete");
    private final DefaultListModel<String> defaultListModel = new DefaultListModel<>();
    //</editor-fold>

    public MainPanel(){
        SetupLogoPanel();
        SetupHeaderPanel();
        SetupDescriptionPanel();
        SetupListPanel();
        SetupMainPanel();
    }

    private void SetupLogoPanel() {
        SetupLogoTextArea();
        SetupLogoPanelLayout();
        logoPanel.setBackground(new Color(76, 96, 133));
        logoPanel.setPreferredSize(new Dimension(450, 500));
    }
    private void SetupLogoTextArea() {
        logoTextArea.setEditable(false);
        logoTextArea.setBackground(new Color(76, 96, 133));
        logoTextArea.setColumns(5);
        logoTextArea.setFont(new Font("Source Code Pro", Font.PLAIN, 30)); // NOI18N
        logoTextArea.setForeground(new Color(52, 66, 91));
        logoTextArea.setRows(1);
        logoTextArea.setTabSize(1);
        logoTextArea.setText("Multimedia \nLibrary");
        logoTextArea.setAutoscrolls(false);
        logoTextArea.setFocusable(false);
    }
    private void SetupLogoPanelLayout() {
        GroupLayout LogoPanelLayout = new GroupLayout(logoPanel);
        logoPanel.setLayout(LogoPanelLayout);
        LogoPanelLayout.setHorizontalGroup(
                LogoPanelLayout.createParallelGroup(Alignment.LEADING)
                        .addGroup(LogoPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(logoLabel)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(logoTextArea, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE)
                                .addContainerGap(19, Short.MAX_VALUE))
        );
        LogoPanelLayout.setVerticalGroup(
                LogoPanelLayout.createParallelGroup(Alignment.LEADING)
                        .addGroup(LogoPanelLayout.createSequentialGroup()
                                .addGroup(LogoPanelLayout.createParallelGroup(Alignment.LEADING, false)
                                        .addComponent(logoTextArea)
                                        .addComponent(logoLabel, DEFAULT_SIZE, DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(64, 64, 64))
        );
    }

    private void SetupHeaderPanel() {
        headerPanel.setBackground(new Color(52, 66, 91));
        SetupGreetingLabel();
        SetupSubmitButton(addButton, this, true, "Add an item to the list");
        SetupSubmitButton(editButton, this, false, "Edit an item in the list");
        SetupSubmitButton(deleteButton, this, false, "Delete an item from the list");
        SetupHeaderPanelLayout();
    }
    private void SetupGreetingLabel() {
        greetingLabel.setFont(new Font("Source Code Pro Light", Font.PLAIN, 24));
        greetingLabel.setForeground(new Color(190, 200, 218));
        greetingLabel.setHorizontalAlignment(SwingConstants.CENTER);
        greetingLabel.setText("Welcome " + GetCurrentUser() + "!");
    }
    private void SetupHeaderPanelLayout() {
        javax.swing.GroupLayout headerPanelLayout = new GroupLayout(headerPanel);
        headerPanel.setLayout(headerPanelLayout);
        headerPanelLayout.setHorizontalGroup(
                headerPanelLayout.createParallelGroup(Alignment.LEADING)
                        .addGroup(headerPanelLayout.createSequentialGroup()
                                .addGap(39, 39, 39)
                                .addComponent(addButton, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE)
                                .addGap(40, 40, 40)
                                .addComponent(editButton, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                                .addComponent(deleteButton, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE)
                                .addGap(42, 42, 42))
                        .addComponent(greetingLabel, Alignment.TRAILING, DEFAULT_SIZE, DEFAULT_SIZE, Short.MAX_VALUE)
        );
        headerPanelLayout.setVerticalGroup(
                headerPanelLayout.createParallelGroup(Alignment.LEADING)
                        .addGroup(headerPanelLayout.createSequentialGroup()
                                .addComponent(greetingLabel)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(headerPanelLayout.createParallelGroup(Alignment.LEADING)
                                        .addGroup(headerPanelLayout.createParallelGroup(Alignment.BASELINE)
                                                .addComponent(editButton, PREFERRED_SIZE, 23, PREFERRED_SIZE)
                                                .addComponent(addButton, PREFERRED_SIZE, 23, PREFERRED_SIZE))
                                        .addComponent(deleteButton, PREFERRED_SIZE, 23, PREFERRED_SIZE))
                                .addContainerGap(DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }

    private void SetupDescriptionPanel() {
        SetupDescriptionImage();
        SetupDescriptionTable();
        SetupDescriptionPanelLayout();
        descriptionPanel.setBackground(new Color(52, 66, 91));
        descriptionPanel.setPreferredSize(new Dimension(450, 500));
    }
    private void SetupDescriptionImage() {
        descriptionImage.setForeground(new Color(255, 255, 255));
        descriptionImage.setBorder(BorderFactory.createLineBorder(new Color(255, 255, 255)));
        descriptionImage.setHorizontalTextPosition(SwingConstants.RIGHT);
    }
    private void SetupDescriptionTable() {
        CreateDescriptionTable();
        descriptionTable.setFont(new Font("Source Code Pro", Font.PLAIN, 15));
        descriptionTable.setForeground(new Color(190, 200, 218));
        descriptionTable.setBackground(new Color(52, 66, 91));
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
        String[][] data = {{"Name", null}, {"Type", null}, {"Date", null}, {"Location", null}};
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
                        .addGroup(descriptionPanelLayout.createSequentialGroup()
                                .addGroup(descriptionPanelLayout.createParallelGroup(Alignment.LEADING)
                                        .addGroup(descriptionPanelLayout.createSequentialGroup()
                                                .addGap(155, 155, 155)
                                                .addComponent(descriptionImage, PREFERRED_SIZE, 150, PREFERRED_SIZE))
                                        .addGroup(descriptionPanelLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(descriptionTable, PREFERRED_SIZE, 436, PREFERRED_SIZE)))
                                .addContainerGap(17, Short.MAX_VALUE))
        );
        descriptionPanelLayout.setVerticalGroup(
                descriptionPanelLayout.createParallelGroup(Alignment.LEADING)
                        .addGroup(descriptionPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(descriptionImage, DEFAULT_SIZE, DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(39, 39, 39)
                                .addComponent(descriptionTable, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE)
                                .addGap(26, 26, 26))
        );
    }

    private void SetupListPanel() {
        SetupScrollPanList();
        SetupListPanelLayout();
        listPanel.setBackground(new Color(52, 66, 91));
    }
    private void SetupScrollPanList() {
        SetupMediaList();
        scrollPanList.setBackground(new Color(52, 66, 91));
        scrollPanList.setBorder(null);
        scrollPanList.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPanList.setEnabled(false);
        scrollPanList.setFocusable(false);
        scrollPanList.setRequestFocusEnabled(false);
        scrollPanList.getVerticalScrollBar().setBackground(new Color(76,96,133));
        scrollPanList.getVerticalScrollBar().setUI(new BasicScrollBarUI() {
            @Override
            protected void configureScrollBarColors() {
                this.thumbColor = new Color(190, 200, 218);
            }
        });
        scrollPanList.setViewportView(list);
    }
    private void SetupMediaList() {
        CreateMediaList();
        list.setFont(new Font("Source Code Pro", Font.PLAIN, 18));
        list.setSelectionBackground(new Color(190, 200, 218));
        list.setSelectionForeground(new Color(52, 66, 91));
        list.setBackground(new Color(52, 66, 91));
        list.setForeground(new Color(190, 200, 218));
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
                        .addGroup(ListPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(scrollPanList))
        );
        ListPanelLayout.setVerticalGroup(
                ListPanelLayout.createParallelGroup(Alignment.LEADING)
                        .addComponent(scrollPanList, DEFAULT_SIZE, 336, Short.MAX_VALUE)
        );
    }

    private void SetupMainPanel() {
        SetupCloseButton(closeButton);
        SetupMainPanelLayout();
        setBackground(new Color(76, 96, 133));
        setPreferredSize(new Dimension(900, 500));
    }
    private void SetupMainPanelLayout() {
        GroupLayout MainPanelLayout = new GroupLayout(this);
        this.setLayout(MainPanelLayout);
        MainPanelLayout.setHorizontalGroup(
                MainPanelLayout.createParallelGroup(Alignment.LEADING)
                        .addGroup(MainPanelLayout.createSequentialGroup()
                                .addGap(41, 41, 41)
                                .addGroup(MainPanelLayout.createParallelGroup(Alignment.LEADING, false)
                                        .addComponent(logoPanel, DEFAULT_SIZE, 322, Short.MAX_VALUE)
                                        .addComponent(listPanel, DEFAULT_SIZE, DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(34, 34, 34)
                                .addGroup(MainPanelLayout.createParallelGroup(Alignment.LEADING)
                                        .addGroup(MainPanelLayout.createSequentialGroup()
                                                .addComponent(descriptionPanel, PREFERRED_SIZE, 468, PREFERRED_SIZE)
                                                .addContainerGap(35, Short.MAX_VALUE))
                                        .addGroup(Alignment.TRAILING, MainPanelLayout.createSequentialGroup()
                                                .addComponent(headerPanel, DEFAULT_SIZE, DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(closeButton, PREFERRED_SIZE, 21, PREFERRED_SIZE)
                                                .addGap(8, 8, 8))))
        );
        MainPanelLayout.setVerticalGroup(
                MainPanelLayout.createParallelGroup(Alignment.LEADING)
                        .addGroup(MainPanelLayout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addGroup(MainPanelLayout.createParallelGroup(Alignment.LEADING, false)
                                        .addComponent(closeButton, PREFERRED_SIZE, 23, PREFERRED_SIZE)
                                        .addComponent(logoPanel, PREFERRED_SIZE, 80, PREFERRED_SIZE)
                                        .addComponent(headerPanel, DEFAULT_SIZE, DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(33, 33, 33)
                                .addGroup(MainPanelLayout.createParallelGroup(Alignment.LEADING, false)
                                        .addComponent(descriptionPanel, DEFAULT_SIZE, 336, Short.MAX_VALUE)
                                        .addComponent(listPanel, DEFAULT_SIZE, DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap(43, Short.MAX_VALUE))
        );
    }

    private void ListSelectionChanged(ListSelectionEvent evt) {
        String selectedValue = list.getSelectedValue();
        if (!evt.getValueIsAdjusting()) {
            editButton.setEnabled(true);
            deleteButton.setEnabled(true);
            OnlListSelection_UpdateDescription(selectedValue, descriptionImage, descriptionTable);
        } }

    @Override
    public JPanel GetPanel() { return this; }
    @Override
    public void Activate(){ this.setVisible(true);}
    @Override
    public void Deactivate(){ this.setVisible(false);}
    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getSource().equals(addButton))
            OnClick_AddMedia(list, defaultListModel, descriptionImage, descriptionTable);
        else if (event.getSource().equals(editButton))
            OnClick_EditMedia(list, defaultListModel, descriptionImage, descriptionTable);
        else if (event.getSource().equals(deleteButton))
            OnClick_DeleteMedia(list, defaultListModel);
    }
}