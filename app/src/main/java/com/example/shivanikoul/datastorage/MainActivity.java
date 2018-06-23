package com.example.shivanikoul.datastorage;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.DialogPreference;
import android.provider.ContactsContract;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.jar.Attributes;

public class MainActivity extends AppCompatActivity {
    EditText name,email,password;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name =findViewById(R.id.nameET);
        email =findViewById(R.id.emailET);
        password =findViewById(R.id.passwordET);
        btn =findViewById(R.id.submitbtn);

        btn.setOnClickListener (new View.OnClickListener(){
            @Override
            public void onClick(View view){

                 if(TextUtils.isEmpty(name.getText().toString())) {
                     name.setError("Required Filed");
                     return;
                 }

                if(TextUtils.isEmpty(email.getText().toString())) {
                    email.setError("Required Filed");
                    return;
                }

                    if(TextUtils.isEmpty(password.getText().toString())){
                        password.setError("Required Filed");
                        return;
            }
                String userName,userEmail,userPassword =null;
                userName = name.getText().toString();
                userEmail = email.getText().toString();
                userPassword =password.getText().toString();

                SharedPreferences sp =getSharedPreferences("details",MODE_PRIVATE);
                SharedPreferences.Editor editor =sp.edit();
                editor.putString("name",userName);
                editor.putString("email",userEmail);
                editor.putString("password",userPassword);
                editor.commit();
//                 Alertdialogbox
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("subnit confirmation");
                builder.setMessage("Are you sure want to continue");
                builder.setPositiveButton("yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent(MainActivity.this, sharepref.class);
                        startActivity(intent);
                    }
                });

                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }

                });

                builder.show();

            }
        });
    }

}