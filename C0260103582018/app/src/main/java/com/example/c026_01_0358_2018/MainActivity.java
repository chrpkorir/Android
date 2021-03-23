package com.example.c026_01_0358_2018;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText mEtName;
    private EditText mEtAge;
    private EditText mEtGender;
    private EditText mEtId;
    private EditText mEtCourse;
    private EditText mEtCounty;
    private EditText mEtUniversity;
    private Info mEnteredInfo;
    private Button mBtSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mEtName = findViewById(R.id.etName);
        mEtAge = findViewById(R.id.etAge);
        mEtGender = findViewById(R.id.etGender);
        mEtId = findViewById(R.id.etId);
        mEtCourse = findViewById(R.id.etCourse);
        mEtCounty = findViewById(R.id.etCounty);
        mEtUniversity = findViewById(R.id.etUniversity);
        mBtSubmit = findViewById(R.id.btSubmit);

        mBtSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(setDisplayValues()){
                    Intent intent= new Intent(MainActivity.this,DisplayDetails.class);
                    intent.putExtra("for display",mEnteredInfo);
                    startActivity(intent);
                }

            }
        });

    }

    private boolean setDisplayValues(){
        try{
        String name =mEtName.getText().toString();
        int age = Integer.parseInt(mEtAge.getText().toString());
        String gender = mEtGender.getText().toString();
        String id = mEtId.getText().toString();
        String course = mEtCourse.getText().toString();
        String county = mEtCounty.getText().toString();
        String university = mEtUniversity.getText().toString();
        mEnteredInfo = new Info(name,age,gender,id,course,county,university);
        }catch (NumberFormatException e){
            Toast.makeText(this,"age is a number",Toast.LENGTH_LONG).show();
            return false;
        }
        return true;

    }


}
