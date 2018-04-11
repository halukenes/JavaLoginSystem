import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CreateDB {
	public static final String DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
	public static final String JDBC_URL = "jdbc:derby:zadb;create=true";

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName(DRIVER);
		Connection connection = DriverManager.getConnection(JDBC_URL);
		//connection.createStatement().execute("create table users(username varchar(20), password varchar(20))");
		connection.createStatement().execute("insert into users values " + 
		        "('admin', 'sadecepas'), " + 
		        "('admin2', 'sadecepas2'), " + 
		        "('admin3', 'sadecepas3')");
		System.out.println("channels table created and records succesfully inserted ...");
	}

}
