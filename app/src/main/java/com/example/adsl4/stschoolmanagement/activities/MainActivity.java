package com.example.adsl4.stschoolmanagement.activities;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.app.ActivityCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.adsl4.stschoolmanagement.R;
import com.example.adsl4.stschoolmanagement.login.StudentDetail;
import com.example.adsl4.stschoolmanagement.login.TeacherDetailsResponse;
import com.example.adsl4.stschoolmanagement.utils.JsonAndGsonOperation;
import com.example.adsl4.stschoolmanagement.utils.SharedPreferenceUtils;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {
    String Student, orgPhone;
    Button btnMessage, btnNotices, btnAssignment, btnAttendance;
    ScrollView relMain;
    EditText edtEmail3;
    TextView txtStsName, txtStsAddress, txtSchoolName;
    String StsName1, Organization;
    ImageView imageView;
    SharedPreferenceUtils sharedPreferenceUtils;
    StudentDetail studentDetail;
    TeacherDetailsResponse teacherDetailsResponse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        overridePendingTransition(R.anim.pull_in_right, R.anim.push_out_left);

        sharedPreferenceUtils = new SharedPreferenceUtils(MainActivity.this);
        studentDetail = JsonAndGsonOperation.getStudentDetails(MainActivity.this);
        teacherDetailsResponse = JsonAndGsonOperation.getTeacherDetails(MainActivity.this);

//        SharedPreferences.Editor loginStatus = getSharedPreferences(Student, MODE_PRIVATE).edit();
//        loginStatus.putInt("loginStatus", 2);
//        loginStatus.apply();
        DrawerLayout drawer = findViewById(R.id.drawer_layout);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        btnAttendance = findViewById(R.id.btnAttendance);
        btnAttendance.setOnClickListener(this);
        btnMessage = findViewById(R.id.btnMessage);
        btnMessage.setOnClickListener(this);
        btnNotices = findViewById(R.id.btnNotices);
        btnNotices.setOnClickListener(this);
        btnAssignment = findViewById(R.id.btnAssignment);
        btnAssignment.setOnClickListener(this);
        txtSchoolName = findViewById(R.id.txtSchoolName);


        edtEmail3 = findViewById(R.id.edtEmail3);

        View header = navigationView.getHeaderView(0);
        imageView = (CircleImageView) header.findViewById(R.id.profile_image);
        txtStsName = header.findViewById(R.id.txtStsName1);
        txtStsAddress = header.findViewById(R.id.txtStsAddress);


        int userType = sharedPreferenceUtils.getIntValue(SharedPreferenceUtils.KEY_USER_ID, -1);

        if (userType == 0) {
            txtStsName.setText(studentDetail.getFullName());
            txtStsAddress.setText(studentDetail.getEmail());
            txtSchoolName.setText(studentDetail.getOrganization());
            Picasso.with(this).load("http://sheshayapathshala.com.np/images/" + studentDetail.getStudentImage()).into(imageView);

        } else if (userType == 1) {
            txtStsName.setText(teacherDetailsResponse.getFullName());
            txtStsAddress.setText(teacherDetailsResponse.getEmail());
            txtSchoolName.setText(teacherDetailsResponse.getOrganization());
            Picasso.with(this).load("http://sheshayapathshala.com.np/images/" + teacherDetailsResponse.getEmployeeImage()).into(imageView);

        }


        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder;
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    builder = new AlertDialog.Builder(MainActivity.this, android.R.style.Theme_Material_Dialog_Alert);
                } else {
                    builder = new AlertDialog.Builder(MainActivity.this);
                }
                builder.setTitle("Call School?")
                        .setMessage("Are you sure you want to call School?")
                        .setIcon(R.drawable.ic_call_black_24dp)
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                Intent intent = new Intent(Intent.ACTION_CALL);
                                intent.setData(Uri.parse("tel:" + orgPhone));
                                Toast.makeText(MainActivity.this, "Calling: " + orgPhone, Toast.LENGTH_SHORT).show();
                                if (ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                                    // TODO: Consider calling
                                    //    ActivityCompat#requestPermissions
                                    // here to request the missing permissions, and then overriding
                                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                                    //                                          int[] grantResults)
                                    // to handle the case where the user grants the permission. See the documentation
                                    // for ActivityCompat#requestPermissions for more details.
                                    return;
                                }
                                startActivity(intent);
                            }
                        })
                        .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                // do nothing
                            }
                        })
                        .show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //  getMenuInflater().inflate(R.menu.menu_main, menu);
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
                            MainActivity.this.finish();
                            System.exit(0);
                        }
                    })
                    .setNegativeButton("No", null)
                    .show();

        }
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        switch (id) {
            case R.id.nav_logout:
                new AlertDialog.Builder(this)
                        .setIcon(R.drawable.sheshaya)
                        .setTitle(R.string.app_name)
                        .setMessage("Do you want to log out?")
                        .setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
//                                SharedPreferences.Editor editor = getSharedPreferences(Student, MODE_PRIVATE).edit();
//                                editor.putInt("loginStatus", 0);
//                                editor.apply();
                                sharedPreferenceUtils.clear();
                                Intent ri = new Intent(MainActivity.this, SplashScreen.class);
                                startActivity(ri);
                                finish();
                            }
                        })
                        .setNegativeButton("No", null)
                        .show();
                break;
            case R.id.nav_notice:
                Intent noticeIntent = new Intent(MainActivity.this, StudentNotices.class);
                startActivity(noticeIntent);
                break;
            case R.id.nav_assignment:
                Intent assignmentIntent = new Intent(MainActivity.this, AssignmentStudent.class);
                startActivity(assignmentIntent);
                break;
            case R.id.nav_attendance:
                Intent attendanceIntent = new Intent(MainActivity.this, StudentAttendance.class);
                startActivity(attendanceIntent);
                break;
            case R.id.nav_myMessage:
                Intent messageIntent = new Intent(MainActivity.this, StudentMessage.class);
                startActivity(messageIntent);
                break;

        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.btnNotices:
                Intent noticeIntent = new Intent(MainActivity.this, StudentNotices.class);
                startActivity(noticeIntent);
                break;
            case R.id.btnMessage:
                Intent messageIntent = new Intent(MainActivity.this, StudentMessage.class);
                startActivity(messageIntent);
                break;
            case R.id.btnAssignment:
                Intent assignmentIntent = new Intent(MainActivity.this, AssignmentStudent.class);
                startActivity(assignmentIntent);
                break;
            case R.id.btnAttendance:
                Intent attendanceIntent = new Intent(MainActivity.this, StudentAttendance.class);
                startActivity(attendanceIntent);
                break;
        }
    }
}
