package com.example.mobileapp;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link LoginFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LoginFragment extends Fragment {

    Button login;
    TextView textView;
    EditText emailText, passwordText;

    String email, password;
    DataInterface dataInterface;


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        dataInterface= (DataInterface) context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_login,container, false);
        textView=v.findViewById(R.id.textFromMain);
        login=v.findViewById(R.id.login_btn);
        emailText =v.findViewById(R.id.email_input);
        passwordText=v.findViewById(R.id.password_input);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                email= String.valueOf(emailText.getText());
                password= String.valueOf(passwordText.getText());
                dataInterface.sendDataToActivity("Email:"+email+"  Password:"+password);
            }
        });
        return v;
    }

    public void receiveDataFromActivity(String data) {
        textView.setText(data);
    }
}