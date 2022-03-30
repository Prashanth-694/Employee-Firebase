package com.dev.myroom;

import java.io.File;
import java.io.FileInputStream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;

@SpringBootApplication
public class SpringBootFireBaseApplication {

	public static void main(String[] args) throws Exception {
		File file = new File("src\\main\\resources\\serviceAccountKey.json");
		FileInputStream fileInputStream = new FileInputStream(file.getAbsolutePath());
		@SuppressWarnings("deprecation")
		FirebaseOptions options = new FirebaseOptions.Builder()
				.setCredentials(GoogleCredentials.fromStream(fileInputStream))
				.setDatabaseUrl("https://myroom-401-default-rtdb.asia-southeast1.firebasedatabase.app").build();

		FirebaseApp.initializeApp(options);

		SpringApplication.run(SpringBootFireBaseApplication.class, args);
	}

}
