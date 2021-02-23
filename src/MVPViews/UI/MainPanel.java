package MVPViews.UI;

import MVPPresenters.OutputPresenter;

import javax.swing.plaf.basic.BasicScrollBarUI;
import javax.swing.event.*;
import javax.swing.table.*;
import javax.swing.*;
import static MVPViews.OutputView.*;
import static javax.swing.GroupLayout.*;
import java.awt.*;

public class MainPanel extends JPanel implements IPanel {
    //<editor-fold desc="Variables Declarations">">
    private final JPanel logoPanel = new JPanel();
    private final JPanel descriptionPanel = new JPanel();
    private final JPanel listPanel = new JPanel();
    private final JList<String> list = new JList<>();
    private final JLabel logoLabel = new JLabel(new ImageIcon("Resources/LoginScreen/library_80px Dark.png"));
    private final JLabel descriptionImage = new JLabel();
    private final JScrollPane scrollPanList = new JScrollPane();
    private final JTable descriptionTable = new JTable();
    private final JTextArea logoTextArea = new JTextArea();
    private final JButton closeButton = new JButton("X");
    //</editor-fold>

    public MainPanel(){
        SetupLogoPanel();
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
                LogoPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(LogoPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(logoLabel)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(logoTextArea, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(19, Short.MAX_VALUE))
        );
        LogoPanelLayout.setVerticalGroup(
                LogoPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(LogoPanelLayout.createSequentialGroup()
                                .addGroup(LogoPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(logoTextArea)
                                        .addComponent(logoLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(64, 64, 64))
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
        descriptionTable.setModel(new DefaultTableModel(
                new String [][] {
                        {"Name", null},
                        {"Type", null},
                        {"Date", null},
                        {"Location", null}
                },
                new String [] {
                        "", ""
                }
        ) {
            final Class[] types = new Class [] {String.class, String.class };
            final boolean[] canEdit = new boolean [] { false, false };
            public Class getColumnClass(int columnIndex) { return types [columnIndex]; }
            public boolean isCellEditable(int rowIndex, int columnIndex) { return canEdit [columnIndex]; }
        });
    }
    private void SetupDescriptionPanelLayout() {
        GroupLayout descriptionPanelLayout = new GroupLayout(descriptionPanel);
        descriptionPanel.setLayout(descriptionPanelLayout);
        descriptionPanelLayout.setHorizontalGroup(
                descriptionPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(descriptionPanelLayout.createSequentialGroup()
                                .addGroup(descriptionPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(descriptionPanelLayout.createSequentialGroup()
                                                .addGap(155, 155, 155)
                                                .addComponent(descriptionImage, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(descriptionPanelLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(descriptionTable, GroupLayout.PREFERRED_SIZE, 436, GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(17, Short.MAX_VALUE))
        );
        descriptionPanelLayout.setVerticalGroup(
                descriptionPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(descriptionPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(descriptionImage, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(39, 39, 39)
                                .addComponent(descriptionTable, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
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
        list.setFont(new Font("Source Code Pro", Font.PLAIN, 18)); // NOI18N
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
    private void CreateMediaList() {
        list.setModel(new AbstractListModel<>() {
            private final String[] strings = GetListContent();
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
    }
    private void SetupListPanelLayout() {
        GroupLayout ListPanelLayout = new GroupLayout(listPanel);
        listPanel.setLayout(ListPanelLayout);
        ListPanelLayout.setHorizontalGroup(
                ListPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(ListPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(scrollPanList))
        );
        ListPanelLayout.setVerticalGroup(
                ListPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(scrollPanList, GroupLayout.DEFAULT_SIZE, 336, Short.MAX_VALUE)
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
                                .addContainerGap(41, Short.MAX_VALUE)
                                .addGroup(MainPanelLayout.createParallelGroup(Alignment.LEADING, false)
                                        .addComponent(logoPanel, DEFAULT_SIZE, 322, Short.MAX_VALUE)
                                        .addComponent(listPanel, DEFAULT_SIZE, DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(MainPanelLayout.createParallelGroup(Alignment.LEADING)
                                        .addGroup(MainPanelLayout.createSequentialGroup()
                                                .addGap(34, 34, 34)
                                                .addComponent(descriptionPanel, PREFERRED_SIZE, 468, PREFERRED_SIZE)
                                                .addContainerGap(35, Short.MAX_VALUE))
                                        .addGroup(Alignment.TRAILING, MainPanelLayout.createSequentialGroup()
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(closeButton, PREFERRED_SIZE, 21, PREFERRED_SIZE)
                                                .addGap(8, 8, 8))))
        );
        MainPanelLayout.setVerticalGroup(
                MainPanelLayout.createParallelGroup(Alignment.LEADING)
                        .addGroup(MainPanelLayout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addGroup(MainPanelLayout.createParallelGroup(Alignment.LEADING)
                                        .addComponent(closeButton, PREFERRED_SIZE, 23, PREFERRED_SIZE)
                                        .addComponent(logoPanel, PREFERRED_SIZE, 80, PREFERRED_SIZE))
                                .addGap(33, 33, 33)
                                .addGroup(MainPanelLayout.createParallelGroup(Alignment.LEADING, false)
                                        .addComponent(descriptionPanel, DEFAULT_SIZE, 336, Short.MAX_VALUE)
                                        .addComponent(listPanel, DEFAULT_SIZE, DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap(43, Short.MAX_VALUE))
        );
    }

    private void ListSelectionChanged(ListSelectionEvent evt) {
        String selectedIndex = list.getSelectedValue();
        if (!evt.getValueIsAdjusting()) OnlListSelection_UpdateDescription(selectedIndex, descriptionImage, descriptionTable); }

    @Override
    public JPanel GetPanel() { return this; }
    @Override
    public void Activate(){ this.setVisible(true);}
    @Override
    public void Deactivate(){ this.setVisible(false);}

}