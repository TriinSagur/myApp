package ee.bcs.myApp;

import ee.bcs.myApp.bank.Bank;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MyAppApplication {

	public static Bank bankRepository = new Bank();

	public static void main(String[] args) {
		SpringApplication.run(MyAppApplication.class, args);
	}

}
