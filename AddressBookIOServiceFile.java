
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class AddressBookIOServiceFile {
	public String path = "src/main/java/resources/iOfile.txt";

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

}
