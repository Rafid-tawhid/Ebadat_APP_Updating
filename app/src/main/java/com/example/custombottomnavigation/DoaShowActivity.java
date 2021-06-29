package com.example.custombottomnavigation;

import androidx.appcompat.app.AppCompatActivity;

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
import com.example.custombottomnavigation.models.DuaItems;

public class DoaShowActivity extends AppCompatActivity {

    TextView name,title,arbi,bangla,meaing;
    ImageView doa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doa_show);

        name=findViewById(R.id.nameDoa);
        title=findViewById(R.id.nameDoa2);
        bangla=findViewById(R.id.doaBangla);
        meaing=findViewById(R.id.doaMeaning);
        doa=findViewById(R.id.doaImg);



        name.setText(""+DuaListAdapter.pos.getTitle());
        title.setText(""+DuaListAdapter.pos.getTitle());
        bangla.setText(""+getResources().getString(DuaListAdapter.pos.getBangla()));
        meaing.setText(""+getResources().getString(DuaListAdapter.pos.getArbi()));
        doa.setImageResource(DuaListAdapter.pos.getDua());




    }

}