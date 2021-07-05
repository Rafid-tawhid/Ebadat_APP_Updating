package com.example.custombottomnavigation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.etebarian.meowbottomnavigation.MeowBottomNavigation;
import com.example.custombottomnavigation.fragments.CompasFragment;
import com.example.custombottomnavigation.fragments.KalimaFragment;
import com.example.custombottomnavigation.fragments.NamazFragment;
import com.example.custombottomnavigation.fragments.TasbeehFragment;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    MeowBottomNavigation bottomNavigation;
    FrameLayout frameLayout;

    DrawerLayout drawerLayout;
    NavigationView navigationView;
   public static Toolbar toolbar;
   public static String area="dhaka",storeArea,txt;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigation=findViewById(R.id.bottom_navigation);


        bottomNavigation.add(new MeowBottomNavigation.Model(1,R.drawable.ic_homef));
        bottomNavigation.add(new MeowBottomNavigation.Model(2,R.drawable.ic_tasbeeh));
        bottomNavigation.add(new MeowBottomNavigation.Model(3,R.drawable.calender));
        bottomNavigation.add(new MeowBottomNavigation.Model(4,R.drawable.ic_baseline_notifications_24));

        getSupportActionBar().hide();
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);

        toolbar = findViewById(R.id.toolbar);


        //change statusbar color
        if (Build.VERSION.SDK_INT >= 21) {
            Window window = this.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(this.getResources().getColor(R.color.colorPrimaryDark));
        }






        bottomNavigation.setOnShowListener(new MeowBottomNavigation.ShowListener() {
            @Override
            public void onShowItem(MeowBottomNavigation.Model item) {
                Fragment fragment=null;
                switch (item.getId()){
                    case 1:
                        fragment=new HomeFragment();

                        break;
                    case 2:
                        fragment=new TasbeehFragment();



                        break;
                    case 3:

                        fragment =new NamazFragment();

                        break;

                    case 4:
                        fragment=new CompasFragment();
                        break;
                }


                loadFragment(fragment);
            }
        });
        // set notification count
        bottomNavigation.setCount(4,"11");

        // set home fragment initially selected/ firstly selected
        bottomNavigation.show(1, true);

        bottomNavigation.setOnClickMenuListener(new MeowBottomNavigation.ClickListener() {
            @Override
            public void onClickItem(MeowBottomNavigation.Model item) {
//                Toast.makeText(getApplicationContext(), "you clicked "+item.getId(), Toast.LENGTH_SHORT).show();
                if (item.getId()==3)
                {



                }
            }
        });
        bottomNavigation.setOnReselectListener(new MeowBottomNavigation.ReselectListener() {
            @Override
            public void onReselectItem(MeowBottomNavigation.Model item) {
               

            }
        });


        ActionBarDrawerToggle toggle = new
                ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close){
                    /** Called when a drawer has settled in a completely closed state. */

                };



        toggle.getDrawerArrowDrawable().setColor(getResources().getColor(R.color.tgl));
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();


        //change toogle icon

        toggle.setDrawerIndicatorEnabled(false);

        // mDrawerToggle.setHomeAsUpIndicator(R.drawable.menu_icon);
        toolbar.setNavigationIcon(R.drawable.menu);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(Gravity.LEFT);
            }
        });


        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.locationId) {

                    //get loaction from spinner

                    getLocation();
                }
                if (item.getItemId()==R.id.shareId)
                {

                    shareApp();
                }
                if (item.getItemId()==R.id.compass_id)
                {
                    drawerLayout.closeDrawers();
                    CompasFragment fragment = new CompasFragment();
                    getSupportFragmentManager().beginTransaction().replace(R.id.frame_layoutId,fragment).commit();
                }
                if (item.getItemId()==R.id.fbBk)
                {
                  sendFeedBack();
                }

                return false;
            }




            //location from spinner
            private void getLocation() {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                ViewGroup viewGroup = findViewById(android.R.id.content);
                View dialogView = LayoutInflater.from(MainActivity.this).inflate(R.layout.location_spinner, viewGroup, false);
                builder.setView(dialogView);
                final AlertDialog alertDialog = builder.create();
                alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                drawerLayout.closeDrawers();
                alertDialog.show();

                // Spinner element
                Spinner spinnerr = (Spinner) alertDialog.findViewById(R.id.spinner);
                spinnerr.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                        String item = parentView.getItemAtPosition(position).toString();

                        // Showing selected spinner item
                        Toast.makeText(parentView.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();
                        area=item;


                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parentView) {
                        // your code here
                    }

                });
                //get stored value from shared preferences
                List<String> categories = new ArrayList<String>();


                SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
                String name = preferences.getString("Name", "dhaka");

                area=name;
                if(!name.equalsIgnoreCase(""))
                {
                    categories.add(name);
                    categories.add("dhaka");
                    categories.add("mymensingh");
                    categories.add("rajshahi");
                    categories.add("rangpur");
                    categories.add("sylhet");
                    categories.add("barisal");
                    categories.add("chittagong");
                    categories.add("khulna");
                    ;  /* Edit the value here*/
                }


                // Creating adapter for spinner
                ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_spinner_item, categories);

                // Drop down layout style - list view with radio button
                dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

                // attaching data adapter to spinner
                spinnerr.setAdapter(dataAdapter);


                Button button=alertDialog.findViewById(R.id.selectBtn);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        storeSpinnerValueinSharedPreferences(area);
                        alertDialog.cancel();
                        //reload full activity
                        finish();
                        overridePendingTransition(0, 0);
                        startActivity(getIntent());
                        overridePendingTransition(0, 0);

                    }
                });



            }

            //SEND FEEDBACK BY MAIL
            private void sendFeedBack() {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                ViewGroup viewGroup = findViewById(android.R.id.content);
                View dialogView = LayoutInflater.from(MainActivity.this).inflate(R.layout.feed_back, viewGroup, false);
                builder.setView(dialogView);
                final AlertDialog alertDialog = builder.create();

                drawerLayout.closeDrawers();
                alertDialog.show();


                EditText msg=alertDialog.findViewById(R.id.feedbkId);
                Button send=alertDialog.findViewById(R.id.feedBtn);

                send.setOnClickListener(new View.OnClickListener() {


                    @Override
                    public void onClick(View v) {

                        alertDialog.cancel();
                        Intent email = new Intent(Intent.ACTION_SEND);
                        email.putExtra(Intent.EXTRA_EMAIL, new String[]{ "rafidtawhid@gmail.com"});
                        email.putExtra(Intent.EXTRA_SUBJECT, "User");
                        email.putExtra(Intent.EXTRA_TEXT, msg.getText().toString());

                        //need this to prompts email client only
                        email.setType("message/rfc822");

                        startActivity(Intent.createChooser(email, "Choose an Email client :"));
                    }
                });

            }



        });

        navigationView.bringToFront();
    }




    //share to social media
    private void shareApp() {

        Intent intent=new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        String shareBody="Download This App from : https://www.facebook.com/&hl=en";
        String name="My App Name";
        intent.putExtra(Intent.EXTRA_SUBJECT,name);
        intent.putExtra(Intent.EXTRA_TEXT,shareBody);
        startActivity(Intent.createChooser(intent,"Share Using"));

    }


    private void loadFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layoutId,fragment).commit();

    }



    private void getAreaValueFromSharedPreferences() {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        String name = preferences.getString("Name", "");
        if(!name.equalsIgnoreCase(""))
        {
            storeArea = name;
            /* Edit the value here*/
            txt=name+", Bangladesh";
        }
    }

    private void storeSpinnerValueinSharedPreferences(String myArea) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("Name",myArea);
        editor.apply();
    }





}