package com.example.adsl4.stschoolmanagement.activities;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;

import com.example.adsl4.stschoolmanagement.R;
import com.example.adsl4.stschoolmanagement.utils.SharedPreferenceUtils;

public class SplashScreen extends AppCompatActivity {
    private static int SPLASH_TIME_OUT=1000;
    String Student;

    SharedPreferenceUtils sharedPreferenceUtils ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        overridePendingTransition(R.anim.pull_in_right, R.anim.push_out_left);

        sharedPreferenceUtils = new SharedPreferenceUtils(SplashScreen.this);

        isNetworkAvailable();
    }
    private boolean isNetworkAvailable() {
        NetworkInfo info = (NetworkInfo) ((ConnectivityManager)
                getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE)).getActiveNetworkInfo();

        if (info == null)
        {
            new AlertDialog.Builder(this)
                    .setIcon(R.drawable.sheshaya)
                    .setTitle(R.string.app_name)
                    .setMessage("No Internet Connection!!!")
                    .setCancelable(false)
                    .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            SplashScreen.this.finish();
                            System.exit(0);
                        }
                    })
                    .show();
            return false;
        }
        else
        {
            if(info.isConnected())
            {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        SharedPreferences prefs = getSharedPreferences(Student, MODE_PRIVATE);
                        int idName = prefs.getInt("loginStatus", 0);

                        boolean alreadyLoggedIn = sharedPreferenceUtils.getBoolanValue(SharedPreferenceUtils.KEY_IS_USER_LOGGED_IN, false);
                        int userType = sharedPreferenceUtils.getIntValue(SharedPreferenceUtils.KEY_USER_ID, -1);
                        if(alreadyLoggedIn && userType == 1){
                            Intent homeIntent = new Intent(SplashScreen.this, DashboardTeacher.class);
                            startActivity(homeIntent);
                            finish();
                        }
                        else if(alreadyLoggedIn && userType == 0){
                            Intent homeIntent = new Intent(SplashScreen.this, MainActivity.class);
                            startActivity(homeIntent);
                            finish();
                        }
                        else {
                            Intent homeIntent = new Intent(SplashScreen.this, ChooseLogin.class);
                            homeIntent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                            startActivity(homeIntent);
                            finish();
                        }
                    }
                },SPLASH_TIME_OUT);
//                Toast.makeText(getApplicationContext(),"Connected",Toast.LENGTH_LONG).show();
                return true;
            }
            else
            {
//                Log.d(TAG," internet connection");
                return true;
            }

        }
    }
}
