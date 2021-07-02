package com.example.custombottomnavigation.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.custombottomnavigation.HomeFragment;
import com.example.custombottomnavigation.MainActivity;
import com.example.custombottomnavigation.R;
import com.example.custombottomnavigation.adapter.DuaListAdapter;
import com.example.custombottomnavigation.models.DuaItems;

import java.util.ArrayList;
import java.util.List;


public class DuaListFragment extends Fragment {

    RecyclerView recyclerView;
    LinearLayoutManager layoutManager;
    List<DuaItems> duaItems;
    DuaListAdapter adapter;
    ImageView backBtn;




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
        duaItems.add(new DuaItems("ঘুমানোর সময় পড়ার দোয়া"," اَللَّهُمَّ بِاسْمِكَ أَمُوتُ وَأَحْيَا","আল্লাহুম্মা বিসমিকা আমুতু ওয়া আহইয়া","আমার বাংলা নিয়ে প্রথম কাজ করবার সুযোগ তৈরি হয়েছিল অভ্র নামক এক যুগান্তকারী বাংলা সফ্টওয়্যার হাতে পাবার মধ্য দিয়ে।","1"));
        duaItems.add(new DuaItems("ঘুম থেকে উঠে পড়ার দোয়া"," الْحَمْدُ لِلَّهِ الَّذِي أَحْيَانَا بَعْدَ مَا أَمَاتَنَا وَإِلَيْهِ النُّشُورُ","আলহামদু লিল্লাহিল লাজি আহইয়ানা বা’দা মা আমাতানা ওয়া ইলাইহিন নুশুর","আমার বাংলা নিয়ে প্রথম কাজ করবার সুযোগ তৈরি হয়েছিল অভ্র^ নামক এক যুগান্তকারী বাংলা সফ্টওয়্যার হাতে পাবার মধ্য দিয়ে।","1"));
        duaItems.add(new DuaItems("ওযুর দোয়া","اَللَّخُمَّ اغْفِرْلِىْ ذَنْبِى وَ وَسِّعْلِىْ فِىْ دَارِىْ وَبَارِكْ لِىْ فِىْ رِزْقِىْ","আল্লাহুম্মাগফিরলি জামবি, ওয়া ওয়াসসিলি ফি দারি, ওয়া বারিক লি ফি রিযক্বি। (নাসাঈ)","আমার বাংলা নিয়ে প্রথম কাজ করবার সুযোগ তৈরি হয়েছিল অভ্র^ নামক এক যুগান্তকারী বাংলা সফ্টওয়্যার হাতে পাবার মধ্য দিয়ে।","1"));
        duaItems.add(new DuaItems("মসজিদে প্রবেশ করার সময়ের দোয়া","اَللّٰهُمَّ افْتَحْ لِيْ اَبْوَابَ رَحْمَتِكَ","আল্লাহুম্মাফতাহলী আবওয়াবা রাহমাতিক","আমার বাংলা নিয়ে প্রথম কাজ করবার সুযোগ তৈরি হয়েছিল অভ্র^ নামক এক যুগান্তকারী বাংলা সফ্টওয়্যার হাতে পাবার মধ্য দিয়ে।","1"));
        duaItems.add(new DuaItems("মসজিদ হতে বের হওয়ার সময়ের দোয়া", "اَللّٰهمَّ اِنِّي اَسْٮَٔلُكَ مِنْ فَضْلِكِ","আল্লাহুম্মা ইন্নী আসআলূকা মিস ফাযলিকা","আমার বাংলা নিয়ে প্রথম কাজ করবার সুযোগ তৈরি হয়েছিল অভ্র^ নামক এক যুগান্তকারী বাংলা সফ্টওয়্যার হাতে পাবার মধ্য দিয়ে।","1"));


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


        backBtn=view.findViewById(R.id.bck_btn2);

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //go back to previous fragment
                Fragment someFragment = new HomeFragment();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.main_frame_bg, someFragment, "Go back to home");
                transaction.addToBackStack("Go to home");

                transaction.commit();

            }
        });

    }

}