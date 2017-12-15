package com.mjbaucas.indecision.List;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

/**
 * Created by mjbau on 2017-12-14.
 */

@Dao
public interface ListEntryDao {
    @Query("SELECT * FROM list_entry")
    List<ListEntry> getAll();

    @Query("SELECT * FROM list_entry where binder_id LIKE :listEntryId")
    List<ListEntry> findByBinderId(int listEntryId);

    @Insert
    void insertAll(ListEntry... listEntries);

    @Delete
    void delete(ListEntry listEntry);
}
