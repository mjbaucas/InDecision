package com.mjbaucas.indecision;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
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
                onCreateLayout.addView(createNewEntryView());
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

    private CardView createNewEntryView() {
        final CardView.LayoutParams layoutParams = new CardView.LayoutParams(
            CardView.LayoutParams.MATCH_PARENT,
            CardView.LayoutParams.WRAP_CONTENT
        );
        layoutParams.setMargins(0, dpToPx(4) ,0 ,dpToPx(4) );
        final CardView cardView = new CardView(this);
        cardView.setLayoutParams(layoutParams);
        cardView.setRadius(dpToPx(2));

        int entryId = View.generateViewId();
        entryIdList.add(entryId);
        cardView.setId(entryId);

        final ViewGroup.LayoutParams editParams = new ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        );
        final EditText editText = new EditText(this);
        editText.setPadding(dpToPx(16), dpToPx(10), dpToPx(16),dpToPx(10));
        editText.setLayoutParams(editParams);

        cardView.addView(editText);
        return cardView;
    }

    public int dpToPx(int dp) {
        Resources r = getResources();
        int px = Math.round(TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP, dp,r.getDisplayMetrics()));
        return px;
    }
}
