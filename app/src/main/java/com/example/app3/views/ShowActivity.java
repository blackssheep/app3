package com.example.app3.views;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.SearchView;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.app3.R;
import com.example.app3.beans.history;
import com.example.app3.persenters.HistoryPersenter;
import com.example.app3.views.interfaces.ArticleViewInterface;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by 黑羊 on 2017/4/15.
 */

public class ShowActivity extends Activity implements
        SearchView.OnQueryTextListener,ArticleViewInterface<List<history>> {
    private HistoryPersenter persenter=new HistoryPersenter(this);
    ProgressDialog progressDialog;
    ArrayAdapter<String> adapter;
    String key;
    Filter filter;
    // 自动完成的列表
    private List<String> mStrings = new ArrayList<String>();

    @Bind(R.id.search_list) ListView mListView;
    @Bind(R.id.searchview) SearchView mSearchView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        ButterKnife.bind(this);//简化findviewbyid()
        initDialog();
        initView();
        init();
    }

    private void initDialog() {
        progressDialog = new ProgressDialog(ShowActivity.this,
                R.style.AppTheme_Dark_Dialog);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Authenticating...");
    }

    private void initView() {
        persenter.loadFavorites();
        adapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1, mStrings);
        mListView.setAdapter(adapter);
        mListView.setTextFilterEnabled(false);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Toast.makeText(getApplication(),"搜索"+mStrings[position],Toast.LENGTH_SHORT).show();
            }
        });
        filter=adapter.getFilter();
        mSearchView.onActionViewExpanded();
        // 设置该SearchView默认是否自动缩小为图标
        mSearchView.setIconifiedByDefault(false);
        // 为该SearchView组件设置事件监听器
        mSearchView.setOnQueryTextListener(this);
        // 设置该SearchView内默认显示的提示文本
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        if (mSearchView != null) {
            // 得到输入管理对象
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            if (imm != null) {
                // 这将让键盘在所有的情况下都被隐藏，但是一般我们在点击搜索按钮后，输入法都会乖乖的自动隐藏的。
                imm.hideSoftInputFromWindow(mSearchView.getWindowToken(), 0); // 输入法如果是显示状态，那么就隐藏输入法
                mListView.setVisibility(View.GONE);
                saveitem(key);
                persenter.loadFavorites();
            }
            mSearchView.clearFocus(); // 不获取焦点
        }
        return true;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        mListView.setVisibility(View.VISIBLE);
        key=newText;
        filter.filter(newText);
        return false;
    }
     private void init() {
        Bundle extraBundle = getIntent().getExtras();
        if (extraBundle != null) {
            key = extraBundle.getString("key");
            if (key.equals("")){
                saveitem(key);
                mSearchView.setQueryHint("查找");
            }else {
                mSearchView.setQueryHint(key);
            }
            mListView.setVisibility(View.GONE);
        }
    }

    private void saveitem(String word){
        history item=new history();
        item.uid=1;
        item.key=word;
        persenter.save(item);
    }

    @Override
    public void showLoading() {
        progressDialog.show();
    }

    @Override
    public void hideLoading() {
        progressDialog.dismiss();
    }

    @Override
    public void fetchedData(List<history> result) {
        for(history item:result){
            mStrings.add(item.key);
        }

        adapter.notifyDataSetChanged();
    }
}
