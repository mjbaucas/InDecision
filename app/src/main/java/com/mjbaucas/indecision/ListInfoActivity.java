package com.mjbaucas.indecision;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by mjbau on 2017-09-15.
 */

public class ListInfoActivity extends AppCompatActivity {
    protected TextView title;
    Button roll;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_info);

        Bundle extras = this.getIntent().getExtras();
        title = (TextView) findViewById(R.id.info_title);
        title.setText(extras.getString("LIST_TITLE"));
        final ArrayList itemList = extras.getStringArrayList("LIST_ITEMS");
        init(itemList);

        roll = (Button) findViewById(R.id.roll);
        roll.setOnClickListener(new View.OnClickListener(){
            public void onClick(final View v){
                AlertDialog.Builder resultBuilder = new AlertDialog.Builder(v.getContext());
                resultBuilder.setMessage(" ");
                final AlertDialog result = resultBuilder.create();
                result.show();

                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    public void run() {
                        result.setMessage((String) itemList.get(pickFromList(itemList.size())));
                    }
                }, 500);
            }
        });
    }

    public int pickFromList(int length){
        Random randomNumber = new Random();
        return (randomNumber.nextInt(length));
    }

    public void init(ArrayList items){
        RecyclerView itemView = (RecyclerView) findViewById(R.id.item_list);
        itemView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        itemView.setLayoutManager(layoutManager);

        ItemAdapter itemAdapter = new ItemAdapter(items);
        itemView.setAdapter(itemAdapter);
    }
}
