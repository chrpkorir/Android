package com.example.send_sms;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private EditText editTextPhone, editTextMessage,editTextPhone2;
    private Button send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextPhone=findViewById(R.id.editTextPhone);
        editTextMessage=findViewById(R.id.editTextMessage);
        editTextPhone2=findViewById(R.id.editTextPhone2);
        send=findViewById(R.id.send);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //request permission
                if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.M){
                    if (checkSelfPermission(Manifest.permission.SEND_SMS) == PackageManager.PERMISSION_GRANTED) {

                        sendsms();
                    }else{
                        requestPermissions(new String[]{Manifest.permission.SEND_SMS},1);
                    }
                }
            }
        });

    }

    private void sendsms() {
        String phoneNumber = editTextPhone.getText().toString().trim();
        String phoneNumber2 = editTextPhone2.getText().toString().trim();
        String sms = editTextMessage.getText().toString().trim();

        //call sms manager
        try {
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(phoneNumber, null, sms, null, null);
            smsManager.sendTextMessage(phoneNumber2, null, sms, null, null);

            Toast.makeText(this, "Message sent successfully", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(this, "Failed to send message", Toast.LENGTH_SHORT).show();
        }
    }}


