package com.ganesh.service;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.FileInputStream;
import java.io.IOException;

@Service
public class FirebaseInitializer {

//    @Value("${app.firebase-config-file}")
//    private String firebaseConfig;
//    private FirebaseApp firebaseApp;
//
//    @PostConstruct
//    private void initialize() {
//        try {
//            FirebaseOptions firebaseOptions =
//                    new FirebaseOptions.Builder()
//                            .setCredentials(
//                                    GoogleCredentials.fromStream(
//                                            new ClassPathResource(firebaseConfig).getInputStream()))
//                            .build();
//            if (FirebaseApp.getApps().isEmpty()) {
//                this.firebaseApp = FirebaseApp.initializeApp(firebaseOptions);
//            } else {
//                this.firebaseApp = FirebaseApp.getInstance();
//            }
//        } catch (IOException io) {
////            log.error("Create FireBase App Error", io);
//        }
//    }

}
