package com.example.custombottomnavigation.adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Dao;

import com.example.custombottomnavigation.DaoClass.Daoclass;
import com.example.custombottomnavigation.DatabaseClass;
import com.example.custombottomnavigation.EntityClass.UserModel;
import com.example.custombottomnavigation.MainActivity;
import com.example.custombottomnavigation.R;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {

    Context context;
    List<UserModel> list;
    private Daoclass notesDao;

    DeleteItemListener deleteItemListener;

    public UserAdapter() {
    }

    public UserAdapter(Context context, List<UserModel> list,DeleteItemListener deleteItemListener) {
        this.context = context;
        this.list = list;
        this.deleteItemListener=deleteItemListener;


    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.tasbhee_rv_layout,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull UserAdapter.ViewHolder holder, int position) {

        holder.date.setText(list.get(position).getDetails());
        holder.numb.setText(list.get(position).getKey()+". ");
        holder.count.setText(list.get(position).getName());

        holder.deletes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                showAlertDialog(position);
            }
        });


    }
    private void showAlertDialog(int position) {
        final AlertDialog.Builder builder=new AlertDialog.Builder(context);
        builder.setTitle("delete "+list.get(position).getName()+" ?");
        builder.setMessage("wana delete parmanently?");
        builder.setIcon(R.drawable.delete_icon);
        builder.setPositiveButton("delete", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                ///

                deleteItemListener.onItemDelete(position,list.get(position).getKey());

                Toast.makeText(context, "Delete Succesfully", Toast.LENGTH_SHORT).show();

            }
        });
        builder.setNegativeButton("cancel",null);
        final AlertDialog dialog=builder.create();
        dialog.show();




    }



    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder
    {

        TextView date,count,numb;
        ImageView deletes;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            date=itemView.findViewById(R.id.dateId);
            count=itemView.findViewById(R.id.nameId);
            numb=itemView.findViewById(R.id.num);
            deletes=itemView.findViewById(R.id.del);
        }
    }

    public interface DeleteItemListener
    {
        void onItemDelete(int position,int id);
    }
}
