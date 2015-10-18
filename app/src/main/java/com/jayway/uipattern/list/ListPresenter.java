package com.jayway.uipattern.list;

import android.os.Handler;

import com.jayway.uipattern.model.Country;
import com.jayway.uipattern.service.ListService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pererik on 14/10/15.
 */
public class ListPresenter {

    // SnackbarManager.LONG_DURATION_MS + 250;
    protected static final int LONG_DURATION_MS = 2750 + 250;

    private final ListModel mAdapter;
    private final ListView  mListView;

    protected Handler mHandler = new Handler();

    protected List<Country> mDeletedItems = new ArrayList<>();

    public ListPresenter(ListModel adapter, ListView listView) {
        mAdapter = adapter;
        mListView = listView;


        mListView.setOnViewListener(new ListActivity.OnViewListener() {
            @Override
            public void onDelete(final Country country) {
                if (!mDeletedItems.contains(country)) {
                    mDeletedItems.add(country);

                    mHandler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            if (mDeletedItems.remove(country)) {
                                ListService.getService().delete(country);
                                updateAdapter();
                            }
                        }
                    }, LONG_DURATION_MS);

                    updateAdapter();

                    mListView.showUndoDelete(country);
                }
            }

            @Override
            public void undoDelete(Country country) {
                mDeletedItems.remove(country);
                updateAdapter();
            }
        });
    }

    private void updateAdapter() {
        List<Country> all = ListService.getService().getAll();
        all.removeAll(mDeletedItems);
        mAdapter.setDataSet(all);
    }

    public interface ListView {
        void setOnViewListener(ListActivity.OnViewListener object);

        void showUndoDelete(Country country);
    }
}
