package com.jayway.uipattern.model;

/**
 * Created by pererik on 12/10/15.
 */
public class Country {

    private String mName;
    private String mRegion;

    public Country() {
    }

    public String getName() {
        return mName;
    }

    public Country setName(String name) {
        mName = name;
        return this;
    }

    public String getRegion() {
        return mRegion;
    }

    public Country setRegion(String region) {
        mRegion = region;
        return this;
    }

}
