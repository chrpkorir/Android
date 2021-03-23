package com.example.mylistview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MpesaMenu extends AppCompatActivity {
    ListView listview;
    // Data source
    String[]mpesamenu = {"Send Money+","Withdraw Cash","Buy Airtime","Loans and Saving","Lipa na Mpesa", "My Account"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mpesa_menu);
        listview=(ListView) findViewById(R.id.listview1);

        // create an adapter
        ArrayAdapter adapter;
        adapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                mpesamenu
        );
        listview.setAdapter(adapter);

        //handle click event

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position==0){
                    Toast.makeText(getApplicationContext(), "You clicked send money +",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MpesaMenu.this,SendMoney.class);
                    startActivity(intent);
                }
                if (position ==1){
                    Toast.makeText(getApplicationContext(), "You clicked Withdraw Cash +",Toast.LENGTH_SHORT).show();
//                    Intent intent = new Intent(MpesaMenu.this,MpesaMenu.class);
//                    startActivity(intent);
                }
            }
        });


    }

    }
