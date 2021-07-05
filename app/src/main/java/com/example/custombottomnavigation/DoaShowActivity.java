package com.example.custombottomnavigation;

import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.custombottomnavigation.adapter.DuaListAdapter;
import com.example.custombottomnavigation.fragments.DuaListFragment;
import com.example.custombottomnavigation.models.DuaItems;

public class DoaShowActivity extends AppCompatActivity {

    TextView name,title,bangla,meaing;
    TextView doa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doa_show);


        //blur my background
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_BLUR_BEHIND,
                WindowManager.LayoutParams.FLAG_BLUR_BEHIND);

        //hide action bar

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

//        name=findViewById(R.id.nameDoa);
        title=findViewById(R.id.nameDoa2);
        bangla=findViewById(R.id.doaBangla);
        meaing=findViewById(R.id.doaMeaning);
        doa=findViewById(R.id.doaImg);



//        name.setText(""+DuaListAdapter.pos.getTitle());
        title.setText(""+DuaListAdapter.pos.getTitle());
        bangla.setText(""+DuaListAdapter.pos.getBangla());
        meaing.setText(""+DuaListAdapter.pos.getOrtho());
        doa.setText(""+DuaListAdapter.pos.getArbi());




        //back btn
        ImageView backBtn = findViewById(R.id.cancelBtn);
        ImageView backBtn2 = findViewById(R.id.bck_btn2);

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //go back to previous fragment
                finish();
                DoaShowActivity.this.getSupportFragmentManager().beginTransaction()
                        .add(R.id.doa_bg2, new DuaListFragment(), "createPost").addToBackStack(null).commit();

            }
        });
//        backBtn2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //go back to previous fragment
//                finish();
//                DoaShowActivity.this.getSupportFragmentManager().beginTransaction()
//                        .add(R.id.doa_bg2, new DuaListFragment(), "createPost").addToBackStack(null).commit();
//
//            }
//        });


    }


    }

