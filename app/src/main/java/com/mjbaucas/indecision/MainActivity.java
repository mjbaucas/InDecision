package com.mjbaucas.indecision;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.content.Intent;

import com.mjbaucas.indecision.List.AppDatabase;
import com.mjbaucas.indecision.List.ListBinder;
import com.mjbaucas.indecision.List.ListBinderDao;

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

    private static void populateWithTestData(AppDatabase db) {
        ListBinder listBinder = new ListBinder();
        listBinder.setListName("List Number 1");
        addListBinder(db, listBinder);
    }

    private ArrayList<ListInfo> createInfoList(AppDatabase db) {
        ArrayList<ListInfo> result = new ArrayList<>();
        List<ListBinder> listBinders = db.listBinderDao().getAll();

        for (int i = 0; i < listBinders.size(); i++) {
            ListInfo li = new ListInfo();
            li.title = listBinders.get(i).getListName();
            ArrayList <String> listItems = new ArrayList<>();
            listItems.add("one");
            listItems.add("two");
            listItems.add("three");
            listItems.add("four");
            listItems.add("five");
            listItems.add("six");
            listItems.add("seven");
            listItems.add("eight");
            listItems.add("nine");
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
