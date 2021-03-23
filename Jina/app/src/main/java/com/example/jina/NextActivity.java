package com.example.jina;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class NextActivity extends AppCompatActivity {

    TextView displayText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);

//        Bundle myBundle  = getIntent().getExtras();

        displayText = findViewById(R.id.text);
//        String inputText = myBundle.getString("message");
        displayText.setText("Dashboard");
    }
}