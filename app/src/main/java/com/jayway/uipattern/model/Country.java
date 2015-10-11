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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Country)) return false;

        Country country = (Country) o;

        if (mName != null ? !mName.equals(country.mName) : country.mName != null) return false;
        return !(mRegion != null ? !mRegion.equals(country.mRegion) : country.mRegion != null);

    }

    @Override
    public int hashCode() {
        int result = mName != null ? mName.hashCode() : 0;
        result = 31 * result + (mRegion != null ? mRegion.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Country{" +
                "mName='" + mName + '\'' +
                ", mRegion='" + mRegion + '\'' +
                '}';
    }
}
