package com.example.mcclellan_duncan_hw4;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    SharedPreferences sp;

    EditText name;
    EditText email;
    EditText password;
    Button save;
    Button retrieve;
    Button clear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        save = findViewById(R.id.save_btn);
        retrieve = findViewById(R.id.retrieve_btn);
        clear = findViewById(R.id.clear_btn);
        name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        password = findViewById(R.id.pswd);

        sp = getSharedPreferences("myPrefs", Context.MODE_PRIVATE);

        setOnClick();
    }

    private void Save(View view){
        SharedPreferences.Editor editor = sp.edit();

        editor.putString("Name", name.getText().toString());
        editor.putString("Email", email.getText().toString());
        editor.putString("Password", password.getText().toString());
        editor.commit();
    }

    private void Retrieve(View view){
        name.setText(sp.getString("Name", null));
        email.setText(sp.getString("Email", null));
        password.setText(sp.getString("Password", null));
    }

    private void Clear(View view){
        name.setText("");
        email.setText("");
        password.setText("");
    }

    private void setOnClick(){
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Save(view);
            }
        });

        retrieve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Retrieve(view);
            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Clear(view);
            }
        });
    }
}
