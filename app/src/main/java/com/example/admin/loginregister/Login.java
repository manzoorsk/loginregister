package com.example.admin.loginregister;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class Login extends AppCompatActivity implements View.OnClickListener {

    EditText etUserName,etUserPass;
    Button butlogin;
    TextView text3;
    UserLocalStore userLocalStore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        butlogin= (Button) findViewById(R.id.butlogin);
        etUserName= (EditText) findViewById(R.id.etUserName);
        etUserPass= (EditText) findViewById(R.id.etUserPass);
        text3= (TextView) findViewById(R.id.text3);
        butlogin.setOnClickListener(this);
        text3.setOnClickListener(this);
        userLocalStore=new UserLocalStore(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.butlogin:
                User user=new User(null,null);
                userLocalStore.storeUserData(user);
                userLocalStore.setUserLoggedIn(true);
                break;
            case R.id.text3:
                startActivity(new Intent(this,Register.class));
//                Intent intent=new Intent(this,Register.class);
//                startActivity(intent);
                break;
        }
    }
}
