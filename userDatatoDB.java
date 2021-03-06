import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class userDatatoDB {

	 static void insertContact() {
		System.out.println("Inserting a new contact to adressbook table");
		Connection conn = AdressBookMain.getsqlConnection();
		if (conn != null) {
			String insertEmp = "INSERT INTO addressbookday37 (firstName,lastName,address,city,state,zip,phoneNumber,email) values(?,?,?,?,?,?,?,?)";
			try {
				PreparedStatement preparedStatement = conn.prepareStatement(insertEmp);
				preparedStatement.setString(1, "SHOB");
				preparedStatement.setString(2, "RANI");
				preparedStatement.setString(3, "A 9999");
				preparedStatement.setString(4, "Delhi");
				preparedStatement.setString(5, "Delhi");
				preparedStatement.setInt(6, 211016);
				preparedStatement.setString(7, "8930788990");
				preparedStatement.setString(8, "ranpp@gmail.com");
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

	public static void updateContactNameOfAdressbook() {
		System.out.println("Updating address of ABD ");
		Connection conn = AdressBookMain.getsqlConnection();
		if (conn != null) {
			String updateEmpPayroll = "UPDATE addressbookday37 SET address = ? WHERE address ='A 401'";
			try {
				PreparedStatement preparedStatement = conn.prepareStatement(updateEmpPayroll);
				preparedStatement.setString(1, "ZZZZ");
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

	public static void showContactsBetweenGivenDates() {
		System.out.println("Displaying information from paticular id");
		Connection conn = AdressBookMain.getsqlConnection();

		try {
			if (conn != null) {
				String readEmpPayroll = "SELECT firstName FROM addressbookday37 WHERE address between 'A 201' and 'A 601'";

				Statement statement = conn.createStatement();
				ResultSet resultSet = statement.executeQuery(readEmpPayroll);
				while (resultSet.next()) {

					String name = resultSet.getString(1);

					String row = String.format("User record: \n Name: %s", name);
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

	public static void ContactsByCity() {
		System.out.println("Getting the data by city");
		Connection conn = AdressBookMain.getsqlConnection();

		try {
			if (conn != null) {
				String readEmpPayroll = "SELECT count(city) FROM addressbookday37 WHERE state = 'UP'";
				Statement statement = conn.createStatement();
				ResultSet resultSet = statement.executeQuery(readEmpPayroll);
				while (resultSet.next()) {

					int countContacts = resultSet.getInt(1);

					String row = String.format("User record: \n Number of Contacts: %d", countContacts);
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
