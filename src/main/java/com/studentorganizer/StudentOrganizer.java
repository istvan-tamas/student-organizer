package com.studentorganizer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StudentOrganizer {

	// mockaroo -> 1000 db os CSV legyen beolvasva
	// létrehozni egy service-s szimulálja az installációt
	// általában batch vagy python utánanézni ennek kell először lefutnia
	// ennek a service-nek kell elindulnia, és létre kell hoznia a DB-t
	// egytáblás DB elindul és felolvassa a fájlt, és beolvassa listába
	// rendelkezésre bocsájtja olyan változót hozzon létre amit a többi service elér
	// controllereken keresztül el kell majd érni
	// pagination thymeleaf -> pageable egy oldalon hány hallgató jelenjen meg
	// baeldung
	// lehessen szűrni 3-4 csúszó menü edutype és major filter függfénnyel 2 paraméterrel + paraméter ami all



	public static void main(String[] args) {
		SpringApplication.run(StudentOrganizer.class, args);
	}

}
