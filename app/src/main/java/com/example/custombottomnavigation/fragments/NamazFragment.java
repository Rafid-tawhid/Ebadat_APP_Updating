package com.example.custombottomnavigation.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.custombottomnavigation.HomeFragment;
import com.example.custombottomnavigation.MainActivity;
import com.example.custombottomnavigation.R;
import com.example.custombottomnavigation.namaz_fragments.NamazFragmentItem1_Oju;


public class NamazFragment extends Fragment {


    ImageView backBtn;
    LinearLayout oju;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_namaj, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        backBtn=view.findViewById(R.id.bck_btn);
        oju=view.findViewById(R.id.singel_item1);


        //HIDE TOOLBAR
        MainActivity.toolbar.setVisibility(View.GONE);





        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //go back to previous fragment
                HomeFragment someFragment = new HomeFragment();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.namaz_main_frame_bg, someFragment, "Go back to home");
                transaction.addToBackStack("Go to home");
                transaction.commit();
            }
        });

        oju.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NamazFragmentItem1_Oju someFragment = new NamazFragmentItem1_Oju();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.namaz_main_frame_bg, someFragment, "Go to item1");
                transaction.commit();
            }
        });

    }





}