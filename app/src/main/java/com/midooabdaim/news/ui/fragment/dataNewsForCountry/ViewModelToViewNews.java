package com.midooabdaim.news.ui.fragment.dataNewsForCountry;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.midooabdaim.news.data.model.Category;
import com.midooabdaim.news.data.model.NewsModel.Article;
import com.midooabdaim.news.data.model.NewsModel.News;

import java.util.ArrayList;
import java.util.List;


import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

import static com.midooabdaim.news.data.api.RetrofitClient.getClient;

public class ViewModelToViewNews extends AndroidViewModel {
    public boolean Filter = false;
    public int max = 0;
    MutableLiveData<List<Article>> articleMutableLiveData;
    MutableLiveData<List<Category>> categoryMutableLiveData;
    private CompositeDisposable compositeDisposable;
    int page = 1;
    public String categoryValue = "";

    public ViewModelToViewNews(@NonNull Application application) {
        super(application);
        articleMutableLiveData = new MutableLiveData<>();
        compositeDisposable = new CompositeDisposable();
        categoryMutableLiveData = new MutableLiveData<>();
        setCategoryMutableLiveData();
    }

    public MutableLiveData<List<Category>> getCategoryMutableLiveData() {
        if (categoryMutableLiveData == null)
            categoryMutableLiveData = new MutableLiveData<>();

        return categoryMutableLiveData;
    }

    public void setCategoryMutableLiveData() {
        categoryMutableLiveData.setValue(setCategory());
    }

    List<Category> setCategory() {
        List<Category> categoryList = new ArrayList<>();
        categoryList.add(new Category(1, "business"));
        categoryList.add(new Category(2, "entertainment"));
        categoryList.add(new Category(3, "general"));
        categoryList.add(new Category(4, "health"));
        categoryList.add(new Category(5, "science"));
        categoryList.add(new Category(6, "sports"));
        categoryList.add(new Category(7, "technology"));
        return categoryList;
    }


    public MutableLiveData<List<Article>> getArticleMutableLiveData() {
        if (articleMutableLiveData == null)
            articleMutableLiveData = new MutableLiveData<>();

        return articleMutableLiveData;
    }


    public void setArticleMutableLiveData(String apiKey, String countryAbbreviation, int page) {
        this.page = page;
        Single<News> single;
        if (Filter) {
            single = getClient().getNewsWithCategory(apiKey, countryAbbreviation, categoryValue, page);
        } else {
            single = getClient().getNewsForCountry(apiKey, countryAbbreviation, page);
        }
        getData(single);
    }

    private void getData(Single<News> single) {
        single.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());

        DisposableSingleObserver<News> disposable = new DisposableSingleObserver<News>() {
            @Override
            public void onSuccess(News news) {
                if (news.getStatus().equals("ok")) {
                    Log.e("hoba", "onSuccess: " + news.getTotalResults());
                    if (page == 1) {
                        max = (int) (news.getTotalResults() / 20);
                    }
                    articleMutableLiveData.setValue(news.getArticles());
                }
                Log.e("hoba", "onSuccess: " + news.getTotalResults());

            }

            @Override
            public void onError(Throwable e) {
                Log.e("hoba", "onError: " + e.getMessage());

            }
        };
        single.subscribe(disposable);

        compositeDisposable.add(disposable);

    }

    @Override
    protected void onCleared() {
        super.onCleared();
        compositeDisposable.clear();
    }
}
