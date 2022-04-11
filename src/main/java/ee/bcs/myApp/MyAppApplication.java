package ee.bcs.myApp;

import ee.bcs.myApp.bank.Bank;
import ee.bcs.myApp.library.Library;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MyAppApplication {

	public static Bank bankRepository = new Bank(); //mängib panga andmebaasi
	public static Library libraryRepository = new Library(); // raamatukogu andmebaas hetkel

	public static void main(String[] args) {
		SpringApplication.run(MyAppApplication.class, args);
	}

}
