package com.example.send_email;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText et1, et2;
    private Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1 = findViewById(R.id.et1);
        et2 = findViewById(R.id.et2);
        button = findViewById(R.id.button);
        // button2 = findViewById(R.id.button2);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendEmail();
            }
        });


        //put your intents here
    }


    public void sendEmail() {
        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("text/plain");
        String[] array = {et1.getText().toString()};
        i.putExtra(Intent.EXTRA_EMAIL, array);
        i.putExtra(Intent.EXTRA_SUBJECT, "");
        String message = et2.getText().toString();
        i.putExtra(Intent.EXTRA_TEXT, message);

        if (i.resolveActivity(getPackageManager()) != null) {

            startActivity(i);

            Toast toast = Toast.makeText(getApplicationContext(), "Email Sent", Toast.LENGTH_SHORT);
            toast.show();

        }

        //return error incase application cannot be found/not available
    }

    public void openBrowser() {
        Intent i = new Intent();
        i.setAction(Intent.ACTION_VIEW);
        i.setData(Uri.parse("http://www.google.com"));
        if (i.resolveActivity(getPackageManager()) != null) {
            startActivity(i);
        }
    }
}