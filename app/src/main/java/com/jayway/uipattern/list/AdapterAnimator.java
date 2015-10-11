package com.jayway.uipattern.list;

import android.support.v7.widget.RecyclerView;

import java.util.List;

/**
 * Created by pererikbergman on 01/09/15.
 */
public class AdapterAnimator<K> {

    private final Callback<K> mCallback;

    public AdapterAnimator(final RecyclerView.Adapter adapter) {
        this(new Callback<K>() {
            @Override
            public void onInserted(K entity, int position) {
                System.out.print("AdapterAnimator.onInserted ");
                System.out.println("entity = [" + entity + "], position = [" + position + "]");
                adapter.notifyItemInserted(position);
            }

            @Override
            public void onMoved(K entity, int fromPosition, int toPosition) {
                System.out.print("AdapterAnimator.onMoved ");
                System.out.println("entity = [" + entity + "], fromPosition = [" + fromPosition + "], toPosition = [" + toPosition + "]");
                adapter.notifyItemMoved(fromPosition, toPosition);
                adapter.notifyItemChanged(toPosition);
            }

            @Override
            public void onRemoved(K entity, int position) {
                System.out.print("AdapterAnimator.onRemoved ");
                System.out.println("entity = [" + entity + "], position = [" + position + "]");
                adapter.notifyItemRemoved(position);
            }
        });
    }

    public AdapterAnimator(final Callback<K> callback) {
        mCallback = callback;
    }

    public void rearrange(List<K> from, List<K> to) {
        for (int toPosition = 0; toPosition < to.size(); ++toPosition) {
            K entity = to.get(toPosition);
            int fromPosition = from.indexOf(entity);

            if (fromPosition < 0) {
                // Add new entities.
                from.add(toPosition, entity);
                mCallback.onInserted(entity, toPosition);
            } else if (fromPosition != toPosition) {
                // Move entities if needed.
                K data = from.remove(fromPosition);
                from.add(toPosition, data);
                mCallback.onMoved(data, fromPosition, toPosition);
            }
        }

        // Delete the rest of the entities.
        while (from.size() > to.size()) {
            int position = from.size() - 1;
            K entity = from.remove(position);
            mCallback.onRemoved(entity, position);
        }
    }

    public boolean verify(List<K> from, List<K> to) {
        if (from.size() != to.size()) {
            return false;
        }

        for (int i = 0; i < from.size(); ++i) {
            if (!from.get(i).equals(to.get(i))) {
                return false;
            }
        }

        return true;
    }

    public void print(List<K> list) {
        for (K l : list) {
            System.out.print(l + " ");
        }
        System.out.println();
    }

    public static interface Callback<K> {
        public void onInserted(K entity, int position);

        public void onMoved(K entity, int fromPosition, int toPosition);

        public void onRemoved(K entity, int position);
    }
}
