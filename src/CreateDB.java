import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CreateDB {
	public static final String DRIVER   = "org.apache.derby.jdbc.EmbeddedDriver";
	public static final String JDBC_URL = "jdbc:derby:zadb;create=true";

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		LogInPage logInPage = new LogInPage();
		logInPage.frame.setVisible(true);
		
		Class.forName(DRIVER);
		Connection connection = DriverManager.getConnection(JDBC_URL);
	    
		connection.createStatement().execute("create table users(username varchar(20), password varchar(20), email varchar(25), telNu varchar(20))");
	    //connection.createStatement().execute("DELETE FROM users");
		//connection.createStatement().execute("drop table users");
		System.out.println("channels table created and records succesfully inserted ...");

		
		
		
	}

}
// this class is for developer to create a database and initialize it. Developer
// can change the comments at the top to control the DB.
