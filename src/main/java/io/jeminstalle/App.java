package io.jeminstalle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

@EnableAutoConfiguration
// On autorise le scan des Component
@ComponentScan
@ImportResource("spring-data-es.xml")
public class App {
    /**
     * Main function to start my app
     *
     * @param args Arguments given on launch
     * @throws Exception If something bad happens
     */
    public static void main(String[] args) throws Exception {

        // Simply starts my webapp
        SpringApplication.run(App.class, args);

        System.out.println("Hello from Jeminstalle.IO !");
    }
}

