package com.mjbaucas.indecision.List;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by mjbau on 2017-12-14.
 */

@Entity (tableName="list_binder")
public class ListBinder {
    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "list_name")
    public String listName;

    public int getListId() {
        return id;
    }

    public void setListId(int id) {
        this.id = id;
    }

    public String getListName() {
        return listName;
    }

    public void setListName(String name) {
        this.listName = name;
    }
}