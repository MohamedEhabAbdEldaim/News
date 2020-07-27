package com.midooabdaim.news.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.security.ProviderInstaller;
import com.midooabdaim.news.R;
import com.midooabdaim.news.data.model.Category;
import com.midooabdaim.news.data.model.Country;
import com.midooabdaim.news.ui.fragment.SplashFragment;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import static com.midooabdaim.news.helper.HelperMethod.replaceFragment;

public class MainActivity extends BaseActivity {


    private static final String TAG = "hoba";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //upgradeSecurityProvider();
        replaceFragment(getSupportFragmentManager(), R.id.main_Activity_frame_layout_id, new SplashFragment());

    }

    private void upgradeSecurityProvider() {
        try {
            ProviderInstaller.installIfNeededAsync(this, new ProviderInstaller.ProviderInstallListener() {
                @Override
                public void onProviderInstalled() {
                    Log.e(TAG, "New security provider installed.");
                }

                @Override
                public void onProviderInstallFailed(int errorCode, Intent recoveryIntent) {
                    GooglePlayServicesUtil.showErrorNotification(errorCode, MainActivity.this);
                    Log.e(TAG, "New security provider install failed.");
                }
            });
        } catch (Exception ex) {
            Log.e(TAG, "Unknown issue trying to install a new security provider", ex);
        }
    }


    public List<Country> countryList = new ArrayList<>();
    public List<Category> categoryList = new ArrayList<>();

    void setCountry() {
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
    }

    void setCategory() {
        categoryList.add(new Category(1, "business"));
        categoryList.add(new Category(2, "entertainment"));
        categoryList.add(new Category(3, "general"));
        categoryList.add(new Category(4, "health"));
        categoryList.add(new Category(5, "science"));
        categoryList.add(new Category(6, "sports"));
        categoryList.add(new Category(7, "technology"));

    }


}