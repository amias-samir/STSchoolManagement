package com.example.adsl4.stschoolmanagement.activities;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.adsl4.stschoolmanagement.R;
import com.example.adsl4.stschoolmanagement.login.TeacherDetailsResponse;
import com.example.adsl4.stschoolmanagement.utils.JsonAndGsonOperation;
import com.example.adsl4.stschoolmanagement.utils.SharedPreferenceUtils;

public class DashboardTeacher extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    String LoginStatus,Student,Organization;
    TextView txtTeacherName,txtTeacherPost;
    ImageView   imageView;

    SharedPreferenceUtils sharedPreferenceUtils;
    TeacherDetailsResponse teacherDetailsResponse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard_teacher);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        overridePendingTransition(R.anim.pull_in_right, R.anim.push_out_left);

        sharedPreferenceUtils = new SharedPreferenceUtils(DashboardTeacher.this);
        teacherDetailsResponse = JsonAndGsonOperation.getTeacherDetails(DashboardTeacher.this);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

//        SharedPreferences.Editor loginStatus = getSharedPreferences(Student, MODE_PRIVATE).edit();
//        loginStatus.putInt("loginStatus", 1);
//        loginStatus.apply();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        View header = navigationView.getHeaderView(0);

        imageView=(de.hdodenhof.circleimageview.CircleImageView) header.findViewById(R.id.profile_image_teacher);
        txtTeacherName = header.findViewById(R.id.txtTeacherName);
        txtTeacherPost=header.findViewById(R.id.txtTeacherPost);

//        SharedPreferences StsName = this.getSharedPreferences(Organization, Context.MODE_PRIVATE);
//        String stName = StsName.getString("teachName", null);
        txtTeacherName.setText(teacherDetailsResponse.getFullName());

//        SharedPreferences techPost = this.getSharedPreferences(Organization, Context.MODE_PRIVATE);
//        String techerPost = techPost.getString("teachPost", null);
        txtTeacherPost.setText(teacherDetailsResponse.getEmployeePost());

//        SharedPreferences stsImage = this.getSharedPreferences(Student, Context.MODE_PRIVATE);
//        String stImage = stsImage.getString("stsImage", null);
//        Picasso.with(this).load("http://sheshayapathshala.com.np/images/"+stImage).into(imageView);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            new AlertDialog.Builder(this)
                    .setIcon(R.drawable.sheshaya)
                    .setTitle(R.string.app_name)
                    .setMessage("Do you want to leave me!!!")
                    .setCancelable(false)
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            DashboardTeacher.this.finish();
                            System.exit(0);
                        }
                    })
                    .setNegativeButton("No", null)
                    .show();

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.dashboard_teacher, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        switch (id) {
            case R.id.nav_logout_teacher:
//                SharedPreferences.Editor editor = getSharedPreferences(LoginStatus, MODE_PRIVATE).edit();
//                editor.putInt("loginStatus", 0);
//                editor.apply();
                sharedPreferenceUtils.clear();
                Intent ri = new Intent(this, SplashScreen.class);
                startActivity(ri);
                finish();
                break;
            case R.id.nav_assignment:
                Intent assignment= new Intent(this,AssignmentTeacher.class);
                startActivity(assignment);
                break;
            case R.id.nav_attendance_add:
                Intent attendance= new Intent(this, AttendanceTeacher.class);
                startActivity(attendance);
                break;
            case R.id.nav_notice:
                Intent notice= new Intent(this,StudentNotices.class);
                startActivity(notice);
                break;

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
