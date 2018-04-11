import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LogInPage {

	private JFrame frame;
	private JTextField username;
	private JTextField password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LogInPage window = new LogInPage();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LogInPage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 460, 330);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblLogn = new JLabel("Login");
		lblLogn.setFont(new Font("Calibri", Font.BOLD, 24));
		lblLogn.setBounds(50, 40, 64, 26);
		frame.getContentPane().add(lblLogn);
		
		JLabel lblNewLabel = new JLabel("Please fill in your credentials to login.");
		lblNewLabel.setFont(new Font("Calibri", Font.PLAIN, 13));
		lblNewLabel.setBounds(50, 66, 210, 14);
		frame.getContentPane().add(lblNewLabel);
		
		username = new JTextField();
		username.setBounds(50, 118, 210, 20);
		frame.getContentPane().add(username);
		username.setColumns(10);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Calibri", Font.BOLD, 12));
		lblUsername.setBounds(50, 102, 51, 14);
		frame.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Calibri", Font.BOLD, 12));
		lblPassword.setBounds(50, 160, 51, 14);
		frame.getContentPane().add(lblPassword);
		
		password = new JTextField();
		password.setBounds(50, 176, 210, 20);
		frame.getContentPane().add(password);
		password.setColumns(10);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnLogin.setBackground(new Color(0, 102, 255));
		btnLogin.setForeground(Color.BLACK);
		btnLogin.setBounds(50, 228, 89, 23);
		frame.getContentPane().add(btnLogin);
		
		JButton btnSignup = new JButton("Sign Up");
		btnSignup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SignUpPage signUpPage = new SignUpPage();
				signUpPage.setVisible(true);
			}
		});
		btnSignup.setBounds(305, 228, 89, 23);
		frame.getContentPane().add(btnSignup);
		
		JLabel lblDontYouHave = new JLabel("Don't have an account?");
		lblDontYouHave.setBounds(305, 212, 113, 14);
		frame.getContentPane().add(lblDontYouHave);
	}
}
