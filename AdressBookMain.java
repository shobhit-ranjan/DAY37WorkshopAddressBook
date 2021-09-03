import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class AdressBookMain  {

	public static void main(String[] args) {
		AdressBookUserDay37 Entery = new AdressBookUserDay37();
		// getsqlConnection();
		// userDatatoDB.insertContact();
		// userDatatoDB.updateContactNameOfAdressbook();
		Entery.addContact();
                                         Entery.searchFromStateOrCity();

		System.out.println("you to make any changes in enter type yes or no");
		Scanner sc = new Scanner(System.in);
		String input = sc.next();
		if (input.equals("yes")) {

			Entery.editContact();
		}
		System.out.println("you want to delete the user type yes or no");
		input = sc.next();
		if (input.equals("yes")) {
			Entery.DeleteUserEntery();
		} else {
			System.out.println("All done");
		}
		sc.close();
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