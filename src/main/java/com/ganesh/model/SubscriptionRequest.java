package com.ganesh.model;

public class SubscriptionRequest {

    private String subscriber;

    private String message;

    public SubscriptionRequest() {}

    public String getSubscriber() {
        return subscriber;
    }

    public void setSubscriber(String subscriber) {
        this.subscriber = subscriber;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
