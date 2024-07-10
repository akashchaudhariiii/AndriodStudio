package com.example.mobileapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity implements DataInterface {

    LoginFragment loginFragment;
    SecondFragment secondFragment;

    Button sendBtn, alertBtn;
    TextView mainText,displayText;
    EditText editText;
    String data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sendBtn =findViewById(R.id.send_btn);
        alertBtn =findViewById(R.id.alert_btn);
        editText=findViewById(R.id.main_editText);
         data= String.valueOf(editText.getText());
        displayText=findViewById(R.id.displayText);

        if(savedInstanceState==null){
            loginFragment=new LoginFragment();
            secondFragment=new SecondFragment();

            FragmentManager fm=getSupportFragmentManager();
            FragmentTransaction fragmentTransaction=fm.beginTransaction();

            fragmentTransaction.add(R.id.login_fragment,loginFragment);
            fragmentTransaction.add(R.id.second_fragment,secondFragment);
            fragmentTransaction.commit();

        }

        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data= String.valueOf(editText.getText());
                loginFragment.receiveDataFromActivity(data);
                secondFragment.receiveDataFromActivity(data);
            }
        });
        alertBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alertBox= new AlertDialog.Builder(MainActivity.this);
                alertBox.setTitle("--** Confirmation **--");
                alertBox.setMessage("Goto Another Page/Activity");
                alertBox.setPositiveButton("Okay", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent=new Intent(MainActivity.this,MenuPage.class);

                        startActivity(intent);
                    }
                });
                alertBox.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }

                });
                alertBox.create();
                alertBox.show();
            }
        });

    }


    @Override
    public void sendDataToActivity(String value) {
        displayText.setText(value);
    }
}