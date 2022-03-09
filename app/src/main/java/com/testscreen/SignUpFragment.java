package com.testscreen;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;
import com.testscreen.Model.User;

import java.util.Objects;

public class SignUpFragment extends Fragment {

    EditText name, email, number, password;
    Button signin;
    ProgressDialog progressDialog;
    private FirebaseAuth firebaseAuth;
    private FirebaseDatabase firebaseDatabase;

    public SignUpFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_sign_up, container, false);

        name = rootView.findViewById(R.id.name);
        email = rootView.findViewById(R.id.email);
        number = rootView.findViewById(R.id.number);
        password = rootView.findViewById(R.id.password);
        signin = rootView.findViewById(R.id.button2);
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseDatabase = FirebaseDatabase.getInstance();

        progressDialog = new ProgressDialog(getContext());
        progressDialog.setTitle("Created Account");
        progressDialog.setMessage("SignUp");




        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (email.getText().toString().length() != 0) {
                    if (password.getText().toString().length() != 0) {
                        if (name.getText().toString().length() != 0) {
                            if (number.getText().toString().length()==10) {
                                progressDialog.show();
                                Show();
                            }else {
                                Toast.makeText(getContext(), "Enter your Number", Toast.LENGTH_SHORT).show();
                            }
                        }else {
                            Toast.makeText(getContext(), "Enter your Name", Toast.LENGTH_SHORT).show();
                        }
                    }else {
                        Toast.makeText(getContext(), "Set  your Password", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(getContext(), "Enter your Email", Toast.LENGTH_SHORT).show();
                }


            }
        });


        return rootView;
    }


    private void Show() {


        new Thread(new Runnable() {
            @Override
            public void run() {


                String Name = name.getText().toString().trim();
                String Email = email.getText().toString().trim();
                String Number = number.getText().toString().trim();
                String Password = password.getText().toString().trim();
                firebaseAuth.createUserWithEmailAndPassword(email.getText().toString(), password.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        User user = new User(Name, Email, Number, Password, firebaseAuth.getUid());
                        firebaseDatabase.getReference().child("User").child(Objects.requireNonNull(firebaseAuth.getUid())).setValue(user);
                        Toast.makeText(getContext(), "SignUp Successfully", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getActivity(), HomeScreen.class);
                        startActivity(intent);
                        progressDialog.dismiss();

                    }
                });

            }
        }).start();


    }
}