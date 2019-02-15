package com.example.simple.myrememberdfirebase.Model;

public class Sender {

    public SetNotification notification;
    public String to;


    public Sender(SetNotification notification,String to) {
        this.notification = notification;
        this.to = to;
    }

    public SetNotification getNotification() {
        return notification;
    }

    public void setNotification(SetNotification notification) {
        this.notification = notification;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

}//Sender
