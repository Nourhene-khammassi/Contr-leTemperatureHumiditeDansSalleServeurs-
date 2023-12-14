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
public class listTadapter extends RecyclerView.Adapter<listTadapter.bkbViewHolder> {
    List<thg> bkblist;
    Context context;
    public listTadapter(Context context, List<thg> list) {
        this.context = context;
        this.bkblist = list;
    }
    @NonNull
    @Override
    public bkbViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerviewt, parent, false);
        bkbViewHolder bkbViewHolder = new bkbViewHolder(view);
        return bkbViewHolder;
    }
    @Override
    public void onBindViewHolder(@NonNull final bkbViewHolder holder, final int position) {
        final thg bkb = bkblist.get(position);
        holder.id.setText(bkb.getId());
        holder.temp.setText(bkb.getTemperature());
        holder.value.setText(bkb.getDate());
        holder.itemView.setOnClickListener(new
       View.OnClickListener() {
   @Override
   public void onClick(View v) {

       Toast.makeText(context,bkblist.get(position).getTemperature(),
               Toast.LENGTH_LONG).show();

   }
       });
}
    @Override
    public int getItemCount() {
        return bkblist.size();
    }
    public static class bkbViewHolder extends RecyclerView.ViewHolder {
        TextView value , id,temp;
        public bkbViewHolder(View itemView) {
            super(itemView);
            id= itemView.findViewById(R.id.idt);
            temp = itemView.findViewById(R.id.tt);
            value = itemView.findViewById(R.id.date);
        }
    }
}