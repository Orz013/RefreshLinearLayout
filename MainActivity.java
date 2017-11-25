package com.orz013.myapplication;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RefreshLinearLayout refresh_ll;
    private SwipeRefreshLayout rfl;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        refresh_ll = (RefreshLinearLayout) findViewById(R.id.root_ll);

        rfl = (SwipeRefreshLayout) findViewById(R.id.rfl);

        rfl.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {

            @Override
            public void onRefresh() {
                // TODO Auto-generated method stub
                rfl.postDelayed(new Runnable() {

                    @Override
                    public void run() {
                        // TODO Auto-generated method stub

                        rfl.setRefreshing(false);
                    }
                }, 1500);
            }
        });

        listView = (ListView) findViewById(R.id.lv);

        ArrayList<String> datas = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            datas.add("item=" + i);
        }
        listView.setAdapter(new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, datas));

        refresh_ll.setTargetView(listView);

        View fixll = findViewById(R.id.fixed_ll);
        //设置固定头部
      refresh_ll.setFixedView(fixll);
    }
}
