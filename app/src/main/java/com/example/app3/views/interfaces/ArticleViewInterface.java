package com.example.app3.views.interfaces;

/**
 * Created by 黑羊 on 2017/3/31.
 */

public interface ArticleViewInterface<T> {
    public void showLoading();

    public void hideLoading();

    public void fetchedData(T result);
}
