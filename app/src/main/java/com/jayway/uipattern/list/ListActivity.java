package com.jayway.uipattern.list;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.jayway.uipattern.R;
import com.jayway.uipattern.model.Country;
import com.jayway.uipattern.service.ListService;

public class ListActivity extends AppCompatActivity implements ListController.ListView {

    private RecyclerView               mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;

    private OnViewListener mViewListener;

    private ListModel               mListModel;
    private ListController.ListView mListView;
    private ListController          mListController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        // Setting up the model.
        mListModel = new ListModel().setDataSet(ListService.getService().getAll());

        // Setting up the view.
        mListView = this;
        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        // Setting up the controller.
        mListController = new ListController(mListModel, mListView);

        // Setting up the interaction to the controller.
        mListModel.setOnClickListener(new ListModel.OnCountryClickListener() {
            @Override
            public void onCountryClick(Country country) {
                mViewListener.onDelete(country);
            }
        });

        // Add listener to model
        mRecyclerView.setAdapter(mListModel);
    }

     /* ListView */

    public void setOnViewListener(OnViewListener viewListener) {
        mViewListener = viewListener;
    }

    @Override
    public void showUndoDelete(final Country country) {
        Snackbar.make(mRecyclerView, "Delete: " + country.getName(), Snackbar.LENGTH_LONG)
                .setAction("Undo", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                mViewListener.undoDelete(country);
                            }
                        }
                ).show();
    }

     /* Listener Interface */

    public interface OnViewListener {
        void onDelete(Country country);

        void undoDelete(Country country);
    }
}
