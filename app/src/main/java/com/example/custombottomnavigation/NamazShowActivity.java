package com.example.custombottomnavigation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.custombottomnavigation.adapter.DuaListAdapter;
import com.example.custombottomnavigation.adapter.NamazListAdapter;

public class NamazShowActivity extends AppCompatActivity {
    TextView name,title,bangla,meaing;
    TextView doa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_namaz_show);
        //hide action bar

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        title=findViewById(R.id.nameDoa2);
        bangla=findViewById(R.id.doaBangla);
        meaing=findViewById(R.id.doaMeaning);
        doa=findViewById(R.id.doaImg);



//        name.setText(""+DuaListAdapter.pos.getTitle());
        title.setText(""+ NamazListAdapter.pos.getTitle());
        bangla.setText(""+NamazListAdapter.pos.getBangla());
        meaing.setText(""+NamazListAdapter.pos.getOrtho());
        doa.setText(""+NamazListAdapter.pos.getArbi());




        //back btn
        ImageView backBtn = findViewById(R.id.cancelBtn);
        ImageView backBtn2 = findViewById(R.id.bck_btn2);

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //go back to previous fragment
                finish();
//                DoaShowActivity.this.getSupportFragmentManager().beginTransaction()
//                        .add(R.id.doa_bg2, new DuaListFragment(), "createPost").addToBackStack(null).commit();

            }
        });

    }
}