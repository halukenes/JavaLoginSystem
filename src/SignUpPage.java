import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class SignUpPage extends JFrame {

	private JPanel contentPane;
	private JTextField username;
	private JPasswordField password;
	private JPasswordField cpassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignUpPage frame = new SignUpPage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void insertDB(String usern, String passw) throws ClassNotFoundException, SQLException {
		Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
		Connection connection = DriverManager.getConnection("jdbc:derby:zadb;create=true");
		connection.createStatement().execute("insert into users values " + "('" + usern + "', '" + passw + "')");
	}

	/**
	 * Create the frame.
	 */
	public SignUpPage() {
		setBounds(100, 100, 460, 350);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		JLabel lblSignUp = new JLabel("Sign Up");
		lblSignUp.setFont(new Font("Calibri", Font.BOLD, 24));
		lblSignUp.setBounds(50, 40, 75, 26);
		getContentPane().add(lblSignUp);

		JLabel lblPleaseFillThis = new JLabel("Please fill this form to create an account.");
		lblPleaseFillThis.setFont(new Font("Calibri", Font.PLAIN, 13));
		lblPleaseFillThis.setBounds(50, 66, 226, 14);
		getContentPane().add(lblPleaseFillThis);

		JLabel label = new JLabel("Username");
		label.setFont(new Font("Calibri", Font.BOLD, 12));
		label.setBounds(50, 91, 51, 14);
		getContentPane().add(label);

		username = new JTextField();
		username.setColumns(10);
		username.setBounds(50, 107, 210, 20);
		getContentPane().add(username);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Calibri", Font.BOLD, 12));
		lblPassword.setBounds(50, 143, 51, 14);
		getContentPane().add(lblPassword);

		JLabel lblPassword_1 = new JLabel("Confirm Password");
		lblPassword_1.setFont(new Font("Calibri", Font.BOLD, 12));
		lblPassword_1.setBounds(50, 195, 89, 14);
		getContentPane().add(lblPassword_1);

		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					if(password.getText().equals(cpassword.getText())) {
						insertDB(username.getText(), password.getText());
						JOptionPane.showMessageDialog(label, "You successfully signed in!");
					} else {
						JOptionPane.showMessageDialog(label, "Your have confirmed your password wrong!");
					}					
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
					JOptionPane.showMessageDialog(label, "Error = ClassNotFoundException");
				} catch (SQLException e) {
					e.printStackTrace();
					JOptionPane.showMessageDialog(label, "Error = SQLException");
				}
			}
		});
		btnSubmit.setForeground(Color.BLACK);
		btnSubmit.setBackground(new Color(0, 102, 255));
		btnSubmit.setBounds(50, 248, 89, 23);
		getContentPane().add(btnSubmit);

		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(305, 248, 89, 23);
		getContentPane().add(btnLogin);

		JLabel lblAlreadyHaveAn = new JLabel("Already have an account?");
		lblAlreadyHaveAn.setBounds(305, 232, 126, 14);
		getContentPane().add(lblAlreadyHaveAn);

		password = new JPasswordField();
		password.setBounds(50, 159, 210, 20);
		getContentPane().add(password);

		cpassword = new JPasswordField();
		cpassword.setBounds(50, 211, 210, 20);
		getContentPane().add(cpassword);
	}

}
