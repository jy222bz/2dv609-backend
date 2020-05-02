package se.lnu.ems.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The main class for the main entry point for MyExam application.
 *
 * @author Group 1
 * @version 1.0
 * @since 2020-05-01
 */
@SpringBootApplication
public class MainApplication {
    /**
     * The main entry point to the application.
     * @param args the arguments.
     */
    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
    }
}
