/**
*Text genereted by Simple GUI Extension for BlueJ
*/
import javax.swing.UIManager.LookAndFeelInfo;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import javax.swing.border.Border;
import javax.swing.*;


public class GUI_project extends JFrame {

	private JMenuBar menuBar;
	private JLabel IDlbl_login;
	private JLabel Logovet_login;
	private JPanel headimage_login;
	private JLabel headlbl_login;
	private JPanel imagen_login;
	private JButton login_btb;
	private JLabel logoklinsy_login;
	private JLabel passforgotlbl_login;
	private JLabel passlbl_login;
	private JPasswordField passwordfield_login;
	private JButton recovlbl_login;
	private JButton register_btn;
	private JLabel separation_login;
	private JLabel textregis_login;
	private JTextField userfield_login;

	//Constructor 
	public GUI_project(){

		this.setTitle("GUI_project");
		this.setSize(750,500);
		//menu generate method
		generateMenu();
		this.setJMenuBar(menuBar);

		//pane with null layout
		JPanel contentPane = new JPanel(null);
		contentPane.setPreferredSize(new Dimension(750,500));
		contentPane.setBackground(new Color(247,247,247));


		IDlbl_login = new JLabel();
		IDlbl_login.setBounds(438,113,30,35);
		IDlbl_login.setBackground(new Color(214,217,223));
		IDlbl_login.setForeground(new Color(102,102,102));
		IDlbl_login.setEnabled(true);
		IDlbl_login.setFont(new Font("SansSerif",1,14));
		IDlbl_login.setText("ID");
		IDlbl_login.setVisible(true);

		Logovet_login = new JLabel();
		Logovet_login.setBounds(43,27,90,35);
		Logovet_login.setBackground(new Color(214,217,223));
		Logovet_login.setForeground(new Color(0,0,0));
		Logovet_login.setEnabled(true);
		Logovet_login.setFont(new Font("sansserif",0,12));
		Logovet_login.setText("");
		Logovet_login.setVisible(true);

		headimage_login = new JPanel(null);
		headimage_login.setBorder(BorderFactory.createEtchedBorder(1));
		headimage_login.setBounds(380,3,372,102);
		headimage_login.setBackground(new Color(214,217,223));
		headimage_login.setForeground(new Color(0,0,0));
		headimage_login.setEnabled(true);
		headimage_login.setFont(new Font("sansserif",0,12));
		headimage_login.setVisible(true);

		headlbl_login = new JLabel();
		headlbl_login.setBounds(68,35,260,35);
		headlbl_login.setBackground(new Color(214,217,223));
		headlbl_login.setForeground(new Color(247,247,247));
		headlbl_login.setEnabled(true);
		headlbl_login.setFont(new Font("SansSerif",1,34));
		headlbl_login.setText("Welcome Back");
		headlbl_login.setVisible(true);

		imagen_login = new JPanel(null);
		imagen_login.setBorder(BorderFactory.createEtchedBorder(1));
		imagen_login.setBounds(2,3,378,495);
		imagen_login.setBackground(new Color(31,70,59));
		imagen_login.setForeground(new Color(0,0,0));
		imagen_login.setEnabled(true);
		imagen_login.setFont(new Font("sansserif",0,12));
		imagen_login.setVisible(true);

		login_btb = new JButton();
		login_btb.setBounds(495,317,150,40);
		login_btb.setBackground(new Color(31,70,59));
		login_btb.setForeground(new Color(247,247,247));
		login_btb.setEnabled(true);
		login_btb.setFont(new Font("SansSerif",1,17));
		login_btb.setText("Login");
		login_btb.setVisible(true);

		logoklinsy_login = new JLabel();
		logoklinsy_login.setBounds(256,30,90,35);
		logoklinsy_login.setBackground(new Color(214,217,223));
		logoklinsy_login.setForeground(new Color(0,0,0));
		logoklinsy_login.setEnabled(true);
		logoklinsy_login.setFont(new Font("sansserif",0,12));
		logoklinsy_login.setText("");
		logoklinsy_login.setVisible(true);

		passforgotlbl_login = new JLabel();
		passforgotlbl_login.setBounds(445,256,180,35);
		passforgotlbl_login.setBackground(new Color(214,217,223));
		passforgotlbl_login.setForeground(new Color(153,153,153));
		passforgotlbl_login.setEnabled(true);
		passforgotlbl_login.setFont(new Font("SansSerif",3,12));
		passforgotlbl_login.setText("Forgot Password? Click on");
		passforgotlbl_login.setVisible(true);

		passlbl_login = new JLabel();
		passlbl_login.setBounds(438,190,90,35);
		passlbl_login.setBackground(new Color(214,217,223));
		passlbl_login.setForeground(new Color(102,102,102));
		passlbl_login.setEnabled(true);
		passlbl_login.setFont(new Font("SansSerif",1,14));
		passlbl_login.setText("Password");
		passlbl_login.setVisible(true);

		passwordfield_login = new JPasswordField();
		passwordfield_login.setBounds(439,224,250,35);
		passwordfield_login.setBackground(new Color(214,217,223));
		passwordfield_login.setForeground(new Color(0,0,0));
		passwordfield_login.setEnabled(true);
		passwordfield_login.setFont(new Font("sansserif",0,12));
		passwordfield_login.setVisible(true);

		recovlbl_login = new JButton();
		recovlbl_login.setBounds(604,261,80,27);
		recovlbl_login.setBackground(new Color(31,70,59));
		recovlbl_login.setForeground(new Color(255,255,255));
		recovlbl_login.setEnabled(true);
		recovlbl_login.setFont(new Font("SansSerif",1,11));
		recovlbl_login.setText("Recovery");
		recovlbl_login.setVisible(true);

		register_btn = new JButton();
		register_btn.setBounds(498,430,130,35);
		register_btn.setBackground(new Color(0,0,0));
		register_btn.setForeground(new Color(247,247,247));
		register_btn.setEnabled(true);
		register_btn.setFont(new Font("SansSerif",1,15));
		register_btn.setText("Register");
		register_btn.setVisible(true);

		separation_login = new JLabel();
		separation_login.setBounds(424,364,300,30);
		separation_login.setBackground(new Color(214,217,223));
		separation_login.setForeground(new Color(153,153,153));
		separation_login.setEnabled(true);
		separation_login.setFont(new Font("SansSerif",0,10));
		separation_login.setText("?????????????????????????? OR ??????????????????????????");
		separation_login.setVisible(true);

		textregis_login = new JLabel();
		textregis_login.setBounds(488,392,170,35);
		textregis_login.setBackground(new Color(214,217,223));
		textregis_login.setForeground(new Color(0,0,0));
		textregis_login.setEnabled(true);
		textregis_login.setFont(new Font("SansSerif",0,14));
		textregis_login.setText("Don't have an account?");
		textregis_login.setVisible(true);

		userfield_login = new JTextField();
		userfield_login.setBounds(438,147,250,35);
		userfield_login.setBackground(new Color(255,255,255));
		userfield_login.setForeground(new Color(0,0,0));
		userfield_login.setEnabled(true);
		userfield_login.setFont(new Font("sansserif",0,12));
		userfield_login.setText("");
		userfield_login.setVisible(true);

		//adding components to contentPane panel
		contentPane.add(IDlbl_login);
		imagen_login.add(Logovet_login);
		contentPane.add(headimage_login);
		headimage_login.add(headlbl_login);
		contentPane.add(imagen_login);
		contentPane.add(login_btb);
		imagen_login.add(logoklinsy_login);
		contentPane.add(passforgotlbl_login);
		contentPane.add(passlbl_login);
		contentPane.add(passwordfield_login);
		contentPane.add(recovlbl_login);
		contentPane.add(register_btn);
		contentPane.add(separation_login);
		contentPane.add(textregis_login);
		contentPane.add(userfield_login);

		//adding panel to JFrame and seting of window position and close operation
		this.add(contentPane);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.pack();
		this.setVisible(true);
	}

	//method for generate menu
	public void generateMenu(){
		menuBar = new JMenuBar();

		JMenu file = new JMenu("File");
		JMenu tools = new JMenu("Tools");
		JMenu help = new JMenu("Help");

		JMenuItem open = new JMenuItem("Open   ");
		JMenuItem save = new JMenuItem("Save   ");
		JMenuItem exit = new JMenuItem("Exit   ");
		JMenuItem preferences = new JMenuItem("Preferences   ");
		JMenuItem about = new JMenuItem("About   ");


		file.add(open);
		file.add(save);
		file.addSeparator();
		file.add(exit);
		tools.add(preferences);
		help.add(about);

		menuBar.add(file);
		menuBar.add(tools);
		menuBar.add(help);
	}



	 public static void main(String[] args){
		System.setProperty("swing.defaultlaf", "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new GUI_project();
			}
		});
	}

}