package com.drexelewb.drexelewbapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainPage extends AppCompatActivity {

    private EditText Name;
    private EditText Password;
    private TextView Info;
    private Button Login;
    private int counter = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);

        Name = (EditText) findViewById(R.id.etEmail);
        Password = (EditText) findViewById(R.id.etPassword);
        Info = (TextView) findViewById(R.id.LoginInfo);
        Login = (Button) findViewById(R.id.btnLogin);

        Info.setText("Attempts remaining: ");


        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate(Name.getText().toString(),Password.getText().toString());

            }
        });
    }
        private void validate(String userName, String userPassword){
            if((userName == "Admin") && (userPassword == "1234")){
                Intent intent = new Intent(MainPage.this, secondActivity.class);
                startActivity(intent);
            } else {
                counter--;

                if(counter == 0){

                    Info.setText("Attempts remaining: " + String.valueOf(counter));
                    Login.setEnabled(false);
                }
            }

        }

}


