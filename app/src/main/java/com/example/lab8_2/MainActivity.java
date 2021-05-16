package com.example.lab8_2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<City> mCityList;
    private AdapterRecyclerView mAdapter;
    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createCityList();
        buildRecyclerView();

    }

    private void buildRecyclerView() {
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new AdapterRecyclerView(mCityList);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.setOnItemClickListener(new AdapterRecyclerView.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                View layout = getLayoutInflater().inflate(R.layout.dialog_thong_bao, null);
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                TextView tvCityName = (TextView) layout.findViewById(R.id.tv_noi_dung_city);
                tvCityName.setText(mCityList.get(position).getName_city());
                builder.setView(layout);
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
                Toast.makeText(MainActivity.this, mCityList.get(position).getName_city(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void createCityList() {
        mCityList = new ArrayList<>();
        mCityList.add(new City(R.drawable.venice, "Venice"));
        mCityList.add(new City(R.drawable.london, "London"));
        mCityList.add(new City(R.drawable.parri, "Parri"));
        mCityList.add(new City(R.drawable.bali, "Bali"));
    }

}