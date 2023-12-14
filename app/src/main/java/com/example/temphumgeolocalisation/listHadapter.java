package com.example.temphumgeolocalisation;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
public class listHadapter extends RecyclerView.Adapter<listHadapter.bkbViewHolder> {
    List<thg> bkblist;
    Context context;
    public listHadapter(Context context, List<thg> list) {
        this.context = context;
        this.bkblist = list;
    }
    @NonNull
    @Override
    public bkbViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerviewh, parent, false);
        bkbViewHolder bkbViewHolder = new bkbViewHolder(view);
        return bkbViewHolder;
    }
    @Override
    public void onBindViewHolder(@NonNull final bkbViewHolder holder, final int position) {
        final thg thg = bkblist.get(position);
        holder.id.setText(thg.getId());
        holder.temp.setText(thg.getHumidite());
        holder.value.setText(thg.getDate());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

               Toast.makeText(context,bkblist.get(position).getHumidite(),
               Toast.LENGTH_LONG).show();

           }
       });
    }
    @Override
    public int getItemCount() {
        return bkblist.size();
    }
    public static class bkbViewHolder extends
            RecyclerView.ViewHolder {
        TextView value , id,temp;
        public bkbViewHolder(View itemView) {
            super(itemView);
            id= itemView.findViewById(R.id.idh);
            temp = itemView.findViewById(R.id.hum);
            value = itemView.findViewById(R.id.date);
        }
    }
}
