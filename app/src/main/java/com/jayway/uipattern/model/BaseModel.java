package com.jayway.uipattern.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pererik on 12/10/15.
 */
public class BaseModel {

    private List<OnModelChangeListener> mOnModelChangeListeners;

    public BaseModel() {
        mOnModelChangeListeners = new ArrayList<>();
    }

    public boolean addOnModelChangeListener(OnModelChangeListener object) {
        if (mOnModelChangeListeners.contains(object)) {
            return false;
        }

        return mOnModelChangeListeners.add(object);
    }

    public boolean removeOnModelChangeListener(Object object) {
        if (!mOnModelChangeListeners.contains(object)) {
            return false;
        }

        return mOnModelChangeListeners.remove(object);
    }

    protected void notifyChange() {
        for (OnModelChangeListener changeListener : mOnModelChangeListeners) {
            changeListener.OnModelChangeListener();
        }
    }

    public static interface OnModelChangeListener {
        public void OnModelChangeListener();
    }
}
