package com.example.springboot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.File;


@RestController
public class HelloController {

    @GetMapping("/")
    public String index() {

        return "Greetings from Spring Boot!";
    }

    @GetMapping("/createfile")
    public String createFileAndGrantPermission() {
        try {
            File myObj = new File("filename.txt");
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
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
