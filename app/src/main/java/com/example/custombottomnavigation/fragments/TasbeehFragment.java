package com.example.custombottomnavigation.fragments;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.custombottomnavigation.DatabaseClass;
import com.example.custombottomnavigation.EntityClass.UserModel;
import com.example.custombottomnavigation.HomeFragment;
import com.example.custombottomnavigation.MainActivity;
import com.example.custombottomnavigation.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class TasbeehFragment extends Fragment {

    Button tap_count;
    ImageView reset,store,show_btn,back;
    TextView count_show;
    private Spinner spinners;
    public String JikirName;

    int count=0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tasbeeh, container, false);
    }

    @Override
    public void onViewCreated( View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //HIDE TOOLBAR
        MainActivity.toolbar.setVisibility(View.GONE);

        tap_count=view.findViewById(R.id.count_id);
        count_show=view.findViewById(R.id.count_show_id);
        show_btn=view.findViewById(R.id.list_show_id);
        reset=view.findViewById(R.id.reset_btn);
        store=view.findViewById(R.id.store_count_id);
        back=view.findViewById(R.id.bck_btn);



        //spiner
        spinners = (Spinner) view.findViewById(R.id.spinner2);




        getSpinnerValue();


        tap_count.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count++;
                count_show.setText(""+count);

            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count=0;
                count_show.setText("00");
            }
        });

        store.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Date c = Calendar.getInstance().getTime();
                SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy", Locale.getDefault());
                String formattedDate = df.format(c);
                String total=JikirName;
                String detailss="Todays Count "+total+ count_show.getText().toString() +" in "+formattedDate+" at "+c;
//                Toast.makeText(getContext(), "Todays Count "+total +" in "+formattedDate+" at "+c, Toast.LENGTH_SHORT).show();


                if (total!=null)
                {
                    UserModel model=new UserModel();
                    model.setName(total);
                    model.setDetails(detailss);

                    DatabaseClass.getDatabase(getContext()).getData().insertAllData(model);
                    Toast.makeText(getContext(), "Saved Succesfully", Toast.LENGTH_SHORT).show();



                }
            }
        });

        show_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TasbheeStoreFragment fragment = new TasbheeStoreFragment();
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.tasbhee_bg, fragment);
                fragmentTransaction.commit();


            }
        });




        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HomeFragment fragment = new HomeFragment();
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.tasbhee_bg, fragment);
                fragmentTransaction.commit();
            }
        });
    }

    private void getSpinnerValue() {

        // Spinner Drop down elements

        spinners.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @SuppressLint({"ResourceAsColor", "Range"})
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                String item = parentView.getItemAtPosition(position).toString();

                // Showing selected spinner item color change
                ((TextView) parentView.getChildAt(0)).setTextColor(Color.parseColor("#F8A349"));
                ((TextView) parentView.getChildAt(0)).setTextSize(18);

                Toast.makeText(parentView.getContext(), "Selected : " + item, Toast.LENGTH_LONG).show();

                JikirName=item;




            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
                JikirName="La Ilaha";
            }

        });
        List<String> categories = new ArrayList<String>();
        categories.add("La Ilaha ");
        categories.add("Allahu Akbar");
        categories.add("Subahan Allah");
        categories.add("Alhamdulillah");
        categories.add("Astagfirullah");


        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, categories);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinners.setAdapter(dataAdapter);

    }
}