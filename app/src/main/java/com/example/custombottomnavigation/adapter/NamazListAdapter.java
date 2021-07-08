package com.example.custombottomnavigation.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.custombottomnavigation.DoaShowActivity;
import com.example.custombottomnavigation.NamazShowActivity;
import com.example.custombottomnavigation.R;
import com.example.custombottomnavigation.models.DuaItems;

import java.util.List;


public class NamazListAdapter extends RecyclerView.Adapter<NamazListAdapter.ViewHolder>
{


    private List<DuaItems> duaItemsList;
    private Context context;
    public static DuaItems pos;

    public NamazListAdapter(List<DuaItems> duaItemsList) {
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
    public void onBindViewHolder(NamazListAdapter.ViewHolder holder, int position) {



        String title=duaItemsList.get(position).getTitle();
        String arbi=duaItemsList.get(position).getArbi();
        String bangla=duaItemsList.get(position).getBangla();
        String ortho=duaItemsList.get(position).getOrtho();
        String ayat=duaItemsList.get(position).getAyat();
        holder.setData(title,arbi,bangla,ortho,ayat);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pos=duaItemsList.get(position);
                Intent nIntent = new Intent(v.getContext(), NamazShowActivity.class);

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


        public void setData(String title, String arbi, String bangla, String dua, String ayat) {
            dua_title.setText(title);
        }
    }
}
