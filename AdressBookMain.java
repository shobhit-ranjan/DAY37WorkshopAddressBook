import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class AdressBookMain {

	public static void main(String[] args) {
		AdressBookUserDay37 Entery = new AdressBookUserDay37();
		getsqlConnection();
		int inputuser, IP;
		System.out.println("Welcome To Address Book System !");
		System.out.println("We have Three Option to store , edit, view, delete your data \n");
		System.out.println("1. In List");
		System.out.println("2. In File ");
		System.out.println("3. In DataBase");
		System.out.println("Select any one from 1 to 3");
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		inputuser = input.nextInt();
		if (inputuser == 1) {
			System.out.println("Welcome to List here you have these operations");
			int counter = 1;
			while (counter != 0) {
				System.out.println("1. Add Contact");
				System.out.println("2. Edit Contact");
				System.out.println("3. Delete Contact");
				System.out.println("4. Search in City or state");
				System.out.println("5. Count by city");
				System.out.println("6. Count by State");

				System.out.println(" You Need to add your data to perfrom any opertion ");
				System.out.println(" You want to add your details press 1 ");
				Scanner Sd = new Scanner(System.in);
				IP = Sd.nextInt();
				if (IP == 1)
					Entery.addContact();
				else {
					System.out.println("Wrong Input");
				}
				counter = 1;
				break;

			}
		} else if (inputuser == 2) {
			int counter = 1;
			int select;
			while (counter != 0) {
				System.out.println("Welcome to File here you have these operations");
				System.out.println("1. Write to file .txt");
				System.out.println("2. Read from file .txt");
				System.out.println("3. Write to csvfile");
				System.out.println("4. Read from csvfile");
				System.out.println("5. To Exit");
				@SuppressWarnings("resource")
				Scanner sc = new Scanner(System.in);
				select = sc.nextInt();
				switch (select) {
				case 1:
					Entery.writeIOContact();
					break;
				case 2:
					Entery.readIOContact();
					break;
				case 3:
					Entery.writeDataToCSV();
					break;
				case 4:
					Entery.readDataFromCSVContact();
				default:
					System.out.println("Invalid Input \n");
					counter = 0;
					break;
				}
			}

		} else if (inputuser == 3) {
			@SuppressWarnings("unused")
			int counter = 1;
			int select;
			System.out.println("Welcome to DataBase here you have these operations");
			System.out.println("1. Show all pervious record");
			System.out.println("2. show data with a city name");
			System.out.println("3. show data from some date to other date");
			System.out.println("4. update the adress of a person");
			System.out.println("5. adding new data to data base");
			@SuppressWarnings("resource")
			Scanner sc = new Scanner(System.in);
			select = sc.nextInt();
			switch (select) {
			case 1:
				userDatatoDB.readAdressbook();
				break;
			case 2:
				userDatatoDB.ContactsByCity();
				break;
			case 3:
				userDatatoDB.showContactsBetweenGivenDates();
				break;
			case 4:
				userDatatoDB.updateContactNameOfAdressbook();
				break;
			case 5:
				userDatatoDB.insertContact();
				break;
			default:
				System.out.println(" Invalid Input \n");
				counter = 0;
				break;
			}

		}

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