package com.mjbaucas.indecision;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by mjbau on 2017-09-15.
 */

public class ListInfoActivity extends AppCompatActivity {
    protected TextView title;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_info);

        Bundle extras = this.getIntent().getExtras();
        title = (TextView) findViewById(R.id.info_title);
        title.setText(extras.getString("LIST_TITLE"));
        init(extras.getStringArrayList("LIST_ITEMS"));
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
