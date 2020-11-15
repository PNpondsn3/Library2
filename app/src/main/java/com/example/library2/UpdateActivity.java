package com.example.library2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.example.library2.DB.AppDatabase;
import com.example.library2.model.User;
import com.example.library2.util.AppExecutors;

public class UpdateActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        final EditText nameEditText = findViewById(R.id.name_edit_text);
        final EditText lastNameEditText = findViewById(R.id.last_name_edit_text);
        final CheckBox borrowBookCheckBox = findViewById(R.id.is_borrow_check_box);
        final Button updateButton = findViewById(R.id.update_button);

       updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String name = nameEditText.getText().toString();
                final String lastname = lastNameEditText.getText().toString();

                if(name.length() == 0 || lastname.length() == 0){
                    AlertDialog.Builder dialog = new AlertDialog.Builder(UpdateActivity.this);
                    dialog.setMessage("กรุณากรอกข้อมูล");
                    dialog.setPositiveButton("Ok" , null);
                    dialog.show();
                }else {
                    final String status;
                    if(borrowBookCheckBox.isChecked()){
                        status = "คืนแล้ว";
                    }else {
                        status = "ยังไม่คืน";
                    }
                    AppExecutors executors = new AppExecutors();
                    executors.diskIO().execute(new Runnable() {
                        @Override
                        public void run() {
                            AppDatabase db = AppDatabase.getInstance(UpdateActivity.this);
                            db.userDao().updateUsers(name ,lastname , status);

                        }
                    });
                    executors.mainThread().execute(new Runnable() {
                        @Override
                        public void run() {
                            Intent intent = new Intent(UpdateActivity.this,ShowDataActivity.class);
                            startActivity(intent);
                        }
                    });
                }
                }

        });


    }
}