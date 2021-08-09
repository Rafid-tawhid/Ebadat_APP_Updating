package com.example.custombottomnavigation;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.wifi.p2p.WifiP2pManager;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.CountDownTimer;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.custombottomnavigation.Retrofit.ApiInterface;
import com.example.custombottomnavigation.Retrofit.RetrofitClient;
import com.example.custombottomnavigation.example.Example;
import com.example.custombottomnavigation.fragments.DuaListFragment;
import com.example.custombottomnavigation.fragments.HazzFragment;
import com.example.custombottomnavigation.fragments.KoranFragment;
import com.example.custombottomnavigation.fragments.NamazFragment;
import com.example.custombottomnavigation.fragments.SortFragment;
import com.example.custombottomnavigation.fragments.ZakatFragment;
import com.example.custombottomnavigation.fragments.KalimaFragment;
import com.example.custombottomnavigation.fragments.RamadanFragment;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import java.util.Timer;
import java.util.concurrent.TimeUnit;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class HomeFragment extends Fragment {

    LinearLayout hadis, kalima, ramadan, dua, jakat, namaj, koran, name99,hazz;
    TextView fajar, johur, asar, magrib, esha, currentNamaj,namajStartTime,namajEndTime;
    public TextView counters;
    TextView demo;
    private Context context;
    ApiInterface apiInterface;
    private CountDownTimer mCountDownTimer;


    public String myArea;
    String fj;
    String jh;
    String asr;
    String mgb;
    String esa;
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
        hazz = view.findViewById(R.id.hazzId);
        name99 = view.findViewById(R.id.allahs_name);
        fajar = view.findViewById(R.id.fajartimeId);
        johur = view.findViewById(R.id.johor);
        asar = view.findViewById(R.id.asorId);
        magrib = view.findViewById(R.id.magribId);
        esha = view.findViewById(R.id.esaId);
        currentNamaj = view.findViewById(R.id.namaj);
        demo = view.findViewById(R.id.a1);
        demo = view.findViewById(R.id.a1);
        namajStartTime = view.findViewById(R.id.startTime);
        namajEndTime = view.findViewById(R.id.endTime);
        counters = view.findViewById(R.id.ctr);



        crnt = System.currentTimeMillis();


        //api for namaj time
        //api data fetch
        apiInterface = RetrofitClient.getRetrofit("http://api.aladhan.com/").create(ApiInterface.class);
//        getAllProductInfo();

        getAllInfo();


        //get Namaz Name after api call after fixed 5 second
        final Handler mTimerHandler = new Handler();
        final Handler threadHandler = new Handler();
        new Thread() {
            @Override
            public void run() {
                threadHandler.postDelayed(new Runnable() {
                    public void run() {
                        setNamajName();
                    }
                }, 3000);
            }
        }.start();





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
        hazz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HazzFragment fragment = new HazzFragment();
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.main_frame_bg, fragment);
                fragmentTransaction.commit();


            }
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void setNamajName() {
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("h:mm a", Locale.ENGLISH);

        String s1,s2,s3,s4,s5,s6,s7,s8,s9,s10;

        if (fj==null||jh==null)
        {
                s1 = "3:00 AM";s2 = "12:01 PM";s3 = "12:01 PM";s4 = "3:30 PM";s5 = "3:30 PM";s6 = "6:30 PM";s7 = "6:30 PM";s8 = "8:00 PM";s9 = "8:00 PM";s10 = "3:00 AM";
        }
        else
        {
          s1 = fj;
          s2 = jh;
          s3 = jh;
          s4 = asr;
          s5 = asr;
          s6= mgb;
          s7= mgb;
          s8= esa;
          s9= esa;
          s10= fj;
        }


        LocalTime time1 = LocalTime.parse(s1, timeFormatter);
        LocalTime time2 = LocalTime.parse(s2, timeFormatter);
        LocalTime time3 = LocalTime.parse(s3, timeFormatter);
        LocalTime time4 = LocalTime.parse(s4, timeFormatter);
        LocalTime time5 = LocalTime.parse(s5, timeFormatter);
        LocalTime time6 = LocalTime.parse(s6, timeFormatter);
        LocalTime time7 = LocalTime.parse(s7, timeFormatter);
        LocalTime time8 = LocalTime.parse(s8, timeFormatter);
        LocalTime time9 = LocalTime.parse(s9, timeFormatter);
        LocalTime time10 = LocalTime.parse(s10, timeFormatter);


        LocalTime localTime=LocalTime.now();


        if (localTime.isAfter(time1) && localTime.isBefore(time2))
        {
            currentNamaj.setText("ফজর");
            namajStartTime.setText(s1);
            namajEndTime.setText(s2);

            Duration duration = Duration.between(localTime, time2);
            countDown(duration.getSeconds()*1000);




        }
//        johor
        else if (localTime.isAfter(time3) && localTime.isBefore(time4))
        {
            currentNamaj.setText("জোহর");
            namajStartTime.setText(s3);
            namajEndTime.setText(s4);
            Duration duration = Duration.between(localTime, time4);
            countDown(duration.getSeconds()*1000);

        }
        else if (localTime.isAfter(time5) && localTime.isBefore(time6))
        {
            currentNamaj.setText("আসর");
            namajStartTime.setText(s5);
            namajEndTime.setText(s6);
            Duration duration = Duration.between(localTime, time6);
            countDown(duration.getSeconds()*1000);
        }
        else if (localTime.isAfter(time7) && localTime.isBefore(time8))
        {
            currentNamaj.setText("মাগরিব");
            namajStartTime.setText(s7);
            namajEndTime.setText(s8);
            Duration duration = Duration.between(localTime, time8);
            countDown(duration.getSeconds()*1000);
        }
        else if (localTime.isAfter(time9) && localTime.isBefore(time10))
        {
            currentNamaj.setText("ইশা");
            namajStartTime.setText(s9);
            namajEndTime.setText(s10);
            Duration duration = Duration.between(localTime, time10);
            countDown(duration.getSeconds()*1000);
        }
        else
        {
            currentNamaj.setText("ফজর+");

        }


    }

    private void countDown(long l) {
        CountDownTimer timer= new CountDownTimer(l, 1000) {
            @Override
            public void onTick(long l) {
            updateTimeRemaining(l);
            }

            @Override
            public void onFinish() {

            }
        }.start();
    }


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
        myArea=MainActivity.area;


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
                        fj = _12HourSDF.format(_24HourDt);




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
                        jh = _12HourSDF.format(_24HourDt);


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
                        asr = _12HourSDF.format(_24HourDt);


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
                        mgb = _12HourSDF.format(_24HourDt);

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
//                        esa = _24HourDt.getTime(); FOR MILISECOND
                        esa = _12HourSDF.format(_24HourDt);

                    } catch (ParseException e) {
                        e.printStackTrace();
                    }



                }
                else {
                    Toast.makeText(getView().getContext(), "un Success", Toast.LENGTH_SHORT).show();
                    Log.e("ww", "un Success");

                }

            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {
                Log.e("err", "on failure");

            }


        });



    }
    private void updateTimeRemaining(long millisUntilFinished) {

        long l=millisUntilFinished;
        int totalSecondsLeft = (int) millisUntilFinished / 1000;
        int hoursLeft = totalSecondsLeft / 3600;
        int minutesLeft = (totalSecondsLeft % 3600) / 60;
        int secondsLeft = totalSecondsLeft % 60;
        String a=String.format("%02d", hoursLeft);
        String b=String.format("%02d", minutesLeft);
        String c=String.format("%02d", secondsLeft);
        counters.setText(a+" "+b+" "+c);

    }



}