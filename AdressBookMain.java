import java.util.Scanner;

public class AdressBookMain {

	public static void main(String[] args) {

		System.out.println("Welcome to Address book program..");

		AdressBookUserDay37 Entery = new AdressBookUserDay37();
		Scanner sc = new Scanner(System.in);
		System.out.println("How Many entry you want to make this time");
		Entery.addContact();
		sc.close();
	}

}