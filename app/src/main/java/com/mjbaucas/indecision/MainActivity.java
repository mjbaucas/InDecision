package com.mjbaucas.indecision;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.content.Intent;

import java.util.ArrayList;

import butterknife.*;

public class MainActivity extends AppCompatActivity {
    Button createList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.main);

        createList = (Button) findViewById(R.id.new_list);
        createList.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent createList = new Intent(MainActivity.this, CreateListActivity.class);
                startActivity(createList);
            }
        });

        ButterKnife.bind(this);
        init();
    }

    public void init(){
        RecyclerView listView = (RecyclerView) findViewById(R.id.card_list);
        listView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        listView.setLayoutManager(layoutManager);

        ListAdapter listAdapter = new ListAdapter(createInfoList());
        listView.setAdapter(listAdapter);
    }

    private ArrayList<ListInfo> createInfoList() {
        ArrayList<ListInfo> result = new ArrayList<>();

        for (int i = 0; i < 20; i++){
            ListInfo li = new ListInfo();
            li.title = "Random List " + (i+1);
            result.add(li);
        }

        return result;
    }
}
