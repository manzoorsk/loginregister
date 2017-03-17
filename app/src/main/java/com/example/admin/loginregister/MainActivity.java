package com.example.admin.loginregister;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button butlogout;
    EditText etFirstName,etAge,etUserName;
    UserLocalStore userLocalStore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        butlogout= (Button) findViewById(R.id.butlogout);
        etFirstName= (EditText) findViewById(R.id.etFirstName);
        etAge= (EditText) findViewById(R.id.etAge);
        etUserName= (EditText) findViewById(R.id.etUserName);

        butlogout.setOnClickListener(this);
        userLocalStore=new UserLocalStore(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        if(authenticate()==true){
            displayUserDetails();
        }
    }

    private boolean authenticate(){
     return userLocalStore.getUserLoggedIn();
    }

    private void displayUserDetails(){
        User user=userLocalStore.getLoggedInUser();
        etUserName.setText(user.username);
        etFirstName.setText(user.name);
        etAge.setText(user.age + "");

    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.butlogout:
                userLocalStore.clearUserData();
                userLocalStore.setUserLoggedIn(false);
                startActivity(new Intent(this,Login.class));
                break;

        }
    }
}
