package com.example.springboot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.File;
import java.util.UUID;


@RestController
public class HelloController {

    @GetMapping("/")
    public String index() {

        return "Greetings from Spring Boot!";
    }

    @GetMapping("/createfile")
    public String createFileAndGrantPermission() {
        try {
            String randomGuid = UUID.randomUUID().toString().replace("-", "");
            File file = new File(randomGuid);
            if (file.createNewFile()) {
                System.out.println("File created: " + file.getName());
                file.setReadable(true, false);
                file.setExecutable(true, false);
                file.setWritable(true, false);
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return "success";
    }

}
