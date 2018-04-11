import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;

public class SignUpPage {

	private JFrame frame;
	private JTextField username;
	private JTextField password;
	private JTextField cpassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignUpPage window = new SignUpPage();
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
	public SignUpPage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 460, 350);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblSignUp = new JLabel("Sign Up");
		lblSignUp.setFont(new Font("Calibri", Font.BOLD, 24));
		lblSignUp.setBounds(50, 40, 75, 26);
		frame.getContentPane().add(lblSignUp);
		
		JLabel lblPleaseFillThis = new JLabel("Please fill this form to create an account.");
		lblPleaseFillThis.setFont(new Font("Calibri", Font.PLAIN, 13));
		lblPleaseFillThis.setBounds(50, 66, 226, 14);
		frame.getContentPane().add(lblPleaseFillThis);
		
		JLabel label = new JLabel("Username");
		label.setFont(new Font("Calibri", Font.BOLD, 12));
		label.setBounds(50, 91, 51, 14);
		frame.getContentPane().add(label);
		
		username = new JTextField();
		username.setColumns(10);
		username.setBounds(50, 107, 210, 20);
		frame.getContentPane().add(username);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Calibri", Font.BOLD, 12));
		lblPassword.setBounds(50, 143, 51, 14);
		frame.getContentPane().add(lblPassword);
		
		password = new JTextField();
		password.setColumns(10);
		password.setBounds(50, 159, 210, 20);
		frame.getContentPane().add(password);
		
		JLabel lblPassword_1 = new JLabel("Confirm Password");
		lblPassword_1.setFont(new Font("Calibri", Font.BOLD, 12));
		lblPassword_1.setBounds(50, 195, 89, 14);
		frame.getContentPane().add(lblPassword_1);
		
		cpassword = new JTextField();
		cpassword.setColumns(10);
		cpassword.setBounds(50, 211, 210, 20);
		frame.getContentPane().add(cpassword);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setForeground(Color.BLACK);
		btnSubmit.setBackground(new Color(0, 102, 255));
		btnSubmit.setBounds(50, 248, 89, 23);
		frame.getContentPane().add(btnSubmit);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(305, 248, 89, 23);
		frame.getContentPane().add(btnLogin);
		
		JLabel lblAlreadyHaveAn = new JLabel("Already have an account?");
		lblAlreadyHaveAn.setBounds(305, 232, 126, 14);
		frame.getContentPane().add(lblAlreadyHaveAn);
	}

}
