package com.example.simple.myrememberdfirebase.Remote;

import com.example.simple.myrememberdfirebase.Model.MyResponse;
import com.example.simple.myrememberdfirebase.Model.Sender;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.PUT;

public interface APIService {

    @Headers({
           "Content-Type:application/json",
            "Authorization:key=AAAA4CYQ2Ag:APA91bEYwj4RoTmf7oUPJsp9RD1jPsMKnUsUhc3eJDuAYlbiSi9YHgX6qFfYhYHuFCXvQdyVe-KH-nQNsrs4SMR-bGdTHPp96NBKMF9cdZS9e8yGhQ9BL5P5-ZgIY1Sjn3iZOqAcs7_f",

    })
    @POST("fcm/send")
    Call<MyResponse> sendNotification(@Body Sender body);

}//APIService
