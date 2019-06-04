package com.example.filterinrecyclerview;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {

    private List<Model> list;
    private List<Model> filterListData;

    public RecyclerAdapter(List<Model> list) {

        //assigning both the list (list and filterListData) with incoming list
        this.list = list;
        this.filterListData = list;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        public ImageView imageView;
        public TextView title;
        public TextView description;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.image);
            title = itemView.findViewById(R.id.title);
            description = itemView.findViewById(R.id.description);
        }
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recycler_row, viewGroup, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int i) {
        Model row = filterListData.get(i);
        holder.imageView.setImageResource(row.getImage());
        holder.title.setText(row.getTitle());
        holder.description.setText(row.getDesc());
    }

    @Override
    public int getItemCount() {
        return filterListData.size();
    }

    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String charString = charSequence.toString();
                //when filter start

                //if filter search is empty means if no character available in filter search
                //the un-filter data will be published.
                if (charString.isEmpty()) {
                    filterListData = list;
                } else {
                    List<Model> filteredList = new ArrayList<>();

                    //always filtering from unused backup data. this is important
                    for (Model row : list) {

                        //Search condition
                        if (row.title.toLowerCase().contains(charString.toLowerCase())) {
                            filteredList.add(row);
                        }
                    }

                    filterListData = filteredList;
                }

                FilterResults filterResults = new FilterResults();
                filterResults.values = filterListData;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                filterListData = (ArrayList<Model>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }
}
