package com.mjbaucas.indecision;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by mjbau on 2017-09-15.
 */

public class CreateListActivity extends AppCompatActivity {
    Button addEntry;
    Button removeEntry;
    protected LinearLayout onCreateLayout;
    ArrayList<Integer> entryIdList = new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_list);
        onCreateLayout = (LinearLayout) findViewById(R.id.entry_layout);

        addEntry = (Button) findViewById(R.id.add_entry);
        addEntry.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                onCreateLayout.addView(createNewTextView());
            }
        });

        removeEntry = (Button) findViewById(R.id.remove_entry);
        removeEntry.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                int size = entryIdList.size();
                if (size != 0) {
                    onCreateLayout.removeView(findViewById(entryIdList.get(size - 1)));
                    entryIdList.remove(entryIdList.get(size - 1));
                }
            }
        });
    }

    private TextView createNewTextView() {
        final LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        final TextView textView = new TextView(this);
        textView.setLayoutParams(layoutParams);
        textView.setText("New text: " + Integer.toString(entryIdList.size()));
        int entryId = View.generateViewId();
        entryIdList.add(entryId);
        textView.setId(entryId);
        return textView;
    }
}
