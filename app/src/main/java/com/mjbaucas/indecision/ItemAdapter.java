package com.mjbaucas.indecision;

/**
 * Created by mjbau on 2017-09-21.
 */

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by mjbau on 2017-09-15.
 */

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder> {
    private ArrayList<String> itemList;

    public ItemAdapter(ArrayList<String> itemList) {
        this.itemList = itemList;
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    @Override
    public void onBindViewHolder(ItemViewHolder itemViewHolder, int i) {
        String info = itemList.get(i);
        itemViewHolder.item.setText(info);
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_card, viewGroup, false);
        return new ItemViewHolder(itemView);
    }

    public static class ItemViewHolder extends RecyclerView.ViewHolder {
        protected TextView item;

        public ItemViewHolder(View itemView) {
            super(itemView);
            item = (TextView) itemView.findViewById(R.id.item_name);
        }
    }

}

