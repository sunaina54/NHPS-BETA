package com.example.dell3.demoapp;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.dell3.demoapp.Model.Menu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private MenuAdapter menuAdapter;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupScreen();
    }

    private void setupScreen(){
        context=getApplication();
        recyclerView= (RecyclerView) findViewById(R.id.recyclerView);

    }



    private void refreshList(ArrayList<Menu> list){
        menuAdapter = new MenuAdapter(list); // pass list
        recyclerView.setAdapter(menuAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        menuAdapter.notifyDataSetChanged();
    }

    private class MenuAdapter extends
            RecyclerView.Adapter<MenuAdapter.MyViewHolder> {
        private ArrayList<Menu> dataSet;


        public class MyViewHolder extends RecyclerView.ViewHolder {
            private TextView menuTV;
            private LinearLayout menuValueLl;

            public MyViewHolder(View v) {
                super(v);
                menuTV=(TextView) v.findViewById(R.id.menuTV);
                menuValueLl=(LinearLayout) v.findViewById(R.id.menuValueLl);

            }

        }

        public void addAll(List<Menu> list) {

            dataSet.addAll(list);
            notifyDataSetChanged();
        }

        public MenuAdapter(List<Menu> data) {
            this.dataSet = (ArrayList<Menu>) data;

        }

        @Override
        public MenuAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.menu_data, parent, false);
            //view.setOnClickListener(MainActivity.myOnClickListener);
            MenuAdapter.MyViewHolder myViewHolder = new MenuAdapter.MyViewHolder(view);
            return myViewHolder;
        }

        @Override
        public void onBindViewHolder(final MenuAdapter.MyViewHolder holder, final int listPosition) {
            final Menu item = dataSet.get(listPosition);
            holder.menuTV.setText("menu1");
            holder.menuValueLl.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context,ViewDetails.class);
                    intent.putExtra("ID",item.getmId());
                    startActivity(intent);
                }
            });


        }

        @Override
        public int getItemCount() {
            return dataSet.size();
        }

        public void clearDataSource() {
            dataSet.clear();
            notifyDataSetChanged();
        }
    }

 private void sendData(){

 }

}
