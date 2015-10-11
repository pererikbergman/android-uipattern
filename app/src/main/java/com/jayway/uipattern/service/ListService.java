package com.jayway.uipattern.service;

import com.jayway.uipattern.model.Country;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pererik on 12/10/15.
 */
public class ListService {

    private static ListService   sListService;
    private        List<Country> mDataSet;

    public ListService() {
        mDataSet = new ArrayList<>();

        mDataSet.add(new Country().setName("Afghanistan").setRegion("Asia"));
        mDataSet.add(new Country().setName("Albania").setRegion("Europe"));
        mDataSet.add(new Country().setName("Algeria").setRegion("Africa"));
        mDataSet.add(new Country().setName("American Samoa").setRegion("Australasia"));
        mDataSet.add(new Country().setName("Andorra").setRegion("Europe"));
        mDataSet.add(new Country().setName("Angola").setRegion("Africa"));
        mDataSet.add(new Country().setName("Anguilla").setRegion("Caribbean"));
        mDataSet.add(new Country().setName("Antigua and Barbuda").setRegion("Caribbean"));
        mDataSet.add(new Country().setName("Argentina").setRegion("South America"));
        mDataSet.add(new Country().setName("Armenia").setRegion("Europe"));
        mDataSet.add(new Country().setName("Aruba").setRegion("Caribbean"));
        mDataSet.add(new Country().setName("Australia").setRegion("Australasia"));
        mDataSet.add(new Country().setName("Austria").setRegion("Europe"));
        mDataSet.add(new Country().setName("Azerbaijan").setRegion("Europe"));

        mDataSet.add(new Country().setName("Bahamas").setRegion("Caribbean"));
        mDataSet.add(new Country().setName("Bahrain").setRegion("Middle East"));
        mDataSet.add(new Country().setName("Bangladesh").setRegion("Asia"));
        mDataSet.add(new Country().setName("Barbados").setRegion("Caribbean"));
        mDataSet.add(new Country().setName("Belarus").setRegion("Europe"));
        mDataSet.add(new Country().setName("Belgium").setRegion("Europe"));
        mDataSet.add(new Country().setName("Belize").setRegion("North America"));
        mDataSet.add(new Country().setName("Benin").setRegion("Africa"));
        mDataSet.add(new Country().setName("Bermuda").setRegion("Caribbean"));
        mDataSet.add(new Country().setName("Bhutan").setRegion("Asia"));
        mDataSet.add(new Country().setName("Bolivia").setRegion("South America"));
        mDataSet.add(new Country().setName("Bonaire").setRegion("Caribbean"));
        mDataSet.add(new Country().setName("Bosnia-Herzegovina").setRegion("Europe"));
        mDataSet.add(new Country().setName("Botswana").setRegion("Africa"));
        mDataSet.add(new Country().setName("Bouvet Island").setRegion("Africa"));
        mDataSet.add(new Country().setName("Brazil").setRegion("South America"));
        mDataSet.add(new Country().setName("Brunei").setRegion("Asia"));
        mDataSet.add(new Country().setName("Bulgaria").setRegion("Europe"));
        mDataSet.add(new Country().setName("Burkina Faso").setRegion("Africa"));
        mDataSet.add(new Country().setName("Burundi").setRegion("Africa"));
    }

    public List<Country> getAll() {
        return new ArrayList<>(mDataSet);
    }

    public static ListService getService() {
        if (sListService == null) {
            sListService = new ListService();
        }

        return sListService;
    }

    public void delete(Country country) {
        mDataSet.remove(country);
    }
}
