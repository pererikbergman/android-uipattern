package com.jayway.uipattern.list;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.jayway.uipattern.list.util.AdapterAnimator;
import com.jayway.uipattern.list.util.ViewHolder;
import com.jayway.uipattern.model.Country;

import java.util.ArrayList;
import java.util.List;

public class ListModel extends RecyclerView.Adapter<ViewHolder> {

    private final AdapterAnimator mAdapterAnimator;
    private       List<Country>   mDataSet;

    private OnCountryClickListener mOnLongClickListener;

    public ListModel() {
        mDataSet = new ArrayList<>();
        mAdapterAnimator = new AdapterAnimator(this);
    }

    public List<Country> getDataSet() {
        return mDataSet;
    }

    public ListModel setDataSet(List<Country> dataSet) {
        mAdapterAnimator.rearrange(mDataSet, dataSet);
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

    public void setOnClickListener(OnCountryClickListener onLongClickListener) {
        mOnLongClickListener = onLongClickListener;
    }

    public interface OnCountryClickListener {
        void onCountryClick(Country position);
    }
}