package com.mjbaucas.indecision;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.content.Intent;

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
    }
}
