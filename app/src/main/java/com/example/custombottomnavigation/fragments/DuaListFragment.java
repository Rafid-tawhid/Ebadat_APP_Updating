package com.example.custombottomnavigation.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.LinearLayout;

import com.example.custombottomnavigation.MainActivity;
import com.example.custombottomnavigation.R;
import com.example.custombottomnavigation.adapter.DuaListAdapter;
import com.example.custombottomnavigation.models.DuaItems;

import java.util.ArrayList;
import java.util.List;


public class DuaListFragment extends Fragment {

    RecyclerView recyclerView;
    String title[]={"jan","fab","march","april","jan","fab","march","april","jan","fab","march","april"};
    LinearLayoutManager layoutManager;
    List<DuaItems> duaItems;
    DuaListAdapter adapter;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        //HIDE TOOLBAR
        MainActivity.toolbar.setVisibility(View.GONE);
        initData();
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dua_list, container, false);
    }

    private void initData() {
        duaItems=new ArrayList<>();
        duaItems.add(new DuaItems("সাইয়্যেদুল ইস্তিগফার",R.drawable.doa_img,R.string.d1,R.string.b1,1));
        duaItems.add(new DuaItems("নিদ্রা যাওয়ার  দোয়া",R.drawable.doa_img,R.string.app_name,R.string.b1,2));
        duaItems.add(new DuaItems("নিদ্রা থেকে জাগ্রত হয়ে কোন দোয়া",R.drawable.doa_img,R.string.d1,R.string.b1,2));
        duaItems.add(new DuaItems("মসজিদে প্রবেশের দোয়া",R.drawable.doa_img,R.string.d1,R.string.b1,2));
        duaItems.add(new DuaItems("মসজিদ থেকে বের হওয়ার দোয়া",R.drawable.doa_img,R.string.d1,R.string.b1,2));
        duaItems.add(new DuaItems("টয়লেটে প্রবেশের দোয়া",R.drawable.doa_img,R.string.d1,R.string.b1,2));
        duaItems.add(new DuaItems("টয়লেট থেকে বের হওয়ার দোয়া",R.drawable.doa_img,R.string.d1,R.string.b1,2));
        duaItems.add(new DuaItems("পিতা-মাতার জন্য  দোয়া",R.drawable.doa_img,R.string.d1,R.string.b1,2));
        duaItems.add(new DuaItems("জ্ঞান বৃদ্ধির জন্য দোয়া",R.drawable.doa_img,R.string.d1,R.string.b1,2));
        duaItems.add(new DuaItems("ঘর থেকে বের হওয়ার সময়  দোয়া ",R.drawable.doa_img,R.string.d1,R.string.b1,2));

    }

    @Override
    public void onViewCreated( View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView=view.findViewById(R.id.dua_recyclervw);
        layoutManager=new LinearLayoutManager(getContext());
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);

        adapter=new DuaListAdapter(duaItems);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

    }
}