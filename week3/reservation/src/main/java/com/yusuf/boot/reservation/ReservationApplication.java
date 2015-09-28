package com.yusuf.boot.reservation;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
public class ReservationApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReservationApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(ReservationRepository repo){
        return args -> {
            Arrays.asList("One", "Two", "Three", "Four", "Five")
                .forEach(name -> {
                    Reservation reservation = new Reservation(name);
                    repo.save(reservation);
                });

            repo.findAll().forEach(System.out::println);
        };
    }
}
