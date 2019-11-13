package com.example.najmidpi;

import android.app.ActionBar;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Activity_Register extends AppCompatActivity {

    Button btnsave ;
    EditText ETemail , ETphone , ETpass , ETretryPass ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__register);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        init();


        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String mail=ETemail.getText().toString().trim();
                String phone=ETphone.getText().toString().trim();

                if(isValidInput(mail , phone)){
                    Toast.makeText(Activity_Register.this, "it is ok", Toast.LENGTH_SHORT).show();

                }

//                Intent intent=new Intent(getApplicationContext(),HomeActivity.class);
//                startActivity(intent);
            }
        });


    }

    private boolean isValidInput(String mail, String phone) {
        if (!phone.isEmpty()&& phone.length() !=11 || !phone.startsWith("09") || phone.isEmpty()){
            ETphone.requestFocus();
            return false;
        }
        if (mail.lastIndexOf("@")<=0 || !mail.contains(".") ||mail.lastIndexOf(".")<mail.lastIndexOf("@")|| mail.split("@").length>2){
            ETemail.requestFocus();
            return false;
        }
        return true;
    }


    private void init() {
        btnsave=findViewById(R.id.register_btn);
        ETemail=findViewById(R.id.register_mail);
        ETphone=findViewById(R.id.register_phone);
        ETpass=findViewById(R.id.register_pass);
        ETretryPass=findViewById(R.id.register_retrypass);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}


