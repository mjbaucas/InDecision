package com.mjbaucas.indecision;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by mjbau on 2017-09-15.
 */

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ListViewHolder> {
    private ArrayList<ListInfo> infoList;

    public ListAdapter(ArrayList<ListInfo> infoList) {
        this.infoList = infoList;
    }

    @Override
    public int getItemCount() {
        return infoList.size();
    }

    @Override
    public void onBindViewHolder(ListViewHolder listViewHolder, int i) {
        ListInfo info = infoList.get(i);
        listViewHolder.title.setText(info.title);
    }

    @Override
    public ListViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_card, viewGroup, false);
        return new ListViewHolder(itemView);
    }

    public static class ListViewHolder extends RecyclerView.ViewHolder {
        protected TextView title;

        public ListViewHolder(View v) {
            super(v);
            title = (TextView) v.findViewById(R.id.list_title);
        }
    }

}
