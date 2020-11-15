package com.example.library2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.library2.DB.AppDatabase;
import com.example.library2.adapter.UserAdapter;
import com.example.library2.model.User;
import com.example.library2.util.AppExecutors;

public class ShowDataActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_data);
        mRecyclerView = findViewById(R.id.user_recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(ShowDataActivity.this));
        AppExecutors executors = new AppExecutors();
        executors.diskIO().execute(new Runnable() {
            @Override
            public void run() {
                AppDatabase db = AppDatabase.getInstance(ShowDataActivity.this);
                User[] users = db.userDao().selectAllData();
                UserAdapter adapter = new UserAdapter(ShowDataActivity.this , users);
                mRecyclerView.setAdapter(adapter);
            }
        });
        executors.mainThread().execute(new Runnable() {
            @Override
            public void run() {
                Button backButton = findViewById(R.id.back_button);
                backButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(ShowDataActivity.this , InsertOrShowDataActivity.class);
                        startActivity(intent);
                    }
                });
            }
        });



    }
}