package com.ganesh.controller;

import com.ganesh.model.DirectNotification;
import com.ganesh.model.Note;
import com.ganesh.model.SubscriptionRequest;
import com.ganesh.model.TopicNotification;
import com.ganesh.service.FCMService;
import com.ganesh.service.FirebaseMessagingService;
import com.google.firebase.messaging.FirebaseMessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
class NotificationController {
    @Autowired
    private FCMService fcm;

    @Autowired
    private FirebaseMessagingService firebaseService;

    @PostMapping("/notification")
    public void sendTargetedNotification(@RequestBody DirectNotification notification) {
        fcm.sendNotificationToTarget(notification);
    }

    @PostMapping("/topic/notification")
    public void sendNotificationToTopic(@RequestBody TopicNotification notification) {
        fcm.sendNotificationToTopic(notification);
    }

    @PostMapping("/topic/subscription")
    public void subscribeToTopic(@RequestBody SubscriptionRequest subscription) throws FirebaseMessagingException {
        fcm.subscribeToTopic(subscription);
    }

    @PostMapping("/send-notification")
    public String sendNotification(@RequestBody Note note,
                                   @RequestParam String token) throws FirebaseMessagingException {
        return firebaseService.sendNotification(note, token);
    }
}