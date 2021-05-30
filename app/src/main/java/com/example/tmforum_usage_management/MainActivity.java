package com.example.tmforum_usage_management;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private static final String LOG_TAG = MainActivity.class.getName();

    private Button listBtn;
    private Button addNewBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listBtn = findViewById(R.id.listBtn);
        addNewBtn = findViewById(R.id.addNewBtn);
    }

    public void loadListAll(View view) {
        Intent intent = new Intent(this, List.class);
        Log.i(LOG_TAG, "starting activity: " + List.class.getName());
        startActivity(intent);
        finish();
    }

    public void loadAddNew(View view) {
        Intent intent = new Intent(this, AddNewManagementActivity.class);
        Log.i(LOG_TAG, "starting activity: " + AddNewManagementActivity.class.getName());
        startActivity(intent);
        finish();
    }
}