import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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

}


