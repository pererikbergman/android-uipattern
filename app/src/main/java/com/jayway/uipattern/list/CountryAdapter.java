package com.jayway.uipattern.list;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.jayway.uipattern.model.Country;

import java.util.ArrayList;
import java.util.List;

public class CountryAdapter extends RecyclerView.Adapter<ViewHolder> {

    private List<Country> mDataSet;

    private View.OnLongClickListener mOnLongClickListener;

    public CountryAdapter() {
        mDataSet = new ArrayList<>();
    }

    public List<Country> getDataSet() {
        return mDataSet;
    }

    public CountryAdapter setDataSet(List<Country> dataSet) {
        mDataSet = dataSet;
        notifyDataSetChanged();

        return this;
    }

    @Override
    public int getItemCount() {
        return mDataSet.size();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return ViewHolder.newInstance(parent);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bind(mDataSet.get(position), mOnLongClickListener);
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        mOnLongClickListener = onLongClickListener;
    }

}