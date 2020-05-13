package se.lnu.ems.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Linnaeus University.
 * 2DV609 - Project Course in Software Engineering.
 * <p>
 * @author Group 1: Abdalrahman Dabor, Ahmad Anbarje, Hamza Hajderovic,
 * Jacob Yousif, Osama Zarraa and Sirwan Rasoul.
 * @version 1.0
 * @since 2020-05-01
 * <p>
 * The main class for the main entry point for the MyExam application.
 */
@SpringBootApplication
public class MainApplication {
    /**
     * The main entry point to the application.
     *
     * @param args the arguments.
     */
    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
        
    }
}
