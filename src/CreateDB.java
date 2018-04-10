import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CreateDB {
	public static final String DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
	public static final String JDBC_URL = "jdbc:derby:zadb;create=true";

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName(DRIVER);
		Connection connection = DriverManager.getConnection(JDBC_URL);
		connection.createStatement().execute("create table channels(channel varchar(20), topic varchar(20), videoclip varchar(20))");
		connection.createStatement().execute("insert into channels values " + 
		        "('oodp', 'creational', 'singleton'), " + 
		        "('oodp', 'creational', 'factory method'), " + 
		        "('oodp', 'creational', 'abstract factory')");
		System.out.println("channels table created and records succesfully inserted ...");
	}

}
