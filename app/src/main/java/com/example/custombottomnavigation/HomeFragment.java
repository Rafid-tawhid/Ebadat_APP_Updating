package com.example.custombottomnavigation;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.preference.PreferenceManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.custombottomnavigation.Retrofit.ApiInterface;
import com.example.custombottomnavigation.Retrofit.RetrofitClient;
import com.example.custombottomnavigation.example.Example;
import com.example.custombottomnavigation.fragments.DuaListFragment;
import com.example.custombottomnavigation.fragments.KoranFragment;
import com.example.custombottomnavigation.fragments.NamazFragment;
import com.example.custombottomnavigation.fragments.ZakatFragment;
import com.example.custombottomnavigation.fragments.KalimaFragment;
import com.example.custombottomnavigation.fragments.RamadanFragment;


import java.lang.reflect.Array;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class HomeFragment extends Fragment {

    LinearLayout hadis, kalima, ramadan, dua, jakat, namaj, koran, name99;
    TextView fajar, johur, asar, magrib, esha, currentNamaj;
    TextView demo;
    private Context context;
    ApiInterface apiInterface;


    public String myArea;
    long fj;
    long jh;
    long asr;
    long mgb;
    long esa;
    long crnt;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);


    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        hadis = view.findViewById(R.id.hadisId);
        kalima = view.findViewById(R.id.kalima_main_btn);
        ramadan = view.findViewById(R.id.ramadan_id);
        dua = view.findViewById(R.id.dua_btn);
        koran = view.findViewById(R.id.koran_id);
        jakat = view.findViewById(R.id.jakat_btn);
        namaj = view.findViewById(R.id.namaj_btn);
        name99 = view.findViewById(R.id.allahs_name);
        fajar = view.findViewById(R.id.fajartimeId);
        johur = view.findViewById(R.id.johor);
        asar = view.findViewById(R.id.asorId);
        magrib = view.findViewById(R.id.magribId);
        esha = view.findViewById(R.id.esaId);
        currentNamaj = view.findViewById(R.id.namaj);
        demo = view.findViewById(R.id.a1);


        crnt = System.currentTimeMillis();


        //api for namaj time
        //api data fetch
        apiInterface = RetrofitClient.getRetrofit("http://api.aladhan.com/").create(ApiInterface.class);
//        getAllProductInfo();

        getAllInfo();


        //namaz time show


//            findClosetNamjTime();



        setNamazTime();


        //SHOW TOOLBAR
        MainActivity.toolbar.setVisibility(View.VISIBLE);

        namaj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NamazFragment fragment = new NamazFragment();
                FragmentManager fragmentManager = getFragmentManager();

                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.main_frame_bg, fragment);
                fragmentTransaction.commit();


            }
        });
        jakat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ZakatFragment fragment = new ZakatFragment();
                FragmentManager fragmentManager = getFragmentManager();

                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.main_frame_bg, fragment);
                fragmentTransaction.commit();

            }
        });
        kalima.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                KalimaFragment fragment = new KalimaFragment();
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.main_frame_bg, fragment);
                fragmentTransaction.commit();


            }
        });
        ramadan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RamadanFragment fragment = new RamadanFragment();
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.main_frame_bg, fragment);
                fragmentTransaction.commit();


            }
        });
        dua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DuaListFragment fragment = new DuaListFragment();
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.main_frame_bg, fragment);
                fragmentTransaction.commit();


            }
        });
        koran.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                KoranFragment fragment = new KoranFragment();
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.main_frame_bg, fragment);
                fragmentTransaction.commit();


            }
        });
        name99.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SortFragment fragment = new SortFragment();
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.main_frame_bg, fragment);
                fragmentTransaction.commit();


            }
        });
    }

    private void setNamazTime() {
//        if (crnt>crnt+10000&&crnt<crnt+20000)
//        {
//            Log.e("as","Fajar");
//        }
//        if (crnt>crnt+20000&&crnt<crnt+30000)
//        {
//            Log.e("as","Duhor");
//        }
    }


//    private void findClosetNamjTime()  {
//        int temp, size;
//
//         int a= (int) (fj-crnt);
//         int b= (int) (jh-crnt);
//         int c= (int) (asr-crnt);
//         int d= (int) (mgb-crnt);
//         int e= (int) (esa-crnt);
//        int array[] = {a, b, c, d, e};
//        size = array.length;
//        for(int i = 0; i<size; i++ ){
//            for(int j = i+1; j<size; j++){
//                if(array[i]>array[j]){
//                    temp = array[i];
//                    array[i] = array[j];
//                    array[j] = temp;
//                }
//            }
//        }
//        Log.e("ss","Third smallest element is:: "+array[0]);
//
//
////
////        }
//
//       if (array[size-1]==b){
//
//            Log.e("qq"," b"+b);
//        }
//        else if(array[size-1]==c){
//
//            Log.e("qq"," c"+c);
//        }
//        else if (array[size-1]==d){
//
//            Log.e("qq"," d"+d);
//        }
//        else if (array[size-1]==e){
//
//            Log.e("qq"," e"+e);
//        }
//        if (array[size-1]==a){
//
//            Log.e("qq"," a"+a);
//        }
//        else {
//            Log.e("qq"," ajira");
//        }
//
//
//
//
//
//
//
//    }


    // Get all select info from api
    private void getAllInfo() {

        //get date and month from system
        Calendar calendar = Calendar.getInstance(TimeZone.getDefault());

        int currentYear = calendar.get(Calendar.YEAR);
        int currentMonth = calendar.get(Calendar.MONTH) + 1;
        int currentDay = calendar.get(Calendar.DAY_OF_MONTH);


        //get location not from spinner from shared preferrence which stored by spinner
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
        String name = preferences.getString("Name", "");
        myArea = name;
//        myArea=MainActivity.area;


        apiInterface.getAllInformation(myArea, currentMonth, currentYear).enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {
                if (response.code() == 200) {
//

                    try {

//
                        // get time remove last character
                        String fazarTime = response.body().getData().get(currentDay).getTimings().getFajr().
                                substring(0, response.body().getData().get(currentDay).getTimings().getFajr().length() - 6);

                        SimpleDateFormat _24HourSDF = new SimpleDateFormat("HH:mm");
                        SimpleDateFormat _12HourSDF = new SimpleDateFormat("hh:mm a");
                        // string to time
                        Date _24HourDt = _24HourSDF.parse(fazarTime);
                        fajar.setText(_12HourSDF.format(_24HourDt));
                        fj = _24HourDt.getTime();


                    } catch (ParseException e) {
                        e.printStackTrace();
                    }


                    try {
                        // get time remove last character
                        String juhorTime = response.body().getData().get(currentDay).getTimings().getDhuhr().
                                substring(0, response.body().getData().get(currentDay).getTimings().getDhuhr().length() - 6);

                        SimpleDateFormat _24HourSDF = new SimpleDateFormat("HH:mm");
                        SimpleDateFormat _12HourSDF = new SimpleDateFormat("hh:mm a");
                        // string to time
                        Date _24HourDt = _24HourSDF.parse(juhorTime);
                        johur.setText(_12HourSDF.format(_24HourDt));
                        jh = _24HourDt.getTime();


                    } catch (ParseException e) {
                        e.printStackTrace();
                    }


                    try {
                        // get time remove last character
                        String asoreTime = response.body().getData().get(currentDay).getTimings().getAsr().
                                substring(0, response.body().getData().get(currentDay).getTimings().getAsr().length() - 6);

                        SimpleDateFormat _24HourSDF = new SimpleDateFormat("HH:mm");
                        SimpleDateFormat _12HourSDF = new SimpleDateFormat("hh:mm a");
                        // string to time
                        Date _24HourDt = _24HourSDF.parse(asoreTime);
                        asar.setText(_12HourSDF.format(_24HourDt));
                        asr = _24HourDt.getTime();


                    } catch (ParseException e) {
                        e.printStackTrace();
                    }


                    try {
                        // get time remove last character
                        String magribTime = response.body().getData().get(currentDay).getTimings().getMaghrib().substring(0, response.body().getData().get(currentDay).getTimings().getMaghrib().length() - 6);

                        SimpleDateFormat _24HourSDF = new SimpleDateFormat("HH:mm");
                        SimpleDateFormat _12HourSDF = new SimpleDateFormat("hh:mm a");
                        // string to time
                        Date _24HourDt = _24HourSDF.parse(magribTime);
                        magrib.setText(_12HourSDF.format(_24HourDt));
                        mgb = _24HourDt.getTime();

                    } catch (ParseException e) {
                        e.printStackTrace();
                    }


                    try {
                        // get time remove last character
                        String eshaTime = response.body().getData().get(currentDay).getTimings().getIsha().substring(0, response.body().getData().get(currentDay).getTimings().getIsha().length() - 6);

                        SimpleDateFormat _24HourSDF = new SimpleDateFormat("HH:mm");
                        SimpleDateFormat _12HourSDF = new SimpleDateFormat("hh:mm a");
                        // string to time
                        Date _24HourDt = _24HourSDF.parse(eshaTime);
                        esha.setText(_12HourSDF.format(_24HourDt));
                        esa = _24HourDt.getTime();

                    } catch (ParseException e) {
                        e.printStackTrace();
                    }


                } else {
                    Toast.makeText(getView().getContext(), "un Success", Toast.LENGTH_SHORT).show();
                    Log.e("err", "un Success");

                }

            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {
                Log.e("err", "on failure");

            }
        });


    }



}