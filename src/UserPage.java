import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.DropMode;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UserPage extends JFrame {

	private JPanel    contentPane;
	private JTextArea textArea;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserPage frame = new UserPage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	//this method shows all the users and their details from the DB.
	public String userDBDatas() throws SQLException {

		Connection        connection        = DriverManager.getConnection(CreateDB.JDBC_URL);
		Statement         statement         = connection.createStatement();
		ResultSet         resultSet         = statement.executeQuery("select * from users");
		ResultSetMetaData resultSetMetaData = resultSet.getMetaData();

		int               columnCount       = resultSetMetaData.getColumnCount();
		String            columns           = "";
		int               counter           = 1;
		
		while (resultSet.next()) {
			columns = columns + "\n";
			for (int x = 1; x <= columnCount; x++) {
				if(x % 2 == 1) {
					columns = columns + counter + ". Username: " + resultSet.getString(x) + "\n";
				} else
					columns = columns + "     Password: " + resultSet.getString(x) + "\n";
			}
			counter++;
		}

		if (statement != null)
			statement.close();
		if (connection != null)
			connection.close();
		
		return columns;

	}

	public UserPage() throws SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 460, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblUserPage = new JLabel("User Page");
		lblUserPage.setFont(new Font("Calibri", Font.BOLD, 24));
		lblUserPage.setBounds(50, 40, 100, 26);
		contentPane.add(lblUserPage);

		JLabel lblYouCanSee = new JLabel("You can see all the details about users below.");
		lblYouCanSee.setFont(new Font("Calibri", Font.PLAIN, 13));
		lblYouCanSee.setBounds(50, 66, 250, 14);
		contentPane.add(lblYouCanSee);
		
		textArea = new JTextArea();
		textArea.setFont(new Font("Calibri", Font.PLAIN, 11));
		textArea.setBounds(50, 91, 341, 268);
		contentPane.add(textArea);
		textArea.setText(userDBDatas());
		
		JButton btnLogOut = new JButton("Log Out");
		btnLogOut.setFont(new Font("Calibri", Font.PLAIN, 12));
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				LogInPage logInPage = new LogInPage();
				logInPage.frame.setVisible(true);
				dispose();
			}
		});
		btnLogOut.setBounds(302, 377, 89, 23);
		contentPane.add(btnLogOut);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(50, 91, 342, 268);
		contentPane.add(scrollPane);
		scrollPane.setViewportView(textArea);
	}
}
