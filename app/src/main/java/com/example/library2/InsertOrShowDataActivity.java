package com.example.library2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class InsertOrShowDataActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_or_show_data);
        Button showDataButton = findViewById(R.id.show_data_button);
        Button backButton = findViewById(R.id.back_button);
        Button addButton = findViewById(R.id.update_button);
        Button updateButton = findViewById(R.id.update_data_button);

        showDataButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(InsertOrShowDataActivity.this , ShowDataActivity.class);
                startActivity(intent);
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(InsertOrShowDataActivity.this , MainActivity.class);
                startActivity(intent);
            }
        });

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(InsertOrShowDataActivity.this , InsertDataActivity.class);
                startActivity(intent);
            }
        });
        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(InsertOrShowDataActivity.this , UpdateActivity.class);
                startActivity(intent);
            }
        });

    }
}