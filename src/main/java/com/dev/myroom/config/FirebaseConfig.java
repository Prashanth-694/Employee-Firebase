package com.dev.myroom.config;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import com.dev.myroom.entity.FirebaseCredential;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;

@Configuration
public class FirebaseConfig {
	@Value("${FIREBASE_TYPE}")
	private String type;
	@Value("${FIREBASE_PROJECT_ID}")
	private String projectId;
	@Value("${FIREBASE_PRIVATE_KEY_ID}")
	private String privateKeyId;
	@Value("${FIREBASE_PRIVATE_KEY}")
	private String firebasePrivateKey;
	@Value("${FIREBASE_CLIENT_EMAIL}")
	private String clientEmail;
	@Value("${FIREBASE_CLIENT_ID}")
	private String clientId;
	@Value("${FIREBASE_AUTH_URI}")
	private String authUri;
	@Value("${FIREBASE_TOKEN_URI}")
	private String tokenUri;
	@Value("${FIREBASE_AUTH_PROVIDER_X509_CERT_URL}")
	private String authProviderX509Url;
	@Value("${FIREBASE_CLIENT_X509_CERT_URL}")
	private String clientX509CertUrl;

	public InputStream createFirebaseCredential() throws Exception {
		System.out.println(privateKeyId);
System.out.println(type);
	    //private key
	    String privateKey = firebasePrivateKey.replace("\\n", "\n");

	    FirebaseCredential firebaseCredential = new FirebaseCredential();
	    firebaseCredential.setType(type);
	    firebaseCredential.setProject_id(projectId);
	    firebaseCredential.setPrivate_key_id(privateKeyId);
	    firebaseCredential.setPrivate_key(privateKey);
	    firebaseCredential.setClient_email(clientEmail);
	    firebaseCredential.setClient_id(clientId);
	    firebaseCredential.setAuth_uri(authUri);
	    firebaseCredential.setToken_uri(tokenUri);
	    firebaseCredential.setAuth_provider_x509_cert_url(authProviderX509Url);
	    firebaseCredential.setClient_x509_cert_url(clientX509CertUrl);
	    //serialization of the object to json string
	    ObjectMapper mapper = new ObjectMapper();
	    String jsonString = mapper.writeValueAsString(firebaseCredential);

	    InputStream targetStream = new ByteArrayInputStream(jsonString.getBytes());
	    return targetStream;
	    		
	}
	
	public void fireBaseConfig()
	{
		@SuppressWarnings("deprecation")
		FirebaseOptions options;
		try {
			options = new FirebaseOptions.Builder()
					.setCredentials(GoogleCredentials.fromStream(createFirebaseCredential()))
					.setDatabaseUrl("https://myroom-401-default-rtdb.asia-southeast1.firebasedatabase.app").build();
			FirebaseApp.initializeApp(options);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}

}
