import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class userDatatoDB {
	
	public static void insertContact() {
		System.out.println("Inserting a new contact to adressbook table");
		Connection conn = AdressBookMain.getsqlConnection();
		if (conn != null) {
			String insertEmp = "INSERT INTO addressbookday37 (firstName,lastName,address,city,state,zip,phoneNumber,email) values(?,?,?,?,?,?,?,?)";
			try {
				PreparedStatement preparedStatement = conn.prepareStatement(insertEmp);
				preparedStatement.setString(1, "QWE");
				preparedStatement.setString(2, "OPI");
				preparedStatement.setString(3, "A 001");
				preparedStatement.setString(4, "Nodia");
				preparedStatement.setString(5, "UP");
				preparedStatement.setInt(6, 211015);
				preparedStatement.setString(7, "8934788982");
				preparedStatement.setString(8, "qwe@gmail.com");
				int rowUpdated = preparedStatement.executeUpdate();
				if (rowUpdated > 0) {
					System.out.println("Data is Updated");
				}
			} catch (SQLException e) {

				e.printStackTrace();
			} finally {
				if (conn != null) {
					try {
						conn.close();
					} catch (SQLException sqlException) {
						System.out.println(sqlException.getMessage());

					}
				}
			}
		}

	}
	public static void readAdressbook() {
		System.out.println("Displaying all data of adressBook table");
	  Connection conn = AdressBookMain.getsqlConnection();

		try {
			if (conn != null) {
				String readEmpPayroll = "SELECT * FROM addressbookday37";

				Statement statement = conn.createStatement();
				ResultSet resultSet = statement.executeQuery(readEmpPayroll);
				while (resultSet.next()) {
					String firstName = resultSet.getString(1);
					String lastName = resultSet.getString(2);
					String adress = resultSet.getString(3);
					String city = resultSet.getString(4);
					String state = resultSet.getString(5);
					Integer zip = resultSet.getInt(6);
					String phoneNumber = resultSet.getString(7);
					String email = resultSet.getString(8);
					String row = String.format(
							"User record:\n FirstName: %s,\n LastName: %s, \n Address: %s,  \n City: %s,\n State: %s , \n Zip: %d, \n PhoneNumber: %s, \n email:%s",
							firstName, lastName, adress, city, state, zip, phoneNumber, email);
					System.out.println(row);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException sqlException) {
					System.out.println(sqlException.getMessage());

				}
			}
		}

	}

}


