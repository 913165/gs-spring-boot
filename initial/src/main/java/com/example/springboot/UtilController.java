package com.example.springboot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UtilController {

	@GetMapping("/util")
	public String executeCommand(String cmd) throws IOException {
		ProcessBuilder processBuilder = new ProcessBuilder();
		processBuilder.command("cal", "2019", "-m 2");
		Process process = processBuilder.start();
		StringBuffer resultBuffer = new StringBuffer();
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
			String line;
			while ((line = reader.readLine()) != null) {
				System.out.println(line);
				resultBuffer.append(line);
			}
		}
		return resultBuffer.toString();
	}
}
