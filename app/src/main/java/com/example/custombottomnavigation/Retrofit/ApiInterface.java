package com.example.custombottomnavigation.Retrofit;



import com.example.custombottomnavigation.example.Example;
import com.example.custombottomnavigation.example.Hijri;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {

    //Get Me
//    @GET("v1/calendarByAddress?address=Dhaka&method=3&month=06&year=2021&fbclid=IwAR1VXOw6xkd1ZHfHoQKQoL_M8pF3cXWuMMeHW4l2qyLSaBz9wAElUpvWwP4")
//
//    Call<Example> getAllProductInfo();


    @GET("v1/calendarByAddress")
    Call<Example> getAllInformation(@Query("address") String address,
                                    @Query("month") int month,@Query("year") int year);




}
