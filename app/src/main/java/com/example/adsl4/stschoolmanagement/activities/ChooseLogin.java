package com.example.adsl4.stschoolmanagement.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.adsl4.stschoolmanagement.R;
import com.example.adsl4.stschoolmanagement.login.Login;
import com.example.adsl4.stschoolmanagement.login.QrScanner;

public class ChooseLogin extends AppCompatActivity implements View.OnClickListener{
Button btnLoginWithId, btnLoginWithQrCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_login);
        btnLoginWithId=findViewById(R.id.btnLoginWithId);
        btnLoginWithId.setOnClickListener(this);
        btnLoginWithQrCode=findViewById(R.id.btnLoginWithQrCode);
        btnLoginWithQrCode.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        int id=v.getId();
        switch(id){
            case R.id.btnLoginWithId:
                Intent loginWithIdIntent= new Intent(ChooseLogin.this,Login.class);
                startActivity(loginWithIdIntent);
                break;
            case R.id.btnLoginWithQrCode:
                Intent loginEIthQrIntent=new Intent(ChooseLogin.this,QrScanner.class);
                startActivity(loginEIthQrIntent);
                break;
        }
    }
}
