package com.example.custombottomnavigation.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.custombottomnavigation.HomeFragment;
import com.example.custombottomnavigation.MainActivity;
import com.example.custombottomnavigation.R;


public class SortFragment extends Fragment {


    ImageView backBtn;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sort, container, false);
    }

    @Override
    public void onViewCreated( View view,Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        MainActivity.toolbar.setVisibility(View.GONE);


        backBtn=view.findViewById(R.id.bck_btn);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //go back to previous fragment
                HomeFragment someFragment = new HomeFragment();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.sort_bg, someFragment, "Go back to home");
                transaction.addToBackStack("Go to home");
                transaction.commit();
            }
        });
    }
}