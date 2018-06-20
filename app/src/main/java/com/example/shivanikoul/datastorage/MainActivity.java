package com.example.shivanikoul.datastorage;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.DialogPreference;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.jar.Attributes;

public class MainActivity extends AppCompatActivity {
    EditText name,age,cls;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name =findViewById(R.id.nameET);
        age =findViewById(R.id.ageEt);
        cls =findViewById(R.id.classEt);
        btn =findViewById(R.id.submitbtn);

        btn.setOnClickListener (new View.OnClickListener(){
            @Override
            public void onClick(View view){

                 if(TextUtils.isEmpty(name.getText().toString())){
                name.setError("Required Filed");
                return;

                if(TextUtils.isEmpty(age.getText().toString())){
                    age.setError("Required Filed");
                    return;

                    if(TextUtils.isEmpty(cls.getText().toString())){
                        cls.setError("Required Filed");
                        return;
            }
                String userName,userAge,userclass =null;
                userName = name.getText().toString();
                userAge  =age.getText().toString();
                userclass =cls.getText().toString();

                SharedPreferences sp =getSharedPreferences("details",MODE_PRIVATE);
                SharedPreferences.Editor editor =sp.edit()
                editor.putString("name",userName);
                editor.putString("age",userAge);
                editor.putString("class",userclass);
                editor.commit();
//                 Alertdialogbox
                AlertDialog.Builder builder =new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Submit Confirmation");
                builder.setMessage("Are you sure to continue");
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int Which) {
                        Intent intent =new Intent(MainActivity.this,sharepref.class);
                        startActivity(intent);

                    }
                });
                builder.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int Which) {
                        finish();

                    }



            }
        });
    }
}