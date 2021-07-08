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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.custombottomnavigation.HomeFragment;
import com.example.custombottomnavigation.MainActivity;
import com.example.custombottomnavigation.R;
import com.example.custombottomnavigation.adapter.DuaListAdapter;
import com.example.custombottomnavigation.adapter.NamazListAdapter;
import com.example.custombottomnavigation.models.DuaItems;
import com.example.custombottomnavigation.namaz_fragments.NamazFragmentItem1_Oju;

import java.util.ArrayList;
import java.util.List;


public class NamazFragment extends Fragment {


    ImageView backBtn;
    RecyclerView recyclerView;
    LinearLayoutManager layoutManager;
    List<DuaItems> duaItems;
    NamazListAdapter adapter;

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
//        oju=view.findViewById(R.id.singel_item1);


        //HIDE TOOLBAR
        MainActivity.toolbar.setVisibility(View.GONE);

        initData();

        recyclerView=view.findViewById(R.id.namaz_recyclerView);
        layoutManager=new LinearLayoutManager(getContext());
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);

        adapter=new NamazListAdapter(duaItems);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();



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



//        oju.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                NamazFragmentItem1_Oju someFragment = new NamazFragmentItem1_Oju();
//                FragmentTransaction transaction = getFragmentManager().beginTransaction();
//                transaction.replace(R.id.namaz_main_frame_bg, someFragment, "Go to item1");
//                transaction.commit();
//            }
//        });

    }





    private void initData() {
        duaItems=new ArrayList<>();
        duaItems.add(new DuaItems("আযানের পর পড়ার দুআ"," اللَّهُمَّ رَبَّ هَذِهِ الدَّعْوَةِ التَّامَّةِ وَالصَّلاَةِ الْقَائِمَةِ آتِ مُحَمَّدًا الْوَسِيلَةَ وَالْفَضِيلَةَ وَابْعَثْهُ مَقَامًا مَحْمُودًا الَّذِي وَعَدْتَهُ","অনুবাদঃ ‘হে আল্লাহ্ -এ পরিপূর্ণ আহবান ও প্রতিষ্ঠিত সালাতের মালিক, মুহাম্মাদ (সাল্লাল্লাহু ‘আলাইহি ওয়া সাল্লাম)-কে ওয়াসীলা ও সর্বোচ্চ মর্যাদার অধিকারী করুন এবং তাঁকে সে মাকামে মাহমুদে পোঁছে দিন যার অঙ্গীকার আপনি করেছেন(বুখারী ৬১৪)","জাবির ইব্নু ‘আবদুল্লাহ (রাঃ) থেকে বর্ণিতঃ আল্লাহ্র রসূল (সাল্লাল্লাহু ‘আলাইহি ওয়া সাল্লাম) বলেছেনঃ\n" +
                "যে ব্যক্তি আযান শুনে (নিম্নোক্ত) দু’আ করেঃ ক্বিয়ামাতের দিন সে আমার শাফা’আত লাভের অধিকারী হবে","1"));


        duaItems.add(new DuaItems("ওযুর শুরুতে দুআ","بِسْمِ اللّٰهِ ","আল্লাহ্র নামে","আবূ দাউদ, নং ১০১; ইবন মাজাহ্, নং ৩৯৭; আহমাদ নং ৯৪১৮।","1"));
        duaItems.add(new DuaItems("ওযুর নিয়ত","নাওয়াইতু আন আতাওয়াজ্জায়া লিরাফয়িল হাদাসি ওয়া ইস্তিবাহাতা লিছছালাতি ওয়া তাকাররুবান ইলাল্লাহি তা'য়ালা।","অর্থঃ “সর্বশ্রেষ্ঠ, সর্বমহান আল্লাহর নামে অজু শুরু করছি। সমস্ত প্রশংসা আল্লাহ্ তা’আলারই প্রাপ্য – যিনি আমাকে দ্বীন ইসলামের উপর রেখেছেন। ইসলাম সত্য এবং আলোক স্বরূপ আর কুফরী মিথ্যা ও অন্ধকারতুল্য।”","নিয়ত অর্থ ইচ্ছা করা, সংকল্প করা। মনে মনে আমরা পবিত্র হওয়ার উদ্দেশ্যে যখন অযুখানায় প্রবেশ করি সেটাই অযুর নিয়ত। কুরআন-হাদীসের কোথাও অযুর শুরুতে পড়তে হবে এমন নিয়তের বাক্যগুলো বর্ণনা করা নাই। বিভিন্ন বইতে যে সকল নিয়তের বাক্যগুলো দেয়া থাকে সেগুলো আরবি ভাষী কোনো ব্যক্তির বানানো। আল্লাহর রাসূল (সা) ও তাঁর সাহাবাগণ অযুর শুরুতে ঐসব নিয়তের বাক্যগুলো আবৃত্তি করতে আমাদের শিখিয়ে যান নাই। তাই অযুর শুরুতে সেই আরবি বাক্যগুলো মুখে উচ্চারণ করাকে জরুরি বা বেশি সওয়াবের বা দ্বীনের অংশ মনে করা বিদআত।\n" +
                "\n" +
                "পবিত্র হওয়ার আগের নিয়তের ব্যাপারে একটা উদাহরণ দেয়া যেতে পারে। ধরা যাক দুইজন ব্যক্তি একটি খালের উপরের বাঁশের সাঁকো পার হচ্ছেন। একজন এসেছেন গোসল করার উদ্দেশ্যে। তিনি এসে সাঁকো থেকে লাফ দিলেন। অপর জন গোসলের উদ্দেশ্যে আসেন নাই বরং তাল সামলাতে না পেরে পড়ে গেছেন। প্রথম ব্যক্তির গোসল হবে নিয়ত সহ। আর দ্বিতীয় ব্যক্তির গোসল হবে ঠিকই কিন্তু নিয়ত ব্যতীত।\n" +
                "\n" +
                "সারকথা হচ্ছে, অযু করার জন্য মনে মনে ইচ্ছা করাই যথেষ্ট। বিভিন্ন বই-পুস্তকে যেসকল নিয়তের বাক্য পাওয়া যায় সেগুলো কুরআন হাদীস দ্বারা প্রমাণিত নয়। আসুন, ইসলাম কোনো বিষয়কে যতটা গুরুত্ব দিয়েছে ততটা গুরুত্বই আমরা দিই। দ্বীনকে পালনের জন্য কঠিন থেকে কঠিনতর না বানিয়ে নিই।\n","1"));

        duaItems.add(new DuaItems("ওযুর শেষে পড়ার দুআ"," أَشْهَدُ أَنْ لاَ إِلَهَ إِلاَّ اللّٰهُ وَحْدَهُ لاَ شَرِيْكَ لَهُ وَأَشْهَدُ أَنَّ مُحَمَّدًا عَبْدُهُ وَرَسُوْلُه","Not Found","আমি সাক্ষ্য দিচ্ছি যে, একমাত্র আল্লাহ ছাড়া কোনো হক্ব ইলাহ নেই, তাঁর কোনো শরীক নেই। আমি আরও সাক্ষ্য দিচ্ছি যে, মুহাম্মাদ তাঁর বান্দা ও রাসূল\n" +
                "\n" +
                "মুসলিম ১/২০৯, নং ২৩৪\n","1"));


        duaItems.add(new DuaItems("মসজিদে প্রবেশের দুআ", " أَعُوْذُ بِاللّٰهِ العَظِيْمِ، وَبِوَجْهِهِ الْكَرِيْمِ، وَسُلْطَانِهِ الْقَدِيْمِ، مِنَ الشَّيْطَانِ الرَّجِيْمِ","আমি মহান আল্লাহ্র কাছে তাঁর সম্মানিত চেহারা ও প্রাচীন ক্ষমতার ওসীলায় বিতাড়িত শয়তান থেকে আশ্রয় প্রার্থনা করছি।","হে আল্লাহ! আপনি আমার জন্য আপনার রহমতের দরজাসমূহ খুলে দিন। [৫]\n" +
                "\n" +
                "[১] হাদীসটি উদ্ধৃত করেছেন, হাকিম ১/২১৮; এবং একে মুসলিমের শর্ত অনুযায়ী সহীহ বলেছেন, আর ইমাম যাহাবী সেটার সমর্থন করেছেন। আরও উদ্ধৃত করেছেন বাইহাকী, ২/৪৪২; আর শাইখ আলবানী তার সিলসিলাতুল আহাদীসিস সহীহা গ্রন্থে এটাকে হাসান বলেছেন, ৫/৬২৪; নং ২৪৭৮। \n" +
                "[২] আবূ দাউদ, নং ৪৬৬; আরও দেখুন, সহীহুল জামে‘ ৪৫৯১। \n" +
                "[৩] ইবনুসসুন্নি কর্তৃক উদ্ধৃত, নং ৮। আর শাইখ আলবানী তার আস-সামারুল মুস্তাতাব গ্রন্থে একে হাসান বলেছেন, পৃ. ৬০৭। \n" +
                "[৪] আবূ দাউদ ১/১২৬; নং ৪৬৫; আরও দেখুন, সহীহুল জামে‘ ১/৫২৮। \n" +
                "[৫] মুসলিম ১/৪৯৪, নং ৭১৩; আর সুনান ইবন মাজায় ফাতিমা রাদিয়াল্লাহু আনহার হাদীসে এসেছে, “হে আল্লাহ, আমার গুনাহ ক্ষমা করে দিন এবং আমার জন্য আপনার রহমতের দ্বারসমূহ অবারিত করে দিন”। আর শাইখ আলবানী অন্যান্য শাহেদ বা সম অর্থের বর্ণনার কারণে একে সহীহ বলেছেন। দেখুন, সহীহ ইবন মাজাহ্ ১/১২৮-১২৯।\n","1"));



        duaItems.add(new DuaItems("মসজিদ থেকে বের হওয়ার দুআ", " بِسْمِ اللّٰهِ وَالصّلَاةُ وَالسَّلَامُ عَلَى رَسُوْلِ اللّٰهِ، اللّٰهُمَّ إِنِّيْ أَسْأَلُكَ مِنْ فَضْلِك، اللّٰهُمَّ اعْصِمْنِيْ مِنَ الشَّيْطَانِ الرَّجِيْمِ، ","বাম পা দিয়ে মসজিদ থেকে বের হবে [১] ","আল্লাহ্\u200Cর নামে (বের হচ্ছি)। আল্লাহ্\u200Cর রাসুলের উপর শান্তি বর্ষিত হোক। হে আল্লাহ! আপনি আমার গুনাসমূহ মাফ করে দিন এবং আমার জন্য আপনার দয়ার দরজাগুলো খুলে দিন। হে আল্লাহ, আমাকে বিতাড়িত শয়তান থেকে হেফাযত করুন [২]\n" +
                "\n" +
                "[১] আল-হাকিম, ১/২১৮; বাইহাকী, ২/৪৪২, আর শাইখ আলবানী তার সিলসিলাতুস সহীহায় একে হাসান হাদীস বলেছেন, ৫/৬২৪, নং ২৪৭৮। আর সেটার তাখরীজ পূর্বে গত হয়েছে। \n" +
                "[২] মসজিদে প্রবেশের দো‘আয় পূর্বে বর্ণিত হাদীসের রেওয়ায়েতসমূহের তাখরীজ দেখুন, (২০ নং) আর “হে আল্লাহ, আমাকে বিতাড়িত শয়তান থেকে হেফাযত করুন” এ বাড়তি অংশের তাখরীজ দেখুন, ইবন মাজাহ্\u200C ১/১২৯।\n","1"));


        duaItems.add(new DuaItems("সালাতের নিয়ত", " سُبْحَانَكَ اللَّهُمَّ وَبِحَمْدِكَ وَتَبَارَكَ اسْمُكَ وَتَعَالَى جَدُّكَ وَلاَ إِلَهَ غَيْرُكَ","আল্লাহ! আপনার প্রশংসাসহ আপনার পবিত্রতা ও মহিমা ঘোষণা করছি, আপনার নাম বড়ই বরকতময়, আপনার প্রতিপত্তি অতি উচ্চ। আর আপনি ব্যতীত অন্য কোনো হক্ব ইলাহ নাই।\n","আয়িশাহ্ (রাঃ) থেকে বর্ণিতঃ তিনি বলেন, রাসূলুল্লাহ (সাল্লাল্লাহু ‘আলাইহি ওয়া সাল্লাম) যখন নামায শুরু করতেন তখন বলতেনঃ \n আল্লাহ! আপনার প্রশংসাসহ আপনার পবিত্রতা ও মহিমা ঘোষণা করছি, আপনার নাম বড়ই বরকতময়, আপনার প্রতিপত্তি অতি উচ্চ। আর আপনি ব্যতীত অন্য কোনো হক্ব ইলাহ নাই।\n" +
                "\n" +
                "সূত্রঃ মুসলিম-৩৯৯, আবু দাঊদ-৭৭৫, তিরমিযি-২৪৩, ইবনু মাজাহ-৮০৬, নাসায়ী-৮৯\n","1"));

        duaItems.add(new DuaItems("রুকুতে পড়ার দুআ"," سُبْحَانَ رَبِّيَ الْعَظِيْمِ","আমার মহান রব্বের পবিত্রতা ও মহিমা ঘোষণা করছি","সূত্রঃ আবূ দাউদ, নং ৮৭০; তিরমিযী, নং ২৬২; নাসাঈ, নং ১০০৭; ইবনে মাজাহ, নং ৮৯৭; আহমাদ, নং ৩৫১৪। ","1"));
        duaItems.add(new DuaItems("রুকু থেকে ওঠার দুআ", " سَمِعَ اللّٰهُ لِمَنْ حَمِدَهُ","যে আল্লাহর হামদ-প্রশংসা করে, আল্লাহ তার প্রশংসা শোনেন (কবুল করুন)","সূত্রঃ বুখারী, (ফাতহুল বারীসহ) ২/২৮২, নং ৭৯৬","1"));




    }


}