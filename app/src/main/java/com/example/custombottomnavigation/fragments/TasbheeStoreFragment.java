package com.example.custombottomnavigation.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.custombottomnavigation.DatabaseClass;
import com.example.custombottomnavigation.EntityClass.UserModel;
import com.example.custombottomnavigation.HomeFragment;
import com.example.custombottomnavigation.R;
import com.example.custombottomnavigation.adapter.UserAdapter;

import java.util.ArrayList;
import java.util.List;


public class TasbheeStoreFragment extends Fragment {

    RecyclerView recyclerView;
    ImageView back;
    private List<UserModel> list;

    UserAdapter.DeleteItemListener listener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tasbhee_store, container, false);
    }

    @Override
    public void onViewCreated( View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView=view.findViewById(R.id.recyclerview_tasbhe);
        back=view.findViewById(R.id.bck_btn);



        list=new ArrayList<>();
        list=DatabaseClass.getDatabase(getContext()).getData().getAllData();
        recyclerView.setAdapter(new UserAdapter(getActivity(), list, new UserAdapter.DeleteItemListener() {
            @Override
            public void onItemDelete(int position, int id) {

                DatabaseClass.getDatabase(getContext()).getData().deleteData(list.get(position));

                //hudai fawl jinish
                reload();


            }

            private void reload() {
                list=new ArrayList<>();
                list=DatabaseClass.getDatabase(getContext()).getData().getAllData();
                recyclerView.setAdapter(new UserAdapter(getActivity(), list, new UserAdapter.DeleteItemListener() {
                    @Override
                    public void onItemDelete(int position, int id) {

                        DatabaseClass.getDatabase(getContext()).getData().deleteData(list.get(position));





                    }
                }));
            }
        }));



        //BACK
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TasbeehFragment fragment = new TasbeehFragment();
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.tasbhee_bg, fragment);
                fragmentTransaction.commit();
            }
        });
    }



}