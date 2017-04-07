package com.example.msi.a123;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import io.skygear.skygear.AuthResponseHandler;
import io.skygear.skygear.Configuration;
import io.skygear.skygear.Container;
import io.skygear.skygear.Error;
import io.skygear.skygear.SkygearApplication;
import io.skygear.skygear.User;

import static android.support.v7.app.AlertDialog.*;

public class MainActivity extends AppCompatActivity {

    EditText user_email;
    EditText password;
    Button signUpButton;
    Button loginButton;
    TextView emailText;
    TextView pwText;
    private Container skygear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        this.skygear = Container.defaultContainer(this);

        user_email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);
        emailText = (TextView) findViewById(R.id.textView);
        pwText = (TextView) findViewById(R.id.textView2);
        signUpButton = (Button) findViewById(R.id.signup);
        loginButton = (Button) findViewById(R.id.login);

        signUpButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String email = user_email.getText().toString();
                String pw = password.getText().toString();

                skygear.signupWithEmail(email, pw, new AuthResponseHandler() {
                    @Override
                    public void onAuthSuccess(User user) {
                        showSuccessSignUp();
                        Context context = getApplicationContext();
                        CharSequence text = "Hello toast!";
                        int duration = Toast.LENGTH_SHORT;

                        Toast toast = Toast.makeText(context, text, duration);
                        toast.show();
                    }

                    @Override
                    public void onAuthFail(Error error) {
                        showFailSignUp();
                    }
                });
            }

        });

        loginButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                String email = user_email.getText().toString();
                String pw = password.getText().toString();

                skygear.loginWithEmail(email, pw, new AuthResponseHandler() {
                    @Override
                    public void onAuthSuccess(User user) {
                        showSuccessLogin();
                    }

                    @Override
                    public void onAuthFail(Error error) {
                        showFailLogin();
                    }
                });
            }
        });
    }

        public void showSuccessSignUp(){
            AlertDialog alertDialog = new AlertDialog.Builder(this).create();
            alertDialog.setTitle("Success");
            alertDialog.setMessage("You have successfully signed up");
            alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                    new DialogInterface.OnClickListener(){

                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
            alertDialog.show();
        }

        public void showSuccessLogin(){
            AlertDialog alertDialog = new Builder(MainActivity.this).create();
            alertDialog.setTitle("Success");
            alertDialog.setMessage("You have successfully logged in");
            alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                    new DialogInterface.OnClickListener(){

                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
            alertDialog.show();
        }

        public void showFailSignUp(){
            AlertDialog alertDialog = new Builder(MainActivity.this).create();
            alertDialog.setTitle("Fail");
            alertDialog.setMessage("You cannot signed up due to some error");
            alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                    new DialogInterface.OnClickListener(){

                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
            alertDialog.show();
        }

        public void showFailLogin(){
            AlertDialog alertDialog = new Builder(MainActivity.this).create();
            alertDialog.setTitle("Fail");
            alertDialog.setMessage("You cannot login due to some error");
            alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                    new DialogInterface.OnClickListener(){

                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
            alertDialog.show();
        }
}



