package com.midooabdaim.news.ui.fragment.viewCountery;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.midooabdaim.news.R;
import com.midooabdaim.news.data.model.Country;

import java.util.ArrayList;
import java.util.List;

public class ViewModelToViewCountry extends AndroidViewModel {
    MutableLiveData<List<Country>> listLiveData;

    public ViewModelToViewCountry(@NonNull Application application) {
        super(application);
        listLiveData = new MutableLiveData<>();
        setListLiveData();
    }

    public MutableLiveData<List<Country>> getListLiveData() {
        if (listLiveData == null)
            listLiveData = new MutableLiveData<>();

        return listLiveData;
    }

    public void setListLiveData() {
        listLiveData.setValue(setCountry());
    }

    List<Country> setCountry() {
        List<Country> countryList = new ArrayList<>();
        countryList.add(new Country("Argentina", "ar", R.drawable.ic_ar));
        countryList.add(new Country("Australia", "au", R.drawable.ic_au));
        countryList.add(new Country("Austria", "at", R.drawable.ic_at));
        countryList.add(new Country("Belgium", "be", R.drawable.ic_be));
        countryList.add(new Country("Brazil", "br", R.drawable.ic_br));
        countryList.add(new Country("Bulgaria", "bg", R.drawable.ic_bg));
        countryList.add(new Country("Canada", "ca", R.drawable.ic_ca));
        countryList.add(new Country("China", "cn", R.drawable.ic_cn));
        countryList.add(new Country("Colombia", "co", R.drawable.ic_co));
        countryList.add(new Country("Cuba", "cu", R.drawable.ic_cu));
        countryList.add(new Country("Czech Republic", "cz", R.drawable.ic_cz));
        countryList.add(new Country("Egypt", "eg", R.drawable.ic_eg));
        countryList.add(new Country("France", "fr", R.drawable.ic_fr));
        countryList.add(new Country("Germany", "de", R.drawable.ic_de));
        countryList.add(new Country("Greece", "gr", R.drawable.ic_gr));
        countryList.add(new Country("Hong Kong", "hk", R.drawable.ic_hk));
        countryList.add(new Country("Hungary", "hu", R.drawable.ic_hu));
        countryList.add(new Country("India", "in", R.drawable.ic_in));
        countryList.add(new Country("Indonesia", "id", R.drawable.ic_id));
        countryList.add(new Country("Ireland", "ie", R.drawable.ic_ie));
        countryList.add(new Country("Italy", "it", R.drawable.ic_it));
        countryList.add(new Country("Japan", "jp", R.drawable.ic_jp));
        countryList.add(new Country("Morocco", "ma", R.drawable.ic_ma));
        countryList.add(new Country("Netherlands", "nl", R.drawable.ic_nl));
        countryList.add(new Country("New Zealand", "nz", R.drawable.ic_nz));
        countryList.add(new Country("Nigeria", "ng", R.drawable.ic_ng));
        countryList.add(new Country("Poland", "pl", R.drawable.ic_pl));
        countryList.add(new Country("Portugal", "pt", R.drawable.ic_pt));
        countryList.add(new Country("Russia", "ru", R.drawable.ic_ru));
        countryList.add(new Country("Saudi Arabia", "sa", R.drawable.ic_sa));
        countryList.add(new Country("South Africa", "za", R.drawable.ic_za));
        countryList.add(new Country("Turkey", "tr", R.drawable.ic_tr));
        countryList.add(new Country("UAE", "ae", R.drawable.ic_ae));
        countryList.add(new Country("Ukraine", "ua", R.drawable.ic_ua));
        countryList.add(new Country("United Kingdom", "gb", R.drawable.ic_gb));
        countryList.add(new Country("United States", "us", R.drawable.ic_us));
        return countryList;
    }

}
