package com.example.app3.db.models;

import android.content.ContentValues;
import android.database.Cursor;

import com.example.app3.beans.history;
import com.example.app3.db.AbsDBAPI;
import com.example.app3.db.helper.DatabaseHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 黑羊 on 2017/4/16.
 */

public class HistoryModel extends AbsDBAPI<history> {
    public HistoryModel() {
        super(DatabaseHelper.TABLE_HISTORY);
    }

    @Override
    protected ContentValues toContentValues(history item) {
        ContentValues newValues = new ContentValues();
        newValues.put("word", item.key);
        return newValues;
    }

    @Override
    protected List<history> parseResult(Cursor cursor) {
        List<history> articles = new ArrayList<history>();
        while (cursor.moveToNext()) {
            history item = new history();
            item.uid = cursor.getInt(0);
            item.key = cursor.getString(1);
            // 解析数据
            articles.add(item);
        }
        return articles;
    }
}
