package com.mjbaucas.indecision;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

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
        listViewHolder.title.setTextColor((i%2 == 0) ? Color.WHITE : Color.BLACK);
        listViewHolder.itemView.setBackgroundColor((i%2 == 0) ? Color.BLUE : Color.CYAN);
        listViewHolder.listTitle = info.title;
        listViewHolder.listItems = info.items;
    }

    @Override
    public ListViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_card, viewGroup, false);
        return new ListViewHolder(itemView);
    }

    public static class ListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        protected TextView title;
        protected String listTitle;
        protected ArrayList<String> listItems;

        public ListViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            title = (TextView) itemView.findViewById(R.id.list_title);
        }

        @Override
        public void onClick(View view){
            Intent openList = new Intent(view.getContext(), ListInfoActivity.class);
            openList.putExtra("LIST_TITLE", listTitle);
            openList.putStringArrayListExtra("LIST_ITEMS", listItems);
            view.getContext().startActivity(openList);
        }

    }

}
