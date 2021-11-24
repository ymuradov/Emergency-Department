package com.bsmp.emergency_room;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class EmergencyRoomApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmergencyRoomApplication.class, args);
    }

}
