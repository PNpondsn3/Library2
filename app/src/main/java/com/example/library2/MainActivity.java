package com.example.library2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.library2.DB.AppDatabase;
import com.example.library2.model.User;
import com.example.library2.util.AppExecutors;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final AppExecutors executors = new AppExecutors();
        executors.diskIO().execute(new Runnable() {
            @Override
            public void run() {
                AppDatabase db = AppDatabase.getInstance(MainActivity.this);
                User[] users = db.userDao().selectAllData();
                String msg ="";
                for(User u : users){
                    Log.i(TAG ,u.id +" "+ u.name + " " + u.lastName + " " + u.status);
                }
            }

        });
        executors.mainThread().execute(new Runnable() {
            @Override
            public void run() {
                Button nextButton = findViewById(R.id.next_button);
                nextButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(MainActivity.this , InsertOrShowDataActivity.class);
                        startActivity(intent);
                    }
                });

            }
        });
    }
}


