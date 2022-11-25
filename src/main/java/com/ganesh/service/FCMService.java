package com.ganesh.service;

import com.ganesh.model.DirectNotification;
import com.ganesh.model.SubscriptionRequest;
import com.ganesh.model.TopicNotification;
import com.google.firebase.messaging.*;
import com.google.firebase.messaging.WebpushConfig;
import com.google.firebase.messaging.WebpushNotification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class FCMService {

    public void sendNotificationToTarget(DirectNotification notification){
        Message message = Message.builder()
                .setWebpushConfig(
                        WebpushConfig.builder()
                                .setNotification(
                                        WebpushNotification.builder()
                                                .setTitle(notification.getTitle())
                                                .setBody(notification.getMessage())
                                                .build()
                                ).build()
                )
                .setToken(notification.getTarget())
                .build();

       FirebaseMessaging.getInstance().sendAsync(message);
    }

    public void sendNotificationToTopic(TopicNotification notification){
        Message message = Message.builder()
                .setWebpushConfig(
                        WebpushConfig.builder()
                                .setNotification(
                                        WebpushNotification.builder()
                                                .setTitle(notification.getTitle())
                                                .setBody(notification.getMessage())
                                                .build()
                                ).build()
                )
                .setToken(notification.getTopic())
                .build();

                FirebaseMessaging.getInstance().sendAsync(message);
    }

    public void subscribeToTopic(SubscriptionRequest subscriber) throws FirebaseMessagingException {
       // FirebaseMessaging.getInstance().subscribeToTopic(listOf(subscription.subscriber), subscription.topic);
        List<String> subscriptionRequestList = new ArrayList<>();
        subscriptionRequestList.add(subscriber.getSubscriber());
        FirebaseMessaging.getInstance().subscribeToTopic(subscriptionRequestList, subscriber.getMessage());
    }
}
