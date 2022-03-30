package com.dev.myroom;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.EventListener;
import org.springframework.core.env.Environment;

import com.dev.myroom.config.FirebaseConfig;
import com.dev.myroom.entity.FirebaseCredential;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;

@SpringBootApplication
public class SpringBootFireBaseApplication {
@Autowired
FirebaseConfig firebaseConfig;
	public static void main(String[] args) throws Exception {
		/*
		 * File file = new File("src\\main\\resources\\serviceAccountKey.json");
		 * FileInputStream fileInputStream = new
		 * FileInputStream(file.getAbsolutePath());
		 */
		SpringApplication.run(SpringBootFireBaseApplication.class, args);
		
	}
	
	@EventListener(ApplicationReadyEvent.class)
	public void runAfterStartup() {
	    firebaseConfig.fireBaseConfig();
	}
}
