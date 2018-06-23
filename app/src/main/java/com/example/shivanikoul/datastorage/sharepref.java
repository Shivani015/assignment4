package com.example.shivanikoul.datastorage;

import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class sharepref extends AppCompatActivity {

    TextView Hello,correct,wrong;
    String userName,userEmail,userPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sharepref);
//        get the reference
        Hello =findViewById(R.id.hello);
        correct =findViewById(R.id.correct);
        wrong =findViewById(R.id.wrong);
//        get shared reference
        SharedPreferences sp =getSharedPreferences("details",MODE_PRIVATE);
//         get the values

        userName = sp.getString("Name","none");
        userEmail = sp.getString("Email","none");
        userPassword =sp.getString("Password","none");
        Hello.setText(userName);
        correct.setText(userEmail);
        wrong.setText(userPassword);

    }
}
