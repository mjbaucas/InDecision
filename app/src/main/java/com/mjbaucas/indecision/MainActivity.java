package com.mjbaucas.indecision;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.content.Intent;

import com.mjbaucas.indecision.List.AppDatabase;
import com.mjbaucas.indecision.List.ListBinder;
import com.mjbaucas.indecision.List.ListBinderDao;
import com.mjbaucas.indecision.List.ListEntry;

import java.util.ArrayList;
import java.util.List;

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

        AppDatabase db = AppDatabase.getAppDatabase(this);
        populateWithTestData(db);
        ButterKnife.bind(this);
        init(db);
    }

    public void init(AppDatabase db){
        RecyclerView listView = (RecyclerView) findViewById(R.id.card_list);
        listView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        listView.setLayoutManager(layoutManager);

        ListAdapter listAdapter = new ListAdapter(createInfoList(db));
        listView.setAdapter(listAdapter);
    }

    private static ListBinder addListBinder(final AppDatabase db, ListBinder listBinder) {
        db.listBinderDao().insertAll(listBinder);
        return listBinder;
    }

    private static ListEntry addListEntry(final AppDatabase db, ListEntry listEntry) {
        db.listEntryDao().insertAll(listEntry);
        return listEntry;
    }

    private static void populateWithTestData(AppDatabase db) {
        ListBinder listBinder = new ListBinder();
        listBinder.setListName("List Number 1");
        addListBinder(db, listBinder);

        List<ListBinder> listBinders = db.listBinderDao().getAll();
        for (int i = 0; i < listBinders.size(); i++) {
            for (int j = 0; j < 10; j++) {
                ListEntry listEntry = new ListEntry();
                listEntry.setBinderId(listBinders.get(i).getListId());
                listEntry.setEntryValue("Entry" + Integer.toString(j));
                addListEntry(db, listEntry);
            }
        }
    }

    private ArrayList<ListInfo> createInfoList(AppDatabase db) {
        ArrayList<ListInfo> result = new ArrayList<>();
        List<ListBinder> listBinders = db.listBinderDao().getAll();

        for (int i = 0; i < listBinders.size(); i++) {
            ListInfo li = new ListInfo();
            li.title = listBinders.get(i).getListName();
            ArrayList <String> listItems = new ArrayList<>();
            List<ListEntry> listEntries = db.listEntryDao().findByBinderId(listBinders.get(i).getListId());
            for (int j = 0; j < listEntries.size(); j++) {
                listItems.add(listEntries.get(j).getEntryValue());
            }
            li.items = listItems;

            result.add(li);
        }

        return result;
    }

    @Override
    protected void onDestroy() {
        AppDatabase.destroyInstance();
        super.onDestroy();
    }
}
