import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AdressBookMain {

	public static void main(String[] args) {

		 getsqlConnection();
		 userDatatoDB.insertContact();
	}
	public static Connection getsqlConnection() {
		Connection conn = null;
		String hostUrl = "jdbc:mysql://localhost:3306/address_book_service";
		String userName = "root";
		String password = "mymaths009!@A";
		try {
			conn = DriverManager.getConnection(hostUrl, userName, password);
		} catch (SQLException e) {
			e.printStackTrace();

		}
		return conn;

	}

}