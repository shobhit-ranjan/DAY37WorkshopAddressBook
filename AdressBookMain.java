import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class AdressBookMain  {
		
	public static void main(String[] args) {
			public static void main(String[] args) {
		AdressBookUserDay37 Entery = new AdressBookUserDay37();
		getsqlConnection();
		// userDatatoDB.insertContact();
		// userDatatoDB.updateContactNameOfAdressbook();
		// userDatatoDB.readAdressbook();
		// userDatatoDB.showContactsBetweenGivenDates();
		// userDatatoDB.updateContactNameOfAdressbook();
		Entery.addContact();
		// Entery.searchFromStateOrCity();
		// userDatatoDB.ContactsByCity();
		// Entery.viewUserByCityOrState() ;
		// Entery.writeIOContact();
		// Entery.readIOContact();
		Entery.writeDataToCSV();
		Entery.readDataFromCSVContact();

	}
	public static Connection getsqlConnection() {
		Connection conn = null;
		String hostUrl = "jdbc:mysql://localhost:3306/address_book_service";
		String userName = "root";
		String password = "mymaths00";
		try {
			conn = DriverManager.getConnection(hostUrl, userName, password);
		} catch (SQLException e) {
			e.printStackTrace();

		}
		return conn;

	}

}