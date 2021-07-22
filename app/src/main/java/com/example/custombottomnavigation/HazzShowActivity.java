package com.example.custombottomnavigation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.custombottomnavigation.adapter.DuaListAdapter;
import com.example.custombottomnavigation.adapter.HazzListAdapter;

public class HazzShowActivity extends AppCompatActivity {
    TextView name,title,bangla,meaing;
    TextView doa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hazz_show);
        //blur my background
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_BLUR_BEHIND,
                WindowManager.LayoutParams.FLAG_BLUR_BEHIND);

        //hide action bar

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        title=findViewById(R.id.nameDoa2);
        bangla=findViewById(R.id.doaMeaning);

        title.setSelected(true);



        title.setText(""+ HazzListAdapter.post.getTitle());
        bangla.setText(""+HazzListAdapter.post.getBangla());


        ImageView backBtn = findViewById(R.id.cancelBtn);
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