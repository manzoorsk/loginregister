package com.example.admin.loginregister;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Register extends AppCompatActivity implements View.OnClickListener {

    EditText etFirstName,etAge,etUserName,etUserPass;
    Button butRegister;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        butRegister= (Button) findViewById(R.id.butRegister);
        etFirstName= (EditText) findViewById(R.id.etFirstName);
        etAge= (EditText) findViewById(R.id.etAge);
        etUserName= (EditText) findViewById(R.id.etUserName);
        etUserPass= (EditText) findViewById(R.id.etUserPass);
        butRegister.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.butRegister:
                String name=etFirstName.getText().toString();
                int age=Integer.parseInt(etAge.getText().toString());
                String username=etUserName.getText().toString();
                String password=etUserPass.getText().toString();
                User registeredData=new User(name,age,username,password);

                break;
        }
    }
}
