package com.example.app3.views.fragments;

import com.example.app3.adapters.ArticleAdapter;
import com.example.app3.beans.Article;
import com.example.app3.views.interfaces.ArticleViewInterface;

/**
 * Created by 黑羊 on 2017/4/9.
 */

public class ArticleFragment extends RecyclerViewFragment<Article> implements ArticleViewInterface<Article> {


    @Override
    public void showLoading() {
        mSwipeRefreshLayout.setRefreshing(true);
    }

    @Override
    public void hideLoading() {
        mSwipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void fetchedData(Article result) {

    }

    @Override
    protected void initPresenter() {

    }

    @Override
    protected void initAdapter() {
        for(int i=0;i<10;i++){
            Article data=new Article();
            mDataSet.add(data);
        }
        ArticleAdapter mAdapter = new ArticleAdapter(mDataSet);
        // 设置Adapter
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public void fetchDatas() {
    }

    @Override
    public void onRefresh() {

    }

    @Override
    public void onLoad() {

    }
}
