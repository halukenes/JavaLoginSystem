import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class LogInPage {

	private JFrame frame;
	private JTextField username;
	private JPasswordField password;
	public static final String SQL_STATEMENT = "select * from users";

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

	public boolean checkDB(String usern, String passw) throws SQLException {
		
		boolean           existInDB         = false;		
		Connection        connection        = DriverManager.getConnection(CreateDB.JDBC_URL);
		Statement         statement         = connection.createStatement();
		ResultSet         resultSet         = statement.executeQuery(SQL_STATEMENT);
		ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
		
		while (resultSet.next()) {
			if (resultSet.getString(1).equals(usern) && resultSet.getString(2).equals(passw)) {
				existInDB = true;
			}
		}
		if (statement != null)
			statement.close();
		if (connection != null)
			connection.close();
		return existInDB;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 460, 330);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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

		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					if(checkDB(username.getText(), password.getText())) {
						JOptionPane.showMessageDialog(frame, "You succesfully login!");
					} else {
						JOptionPane.showMessageDialog(frame, "Incorrect username or password!");
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
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

		password = new JPasswordField();
		password.setBounds(50, 176, 210, 20);
		frame.getContentPane().add(password);
	}
}
