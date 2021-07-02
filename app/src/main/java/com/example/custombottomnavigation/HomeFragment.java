package com.example.custombottomnavigation;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

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


import java.text.ParseException;
import java.text.SimpleDateFormat;
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

    LinearLayout hadis,kalima,ramadan,dua,jakat,namaj,koran,name99;
    TextView fajar,johur,asar,magrib,esha;
    private Context context;
    ApiInterface apiInterface;

    private String myArea;
    long fj;
    long jh;
    long asr;
    long mgb;
    long esa;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);



    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onViewCreated( View view,Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        hadis =view.findViewById(R.id.hadisId);
        kalima=view.findViewById(R.id.kalima_main_btn);
        ramadan=view.findViewById(R.id.ramadan_id);
        dua=view.findViewById(R.id.dua_btn);
        koran=view.findViewById(R.id.koran_id);
        jakat=view.findViewById(R.id.jakat_btn);
        namaj=view.findViewById(R.id.namaj_btn);
        name99=view.findViewById(R.id.allahs_name);
        fajar=view.findViewById(R.id.fajartimeId);
        johur=view.findViewById(R.id.johor);
        asar=view.findViewById(R.id.asorId);
        magrib=view.findViewById(R.id.magribId);
        esha=view.findViewById(R.id.esaId);











        //api for namaj time
        //api data fetch
        apiInterface = RetrofitClient.getRetrofit("http://api.aladhan.com/").create(ApiInterface.class);
//        getAllProductInfo();
        getAllInfo();


        //namaz time show

        findClosetNamjTime();




        //SHOW TOOLBAR
        MainActivity.toolbar.setVisibility(View.VISIBLE);

        namaj .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NamazFragment fragment = new NamazFragment();
                FragmentManager fragmentManager = getFragmentManager();

                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.main_frame_bg, fragment);
                fragmentTransaction.commit();



            }
        });
        jakat .setOnClickListener(new View.OnClickListener() {
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



    private void findClosetNamjTime() {
//        Long[] numbers = new Long[50];
//        numbers[0] = fj;
//        numbers[1] = jh;
//        numbers[2] = asr;
//        numbers[3] = mgb;
//        numbers[4] = esa;


//        long time = (long) (System.currentTimeMillis());
//
//
//
//        long myNumber =time ;
//        long distance = Math.abs(numbers[0] - myNumber);
//        int idx = 0;
//        for(int c = 1; c < numbers.length; c++){
//            long cdistance = Math.abs(numbers[c] - myNumber);
//            if(cdistance < distance){
//                idx = c;
//                distance = cdistance;
//            }
//        }
//        long theNumber = numbers[0];




    }


    // Get all select info from api
    private void getAllInfo(){

        //get date and month from system
        Calendar calendar = Calendar.getInstance(TimeZone.getDefault());

        int currentYear = calendar.get(Calendar.YEAR);
        int currentMonth = calendar.get(Calendar.MONTH) + 1;
        int currentDay = calendar.get(Calendar.DAY_OF_MONTH);


        //get location from spinner
        myArea=MainActivity.area;

      Log.e("aa",myArea);
      Log.e("bb", String.valueOf(currentDay));




        apiInterface.getAllInformation(myArea,currentMonth,currentYear).enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {
                if (response.code()==200){

                    try {

//                        Integer a=response.body().getData().get(currentDay).getDate().getHijri().getMonth().getNumber();
//                        String b=response.body().getData().get(currentDay).getDate().getHijri().getMonth().getEn();
//
//                        Log.e("c", String.valueOf(a+b));
                        // get time remove last character
                        String fazarTime=response.body().getData().get(currentDay).getTimings().getFajr().
                                substring(0, response.body().getData().get(currentDay).getTimings().getFajr().length() - 6);

                        SimpleDateFormat _24HourSDF = new SimpleDateFormat("HH:mm");
                        SimpleDateFormat _12HourSDF = new SimpleDateFormat("hh:mm a");
                        // string to time
                        Date _24HourDt = _24HourSDF.parse(fazarTime);
                        fajar.setText(_12HourSDF.format(_24HourDt));
                        fj=_24HourDt.getTime();
                        Log.e("cc", String.valueOf(fj));


                    } catch (ParseException e) {
                        e.printStackTrace();
                    }


                    try {
                        // get time remove last character
                        String juhorTime=response.body().getData().get(currentDay).getTimings().getDhuhr().
                                substring(0, response.body().getData().get(currentDay).getTimings().getDhuhr().length() - 6);

                        SimpleDateFormat _24HourSDF = new SimpleDateFormat("HH:mm");
                        SimpleDateFormat _12HourSDF = new SimpleDateFormat("hh:mm a");
                        // string to time
                        Date _24HourDt = _24HourSDF.parse(juhorTime);
                        johur.setText(_12HourSDF.format(_24HourDt));
                        jh=_24HourDt.getTime();

                    } catch (ParseException e) {
                        e.printStackTrace();
                    }




                    try {
                        // get time remove last character
                        String asoreTime=response.body().getData().get(currentDay).getTimings().getAsr().
                                substring(0, response.body().getData().get(currentDay).getTimings().getAsr().length() - 6);

                        SimpleDateFormat _24HourSDF = new SimpleDateFormat("HH:mm");
                        SimpleDateFormat _12HourSDF = new SimpleDateFormat("hh:mm a");
                        // string to time
                        Date _24HourDt = _24HourSDF.parse(asoreTime);
                        asar.setText(_12HourSDF.format(_24HourDt));
                        asr=_24HourDt.getTime();



                    } catch (ParseException e) {
                        e.printStackTrace();
                    }





                    try {
                        // get time remove last character
                        String magribTime=response.body().getData().get(currentDay).getTimings().getMaghrib().substring(0, response.body().getData().get(currentDay).getTimings().getMaghrib().length() - 6);

                        SimpleDateFormat _24HourSDF = new SimpleDateFormat("HH:mm");
                        SimpleDateFormat _12HourSDF = new SimpleDateFormat("hh:mm a");
                        // string to time
                        Date _24HourDt = _24HourSDF.parse(magribTime);
                        magrib.setText(_12HourSDF.format(_24HourDt));
                        mgb=_24HourDt.getTime();

                    } catch (ParseException e) {
                        e.printStackTrace();
                    }


                    try {
                        // get time remove last character
                        String eshaTime=response.body().getData().get(currentDay).getTimings().getIsha().substring(0, response.body().getData().get(currentDay).getTimings().getIsha().length() - 6);

                        SimpleDateFormat _24HourSDF = new SimpleDateFormat("HH:mm");
                        SimpleDateFormat _12HourSDF = new SimpleDateFormat("hh:mm a");
                        // string to time
                        Date _24HourDt = _24HourSDF.parse(eshaTime);
                        esha.setText(_12HourSDF.format(_24HourDt));
                        esa=_24HourDt.getTime();

                    } catch (ParseException e) {
                        e.printStackTrace();
                    }






                }else {
                    Toast.makeText(getView().getContext(), "un Success", Toast.LENGTH_SHORT).show();
                    Log.e("err","un Success");

                }

            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {
                Log.e("err","on failure");

            }
        });




    }
}