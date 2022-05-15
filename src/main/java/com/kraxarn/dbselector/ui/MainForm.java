package com.kraxarn.dbselector.ui;

import javax.swing.*;

public class MainForm
{
	protected JPanel panelMain;
	private JPanel panelSettings;
	private JPanel panelServerList;
	private JTabbedPane tabbedPaneMain;
	private JList listServers;
	private JButton buttonUpdateConnections;
	private JPanel panelScripts;
	private JPanel panelPasswords;
	protected JTextField textFieldPasswordUsername;
	protected JCheckBox checkBoxPasswordsAllUsers;
	protected JPasswordField passwordFieldPasswordsPassword;
	private JButton buttonPasswordsSetPassword;
	private JLabel labelDatabasesNoConfigs;
	private JLabel labelScriptsNoScripts;
	protected JButton buttonAboutOpenSource;
	protected JLabel labelAboutSecret;
	protected JComboBox comboBoxServer;
	private JPanel panelAbout;
	protected JCheckBox checkBoxPasswordsClearPassword;
	protected JLabel labelAppName;
}
