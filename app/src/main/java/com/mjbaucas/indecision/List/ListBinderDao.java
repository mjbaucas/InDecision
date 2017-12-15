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
public interface ListBinderDao {
    @Query("SELECT * FROM list_binder")
    List<ListBinder> getAll();

    @Query("SELECT * FROM list_binder where id LIKE :listBinderId")
    ListBinder findById(int listBinderId);

    @Insert
    void insertAll(ListBinder... listBinders);

    @Delete
    void delete(ListBinder listBinder);
}
