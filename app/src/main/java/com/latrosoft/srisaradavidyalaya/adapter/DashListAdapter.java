package com.latrosoft.srisaradavidyalaya.adapter;

import android.content.res.TypedArray;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.latrosoft.srisaradavidyalaya.R;
import com.latrosoft.srisaradavidyalaya.databinding.AdapterDashBinding;

public class DashListAdapter extends RecyclerView.Adapter<DashListAdapter.MyViewHolder> {
    private TypedArray bgDrawableList;
    private TypedArray iconDrawableList;
    private String[] headerList;
    private String[] titleList;
    private RecyclerViewItemClickCallback itemClickCallback;

    public DashListAdapter(TypedArray bgDrawableList,
                           TypedArray iconDrawableList,
                           String[] headerList,
                           String[] titleList, RecyclerViewItemClickCallback itemClickCallback) {
        this.bgDrawableList = bgDrawableList;
        this.headerList = headerList;
        this.titleList = titleList;
        this.iconDrawableList = iconDrawableList;
        this.itemClickCallback = itemClickCallback;
    }

    @NonNull
    @Override
    public DashListAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        AdapterDashBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.adapter_dash, parent, false);
        return new MyViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull final DashListAdapter.MyViewHolder holder, int position) {
        holder.binding.clickableItem.setOnClickListener(v -> itemClickCallback.onItemClickedAtPosition(holder.getAdapterPosition()));
        holder.binding.header.setText(headerList[position]);
        holder.binding.mItemViewText.setText(titleList[position]);
        holder.binding.clickableItem.setBackground(bgDrawableList.getDrawable(position));
        holder.binding.imageIcon.setImageDrawable(iconDrawableList.getDrawable(position));
    }

    @Override
    public int getItemCount() {
        return titleList.length;
    }

    public interface RecyclerViewItemClickCallback {
        void onItemClickedAtPosition(int position);
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public AdapterDashBinding binding;

        public MyViewHolder(AdapterDashBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
