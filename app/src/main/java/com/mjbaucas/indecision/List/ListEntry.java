package com.mjbaucas.indecision.List;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by mjbau on 2017-12-14.
 */

@Entity(tableName="list_entry")
public class ListEntry {
    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "binder_id")
    public int binderId;

    @ColumnInfo(name = "entry_value")
    public String entryValue;

    public int getEntryId() {
        return id;
    }

    public void setEntryId(int id) {
        this.id = id;
    }

    public String getEntryValue() {
        return entryValue;
    }

    public void setEntryValue(String value) {
        this.entryValue = value;
    }

    public int getBinderId() {
        return binderId;
    }

    public void setBinderId(int binder_id) {
        this.binderId = binder_id;
    }
}
