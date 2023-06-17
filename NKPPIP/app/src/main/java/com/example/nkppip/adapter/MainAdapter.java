package com.example.nkppip.adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nkppip.AddActivity;
import com.example.nkppip.R;
import com.example.nkppip.db.Constants;

import java.util.ArrayList;
import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {
    private Context context;
    private List<ListItem> mainArray;

    public MainAdapter(Context context){
        this.context = context;
        mainArray = new ArrayList<>();
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_list,parent,false);
        return new ViewHolder(view, context, mainArray);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.setData(mainArray.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return mainArray.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView tvText;
        private Context context;
        private List<ListItem> mainArray;
        public ViewHolder(@NonNull View itemView, Context context, List<ListItem> mainArray) {
            super(itemView);
            this.context = context;
            this.mainArray = mainArray;
            tvText = itemView.findViewById(R.id.tvText);
            itemView.setOnClickListener(this);
        }
        public void setData(String title){
            tvText.setText(title);
        }
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(context, AddActivity.class);
            intent.putExtra(Constants.LIST_ITEM,mainArray.get(getAdapterPosition()));
            intent.putExtra(Constants.EDIT,true);
            context.startActivity(intent);
        }
    }
    public void updateAdapter(List<ListItem> newlist){
        mainArray.clear();
        mainArray.addAll(newlist);
        notifyDataSetChanged();
    }
}
