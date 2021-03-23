package com.example.c026_01_0358_2018;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DisplayDetails extends AppCompatActivity {

    private TextView mDpName;
    private TextView mDpAge;
    private TextView mDpGender;
    private TextView mDpId;
    private TextView mDpCourse;
    private TextView mDpCounty;
    private TextView mDpUniversity;
    private Button mBtFinish;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_details);
        Intent intent = getIntent();
        Info details=(Info)intent.getSerializableExtra("for display");
        mDpName = findViewById(R.id.dpName);
        mDpAge = findViewById(R.id.dpAge);
        mDpGender = findViewById(R.id.dpGender);
        mDpId = findViewById(R.id.dpId);
        mDpCourse = findViewById(R.id.dpCourse);
        mDpCounty = findViewById(R.id.dpCounty);
        mDpUniversity = findViewById(R.id.dpUniversity);
        mBtFinish = findViewById(R.id.btFinish);

        mBtFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(DisplayDetails.this,FinalActivity.class);
                startActivity(intent);
            }
        });

        mDpName.setText(details.getName());
        mDpAge.setText(details.getAge());
        mDpCourse.setText(details.getCourse());
        mDpCounty.setText(details.getCounty());
        mDpId.setText(details.getId());
        mDpGender.setText(details.getGender());
        mDpUniversity.setText(details.getUniversity());


    }
}