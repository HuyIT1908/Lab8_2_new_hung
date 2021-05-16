package com.example.lab8_2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterRecyclerView extends RecyclerView.Adapter<AdapterRecyclerView.CityViewHolder> {
    private ArrayList<City> mCityList;
    private OnItemClickListener mListener;

    public interface OnItemClickListener{
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener){
        mListener = listener;
    }

    public AdapterRecyclerView(ArrayList<City> mCityList) {
        this.mCityList = mCityList;
    }

    public static class CityViewHolder extends RecyclerView.ViewHolder{
        public ImageView imgView, imgFavorite, imgShare;
        public TextView tvCityName;
        public CityViewHolder(@NonNull View itemView, OnItemClickListener listener) {
            super(itemView);
            imgView= (ImageView) itemView.findViewById(R.id.img_item);
            tvCityName= (TextView) itemView.findViewById(R.id.tv_title);
            imgFavorite= (ImageView) itemView.findViewById(R.id.img_favorite);
            imgShare= (ImageView) itemView.findViewById(R.id.img_share);
            imgView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener!=null){
                        int position = getAdapterPosition();
                        if (position!=RecyclerView.NO_POSITION){
                            listener.onItemClick(position);
                        }
                    }
                }
            });
            imgFavorite.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(itemView.getContext(), "Favorite", Toast.LENGTH_SHORT).show();
                }
            });
            imgShare.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(itemView.getContext(), "Share", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
    @NonNull
    @Override
    public CityViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item,parent,false);
        CityViewHolder cvh = new CityViewHolder(v, mListener);
        return cvh;
    }

    @Override
    public void onBindViewHolder(@NonNull CityViewHolder holder, int position) {
        City city = mCityList.get(position);
        holder.imgView.setImageResource(city.getImg());
        holder.tvCityName.setText(city.getName_city());
    }

    @Override
    public int getItemCount() {
        return mCityList.size();
    }


}
