package com.jayway.uipattern.list.util;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jayway.uipattern.R;
import com.jayway.uipattern.list.ListModel;
import com.jayway.uipattern.model.Country;

public class ViewHolder extends RecyclerView.ViewHolder {

    public TextView mTextView;

    public ViewHolder(View v) {
        super(v);
        mTextView = (TextView) v.findViewById(R.id.label);
    }

    public void bind(final Country country, final ListModel.OnCountryClickListener onLongClickListener) {
        mTextView.setText(country.getName());
        itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                onLongClickListener.onCountryClick(country);
                return true;
            }
        });
    }

    public static ViewHolder newInstance(ViewGroup parent) {
        return new ViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(R.layout.my_text_view,
                        parent,
                        false
                )
        );
    }
}