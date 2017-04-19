package com.example.app3.persenters;

import com.example.app3.beans.history;
import com.example.app3.db.AbsDBAPI;
import com.example.app3.db.models.DbFactory;
import com.example.app3.listener.DataListener;
import com.example.app3.views.interfaces.ArticleViewInterface;

import java.util.List;

/**
 * Created by 黑羊 on 2017/4/16.
 */

public class HistoryPersenter {
    ArticleViewInterface mViewInterface;

    AbsDBAPI<history> mHistoryDBAPI = DbFactory.createHistoryModel();

    public HistoryPersenter(ArticleViewInterface viewInterface) {
        mViewInterface = viewInterface;
    }
    public void loadFavorites() {
        mHistoryDBAPI.loadDatasFromDB(new DataListener<List<history>>() {

            @Override
            public void onComplete(List<history> result) {
                mViewInterface.fetchedData(result);
            }
        });
    }

    public void save(history item) {
        if(item.key.isEmpty()){
            return;
        }
        mHistoryDBAPI.saveItem(item);
    }
    public void deleteall(){
        mHistoryDBAPI.deleteAll();
    }
}
