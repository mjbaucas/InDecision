package com.mjbaucas.indecision;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

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
    }
}
