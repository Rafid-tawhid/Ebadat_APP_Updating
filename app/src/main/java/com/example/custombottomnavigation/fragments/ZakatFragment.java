package com.example.custombottomnavigation.fragments;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.custombottomnavigation.HomeFragment;
import com.example.custombottomnavigation.MainActivity;
import com.example.custombottomnavigation.R;
import com.example.custombottomnavigation.adapter.ListViewCustomAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;


public class ZakatFragment extends Fragment {

    ImageView back;
    LinearLayout item1,item2,item3,item4,item5,item6,item7,item8;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_zakat, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //HIDE TOOLBAR
        MainActivity.toolbar.setVisibility(View.GONE);

        item1=view.findViewById(R.id.jakat_item1);
        item3=view.findViewById(R.id.jakat3);
        item4=view.findViewById(R.id.jakat4);
        item5=view.findViewById(R.id.jakat5);
        item6=view.findViewById(R.id.jakat6);
        item7=view.findViewById(R.id.jakat7);
        item8=view.findViewById(R.id.jakat8);

        item1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                showDialoge(R.layout.jakat_item1);


            }
        });
        item3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            showDialoge(R.layout.jakat_item3);

            }
        });
        item4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                showDialoge(R.layout.jakat_item4);

            }
        });
        item5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                showDialoge(R.layout.jakat_item5);

            }
        });
        item6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                showDialoge(R.layout.jakat_item6);

            }
        });
        item7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                showDialoge(R.layout.jakat_item7);

            }
        });
        item8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                showDialoge(R.layout.jakat_item8);

            }
        });







        back=view.findViewById(R.id.bck_btn);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HomeFragment fragment = new HomeFragment();
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.zakat_bg, fragment);
                fragmentTransaction.commit();
            }
        });

    }

    private void showDialoge(int layout) {
        Dialog dialog = new Dialog(getActivity());
        dialog.setCancelable(true);

        View view  = getActivity().getLayoutInflater().inflate(layout, null);
        dialog.setContentView(view);
        ImageView cancel=dialog.findViewById(R.id.cancelBtn);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.cancel();
            }
        });



        dialog.show();
    }


}