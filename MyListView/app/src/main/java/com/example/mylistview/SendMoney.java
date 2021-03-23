package com.example.mylistview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class SendMoney extends AppCompatActivity {
    ListView listview;
    String[]sendMoneyMenu = {"Search SIM Contact","Enter Phone No"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_money);
        listview=(ListView) findViewById(R.id.listview2);

        // create an adapter
        ArrayAdapter adapter;
        adapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                sendMoneyMenu
        );
        listview.setAdapter(adapter);

        //handle click event

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position==0){
                    Toast.makeText(getApplicationContext(), "You clicked Search SIM Contact",Toast.LENGTH_SHORT).show();
                }
                if (position ==1){
//                    Toast.makeText(getApplicationContext(), "You clicked Enter Phone No",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(SendMoney.this,EnterPhoneNo.class);
                    startActivity(intent);
                }
            }
        });
    }
} 