package com.example.app3.views;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.app3.R;
import com.example.app3.beans.history;
import com.example.app3.persenters.HistoryPersenter;
import com.example.app3.utils.flexbox.adapter.StringTagAdapter;
import com.example.app3.utils.flexbox.interfaces.OnFlexboxSubscribeListener;
import com.example.app3.utils.flexbox.widget.TagFlowLayout;
import com.example.app3.views.interfaces.ArticleViewInterface;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by 黑羊 on 2017/4/2.
 */

public class FindActivity extends AppCompatActivity implements ArticleViewInterface<List<history>> {
    private HistoryPersenter persenter=new HistoryPersenter(this);
    private List<String> sourceData;
    private List<String> SourceHistory;
    StringTagAdapter adapter1;
    StringTagAdapter adapter2;
    List<String> selectItems;

    @Bind(R.id.history_layout) TagFlowLayout historyFlow;
    @Bind(R.id.flow_layout) TagFlowLayout signFlow;
    @Bind(R.id.fd_head) RelativeLayout head;
    @Bind(R.id.delete_all) TextView delete;
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find);
        ButterKnife.bind(this);//简化findviewbyid()
        initData();
        initViews();
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                persenter.deleteall();
                refresh();
            }
        });
        head .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity("");

            }
        });

    }

    private void initData() {
        SourceHistory=new ArrayList<>();
        sourceData = new ArrayList<>();
        persenter.loadFavorites();
        sourceData.add("程序员");
        sourceData.add("设计师");
        sourceData.add("产品经理");
        sourceData.add("运营");
        sourceData.add("商务");
        sourceData.add("人事经理");
        sourceData.add("项目经理");
        sourceData.add("客户代表");
        sourceData.add("技术主管");
        sourceData.add("测试工程师");
        sourceData.add("前端工程师");
        sourceData.add("Java工程师");
        sourceData.add("Android工程师");
        sourceData.add("iOS工程师");
    }

    private void initViews() {
        adapter1 = new StringTagAdapter(this, SourceHistory, selectItems);
        adapter2 = new StringTagAdapter(this, sourceData, selectItems);
        adapter1.setOnSubscribeListener(new OnFlexboxSubscribeListener<String>() {
            @Override
            public void onSubscribe(List<String> selectedItem) {
                openActivity(selectedItem.get(0));
            }
        });
        adapter2.setOnSubscribeListener(new OnFlexboxSubscribeListener<String>() {
            @Override
            public void onSubscribe(List<String> selectedItem) {
                openActivity(selectedItem.get(0));
            }
        });
        historyFlow.setAdapter(adapter1);
        signFlow.setAdapter(adapter2);
    }

    public void openActivity(String key){
        Intent intent=new Intent(FindActivity.this,ShowActivity.class);
        intent.putExtra("key", key);
        startActivity(intent);
        finish();
    }
    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void fetchedData(List<history> result) {
        for(history item:result){
            SourceHistory.add(item.key);
        }
        adapter1.notifyDataSetChanged();
    }

    public void refresh(){
        Intent intent=new Intent(this,FindActivity.class);
        startActivity(intent);
        finish();
    }
}
