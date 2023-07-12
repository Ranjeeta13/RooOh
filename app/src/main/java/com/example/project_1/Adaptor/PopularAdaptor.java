package com.example.project_1.Adaptor;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.project_1.Domain.FoodDomain;
import com.example.project_1.R;
import com.example.project_1.Activity.ShowDetailActivity;

import java.io.Serializable;
import java.util.ArrayList;

public class PopularAdaptor extends RecyclerView.Adapter<PopularAdaptor.ViewHolder> {

    ArrayList<FoodDomain>popularFood;

    public PopularAdaptor(ArrayList<FoodDomain>popularFood){
        this.popularFood=popularFood;
    }

    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate= LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_popular,parent,false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull PopularAdaptor.ViewHolder holder1, int position) {
     holder1.title1.setText(popularFood.get(position).getTitle());
     holder1.price.setText(String.valueOf(popularFood.get(position).getPrice()));

        int drawableResourceId=holder1.itemView.getContext().getResources().getIdentifier(popularFood.get(position).getPic(),"drawable",holder1.itemView.getContext().getPackageName());
        Glide.with(holder1.itemView.getContext())
                .load(drawableResourceId)
                .into(holder1.pic);

        holder1.addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(holder1.itemView.getContext(), ShowDetailActivity.class);
                intent.putExtra("object", (Serializable) popularFood.get(position));
                holder1.itemView.getContext().startActivity(intent);
            }
        });
    }
    @Override
    public int getItemCount() {
        return popularFood.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView title1,price;
        ImageView pic;
        TextView addBtn;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title1=itemView.findViewById(R.id.title1);
            price=itemView.findViewById(R.id.price);
            pic=itemView.findViewById(R.id.pic);
            addBtn=itemView.findViewById(R.id.addBtn);
        }
    }
}
