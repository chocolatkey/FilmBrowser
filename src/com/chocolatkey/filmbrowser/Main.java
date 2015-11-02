/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chocolatkey.filmbrowser;

import enigma.console.TextAttributes;
import enigma.core.Enigma;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.font.TextAttribute;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.UIManager;
import javax.swing.text.JTextComponent;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.io.FilenameUtils;
import org.java.ayatana.ApplicationMenu;
import org.java.ayatana.AyatanaDesktop;
//import org.apache.commons.io.*;

/**
 *
 * @author Henry Stark
 */
public class Main extends javax.swing.JFrame {

    ComboBoxModel model;
    JTextComponent editor;
    boolean selecting = false;
    /**
     * Is the program maximized
     */
    boolean maximized = false;
    /**
     * System toolkit
     */
    Toolkit toolkit = Toolkit.getDefaultToolkit();
    int x;
    int y;
    int x1;
    int y1;
    boolean e;
    ImageIcon coverimage;
    Image cover;
    boolean filterwatched;
    /**
     * Folder where films are (OLD!!!)
     */
    File folder;
    /**
     * Main settings file
     */
    File fb;
    /**
     * User settings file, contains watched films
     */
    File ufb;
    /**
     * Amount of films total
     */
    int filmamount;
    //THESE ARE PRACTICALLY THE SAME
    int currentfilm = 0;
    int filmnow = 0;
    /**
     * Cover array
     */
    String[] covers;
    /**
     * Film array
     */
    String[] films;
    String[] unknown;
    int unknownnum;
    String[] finalfilms;
    boolean starting = true;
    String[] watched;
    double coverheightd;// Höhe=Breite*√2 !!!
    int coverheight;
    int coverwidth;
    boolean nocover;
    /**
     * System username
     */
    String username;

    /**
     * Username dialog integer
     */
    int dialog;
    /**
     * Folder with the films
     */
    String filmFolder;
    /**
     * Folder with the covers
     */
    String coverFolder;
    /**
     * Folder with the .info files
     */
    String infoFolder;
    /**
     * Folder with the user settings and main settings
     */
    File dotfolder = new File(Util.uhome + "/.filmbrowser");
    /**
     * Default settings
     */
    PropertiesConfiguration defset;
    /**
     * Settings properties file
     */
    PropertiesConfiguration settings;
    PropertiesConfiguration pro;
    PropertiesConfiguration user;
    String filmname;
    File safe;

    /**
     * Creates new form Main
     *
     * @param initialize Set system variables or not
     */
    public Main(boolean initialize) {
        safe();
        initialize(initialize);
        initComponents();
        x = ((int) toolkit.getScreenSize().getWidth() / 2 - (int) getSize().getWidth() / 2);
        y = ((int) toolkit.getScreenSize().getHeight() / 2 - (int) getSize().getHeight() / 2);
        System.out.println("Panel location= X: " + x + " Y: " + y);
        setLocation(x, y);
        sc();

        editor = (JTextComponent) filmCombo.getEditor().getEditorComponent();
        editor.setDocument(new Autocomplete(filmCombo));
        if (user.containsKey("filterwatched")) {
            filterwatched = user.getBoolean("filterwatched");
            notwatchedItem.setSelected(filterwatched);
            System.out.println("Filter watched");
        }
        if (user.containsKey("theme")) {
            int theme = user.getInt("theme");
            settheme(theme);
            themeCombo.setSelectedIndex(theme);
        }
        start();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        folderChooser = new javax.swing.JFileChooser();
        settingsFrame = new javax.swing.JFrame();
        settingsPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        themeCombo = new javax.swing.JComboBox();
        settingsOKButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        filmChooser = new javax.swing.JFileChooser();
        coverChooser = new javax.swing.JFileChooser();
        infoChooser = new javax.swing.JFileChooser();
        aboutDialog = new javax.swing.JDialog();
        aboutPanel = new javax.swing.JPanel();
        fullName = new javax.swing.JLabel();
        url = new javax.swing.JLabel();
        Chocostudio = new javax.swing.JLabel();
        Icons = new javax.swing.JLabel();
        Version = new javax.swing.JLabel();
        closeButton = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        changeDialog = new javax.swing.JDialog();
        jButton1 = new javax.swing.JButton();
        scrollPane = new javax.swing.JScrollPane();
        changesPane = new javax.swing.JTextPane();
        searchDialog = new javax.swing.JDialog();
        searchforLabel = new javax.swing.JLabel();
        queryField = new javax.swing.JTextField();
        searchonLabel = new javax.swing.JLabel();
        searchCombo = new javax.swing.JComboBox();
        goButton = new javax.swing.JButton();
        panel = new javax.swing.JPanel();
        bottomPanel = new javax.swing.JPanel();
        nextButton = new javax.swing.JButton();
        previousButton = new javax.swing.JButton();
        filmamountLabel = new javax.swing.JLabel();
        filmamountLabeltext = new javax.swing.JLabel();
        pictureLabel = new javax.swing.JLabel();
        filmCombo = new javax.swing.JComboBox();
        titleField = new javax.swing.JTextField();
        directorField = new javax.swing.JTextField();
        yearSpinner = new javax.swing.JSpinner();
        yearLabel = new javax.swing.JLabel();
        ageLabel = new javax.swing.JLabel();
        titleLabel = new javax.swing.JLabel();
        directorLabel = new javax.swing.JLabel();
        genreLabel = new javax.swing.JLabel();
        genreField = new javax.swing.JTextField();
        ageyearLabel = new javax.swing.JLabel();
        playButton = new javax.swing.JButton();
        editButton = new javax.swing.JButton();
        watchedCheckbox = new javax.swing.JCheckBox();
        ageCombo = new javax.swing.JComboBox();
        randomButton = new javax.swing.JButton();
        menu = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        userItem = new javax.swing.JMenuItem();
        saveItem = new javax.swing.JMenuItem();
        restartItem = new javax.swing.JMenuItem();
        exitItem = new javax.swing.JMenuItem();
        editMenu = new javax.swing.JMenu();
        editItem = new javax.swing.JMenuItem();
        searchItem = new javax.swing.JMenuItem();
        watchedItem = new javax.swing.JCheckBoxMenuItem();
        viewMenu = new javax.swing.JMenu();
        foregroundItem = new javax.swing.JCheckBoxMenuItem();
        maxItem = new javax.swing.JMenuItem();
        gotoMenu = new javax.swing.JMenu();
        nextItem = new javax.swing.JMenuItem();
        previousItem = new javax.swing.JMenuItem();
        randomItem = new javax.swing.JMenuItem();
        optionsMenu = new javax.swing.JMenu();
        settingsMenu = new javax.swing.JMenuItem();
        folderMenu = new javax.swing.JMenu();
        filmMenu = new javax.swing.JMenu();
        filmCurrent = new javax.swing.JMenuItem();
        filmChoose = new javax.swing.JMenuItem();
        coverMenu = new javax.swing.JMenu();
        coverCurrent = new javax.swing.JMenuItem();
        coverChooose = new javax.swing.JMenuItem();
        infoMenu = new javax.swing.JMenu();
        infoCurrent = new javax.swing.JMenuItem();
        infoChoose = new javax.swing.JMenuItem();
        filterMenu = new javax.swing.JMenu();
        notwatchedItem = new javax.swing.JCheckBoxMenuItem();
        helpMenu = new javax.swing.JMenu();
        helpItem = new javax.swing.JMenuItem();
        aboutItem = new javax.swing.JMenuItem();

        folderChooser.setApproveButtonText("Ordner öffnen");
        folderChooser.setDialogTitle("Filmordner auswählen");
        folderChooser.setFileSelectionMode(javax.swing.JFileChooser.DIRECTORIES_ONLY);
        folderChooser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                folderChooserActionPerformed(evt);
            }
        });

        settingsFrame.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        settingsFrame.setTitle("Einstellungen");
        settingsFrame.setAlwaysOnTop(true);
        settingsFrame.setMinimumSize(new java.awt.Dimension(400, 300));
        settingsFrame.setResizable(false);
        settingsFrame.setType(java.awt.Window.Type.POPUP);

        settingsPanel.setBackground(new java.awt.Color(255, 255, 255));
        settingsPanel.setLayout(new java.awt.GridBagLayout());

        jLabel1.setText("Theme");
        settingsPanel.add(jLabel1, new java.awt.GridBagConstraints());

        themeCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Crimson Red", "Ocean Blue", "Jet Black", "Crystal Clear" }));
        themeCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                themeComboActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        settingsPanel.add(themeCombo, gridBagConstraints);

        settingsOKButton.setText("OK");
        settingsOKButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                settingsOKButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTH;
        gridBagConstraints.insets = new java.awt.Insets(200, 0, 0, 0);
        settingsPanel.add(settingsOKButton, gridBagConstraints);

        jLabel2.setText("Mehr kommt bald!");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        settingsPanel.add(jLabel2, gridBagConstraints);

        javax.swing.GroupLayout settingsFrameLayout = new javax.swing.GroupLayout(settingsFrame.getContentPane());
        settingsFrame.getContentPane().setLayout(settingsFrameLayout);
        settingsFrameLayout.setHorizontalGroup(
            settingsFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(settingsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        settingsFrameLayout.setVerticalGroup(
            settingsFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(settingsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        filmChooser.setApproveButtonText("Ordner öffnen");
        filmChooser.setFileSelectionMode(javax.swing.JFileChooser.DIRECTORIES_ONLY);
        filmChooser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filmChooserActionPerformed(evt);
            }
        });

        coverChooser.setApproveButtonText("Ordner öffnen");
        coverChooser.setFileSelectionMode(javax.swing.JFileChooser.DIRECTORIES_ONLY);
        coverChooser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                coverChooserActionPerformed(evt);
            }
        });

        infoChooser.setApproveButtonText("");
        infoChooser.setFileSelectionMode(javax.swing.JFileChooser.DIRECTORIES_ONLY);
        infoChooser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                infoChooserActionPerformed(evt);
            }
        });

        aboutDialog.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        aboutDialog.setAlwaysOnTop(true);
        aboutDialog.setBackground(new java.awt.Color(51, 51, 255));
        aboutDialog.setMinimumSize(new java.awt.Dimension(300, 260));
        aboutDialog.setResizable(false);
        aboutDialog.setType(java.awt.Window.Type.POPUP);

        aboutPanel.setBackground(new java.awt.Color(255, 51, 51));
        aboutPanel.setForeground(new java.awt.Color(51, 51, 255));

        fullName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fullName.setText("Programmierung: Henry Stary und Beat Jäckle");
        fullName.setAlignmentY(0.0F);

        url.setForeground(new java.awt.Color(0, 0, 204));
        url.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        url.setText("www.chocolatkey.com");
        url.setAlignmentY(0.0F);
        url.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        url.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                urlMouseClicked(evt);
            }
        });

        Chocostudio.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Chocostudio.setText("Chocolatkey Studios 2013");
        Chocostudio.setAlignmentY(0.0F);

        Icons.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Icons.setText("Logo: Beat/Ubuntu");

        Version.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Version.setText("Version: " + Util.version);

        closeButton.setText("Schliessen");
        closeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeButtonActionPerformed(evt);
            }
        });

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Idee: Beat");

        javax.swing.GroupLayout aboutPanelLayout = new javax.swing.GroupLayout(aboutPanel);
        aboutPanel.setLayout(aboutPanelLayout);
        aboutPanelLayout.setHorizontalGroup(
            aboutPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, aboutPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(aboutPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Icons, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Chocostudio, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(url, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Version, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(fullName, javax.swing.GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE)
                    .addComponent(closeButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        aboutPanelLayout.setVerticalGroup(
            aboutPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(aboutPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Chocostudio, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(url, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fullName, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                .addGap(1, 1, 1)
                .addComponent(Icons, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                .addGap(1, 1, 1)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Version)
                .addGap(29, 29, 29)
                .addComponent(closeButton)
                .addContainerGap())
        );

        javax.swing.GroupLayout aboutDialogLayout = new javax.swing.GroupLayout(aboutDialog.getContentPane());
        aboutDialog.getContentPane().setLayout(aboutDialogLayout);
        aboutDialogLayout.setHorizontalGroup(
            aboutDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(aboutPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        aboutDialogLayout.setVerticalGroup(
            aboutDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(aboutPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jButton1.setText("OK");

        changesPane.setText("Neu:");
        changesPane.setToolTipText("");
        scrollPane.setViewportView(changesPane);

        javax.swing.GroupLayout changeDialogLayout = new javax.swing.GroupLayout(changeDialog.getContentPane());
        changeDialog.getContentPane().setLayout(changeDialogLayout);
        changeDialogLayout.setHorizontalGroup(
            changeDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(changeDialogLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollPane)
                .addContainerGap())
            .addGroup(changeDialogLayout.createSequentialGroup()
                .addGap(173, 173, 173)
                .addComponent(jButton1)
                .addContainerGap(180, Short.MAX_VALUE))
        );
        changeDialogLayout.setVerticalGroup(
            changeDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, changeDialogLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addContainerGap())
        );

        searchDialog.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        searchDialog.setTitle("Suchen");
        searchDialog.setAlwaysOnTop(true);
        searchDialog.setMinimumSize(new java.awt.Dimension(618, 75));
        searchDialog.setResizable(false);
        searchDialog.setType(java.awt.Window.Type.POPUP);

        searchforLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        searchforLabel.setText("Suche nach:");

        queryField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        searchonLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        searchonLabel.setText("auf");

        searchCombo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        searchCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Wikipedia", "IMDB", "Google", "AniDB", "Kino.de" }));
        searchCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchComboActionPerformed(evt);
            }
        });

        goButton.setBackground(new java.awt.Color(0, 153, 51));
        goButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        goButton.setForeground(new java.awt.Color(255, 255, 255));
        goButton.setText("GO!");
        goButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                goButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout searchDialogLayout = new javax.swing.GroupLayout(searchDialog.getContentPane());
        searchDialog.getContentPane().setLayout(searchDialogLayout);
        searchDialogLayout.setHorizontalGroup(
            searchDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchDialogLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(searchforLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(queryField, javax.swing.GroupLayout.DEFAULT_SIZE, 328, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(searchonLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(searchCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(goButton)
                .addContainerGap())
        );
        searchDialogLayout.setVerticalGroup(
            searchDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchDialogLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(searchDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(queryField)
                    .addGroup(searchDialogLayout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(goButton, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE))
                    .addComponent(searchforLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(searchonLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(searchCombo, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Film Browser " + Util.version);
        setIconImage((new ImageIcon(this.getClass().getResource("/com/chocolatkey/filmbrowser/playIcon.png"))).getImage());
        setMinimumSize(new java.awt.Dimension(550, 340));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        panel.setBackground(new java.awt.Color(102, 0, 0));

        bottomPanel.setOpaque(false);

        nextButton.setBackground(new java.awt.Color(51, 102, 255));
        nextButton.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        nextButton.setForeground(new java.awt.Color(255, 255, 255));
        nextButton.setText("Weiter →");
        nextButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        nextButton.setEnabled(false);
        nextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextButtonActionPerformed(evt);
            }
        });

        previousButton.setBackground(new java.awt.Color(51, 102, 255));
        previousButton.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        previousButton.setForeground(new java.awt.Color(255, 255, 255));
        previousButton.setText("← Vorherige");
        previousButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        previousButton.setEnabled(false);
        previousButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                previousButtonActionPerformed(evt);
            }
        });

        filmamountLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        filmamountLabel.setForeground(new java.awt.Color(255, 255, 255));
        filmamountLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        filmamountLabel.setText("0/0");
        filmamountLabel.setFocusable(false);

        filmamountLabeltext.setForeground(new java.awt.Color(255, 255, 255));
        filmamountLabeltext.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        filmamountLabeltext.setText("Film / Anzahl Filme");
        filmamountLabeltext.setFocusable(false);

        javax.swing.GroupLayout bottomPanelLayout = new javax.swing.GroupLayout(bottomPanel);
        bottomPanel.setLayout(bottomPanelLayout);
        bottomPanelLayout.setHorizontalGroup(
            bottomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bottomPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(previousButton, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(bottomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(filmamountLabeltext, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
                    .addComponent(filmamountLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nextButton, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                .addContainerGap())
        );
        bottomPanelLayout.setVerticalGroup(
            bottomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bottomPanelLayout.createSequentialGroup()
                .addGroup(bottomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bottomPanelLayout.createSequentialGroup()
                        .addComponent(previousButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(5, 5, 5))
                    .addComponent(nextButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bottomPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(filmamountLabeltext, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(filmamountLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(2, 2, 2))
        );

        pictureLabel.setBackground(new java.awt.Color(51, 0, 51));
        pictureLabel.setForeground(new java.awt.Color(51, 51, 255));
        pictureLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pictureLabel.setText("Error");
        pictureLabel.setFocusable(false);
        pictureLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        pictureLabel.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        pictureLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pictureLabelMouseClicked(evt);
            }
        });

        filmCombo.setEditable(true);
        filmCombo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        filmCombo.setEnabled(false);
        filmCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filmComboActionPerformed(evt);
            }
        });

        titleField.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        titleField.setEnabled(false);
        titleField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                titleFieldActionPerformed(evt);
            }
        });

        directorField.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        directorField.setEnabled(false);

        yearSpinner.setModel(new javax.swing.SpinnerNumberModel(2011, 0, 3000, 1));
        yearSpinner.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        yearSpinner.setEditor(new javax.swing.JSpinner.NumberEditor(yearSpinner, ""));
        yearSpinner.setEnabled(false);
        yearSpinner.setOpaque(false);

        yearLabel.setForeground(new java.awt.Color(255, 255, 255));
        yearLabel.setText("Jahr:");
        yearLabel.setFocusable(false);

        ageLabel.setBackground(new java.awt.Color(255, 255, 255));
        ageLabel.setForeground(new java.awt.Color(255, 255, 255));
        ageLabel.setText("FSK ab");
        ageLabel.setFocusable(false);

        titleLabel.setForeground(new java.awt.Color(255, 255, 255));
        titleLabel.setText("Titel:");
        titleLabel.setFocusable(false);

        directorLabel.setForeground(new java.awt.Color(255, 255, 255));
        directorLabel.setText("Regie:");
        directorLabel.setFocusable(false);

        genreLabel.setForeground(new java.awt.Color(255, 255, 255));
        genreLabel.setText("Genre:");
        genreLabel.setFocusable(false);

        genreField.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        genreField.setEnabled(false);

        ageyearLabel.setForeground(new java.awt.Color(255, 255, 255));
        ageyearLabel.setText("Jahre");
        ageyearLabel.setFocusable(false);

        playButton.setBackground(new java.awt.Color(0, 102, 51));
        playButton.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        playButton.setForeground(new java.awt.Color(255, 255, 255));
        playButton.setText("Abspielen ►");
        playButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        playButton.setEnabled(false);
        playButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playButtonActionPerformed(evt);
            }
        });

        editButton.setBackground(new java.awt.Color(204, 102, 0));
        editButton.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        editButton.setForeground(new java.awt.Color(255, 255, 255));
        editButton.setText("Bearbeiten");
        editButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        editButton.setEnabled(false);
        editButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editButtonActionPerformed(evt);
            }
        });

        watchedCheckbox.setForeground(new java.awt.Color(255, 255, 255));
        watchedCheckbox.setText("Angeschaut");
        watchedCheckbox.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        watchedCheckbox.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        watchedCheckbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                watchedCheckboxActionPerformed(evt);
            }
        });

        ageCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-", "0", "6", "12", "16", "18" }));
        ageCombo.setEnabled(false);

        randomButton.setText("Zufällig");
        randomButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        randomButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                randomButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bottomPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pictureLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(filmCombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(genreLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelLayout.createSequentialGroup()
                                .addComponent(directorLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(2, 2, 2))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelLayout.createSequentialGroup()
                                .addComponent(titleLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(3, 3, 3)))
                        .addGap(1, 1, 1)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(directorField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
                            .addComponent(titleField)
                            .addComponent(genreField, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelLayout.createSequentialGroup()
                                .addComponent(ageLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(panelLayout.createSequentialGroup()
                                .addComponent(yearLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(3, 3, 3)))
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ageCombo, 0, 64, Short.MAX_VALUE)
                            .addComponent(yearSpinner))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ageyearLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(93, 93, 93)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(watchedCheckbox, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(randomButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(panelLayout.createSequentialGroup()
                        .addComponent(editButton, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(playButton, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addComponent(filmCombo, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(titleLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(titleField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(directorLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(directorField))
                        .addGap(12, 12, 12)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelLayout.createSequentialGroup()
                                .addComponent(genreLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE)
                                .addGap(1, 1, 1))
                            .addComponent(genreField))
                        .addGap(8, 8, 8)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(watchedCheckbox, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(panelLayout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(yearLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(yearSpinner))))
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelLayout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(ageLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(panelLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ageCombo, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(ageyearLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(randomButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(11, 11, 11)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(playButton, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                            .addComponent(editButton, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)))
                    .addComponent(pictureLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bottomPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        menu.setBackground(new java.awt.Color(0, 102, 255));
        menu.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        menu.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        menu.setPreferredSize(new java.awt.Dimension(323, 25));

        fileMenu.setText("Datei");
        fileMenu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fileMenu.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        userItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_U, java.awt.event.InputEvent.CTRL_MASK));
        userItem.setText("Benutzter wechseln");
        userItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userItemActionPerformed(evt);
            }
        });
        fileMenu.add(userItem);

        saveItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        saveItem.setText("Speichern");
        saveItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveItemActionPerformed(evt);
            }
        });
        fileMenu.add(saveItem);

        restartItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_MASK));
        restartItem.setText("Neustarten");
        restartItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                restartItemActionPerformed(evt);
            }
        });
        fileMenu.add(restartItem);

        exitItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.CTRL_MASK));
        exitItem.setText("Verlassen");
        exitItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitItemActionPerformed(evt);
            }
        });
        fileMenu.add(exitItem);

        menu.add(fileMenu);

        editMenu.setText("Bearbeiten");

        editItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_B, java.awt.event.InputEvent.CTRL_MASK));
        editItem.setText("Bearbeiten");
        editItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editItemActionPerformed(evt);
            }
        });
        editMenu.add(editItem);

        searchItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_MASK));
        searchItem.setText("Suchen");
        searchItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchItemActionPerformed(evt);
            }
        });
        editMenu.add(searchItem);

        watchedItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_G, java.awt.event.InputEvent.CTRL_MASK));
        watchedItem.setSelected(true);
        watchedItem.setText("Angeschaut");
        watchedItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                watchedItemActionPerformed(evt);
            }
        });
        editMenu.add(watchedItem);

        menu.add(editMenu);

        viewMenu.setText("Ansicht");

        foregroundItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F10, 0));
        foregroundItem.setText("Immer im Vordergrund");
        foregroundItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                foregroundItemActionPerformed(evt);
            }
        });
        viewMenu.add(foregroundItem);

        maxItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F11, 0));
        maxItem.setText("Vollbild (Nicht fertig!)");
        maxItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maxItemActionPerformed(evt);
            }
        });
        viewMenu.add(maxItem);

        menu.add(viewMenu);

        gotoMenu.setText("Gehe zu");

        nextItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_RIGHT, 0));
        nextItem.setText("Weiter");
        nextItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextItemActionPerformed(evt);
            }
        });
        gotoMenu.add(nextItem);

        previousItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_LEFT, 0));
        previousItem.setText("Vorherige");
        previousItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                previousItemActionPerformed(evt);
            }
        });
        gotoMenu.add(previousItem);

        randomItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_RIGHT, java.awt.event.InputEvent.CTRL_MASK));
        randomItem.setText("Zufällig");
        randomItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                randomItemActionPerformed(evt);
            }
        });
        gotoMenu.add(randomItem);

        menu.add(gotoMenu);

        optionsMenu.setText("Optionen");

        settingsMenu.setText("Einstellungen");
        settingsMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                settingsMenuActionPerformed(evt);
            }
        });
        optionsMenu.add(settingsMenu);

        folderMenu.setText("Ordnern");

        filmMenu.setText("Filme");

        filmCurrent.setText("ERROR");
        filmCurrent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filmCurrentActionPerformed(evt);
            }
        });
        filmMenu.add(filmCurrent);

        filmChoose.setText("Filmordner ändern");
        filmChoose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filmChooseActionPerformed(evt);
            }
        });
        filmMenu.add(filmChoose);

        folderMenu.add(filmMenu);

        coverMenu.setText("Covers");

        coverCurrent.setText("ERROR");
        coverCurrent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                coverCurrentActionPerformed(evt);
            }
        });
        coverMenu.add(coverCurrent);

        coverChooose.setText("Coverordner ändern");
        coverChooose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                coverChoooseActionPerformed(evt);
            }
        });
        coverMenu.add(coverChooose);

        folderMenu.add(coverMenu);

        infoMenu.setText("Info");

        infoCurrent.setText("ERROR");
        infoCurrent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                infoCurrentActionPerformed(evt);
            }
        });
        infoMenu.add(infoCurrent);

        infoChoose.setText("Infoordner ändern");
        infoChoose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                infoChooseActionPerformed(evt);
            }
        });
        infoMenu.add(infoChoose);

        folderMenu.add(infoMenu);

        optionsMenu.add(folderMenu);

        filterMenu.setText("Filter");

        notwatchedItem.setText("Noch nicht angeschaute Films");
        notwatchedItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                notwatchedItemActionPerformed(evt);
            }
        });
        filterMenu.add(notwatchedItem);

        optionsMenu.add(filterMenu);

        menu.add(optionsMenu);

        helpMenu.setText("Hilfe");

        helpItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
        helpItem.setText("Dokumentation");
        helpItem.setEnabled(false);
        helpMenu.add(helpItem);

        aboutItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F2, 0));
        aboutItem.setText("Über");
        aboutItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aboutItemActionPerformed(evt);
            }
        });
        helpMenu.add(aboutItem);

        menu.add(helpMenu);

        setJMenuBar(menu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void maxItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maxItemActionPerformed
        if (!maximized) {
            maximized = true;
            x1 = getWidth();
            y1 = getHeight();
            setSize((int) toolkit.getScreenSize().getWidth(), (int) toolkit.getScreenSize().getHeight());
            setLocation(0, 0);
            pictureLabel.setSize((int) (pictureLabel.getHeight() / 1.414), pictureLabel.getHeight());
            coverwidth = pictureLabel.getWidth() * 2;
            coverheightd = coverwidth * 1.414213562373095;// Höhe=Breite*√2 !!!
            coverheight = (int) coverheightd;

        } else {
            //setUndecorated(false);
            setSize(x1, y1);
            setLocation(x, y);
            maximized = false;
        }
        //setUndecorated(maximized);
        change(currentfilm);
        toFront();

    }//GEN-LAST:event_maxItemActionPerformed

    private void exitItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitItemActionPerformed
        System.out.println("Exiting...");
        System.exit(0);

    }//GEN-LAST:event_exitItemActionPerformed

    private void playButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_playButtonActionPerformed
        if (e) {
            searchDialog.setVisible(true);
            searchDialog.setLocationRelativeTo(panel);
            queryField.setText(titleField.getText());
        } else {
            Util.open(new File(filmFolder + "/" + films[(filmnow - 1)]).toString());
        }
    }//GEN-LAST:event_playButtonActionPerformed

    private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButtonActionPerformed
        edit();

    }//GEN-LAST:event_editButtonActionPerformed

    private void folderChooserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_folderChooserActionPerformed
        folder = folderChooser.getSelectedFile();
        if (folder == null) {
            System.err.println("No selected folder");
            JOptionPane.showMessageDialog(panel, "Keinen Ordner ausgewählt!", "Error", 0);
        } else {
            String folderText = folder.toString();
            System.out.println("\nSet folder to: " + folderText);
            String[] folders = folder.list();
            //System.out.println("Folders:\n"+folders[1]+folders[0]+"\n");
            if (Arrays.toString(folders).contains("Filme")) {
                System.out.println("Contains \"Filme\" folder");
                if (Arrays.toString(folders).contains("Covers")) {
                    System.out.println("Contains \"Covers\" folder");
                    start();
                } else {
                    System.err.println("No \"Covers\" folder");
                    JOptionPane.showMessageDialog(panel, "Keinen Ordner namens \"Covers\" in " + folderText + " !", "Error", 0);
                }
            } else {
                System.err.println("No \"Filme\" folder");
                JOptionPane.showMessageDialog(panel, "Keinen Ordner namens \"Filme\" in " + folderText + " !", "Error", 0);
            }
        }
    }//GEN-LAST:event_folderChooserActionPerformed

    private void filmComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filmComboActionPerformed
        if (!starting && filmnow != filmCombo.getSelectedIndex() + 1) {
            filmnow = filmCombo.getSelectedIndex() + 1;//Has to be +1 because index first film is 0
            change(filmnow);
        }
    }//GEN-LAST:event_filmComboActionPerformed

    private void nextButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextButtonActionPerformed
        /*if (!starting) {*/
            filmnow += 1;
            currentfilm += 1;
            change(filmnow + 1);
        /*}*/

    }//GEN-LAST:event_nextButtonActionPerformed

    private void previousButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_previousButtonActionPerformed
        /*if (!starting) {*/
            filmnow -= 1;
            currentfilm -= 1;
            change(filmnow - 1);
        /*}*/

    }//GEN-LAST:event_previousButtonActionPerformed

    private void saveItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveItemActionPerformed
        save();
    }//GEN-LAST:event_saveItemActionPerformed

    private void filmChooserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filmChooserActionPerformed
    }//GEN-LAST:event_filmChooserActionPerformed

    private void coverChooserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_coverChooserActionPerformed
    }//GEN-LAST:event_coverChooserActionPerformed

    private void infoChooserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_infoChooserActionPerformed
    }//GEN-LAST:event_infoChooserActionPerformed

    private void urlMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_urlMouseClicked
        try {
            URL openurl = new URL("http://www.chocolatkey.com/");
            Desktop.getDesktop().browse(openurl.toURI());
            System.out.println("Opening URL");
        } catch (URISyntaxException | IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        aboutDialog.dispose();
    }//GEN-LAST:event_urlMouseClicked

    private void closeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeButtonActionPerformed
        aboutDialog.dispose();
    }//GEN-LAST:event_closeButtonActionPerformed

    private void aboutItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aboutItemActionPerformed
        aboutDialog.setVisible(true);
        aboutDialog.setLocationRelativeTo(panel);
    }//GEN-LAST:event_aboutItemActionPerformed

    private void userItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userItemActionPerformed
        String un = JOptionPane.showInputDialog(panel, "Geben Sie ihre Benutzername ein.", "Film Browser " + Util.version, JOptionPane.QUESTION_MESSAGE);
        System.out.println("Username: " + un);
        if (un != null && !" ".equals(un)) {
            username = un.toLowerCase();
        } else {
            username = null;
            while (un == null || " ".equals(un)) {
                un = JOptionPane.showInputDialog(panel, "Sie müssen eine Benutzername eingeben!", "Film Browser " + Util.version, JOptionPane.QUESTION_MESSAGE);
            }//needs username
        }
        username = un.toLowerCase();
        settings.setProperty("lastuser", username);
        System.out.println("\nNew Username: " + username);
        restart(false);
    }//GEN-LAST:event_userItemActionPerformed

    private void restartItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_restartItemActionPerformed
        restart(false);
    }//GEN-LAST:event_restartItemActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        if (e) {
            int answer = JOptionPane.showConfirmDialog(panel, "Daten/Einstellungen nicht gespeichert! Willst du wirklich verlassen?", "Achtung!", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (answer == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        } else {
            System.exit(0);
        }
    }//GEN-LAST:event_formWindowClosing

    private void titleFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_titleFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_titleFieldActionPerformed

    private void randomButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_randomButtonActionPerformed
        int random = 1 + (int) (Math.random() * ((filmamount - 1) + 1));
        System.out.println("Choosing random film: " + random);
        filmnow = random;
        currentfilm = random;
        change(random);
    }//GEN-LAST:event_randomButtonActionPerformed

    private void notwatchedItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_notwatchedItemActionPerformed
        if (notwatchedItem.isSelected()) {
            filterwatched = true;
        } else {
            filterwatched = false;
        }
        user.setProperty("filterwatched", filterwatched);
        try {
            user.save();
        } catch (ConfigurationException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        restart(false);
    }//GEN-LAST:event_notwatchedItemActionPerformed

    private void watchedCheckboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_watchedCheckboxActionPerformed
        watched(watchedCheckbox.isSelected());
    }//GEN-LAST:event_watchedCheckboxActionPerformed

    private void watchedItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_watchedItemActionPerformed
        watched(watchedItem.isSelected());
    }//GEN-LAST:event_watchedItemActionPerformed

    private void previousItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_previousItemActionPerformed
        if (!starting) {
            filmnow -= 1;
            currentfilm -= 1;
            change(filmnow - 1);
        }
    }//GEN-LAST:event_previousItemActionPerformed

    private void nextItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextItemActionPerformed
        if (!starting) {
            filmnow += 1;
            currentfilm += 1;
            change(filmnow + 1);
        }
    }//GEN-LAST:event_nextItemActionPerformed

    private void randomItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_randomItemActionPerformed
        int random = 1 + (int) (Math.random() * ((filmamount - 1) + 1));
        System.out.println("Choosing random film: " + random);
        filmnow = random;
        currentfilm = random;
        change(random);
    }//GEN-LAST:event_randomItemActionPerformed

    private void editItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editItemActionPerformed
        edit();
    }//GEN-LAST:event_editItemActionPerformed

    private void foregroundItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_foregroundItemActionPerformed
        if (foregroundItem.isSelected()) {
            setAlwaysOnTop(true);
        } else {
            setAlwaysOnTop(false);
        }
    }//GEN-LAST:event_foregroundItemActionPerformed

    private void settingsOKButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_settingsOKButtonActionPerformed
        settingsFrame.dispose();
    }//GEN-LAST:event_settingsOKButtonActionPerformed

    private void settingsMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_settingsMenuActionPerformed
        settingsFrame.setVisible(true);
        settingsFrame.setLocationRelativeTo(panel);
    }//GEN-LAST:event_settingsMenuActionPerformed

    private void infoChooseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_infoChooseActionPerformed
        infoChooser.showDialog(panel, "Infoordner auswählen");
        folder = infoChooser.getSelectedFile();
        while (folder == null) {
            System.err.println("No selected folder (info)");
            JOptionPane.showMessageDialog(panel, "Keinen Ordner ausgewählt!", "Error", 0);
            infoChooser.showDialog(panel, "Infoordner auswählen");
            folder = infoChooser.getSelectedFile();
        }
        infoFolder = folder.toString();
        System.out.println("Set .info folder to: " + infoFolder);
        settings.setProperty("infofolder", infoFolder);
        restart(false);
    }//GEN-LAST:event_infoChooseActionPerformed

    private void infoCurrentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_infoCurrentActionPerformed
        Util.open(infoCurrent.getText());
    }//GEN-LAST:event_infoCurrentActionPerformed

    private void coverChoooseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_coverChoooseActionPerformed
        coverChooser.showDialog(panel, "Coverordner auswählen");
        folder = coverChooser.getSelectedFile();
        while (folder == null) {
            System.err.println("No selected folder (cover)");
            JOptionPane.showMessageDialog(panel, "Keinen Ordner ausgewählt!", "Error", 0);
            coverChooser.showDialog(panel, "Coverordner auswählen");
            folder = coverChooser.getSelectedFile();
        }
        coverFolder = folder.toString();
        System.out.println("Set cover folder to: " + coverFolder);
        settings.setProperty("coverfolder", coverFolder);
        restart(false);
    }//GEN-LAST:event_coverChoooseActionPerformed

    private void coverCurrentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_coverCurrentActionPerformed
        Util.open(coverCurrent.getText());
    }//GEN-LAST:event_coverCurrentActionPerformed

    private void filmChooseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filmChooseActionPerformed

        filmChooser.showDialog(panel, "Filmordner auswählen");
        folder = filmChooser.getSelectedFile();
        while (folder == null) {
            System.err.println("No selected folder (film)");
            JOptionPane.showMessageDialog(panel, "Keinen Ordner ausgewählt!", "Error", 0);
            filmChooser.showDialog(panel, "Filmordner auswählen");
            folder = filmChooser.getSelectedFile();
        }
        filmFolder = folder.toString();
        System.out.println("Set film folder to: " + filmFolder);
        settings.setProperty("filmfolder", filmFolder);
        restart(false);
    }//GEN-LAST:event_filmChooseActionPerformed

    private void filmCurrentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filmCurrentActionPerformed
        Util.open(filmCurrent.getText());
    }//GEN-LAST:event_filmCurrentActionPerformed

    private void themeComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_themeComboActionPerformed
        int theme = themeCombo.getSelectedIndex();
        settheme(theme);
        if (user.containsKey("theme")) {
            user.setProperty("theme", theme);
        } else {
            user.addProperty("theme", theme);

        }
        try {
            user.save();
        } catch (ConfigurationException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_themeComboActionPerformed

    private void goButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_goButtonActionPerformed
        try {
            URL open = null;
            int machine = searchCombo.getSelectedIndex();//Wikipedia, IMDB, Google, The Pirate Bay, Kinox.to, AniDB, Kino.de
            switch (machine) {
                case 0://Wikipedia
                    open = new URL("http://de.wikipedia.org/w/index.php?search=" + queryField.getText().replace(" ", "+"));
                    break;
                case 1://IMDB
                    open = new URL("http://www.imdb.com/find?s=all&q=" + queryField.getText().replace(" ", "+"));
                    break;
                case 2://Google
                    open = new URL("http://www.google.ch/search?q=" + queryField.getText().replace(" ", "+"));
                    break;
                /*case 4://kinox
                 open = new URL("http://www.kinox.to/Search.html?q=" + queryField.getText().replace(" ", "+"));
                 break;*/
                case 3://anidb
                    open = new URL(("http://anidb.net/perl-bin/animedb.pl?show=animelist&adb.search=" + queryField.getText().replace(" ", "+") + "&do.search=search"));
                    break;
                case 4://kino.de
                    open = new URL("http://www.kino.de/suche/trefferliste?searchString=" + queryField.getText().replace(" ", "+"));
                    break;
            }

            Desktop.getDesktop().browse(open.toURI());
            System.out.println("Searching on " + searchCombo.getSelectedItem());
        } catch (MalformedURLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (URISyntaxException | IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        searchDialog.dispose();
    }//GEN-LAST:event_goButtonActionPerformed

    private void searchItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchItemActionPerformed
        searchDialog.setVisible(true);
        searchDialog.setLocationRelativeTo(panel);
        queryField.setText(titleField.getText());
    }//GEN-LAST:event_searchItemActionPerformed

    private void searchComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchComboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchComboActionPerformed

    private void pictureLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pictureLabelMouseClicked
        if(nocover){
        Util.open(coverFolder);
        }
    }//GEN-LAST:event_pictureLabelMouseClicked

    private void settheme(int theme) {
        System.out.println("Setting theme to: " + theme);
        Color background = null;
        Color foreground = null;
        switch (theme) {
            case 0:
                background = new Color(102, 0, 0);
                foreground = Color.white;
                break;
            case 1:
                background = new Color(0, 35, 100);
                foreground = Color.white;
                break;
            case 2:
                background = Color.black;
                foreground = Color.white;
                break;
            case 3:
                background = new Color(233, 233, 255);
                foreground = Color.black;
                break;

        }
        /*while (getOpacity() > 0.1f) {
         setOpacity(this.getOpacity() - 0.01f);
         try {
         Thread.sleep(5);
         } catch (InterruptedException ex) {
         Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
         }
         }*/
        panel.setBackground(background);
        pictureLabel.setForeground(foreground);
        titleLabel.setForeground(foreground);
        directorLabel.setForeground(foreground);
        genreLabel.setForeground(foreground);
        yearLabel.setForeground(foreground);
        ageLabel.setForeground(foreground);
        ageyearLabel.setForeground(foreground);
        filmamountLabel.setForeground(foreground);
        filmamountLabeltext.setForeground(foreground);
        watchedCheckbox.setForeground(foreground);
        /*while (getOpacity() < 1.0f) {
         setOpacity(this.getOpacity() + 0.01f);
         try {
         Thread.sleep(5);
         } catch (InterruptedException ex) {
         Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
         }
         }*/
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        if (args.length > 0 && ((args[0]).startsWith("-d") || (args[0]).startsWith("--debug"))) {
            console();
            System.out.println("Debug console\n-----------------------------------------");
        }
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */

        try {
            for (UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        /*
         try {
         // Setting up WebLookAndFeel style
         UIManager.setLookAndFeel(WebLookAndFeel.class.getCanonicalName());
         } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException e) {
         // Something went wrong
         }*/
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                Main main = new Main(true);
                main.setVisible(true);
                if (AyatanaDesktop.isSupported()) {
                    ApplicationMenu.tryInstall(main);
                }//Ubuntu menu bar integration!
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Chocostudio;
    private javax.swing.JLabel Icons;
    private javax.swing.JLabel Version;
    private javax.swing.JDialog aboutDialog;
    private javax.swing.JMenuItem aboutItem;
    private javax.swing.JPanel aboutPanel;
    private javax.swing.JComboBox ageCombo;
    private javax.swing.JLabel ageLabel;
    private javax.swing.JLabel ageyearLabel;
    private javax.swing.JPanel bottomPanel;
    private javax.swing.JDialog changeDialog;
    private javax.swing.JTextPane changesPane;
    private javax.swing.JButton closeButton;
    private javax.swing.JMenuItem coverChooose;
    private javax.swing.JFileChooser coverChooser;
    private javax.swing.JMenuItem coverCurrent;
    private javax.swing.JMenu coverMenu;
    private javax.swing.JTextField directorField;
    private javax.swing.JLabel directorLabel;
    private javax.swing.JButton editButton;
    private javax.swing.JMenuItem editItem;
    private javax.swing.JMenu editMenu;
    private javax.swing.JMenuItem exitItem;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JMenuItem filmChoose;
    private javax.swing.JFileChooser filmChooser;
    private javax.swing.JComboBox filmCombo;
    private javax.swing.JMenuItem filmCurrent;
    private javax.swing.JMenu filmMenu;
    private javax.swing.JLabel filmamountLabel;
    private javax.swing.JLabel filmamountLabeltext;
    private javax.swing.JMenu filterMenu;
    private javax.swing.JFileChooser folderChooser;
    private javax.swing.JMenu folderMenu;
    private javax.swing.JCheckBoxMenuItem foregroundItem;
    private javax.swing.JLabel fullName;
    private javax.swing.JTextField genreField;
    private javax.swing.JLabel genreLabel;
    private javax.swing.JButton goButton;
    private javax.swing.JMenu gotoMenu;
    private javax.swing.JMenuItem helpItem;
    private javax.swing.JMenu helpMenu;
    private javax.swing.JMenuItem infoChoose;
    private javax.swing.JFileChooser infoChooser;
    private javax.swing.JMenuItem infoCurrent;
    private javax.swing.JMenu infoMenu;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenuItem maxItem;
    private javax.swing.JMenuBar menu;
    private javax.swing.JButton nextButton;
    private javax.swing.JMenuItem nextItem;
    private javax.swing.JCheckBoxMenuItem notwatchedItem;
    private javax.swing.JMenu optionsMenu;
    private javax.swing.JPanel panel;
    private javax.swing.JLabel pictureLabel;
    private javax.swing.JButton playButton;
    private javax.swing.JButton previousButton;
    private javax.swing.JMenuItem previousItem;
    private javax.swing.JTextField queryField;
    private javax.swing.JButton randomButton;
    private javax.swing.JMenuItem randomItem;
    private javax.swing.JMenuItem restartItem;
    private javax.swing.JMenuItem saveItem;
    private javax.swing.JScrollPane scrollPane;
    private javax.swing.JComboBox searchCombo;
    private javax.swing.JDialog searchDialog;
    private javax.swing.JMenuItem searchItem;
    private javax.swing.JLabel searchforLabel;
    private javax.swing.JLabel searchonLabel;
    private javax.swing.JFrame settingsFrame;
    private javax.swing.JMenuItem settingsMenu;
    private javax.swing.JButton settingsOKButton;
    private javax.swing.JPanel settingsPanel;
    private javax.swing.JComboBox themeCombo;
    private javax.swing.JTextField titleField;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JLabel url;
    private javax.swing.JMenuItem userItem;
    private javax.swing.JMenu viewMenu;
    private javax.swing.JCheckBox watchedCheckbox;
    private javax.swing.JCheckBoxMenuItem watchedItem;
    private javax.swing.JLabel yearLabel;
    private javax.swing.JSpinner yearSpinner;
    // End of variables declaration//GEN-END:variables

    public static void console() {
        enigma.console.Console console = Enigma.getConsole("Debug");
        TextAttributes attrs = new TextAttributes(Color.GREEN, Color.BLACK);
        console.setTextAttributes(attrs);
    }

    /**
     * Detect if program closed normally using file If closed normally do
     * nothing, if not then ask to delete settings If safe file doesn't exist
     * (first start?) then make it
     */
    private void safe() {
        safe = new File(dotfolder + File.separator + ".safe");
        safe.deleteOnExit();
        if (!safe.exists()) {
            try {
                safe.createNewFile();
            } catch (IOException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            System.out.println(".safe file exists - Program wasn't closed properly or there was an error");
            int deleteDialog = JOptionPane.showConfirmDialog(panel, "Filmbrowser wurde nicht richtig geschlossen oder ein Fehler\n ist aufgetreten beim letzten Ausführung. "
                    + "Willst du die Einstellungen löschen?", "Warning", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
            if (deleteDialog == JOptionPane.YES_OPTION) {
                deletesettings();
            }
        }
    }

    void deletesettings() {
        new File(dotfolder + "/settings.fb").delete();
        System.out.println("Deleted settings.fb");
        restart(true);
    }

    private void start() {
        starting = true;
        pictureLabel.setText("Am Laden...");
        filmCombo.setEnabled(true);
        editButton.setEnabled(true);
        nextButton.setEnabled(true);
        previousButton.setEnabled(true);
        //propertiesItem.setEnabled(true);
        File coverFile = new File(coverFolder);
        File filmFile = new File(filmFolder);
        covers = coverFile.list();
        films = filmFile.list();
        Arrays.sort(films);//Sort films alphabetically
        //System.out.println("Covers: "+Arrays.toString(covers));
        //System.out.println("Films:  "+Arrays.toString(films));
        folder = new File(infoFolder);
        System.out.println("\nFilms:\n----------------");

        /*if (!new File(infoFolder).exists()) {//if info folder doesnt exist make a new one
         fb.mkdir();
         }*/
        //filmamount = 0;
        //filmCombo.removeAllItems();
        String[] exts = {"avi", "mkv", "mp4", "mov", "wmv", "mts", "ogp", "m4v"};
        for (String file : films) {
            String f = file.toString();
            String n = FilenameUtils.removeExtension(f);
            //System.out.println(n);
            if (filterwatched && ufb.exists() && user.containsKey(n) && user.getBoolean(n)) {
                System.out.println("Excluding: " + f);
            } else if (FilenameUtils.isExtension(f.toLowerCase().trim(), exts)) {//Is the file a directory or non specified extension? If it is, exclude it

                System.out.println(n);
                filmCombo.addItem(n);
                films[filmamount] = f;
                filmamount++;

            } else if (new File((filmFolder + File.separator + n)).isDirectory()) {
                if (f.toLowerCase().contains("info") || f.toLowerCase().contains("cover") || f.toLowerCase().contains("subtitle")) {
                    System.out.println("Info or cover folder: " + f);
                } else {
                    System.out.println("Dir: " + f);
                    filmCombo.addItem(n);
                    films[filmamount] = f;
                    filmamount++;
                }
            } else {
                System.out.println("? " + f); //Unknown file
                //unknown[unknownnum] = f.toString();
                //unknownnum++;
                System.err.println("Unknown file in film folder");
                JOptionPane.showMessageDialog(panel, "Unbekannte Datei(en) im Filmordner.\nBitte räumen Sie auf.", "Error", JOptionPane.ERROR_MESSAGE);
                restart(true);
            }
        }
        /*if (unknown != null) {
         JOptionPane.showConfirmDialog(panel, "Unknown files in film folder:\n" + Util.arraytoString(unknown), "Warning", JOptionPane.WARNING_MESSAGE);
         }*/
        try {
            filmCombo.setSelectedIndex(1);
        } catch (Exception err) {
            System.err.println("Error setting combo Index: " + err);
            JOptionPane.showMessageDialog(panel, "1 oder weniger Filme im Ordner! Einstellung werden gelöscht", "Error", JOptionPane.ERROR_MESSAGE);
            deletesettings();

        }
        System.out.println("----------------\nTotal number of films: " + filmamount + "\n");
        filmamountLabel.setText("1/" + filmamount);
        filmCurrent.setText(filmFolder);
        coverCurrent.setText(coverFolder);
        infoCurrent.setText(infoFolder);

        /*
         // accessDb4o
         ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "db.fb");
         try {
         db.store("eeaklafEGAERGER");
         } finally {
         db.close();
         }*/
        playButton.setEnabled(true);
        starting = false;
        pictureLabel.setText("Kein Cover vorhanden!");
        change(0);
        //pictureLabel.setText(null);
    }

    private void change(int film) {
        pictureLabel.setCursor(null);
        watchedCheckbox.setSelected(false);
        watchedItem.setSelected(false);
        film = filmnow;
        //film = currentfilm;
        if (currentfilm > filmamount) {
            currentfilm -= 1;
        } else if (currentfilm == 0) {
            currentfilm++;
        }
        if (filmnow - 1 == filmamount) {
            filmnow -= 1;
        } else if (filmnow == -1 || filmnow == 0) {
            filmnow++;
        }
        if (currentfilm == filmamount) {
            //nextButton.setEnabled(false);
        } else if (currentfilm == 1) {
            //previousButton.setEnabled(false);
        } else {
            previousButton.setEnabled(true);
            nextButton.setEnabled(true);
        }
        filmname = FilenameUtils.removeExtension(films[(filmnow - 1)]);
        folder = new File(infoFolder + "/" + filmname + ".info");

        System.out.print("Change: " + films[(filmnow - 1)] + " ");
        if (!folder.exists()) {
            pro = new PropertiesConfiguration();
            try {
                pro.load(Main.class.getResource("/com/chocolatkey/filmbrowser/default.conf"));//get default configuration from default.conf
            } catch (ConfigurationException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            try {
                pro = new PropertiesConfiguration(folder);
            } catch (ConfigurationException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        pro.setDelimiterParsingDisabled(true); // NO DELIMITER!! (IF SAVED ACTION, ADVENTURE IN GENRES IT WON'T READ AS ARRAY YAY!? I DONT THINK IT WORKS)
        directorField.setText(pro.getString("director"));
        if (ufb.exists()) {
            user = null;
            try {
                user = new PropertiesConfiguration(ufb);
            } catch (ConfigurationException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (user.containsKey(filmname)) {
                watchedCheckbox.setSelected(user.getBoolean(filmname));
                watchedItem.setSelected(user.getBoolean(filmname));
            }
        }

        genreField.setText(pro.getString("genre"));
        int year = Integer.parseInt(pro.getString("year"));
        yearSpinner.setModel(new SpinnerNumberModel(year, 0, 3000, 1));
        JSpinner.NumberEditor neditor = new JSpinner.NumberEditor(yearSpinner, "#");
        yearSpinner.setEditor(neditor);

        int age = Integer.parseInt(pro.getString("fsk"));
        //model = new SpinnerNumberModel(age, 0, 99, 1);
        //ageSpinner.setModel(model);
        //editor = new JSpinner.NumberEditor(ageSpinner, "#");
        //ageSpinner.setEditor(editor);
        ageCombo.setSelectedIndex(age);

        titleField.setText(filmname);
        try {
            filmCombo.setSelectedIndex(filmnow - 1);
        } catch (Exception err) {
            System.err.println("Can't set filmCombo (Probably no films in folder!)");
        }
        filmamountLabel.setText(filmnow + "/" + filmamount);
        //System.out.println("Currentfilm:"+currentfilm+"\nfilm:"+film);
        /*for (int i = 0; i < covers.length; i++){
         String n = FilenameUtils.removeExtension(covers[i].toString());
         }*/
        //int covernumber = filmnow - 1;
        //Image cover = toolkit.getImage(coverFolder + "/" + covers[covernumber]);
        if (new File(coverFolder + "/" + filmname + ".jpg").exists()||new File(coverFolder + "/" + filmname + ".png").exists()) {
            if(new File(coverFolder + "/" + filmname + ".jpg").exists()){cover = toolkit.getImage(coverFolder + "/" + filmname + ".jpg");}
            else{cover = toolkit.getImage(coverFolder + "/" + filmname + ".png");}
            nocover = false;
            pictureLabel.setText(null);
            if (maximized) {
                System.out.println("Cover Width: " + coverwidth + " Cover height: " + coverheight);// Höhe=Breite*√2 !!! (1.414)194
                coverimage = new ImageIcon(cover.getScaledInstance(coverwidth+50, (int) coverheightd+50, Image.SCALE_DEFAULT));
            } else {
                coverimage = new ImageIcon(cover.getScaledInstance(194, 275, Image.SCALE_DEFAULT));
            }
            //new ImageIcon(getScaledImage(cover,pictureLabel.getWidth(),pictureLabel.getHeight()));

        } else {
            nocover = true;
            cover = toolkit.getImage(this.getClass().getResource("/com/chocolatkey/filmbrowser/cover.jpg"));
            if (maximized) {
                coverimage = new ImageIcon(cover.getScaledInstance(coverwidth, (int) coverheightd, Image.SCALE_DEFAULT));
            } else {
                coverimage = new ImageIcon(cover.getScaledInstance(194, 255, Image.SCALE_DEFAULT));
            }
            pictureLabel.setText("+Cover");
            pictureLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
            pictureLabel.setForeground(new Color(70, 70, 255));
            Font font = pictureLabel.getFont();
            Map attributes = font.getAttributes();
            attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
            pictureLabel.setFont(font.deriveFont(attributes));
        }
        pictureLabel.setIcon(coverimage);
        if (new File(filmFolder + "/" + films[(filmnow - 1)]).isDirectory()) {
            //watchedCheckbox.setText("Serie Fertig");
        } else {
            watchedCheckbox.setText("Angeschaut");
        }
        System.out.println("✓");

    }

    /*private Image getScaledImage(Image srcImg, int w, int h) {
     BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
     Graphics2D g2 = resizedImg.createGraphics();
     g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
     g2.drawImage(srcImg, 0, 0, w, h, null);
     g2.dispose();
     return resizedImg;
     }*/
    private void save() {
        if (e) {
            edit();
        }
        System.out.print("Saving...");
        pro.setProperty("director", directorField.getText());
        pro.setProperty("genre", genreField.getText());
        pro.setProperty("year", yearSpinner.getValue());
        pro.setProperty("fsk", ageCombo.getSelectedIndex());
        if (!fb.exists()) {
            PropertiesConfiguration def = new PropertiesConfiguration();
            try {
                def.load(Main.class.getResource("/com/chocolatkey/filmbrowser/default.conf"));//get default configuration from default.conf
            } catch (ConfigurationException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                def.save(fb);//save default configuration to file
            } catch (ConfigurationException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        if (fb.exists() && ufb.exists()) {
            try {

                pro.save(folder);
                settings.save(fb);
                user.save(ufb);
            } catch (ConfigurationException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            System.err.println("Error while saving. File: folder, fb or ufb doesn't exist anymore!");
            JOptionPane.showMessageDialog(panel, "Error beim speichern: Eine Einstellungsdatei existiert nicht meht!\nFilmBrowser wird beendet ohne zu speichern.", "Error", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }
        System.out.println("Saved");
    }

    private void restart(boolean basic) {
        System.out.println("\nRestarting\n-----------------------------------------");
        if (!basic) {
            try {
                settings.save(fb);
            } catch (ConfigurationException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        safe.delete();
        Main main = new Main(false);
        main.setVisible(true);
        if (AyatanaDesktop.isSupported()) {
            ApplicationMenu.tryInstall(main);
        }//Ubuntu menu bar integration!
        this.dispose();
    }

    private void initialize(boolean info) {

        //get current date time with Date()
        Date date = new Date();

        if (info) {
            System.out.println("Filmbrowser" + " " + Util.version + " - (c) Chocolatkey Studios 2013-2015");//Branding and app
            System.out.println("-----------------------------------------");
            System.out.println(Util.dateFormat.format(date));
            System.out.println("Java version " + Util.java);
            System.out.println("OS: " + Util.osname() + " " + Util.osversion + " (" + Util.os + ")");
            System.out.println("Java Architecture: " + Util.arch);
            System.out.println("Device name: " + Util.devname() + " (" + Util.ip() + ")");
            System.out.println("Username: " + Util.uname);
            System.out.println("User home: " + Util.uhome);
            System.out.println("Sys language: " + Util.lang);
        }
    }//determines the OS in use

    public void watched(boolean watched) {
        if (!user.containsKey(filmname)) {// If the key for this film doesnt exist then
            System.out.println("Adding watched key...");
            user.setProperty(filmname, watched);// add it with default value false
        } else if (!watched) {
            System.out.println("Removing watched key...");
            user.clearProperty(filmname);
        }
        /*if (watched && filterwatched) {
         restart();
         }*/
        try {
            user.save();
        } catch (ConfigurationException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        watchedCheckbox.setSelected(watched);
        watchedItem.setSelected(watched);

    }

    public void edit() {
        e = !e;
        System.out.println("Editing: " + e);
        titleField.setEnabled(e);
        directorField.setEnabled(e);
        genreField.setEnabled(e);
        filmCombo.setEnabled(!e);
        nextButton.setEnabled(!e);
        previousButton.setEnabled(!e);
        exitItem.setEnabled(!e);
        editItem.setEnabled(!e);
        yearSpinner.setEnabled(e);
        ageCombo.setEnabled(e);
        //watchedCheckbox.setEnabled(e);
        restartItem.setEnabled(!e);
        userItem.setEnabled(!e);
        restartItem.setEnabled(!e);
        folderMenu.setEnabled(!e);
        randomButton.setEnabled(!e);
        gotoMenu.setEnabled(!e);
        filterMenu.setEnabled(!e);
        if (e) {
            //change edit to save
            String editingText = "Am bearbeiten!";
            editButton.setBackground(Color.GREEN);
            editButton.setForeground(Color.BLACK);
            editButton.setText("Speichern");
            editItem.setText(editingText);
            exitItem.setText(editingText);
            //change play to wiki
            playButton.setText("Suchen");
            playButton.setBackground(new java.awt.Color(150, 150, 150));
            playButton.setForeground(Color.BLACK);
        } else {
            save();
            //change save to edit
            editButton.setBackground(new java.awt.Color(255, 102, 0));
            editButton.setForeground(Color.WHITE);
            editButton.setText("Bearbeiten");
            editItem.setText("Bearbeiten");
            exitItem.setText("Verlassen");
            //change wiki to play
            playButton.setText("Abspielen ►");
            playButton.setBackground(new java.awt.Color(0, 102, 51));
            playButton.setForeground(Color.WHITE);
        }
    }

    /**
     * Start creation/read
     */
    private void sc() {
        //File upro = new File(uhome+"/"+username+".conf");

        fb = new File(dotfolder + File.separator + "settings.fb");
        File fba = new File(Util.udir + File.separator + "settings.fb");
        if (fba.exists()) {
            fb = fba;
            System.out.println("Settings in same directory");
            JOptionPane.showMessageDialog(panel, "Loading settings from udir", "", JOptionPane.INFORMATION_MESSAGE);
            try {
                settings = new PropertiesConfiguration(fb);
            } catch (ConfigurationException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
            username = settings.getString("lastuser");
            System.out.println("\nUsername: " + username);
        } else if (!fb.exists()) {
            System.out.println(fb + " doesn't exist. Creating it and showing selection dialogs...");
            settings = new PropertiesConfiguration();
            try {
                settings.load(Main.class.getResource("/com/chocolatkey/filmbrowser/settings.conf"));//get default configuration from default.conf
            } catch (ConfigurationException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                settings.save(fb);//save default configuration to file
            } catch (ConfigurationException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }

            try {
                settings.load(fb);
            } catch (ConfigurationException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }

            //USERNAME
            //JOptionPane userinput = new JOptionPane(version, WIDTH, WIDTH)
            if (settings.getString("lastuser") == null || settings.getString("lastuser").equals("") || settings.getString("lastuser").equals(" ")) {
                username = JOptionPane.showInputDialog(panel, "Geben Sie ihre Benutzername ein.", "Film Browser " + Util.version, JOptionPane.QUESTION_MESSAGE);
                while (username == null || "".equals(username)) {
                    username = JOptionPane.showInputDialog(panel, "Sie müssen eine Benutzername eingeben!", "Film Browser " + Util.version, JOptionPane.QUESTION_MESSAGE);
                }//needs username
                username = username.toLowerCase();
                settings.setProperty("lastuser", username);
                System.out.println("\nUsername: " + username);
            }
            //Choose/set all 3 folders
            filmChooser.showDialog(panel, "Filmordner auswählen");
            folder = filmChooser.getSelectedFile();
            while (folder == null) {
                System.err.println("No selected folder (film)");
                JOptionPane.showMessageDialog(panel, "Keinen Ordner ausgewählt!", "Error", 0);
                filmChooser.showDialog(panel, "Filmordner auswählen");
                folder = filmChooser.getSelectedFile();
            }
            filmFolder = folder.toString();
            System.out.println("Set film folder to: " + filmFolder);
            settings.setProperty("filmfolder", filmFolder);

            coverChooser.showDialog(panel, "Coverordner auswählen");
            folder = coverChooser.getSelectedFile();
            while (folder == null) {
                System.err.println("No selected folder (cover)");
                JOptionPane.showMessageDialog(panel, "Keinen Ordner ausgewählt!", "Error", 0);
                coverChooser.showDialog(panel, "Coverordner auswählen");
                folder = coverChooser.getSelectedFile();
            }
            coverFolder = folder.toString();
            System.out.println("Set cover folder to: " + coverFolder);
            settings.setProperty("coverfolder", coverFolder);

            infoChooser.showDialog(panel, "Infoordner auswählen");
            folder = infoChooser.getSelectedFile();
            while (folder == null) {
                System.err.println("No selected folder (info)");
                JOptionPane.showMessageDialog(panel, "Keinen Ordner ausgewählt!", "Error", 0);
                infoChooser.showDialog(panel, "Infoordner auswählen");
                folder = infoChooser.getSelectedFile();
            }
            infoFolder = folder.toString();
            System.out.println("Set .info folder to: " + infoFolder);
            settings.setProperty("infofolder", infoFolder);
        } else {
            try {
                settings = new PropertiesConfiguration(fb);
            } catch (ConfigurationException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
            username = settings.getString("lastuser");
            System.out.println("\nUsername: " + username);
            System.out.println("settings.fb exists. Reading config and setting folders");
        }
        try {
            settings.save(fb);
        } catch (ConfigurationException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

        /*Make a user-specific file (.ufb)*/
        ufb = new File(dotfolder + File.separator + username + ".ufb");// Normal user file in .filmbrowser
        File ufba = new File(Util.udir + File.separator + username + ".ufb");// Alernate user file in udir
        if (ufba.exists()) {
            System.out.println("User config exists in udir");
            ufb = ufba;
        } else if (!ufb.exists()) {
            try {
                user = new PropertiesConfiguration(Main.class.getResource("/com/chocolatkey/filmbrowser/user.conf"));
                user.save(ufb);

            } catch (ConfigurationException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        try {
            user = new PropertiesConfiguration(ufb);
        } catch (ConfigurationException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        filmFolder = settings.getString("filmfolder");
        System.out.println("Film folder = " + filmFolder);
        coverFolder = settings.getString("coverfolder");
        System.out.println("Cover folder = " + coverFolder);
        infoFolder = settings.getString("infofolder");
        System.out.println("Info folder = " + infoFolder);
        if (!new File(filmFolder).exists()) {
            fb.delete();
            sc();
        } else if (!new File(coverFolder).exists()) {
            fb.delete();
            sc();
        } else if (!new File(infoFolder).exists()) {
            fb.delete();
            sc();
        }

    }
}
