package com.example.simple.myrememberdfirebase;

import android.app.DatePickerDialog;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.TimePickerDialog;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.text.InputType;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.simple.myrememberdfirebase.Model.MyResponse;
import com.example.simple.myrememberdfirebase.Model.SetNotification;
import com.example.simple.myrememberdfirebase.Model.Sender;
import com.example.simple.myrememberdfirebase.Remote.APIService;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.InstanceIdResult;
import com.google.firebase.messaging.FirebaseMessaging;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    FirebaseFirestore db;
    Map<String, Object> user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        db = FirebaseFirestore.getInstance();
        user = new HashMap<>();

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel channel = new NotificationChannel("MyNotification","MyNotification",NotificationManager.IMPORTANCE_DEFAULT);

            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }


        FloatingActionButton button = findViewById(R.id.btn_add);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.setCustomAnimations(R.anim.right_to_left,R.anim.left_to_right);
                transaction.replace(R.id.main, new AddFragment());
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        ArrayList<String> data = new ArrayList<>();
        data.add("January");
        data.add("February");
        data.add("March");
        data.add("April");
        data.add("May");
        data.add("June");
        data.add("July");
        data.add("August");
        data.add("September");
        data.add("October");
        data.add("November");
        data.add("December");

        Adapter1 adapter = new Adapter1(this, data, new Adapter1.OnItemClickListener() {
            @Override
            public void onItemClick(String data,int position) {
                Log.d("position", String.valueOf(position));
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                BlankFragment fragment = new BlankFragment();
                Bundle bundle = new Bundle();
                bundle.putString("month", data);
                fragment.setArguments(bundle);
                transaction.setCustomAnimations(R.anim.down_to_up,R.anim.up_to_down);
                transaction.replace(R.id.main, fragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
        RecyclerView recyclerView = findViewById(R.id.rcv1);
        recyclerView.setAdapter(adapter);


    }//onCreate

}
