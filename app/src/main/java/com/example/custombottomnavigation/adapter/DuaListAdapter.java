package com.example.custombottomnavigation.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.example.custombottomnavigation.DoaShowActivity;
import com.example.custombottomnavigation.MainActivity;
import com.example.custombottomnavigation.R;
import com.example.custombottomnavigation.fragments.DoaFragmentShows;
import com.example.custombottomnavigation.fragments.NamazFragment;
import com.example.custombottomnavigation.models.DuaItems;

import java.util.List;


public class  DuaListAdapter extends RecyclerView.Adapter<DuaListAdapter.ViewHolder>
{


    private List<DuaItems> duaItemsList;
    private Context context;
    public static DuaItems pos;

    public DuaListAdapter(List<DuaItems> duaItemsList) {
        this.duaItemsList = duaItemsList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());
        View view=layoutInflater.inflate(R.layout.dua_list_singel_item,parent,false);
        ViewHolder viewHolder=new ViewHolder(view);


        return viewHolder;
    }

    @Override
    public void onBindViewHolder(DuaListAdapter.ViewHolder holder, int position) {



        String title=duaItemsList.get(position).getTitle();
        int arbi=duaItemsList.get(position).getArbi();
        int bangla=duaItemsList.get(position).getBangla();
        int dua=duaItemsList.get(position).getDua();
        int ayat=duaItemsList.get(position).getAyat();
        holder.setData(title,arbi,bangla,dua,ayat);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pos=duaItemsList.get(position);
                Intent nIntent = new Intent(v.getContext(),DoaShowActivity.class);

//                String title=pos.getTitle();
//                int doa=pos.getDua();
//                int bangla=pos.getBangla();
//                int arbi=pos.getArbi();
//
//                nIntent.putExtra("tt", title);
//                nIntent.putExtra("d", doa);
//                nIntent.putExtra("b", bangla);
//                nIntent.putExtra("a", arbi);



                v.getContext().startActivity(nIntent);


//                Toast.makeText(v.getContext(), "Numb : "+pos.getTitle(), Toast.LENGTH_SHORT).show();
            }
        });



    }


    @Override
    public int getItemCount() {
        return duaItemsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView dua_title;

        public ViewHolder( View itemView) {
            super(itemView);

            dua_title=itemView.findViewById(R.id.headerTextViewId);





        }


        public void setData(String title, int arbi, int bangla, int dua, int ayat) {
            dua_title.setText(title);
        }
    }
}
