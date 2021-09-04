
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

public class AddressBookIOServiceFile {
	public String path = "src/main/java/resources/iOfile.txt";
	public String pathcsv = "src/main/java/resources/csvfile.csv";

	public void writeData(List<Contactsuser> list) {
		StringBuffer Buffer = new StringBuffer();
		list.forEach(contact -> {
			String data = contact.toString().concat(" ");
			Buffer.append(data);
		});
		try {
			Files.write(Paths.get(path), Buffer.toString().getBytes());
		} catch (IOException e) {
			e.getStackTrace();
		}

	}

	public void readData() {
		System.out.println("Getting data from IO File");
		try {
			System.out.println(new String(Files.readAllBytes(Paths.get(path))));
		} catch (IOException e) {
			e.getStackTrace();
		}

	}

	public void writeDataToCSVdata(List<Contactsuser> list) {
		try (Writer writer = Files.newBufferedWriter(Paths.get(pathcsv));) {
			StatefulBeanToCsv<Contactsuser> beanToCsv = new StatefulBeanToCsvBuilder<Contactsuser>(writer)
					.withQuotechar(CSVWriter.NO_QUOTE_CHARACTER).build();
			try {
				beanToCsv.write(list);
			} catch (CsvDataTypeMismatchException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (CsvRequiredFieldEmptyException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	public void readDataFromCSVContactdata() {
		System.out.println("Reading user data From CSV file");
		Path pathforcsv = Paths.get(pathcsv);
		try (Reader reader = Files.newBufferedReader(pathforcsv); CSVReader csvReader = new CSVReader(reader);) {
			List<String[]> list = csvReader.readAll();

			for (String[] record : list) {

				System.out.println("userFirstName :" + record[0]);
				System.out.println("userLastName :" + record[1]);
				System.out.println("userCity :" + record[2]);
				System.out.println("userState :" + record[3]);
				System.out.println("useremail :" + record[4]);
				System.out.println("userphoneNumber :" + record[5]);
				System.out.println("userzip :" + record[6]);

			}

		} catch (IOException e) {
			e.printStackTrace();
		} catch (CsvException e) {
			e.printStackTrace();
		}

	}

}
